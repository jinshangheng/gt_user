package cool.byr.gt.user.api

import cool.byr.gt.user.api.response.JWTResponse
import cool.byr.gt.user.api.response.UserResponse

interface UserAPI {
    fun createNewUser(jwt: String, userName: String): JWTResponse
    fun getAvailableUserNameList(): JWTResponse
    fun queryUserInfo(jwt: String, userId: String): UserResponse
}