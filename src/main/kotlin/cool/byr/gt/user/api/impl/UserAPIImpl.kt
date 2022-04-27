package cool.byr.gt.user.api.impl

import cool.byr.gt.user.api.UserAPI
import cool.byr.gt.user.api.code.JWTKey
import cool.byr.gt.user.api.code.UserErrorCode
import cool.byr.gt.user.api.response.JWTResponse
import cool.byr.gt.user.api.response.UserResponse
import cool.byr.gt.user.service.CreateUserService
import cool.byr.gt.user.service.GlobalAdminStatusService
import cool.byr.gt.user.service.UserNameGenerateService
import cool.byr.gt.user.util.JWTUtil
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*
import javax.annotation.Resource

@Controller
class UserAPIImpl: UserAPI {

    @Resource
    lateinit var userNameGenerateService: UserNameGenerateService

    @Resource
    lateinit var globalAdminStatusService: GlobalAdminStatusService

    @Resource
    lateinit var createUserService: CreateUserService

    @Resource
    lateinit var jwtUtil: JWTUtil

    @RequestMapping(value = ["/user/create"])
    override fun createNewUser(
        @RequestHeader(HttpHeaders.AUTHORIZATION) jwt: String,
        @RequestBody userName: String
    ): JWTResponse {
        TODO()
    }

    @RequestMapping(value = ["/user/random"])
    override fun getAvailableUserNameList(): JWTResponse {
        TODO()
    }

    @RequestMapping(value = ["/user/query"])
    override fun queryUserInfo(
        @RequestHeader(HttpHeaders.AUTHORIZATION) jwt: String,
        @RequestBody userId: String
    ): UserResponse {
        TODO("Not yet implemented")
    }
}