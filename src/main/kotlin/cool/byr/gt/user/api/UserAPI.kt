package cool.byr.gt.user.api

import cool.byr.gt.user.api.response.JWTResponse
import cool.byr.gt.user.api.response.UserNameResponse
import cool.byr.gt.user.api.response.UserResponse

interface UserAPI {
    fun createNewUser(selectedUserName: String): JWTResponse
    fun getAvailableUserNameList(): UserNameResponse
    fun queryUserInfo(jwt: String): UserResponse
}