package cool.byr.gt.user.ability.cache

import cool.byr.gt.user.model.bo.CreditBO
import org.springframework.beans.factory.InitializingBean

/**
 * Credit缓存能力
 */
interface CreditCacheAbility: InitializingBean {
    /**
     * 增量更新积分
     */
    fun updateCreditByUserId(delta: Long, userId: Long): Boolean

    /**
     * 批量-增量更新积分，Map<userId, delta>
     */
    fun batchUpdateCreditByUserId(map: Map<Long, Long>): Int

    fun queryCreditByUserId(userId: Long): CreditBO?

    fun createNewCredit(creditBO: CreditBO): Boolean
}