package cool.byr.gt.user.ability

/**
 * 随机生成emoji + # + 5digits的用户名
 */
interface EmojiNumberNameAbility {
    fun single(): String
    fun batch(num: Int): List<String>
}