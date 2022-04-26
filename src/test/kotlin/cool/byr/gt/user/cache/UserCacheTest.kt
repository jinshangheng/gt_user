package cool.byr.gt.user.cache

import cool.byr.gt.user.ability.cache.impl.UserCacheImpl
import cool.byr.gt.user.model.bo.UserBO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class UserCacheTest {
    private val test = UserCacheImpl()

    /**
     * 并发测试。
     * 测试目的：验证UserCacheImpl#notify方法可以确保所在线程对于自身是否抢夺到命名权的认知。
     * 测试逻辑：模拟远大于生产环境中可能遇到的同名争夺情况。记录"认为自己抢夺到命名权的任务的数量"，"某一个抢夺到命名权的任务编号"。
     * 验证指标：有且只有一个任务认为自己抢夺到了命名权，它成功写入了自己期望写入的内容且没有被他人覆盖。
     */
    @Test
    fun concurrentTest() {
        val executor = Executors.newFixedThreadPool(20)
        var winner = -1L
        var winnerCount = 0
        for (i in 0L..999L) {
            executor.submit {
                val res = test.notify(
                    UserBO(i, "same", i.toString(), "", "")
                )
                if (res) {
                    winner = i
                    winnerCount++
                }
            }
        }
        executor.shutdown()
        val bo = test.queryUserById(winner)
        // 是否成功写入
        Assertions.assertNotNull(bo)
        // 写入是否正确且未被覆盖
        Assertions.assertEquals(winner.toString(), bo?.password)
        // 线程对命名权的认知是否准确
        Assertions.assertEquals(1, winnerCount)
    }
}