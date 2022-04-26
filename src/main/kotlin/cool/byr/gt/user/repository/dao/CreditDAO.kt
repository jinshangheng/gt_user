package cool.byr.gt.user.repository.dao

import cool.byr.gt.user.repository.param.CreditParam
import cool.byr.gt.user.repository.po.CreditPO

interface CreditDAO {
    fun selectByUserId(userId: Long): CreditPO
    fun selectAllCredits(): List<CreditPO>
    fun insertNewCredit(creditParam: CreditParam): Int
    fun updateCredit(userId: Long, newCredit: Long): Int
}