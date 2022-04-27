package cool.byr.gt.user.service

interface CreateUserService {
    /**
     * 用选择的姓名尝试创建用户，若成功则返回被分配的用户ID；失败则返回负数。
     */
    fun create(name: String): Long
}