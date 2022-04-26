package cool.byr.gt.user.repository.param

data class UserParam(
    /**
     * id: pk
     */
    var id: Long,
    /**
     * name: emoji + # + 5digits, as shown name
     */
    var name: String,
    /**
     * password: pw for login, not valid yet
     */
    var password: String?,
    /**
     * token: token for 3rd Login/Access API such as Discord/QQ/Wechat
     */
    var token: String?,
    /**
     * phoneNumber: Telephone number, for login and register checking/verifying
     */
    var phoneNumber: String?,
    /**
     * ext: JSON-Map style, for adding more fields
     */
    var ext: String?
)
