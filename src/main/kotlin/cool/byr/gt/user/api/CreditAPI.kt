package cool.byr.gt.user.api

interface CreditAPI {
    fun updateCreditWithDeltaByUserId(delta: Long, userId: Long)
    fun queryCreditRank(jwt: String)
}