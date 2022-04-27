package cool.byr.gt.user.api.response

import cool.byr.gt.user.api.code.UserErrorCode

class JWTResponse: BaseResponse() {
    var jwtString: String = ""

    companion object {
        fun fail(errorCode: UserErrorCode): JWTResponse {
            return JWTResponse().apply {
                success = false
                this.code = errorCode.code
                this.msg = errorCode.msg
            }
        }
    }
}
