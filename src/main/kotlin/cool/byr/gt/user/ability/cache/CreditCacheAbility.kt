package cool.byr.gt.user.ability.cache

import org.springframework.beans.factory.InitializingBean

/**
 * Credit缓存能力
 */
interface CreditCacheAbility: InitializingBean {
    /**
     * 增量更新积分
     */
    fun updateCreditByUserId(delta: Long, userId: Long)

    /**
     * 批量-增量更新积分，Map<userId, delta>
     */
    fun batchUpdateCreditByUserId(map: Map<Long, Long>)
}