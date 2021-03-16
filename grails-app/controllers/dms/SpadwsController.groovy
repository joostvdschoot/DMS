package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class SpadwsController {

    SpadwsService spadwsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond spadwsService.list(params), model:[spadwsCount: spadwsService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond spadwsService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Spadws(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Spadws spadws) {
        if (spadws == null) {
            notFound()
            return
        }

        try {
            spadwsService.save(spadws)
        } catch (ValidationException e) {
            respond spadws.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'spadws.label', default: 'Spadws'), spadws.id])
                redirect spadws
            }
            '*' { respond spadws, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond spadwsService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Spadws spadws) {
        if (spadws == null) {
            notFound()
            return
        }

        try {
            spadwsService.save(spadws)
        } catch (ValidationException e) {
            respond spadws.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'spadws.label', default: 'Spadws'), spadws.id])
                redirect spadws
            }
            '*'{ respond spadws, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        spadwsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'spadws.label', default: 'Spadws'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'spadws.label', default: 'Spadws'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
