package cool.byr.gt.user.model.bo

data class UserBO(
    var id: Long,
    var name: String,
    var password: String,
    var token: String,
    var phoneNumber: String,
)
