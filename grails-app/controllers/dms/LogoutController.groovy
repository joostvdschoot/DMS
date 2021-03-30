package DMS
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.security.core.Authentication

import javax.servlet.http.HttpServletResponse

@Secured('permitAll')
class LogoutController extends grails.plugin.springsecurity.LogoutController {
    def index() {
        session.invalidate()
        request.logout()
        println("Logged Out")
        redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl
	}
}