package cool.byr.gt.user.api

interface CreditAPI {
    fun updateCreditWithDeltaByUserId(userIdAndDelta: Map<String, Long>)
    fun queryCreditRank(jwt: String, userId: Long)
}