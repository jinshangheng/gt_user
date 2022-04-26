package cool.byr.gt.user.ability.cache.impl

import cool.byr.gt.user.ability.cache.UserCacheAbility
import cool.byr.gt.user.model.bo.UserBO
import cool.byr.gt.user.repository.dao.UserDAO
import cool.byr.gt.user.repository.po.UserPO
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArraySet
import javax.annotation.Resource

/**
 * 全内存缓存实现。
 * 考虑到内存空间有限，需要向Redis改变。
 */
@Component
class UserCacheImpl: UserCacheAbility {

    @Resource
    lateinit var userDAO: UserDAO

    /**
     * id-bo map，数据库的内存形态。
     * 线程安全。
     */
    private val db: MutableMap<Long, UserBO> = ConcurrentHashMap(64)

    /**
     * 额外维护的用户名查重集合。线程安全。
     * 可以通过抢夺重入锁的方式来让某个线程声明它对特定名称的命名权。
     */
    private val nameSet: MutableSet<String> = CopyOnWriteArraySet()

    /**
     * 初始化，全量拉，写入
     */
    private fun init() {
        var userList: List<UserPO>? = null
        try {
            userList = userDAO.selectAllUsers()
        } catch (e: Exception) {
            // TODO: log4j
        }
        if (!userList.isNullOrEmpty()) {
            // 写入内存缓存
            userList.forEach { po ->
                db[po.id] = UserBO(po.id, po.name, po.password, po.token, po.phoneNumber)
                nameSet.add(po.name)
            }
        }
    }

    /**
     * 对增加一个BO的声明
     */
    private fun sync(userBO: UserBO): Boolean {
        return if (nameSet.add(userBO.name)) {
            // 成功抢夺nameSet注册权的线程视为获得命名权
            db[userBO.id] = userBO
            true
        } else {
            false
        }
    }

    override fun checkRepeatName(nameList: List<String>): List<String> {
        return nameList.distinct().filterNot {
            nameSet.contains(it)
        }
    }

    override fun queryUserById(id: Long): UserBO? {
        return db[id]
    }

    override fun notify(bo: UserBO): Boolean {
        return sync(bo)
    }

    override fun notify(boList: List<UserBO>): Int {
        var count = 0
        boList.forEach {
            if (sync(it)) {
                count++
            }
        }
        return count
    }

    override fun afterPropertiesSet() {
        init()
    }
}