package cool.byr.gt.user

import cool.byr.gt.user.util.JWTUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class JWTUtilTest {
    private val test = JWTUtil().apply { secretKey = "JinShangHengShiYiGeFeiChangWanMeiDeRen" }

    @Test
    fun jwtCreateAndParseTest() {
        val token = test.createJWT("114514", "11", 0, mapOf("kim" to "vivian"))
        val map = test.parseJWT(token)
        Assertions.assertEquals("114514", map["jti"])
        Assertions.assertEquals("11", map["sub"])
        Assertions.assertEquals("vivian", map["kim"])
    }
}