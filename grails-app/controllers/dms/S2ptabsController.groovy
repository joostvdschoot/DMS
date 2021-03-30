package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class S2ptabsController {

    S2ptabsService s2ptabsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond s2ptabsService.list(params), model:[s2ptabsCount: s2ptabsService.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def show(Long id) {
        respond s2ptabsService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def create() {
        respond new S2ptabs(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def save(S2ptabs s2ptabs) {
        if (s2ptabs == null) {
            notFound()
            return
        }

        try {
            s2ptabsService.save(s2ptabs)
        } catch (ValidationException e) {
            respond s2ptabs.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 's2ptabs.label', default: 'S2ptabs'), s2ptabs.id])
                redirect s2ptabs
            }
            '*' { respond s2ptabs, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def edit(Long id) {
        respond s2ptabsService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def update(S2ptabs s2ptabs) {
        if (s2ptabs == null) {
            notFound()
            return
        }

        try {
            s2ptabsService.save(s2ptabs)
        } catch (ValidationException e) {
            respond s2ptabs.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 's2ptabs.label', default: 'S2ptabs'), s2ptabs.id])
                redirect s2ptabs
            }
            '*'{ respond s2ptabs, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        s2ptabsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 's2ptabs.label', default: 'S2ptabs'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 's2ptabs.label', default: 'S2ptabs'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
