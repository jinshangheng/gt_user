package cool.byr.gt.user.repository.dao

import cool.byr.gt.user.repository.param.UserParam
import cool.byr.gt.user.repository.po.UserPO

interface UserDAO {
    fun selectById(id: Long): UserPO
    fun selectAllUsers(): List<UserPO>
    fun insertNewUser(param: UserParam): Int
    fun updateUserInfo(param: UserParam): Int
}