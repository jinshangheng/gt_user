package cool.byr.gt.user.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GtUserApplication

fun main(args: Array<String>) {
    runApplication<GtUserApplication>(*args)
}
