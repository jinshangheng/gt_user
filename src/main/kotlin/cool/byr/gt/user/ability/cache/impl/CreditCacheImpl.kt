package cool.byr.gt.user.ability.cache.impl

import cool.byr.gt.user.ability.cache.CreditCacheAbility
import cool.byr.gt.user.model.bo.CreditBO
import cool.byr.gt.user.repository.dao.CreditDAO
import cool.byr.gt.user.repository.po.CreditPO
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap
import javax.annotation.Resource

/**
 * 全内存缓存实现
 */
@Component
class CreditCacheImpl: CreditCacheAbility {

    @Resource
    lateinit var creditDAO: CreditDAO

    /**
     * Map<userId, bo>
     */
    private val db: MutableMap<Long, CreditBO> = ConcurrentHashMap(64)

    private fun init() {
        var creditList: List<CreditPO>? = null
        try {
            creditList = creditDAO.selectAllCredits()
        } catch (e: Exception) {
            // TODO: log4j
        }
        if (!creditList.isNullOrEmpty()) {
            creditList.forEach { po ->
                db[po.userId] = CreditBO(po.id, po.userId, po.credit)
            }
        }
    }

    private fun syncCreate(creditBO: CreditBO): Boolean {
        db[creditBO.id] = creditBO
        return true
    }

    private fun syncUpdateCredit(delta: Long, userId: Long): Boolean {
        val bo = db[userId] ?: return false
        synchronized(bo) {
            bo.credit += bo.credit + delta
        }
        return true
    }

    override fun updateCreditByUserId(delta: Long, userId: Long): Boolean {
        return syncUpdateCredit(delta, userId)
    }

    override fun batchUpdateCreditByUserId(map: Map<Long, Long>): Int {
        var count = 0
        map.forEach { (id, delta) ->
            if (syncUpdateCredit(delta, id)) {
                count++
            }
        }
        return count
    }

    override fun queryCreditByUserId(userId: Long): CreditBO? {
        return db[userId]
    }

    override fun createNewCredit(creditBO: CreditBO): Boolean {
        return syncCreate(creditBO)
    }

    override fun afterPropertiesSet() {
        init()
    }
}