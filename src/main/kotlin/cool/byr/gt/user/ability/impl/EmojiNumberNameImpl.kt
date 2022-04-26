package cool.byr.gt.user.ability.impl

import cool.byr.gt.user.ability.EmojiNumberNameAbility
import org.springframework.stereotype.Component
import java.lang.StringBuilder
import java.util.*

@Component
class EmojiNumberNameImpl: EmojiNumberNameAbility {

    private val emojiList = listOf(
        "🐧", "🐱", "🐶", "🐭", "🐹", "🐰",
        "🦁️", "🐯", "🐻", "🐮", "🐲", "🐼",
    )

    private val numTag = "#"
    private val zero = "0"
    private val interval = (0..99999)

    override fun single(): String {
        val sb = StringBuilder()
        sb.append(emojiList[emojiList.indices.random()])
        sb.append(numTag)
        val num = interval.random().toString()
        for (i in 0 until (5 - num.length)) {
            sb.append(zero)
        }
        sb.append(num)
        return sb.toString()
    }

    override fun batch(num: Int): List<String> {
        if (num <= 0) {
            return emptyList()
        }

        val res = LinkedList<String>()

        for (i in 0 until num) {
            res.add(single())
        }

        return res
    }
}