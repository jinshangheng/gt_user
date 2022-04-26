package cool.byr.gt.user

import cool.byr.gt.user.ability.impl.EmojiNumberNameImpl
import org.junit.jupiter.api.Test


class EmojiNumberNameTest {

    private val test = EmojiNumberNameImpl()

    @Test
    fun testOnce() {
        print(test.single())
    }

    @Test
    fun batchTest() {
        print(test.batch(1))
        print(test.batch(5))
        print(test.batch(0))
        print(test.batch(-1))
    }
}