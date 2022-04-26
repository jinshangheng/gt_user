package cool.byr.gt.user.service.impl

import cool.byr.gt.user.ability.EmojiNumberNameAbility
import cool.byr.gt.user.service.UserNameGenerateService
import org.springframework.stereotype.Component
import javax.annotation.Resource

@Component
class UserNameGenerateServiceImpl: UserNameGenerateService {

    @Resource
    lateinit var emojiNumberNameAbility: EmojiNumberNameAbility

    override fun generate(num: Int): List<String> {
        return emojiNumberNameAbility.batch(num)
    }
}