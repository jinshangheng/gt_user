package cool.byr.gt.user.ability

interface EmojiNumberNameAbility {
    fun single(): String
    fun batch(num: Int): List<String>
}