package cool.byr.gt.user.api.impl

import cool.byr.gt.user.api.UserAPI
import cool.byr.gt.user.api.code.UserErrorCode
import cool.byr.gt.user.api.response.JWTResponse
import cool.byr.gt.user.api.response.UserNameResponse
import cool.byr.gt.user.api.response.UserResponse
import cool.byr.gt.user.service.GlobalAdminStatusService
import cool.byr.gt.user.service.UserNameGenerateService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource

@Controller
class UserAPIImpl: UserAPI {

    @Resource
    lateinit var userNameGenerateService: UserNameGenerateService

    @Resource
    lateinit var globalAdminStatusService: GlobalAdminStatusService

    @RequestMapping(value = ["/user/create"])
    override fun createNewUser(selectedUserName: String): JWTResponse {
        TODO("Not yet implemented")
    }

    @RequestMapping(value = ["/user/random"])
    override fun getAvailableUserNameList(): UserNameResponse {
        if (!globalAdminStatusService.isOpenForNewUser()) {
            return UserNameResponse().apply {
                success = false
                msg = UserErrorCode.CLOSE_TO_NEW.msg
                code = UserErrorCode.ALL_DUPLICATE.code
            }
        }
        val nameList = userNameGenerateService.generate(globalAdminStatusService.getGenerateNameNumber())
        return if (nameList.isNotEmpty()) {
            UserNameResponse().apply {
                userNames = nameList
                success = true
            }
        } else {
            UserNameResponse().apply {
                success = false
                msg = UserErrorCode.ALL_DUPLICATE.msg
                code = UserErrorCode.ALL_DUPLICATE.code
            }
        }
    }

    @RequestMapping(value = ["/user/query"])
    override fun queryUserInfo(jwt: String): UserResponse {
        TODO("Not yet implemented")
    }
}