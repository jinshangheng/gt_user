package cool.byr.gt.user.util

object UserNameUtil {
    fun check(name: String): Boolean {
        if (name.isBlank()) {
            return false
        }
        if (name.length > 20 || name.length < 6) {
            return false
        }
        return true
    }
}