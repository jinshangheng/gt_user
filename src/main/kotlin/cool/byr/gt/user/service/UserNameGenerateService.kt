package cool.byr.gt.user.service

interface UserNameGenerateService {
    fun generate(num: Int): List<String>
}