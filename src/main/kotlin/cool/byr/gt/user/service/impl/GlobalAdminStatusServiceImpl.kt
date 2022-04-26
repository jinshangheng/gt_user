package cool.byr.gt.user.service.impl

import cool.byr.gt.user.service.GlobalAdminStatusService
import org.springframework.stereotype.Component

@Component
class GlobalAdminStatusServiceImpl: GlobalAdminStatusService {

    private var openForNew: Boolean = true

    private var batchNameNumber: Int = 10

    override fun isOpenForNewUser(): Boolean {
        return openForNew
    }

    override fun getGenerateNameNumber(): Int {
        return batchNameNumber
    }
}