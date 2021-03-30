package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class WsfolderController {

    WsfolderService wsfolderService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond wsfolderService.list(params), model:[wsfolderCount: wsfolderService.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def show(Long id) {
        respond wsfolderService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def create() {
        respond new Wsfolder(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def save(Wsfolder wsfolder) {
        if (wsfolder == null) {
            notFound()
            return
        }

        try {
            wsfolderService.save(wsfolder)
        } catch (ValidationException e) {
            respond wsfolder.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'wsfolder.label', default: 'Wsfolder'), wsfolder.id])
                redirect wsfolder
            }
            '*' { respond wsfolder, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def edit(Long id) {
        respond wsfolderService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def update(Wsfolder wsfolder) {
        if (wsfolder == null) {
            notFound()
            return
        }

        try {
            wsfolderService.save(wsfolder)
        } catch (ValidationException e) {
            respond wsfolder.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'wsfolder.label', default: 'Wsfolder'), wsfolder.id])
                redirect wsfolder
            }
            '*'{ respond wsfolder, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        wsfolderService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'wsfolder.label', default: 'Wsfolder'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'wsfolder.label', default: 'Wsfolder'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
