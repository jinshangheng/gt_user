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

    override fun single(): String {
        val sb = StringBuilder()
        sb.append(emojiList[emojiList.indices.random()])
        sb.append(numTag)
        for (i in 0..4) {
            sb.append((0..9).random())
        }
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