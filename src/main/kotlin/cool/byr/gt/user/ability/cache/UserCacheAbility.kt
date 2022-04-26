package cool.byr.gt.user.ability.cache

import cool.byr.gt.user.model.bo.UserBO
import org.springframework.beans.factory.InitializingBean

/**
 * User缓存能力
 */
interface UserCacheAbility: InitializingBean {
    /**
     * 检查重复的名称，返回去重结果。这里的重复指的是和内存中发生冲突的情况。
     */
    fun checkRepeatName(nameList: List<String>): List<String>

    fun queryUserById(id: Long): UserBO?

    /**
     * 通知新增一个bo
     */
    fun notify(bo: UserBO): Boolean

    /**
     * 通知新增一组bo
     */
    fun notify(boList: List<UserBO>): Int
}