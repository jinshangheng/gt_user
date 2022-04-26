package cool.byr.gt.user.service

interface GlobalAdminStatusService {
    fun isOpenForNewUser(): Boolean
    fun getGenerateNameNumber(): Int
}