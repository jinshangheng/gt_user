package cool.byr.gt.user.repository.po

data class CreditPO(
    /**
     * id: pk
     */
    var id: Long,
    /**
     * userId: Index, pk of table user
     */
    var userId: Long,
    /**
     * credit: Credit/Point/Balance/积分/分数 of a certain user
     */
    var credit: Long,
    /**
     * ext: JSON-Map style, for adding more fields
     */
    var ext: String
)
