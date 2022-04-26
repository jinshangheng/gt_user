package cool.byr.gt.user

import cool.byr.gt.user.ability.impl.EmojiNumberNameImpl
import org.junit.jupiter.api.Test


class EmojiNumberNameTest {

    private val test = EmojiNumberNameImpl()

    @Test
    fun singleTest() {
        print(test.single())
    }

    @Test
    fun batchTest() {
        println(test.batch(1))
        println(test.batch(50))
        println(test.batch(0))
        println(test.batch(-1))
    }
}