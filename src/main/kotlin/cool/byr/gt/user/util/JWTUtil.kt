package cool.byr.gt.user.util

import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
final class JWTUtil {
    @Value("{jwt.secretKey}")
    lateinit var secretKey: String

    fun createJWT(id: String, subject: String, ttl: Long, map: Map<String, Any>): String {
        val builder: JwtBuilder = Jwts.builder()
            .setSubject(subject)
            .setId(id)
            .setIssuedAt(Date())
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compressWith(CompressionCodecs.DEFLATE)
        if (map.isNotEmpty()) {
            builder.addClaims(map)
        }
        if (ttl > 0) {
            builder.setExpiration(Date(System.currentTimeMillis() + ttl))
        }
        return builder.compact()
    }

    fun parseJWT(jwtString: String): Claims {
        return Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(jwtString)
            .body
    }
}