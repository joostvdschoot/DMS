package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class SpadwsgroupController {

    SpadwsgroupService spadwsgroupService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond spadwsgroupService.list(params), model:[spadwsgroupCount: spadwsgroupService.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def show(Long id) {
        respond spadwsgroupService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def create() {
        respond new Spadwsgroup(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def save(Spadwsgroup spadwsgroup) {
        if (spadwsgroup == null) {
            notFound()
            return
        }

        try {
            spadwsgroupService.save(spadwsgroup)
        } catch (ValidationException e) {
            respond spadwsgroup.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'spadwsgroup.label', default: 'Spadwsgroup'), spadwsgroup.id])
                redirect spadwsgroup
            }
            '*' { respond spadwsgroup, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def edit(Long id) {
        respond spadwsgroupService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def update(Spadwsgroup spadwsgroup) {
        if (spadwsgroup == null) {
            notFound()
            return
        }

        try {
            spadwsgroupService.save(spadwsgroup)
        } catch (ValidationException e) {
            respond spadwsgroup.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'spadwsgroup.label', default: 'Spadwsgroup'), spadwsgroup.id])
                redirect spadwsgroup
            }
            '*'{ respond spadwsgroup, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        spadwsgroupService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'spadwsgroup.label', default: 'Spadwsgroup'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'spadwsgroup.label', default: 'Spadwsgroup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
