package DMS
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
class UserController extends grails.plugin.springsecurity.ui.UserController {
}
