package cool.byr.gt.user.api.vo

data class UserVO (
    var id: Long,
    var name: String,
    /**
     * rank: if > 0, valid rank; if <= 0, invalid rank, for n+ rank or error cases
     */
    var rank: Int,
    var credit: Long
)
