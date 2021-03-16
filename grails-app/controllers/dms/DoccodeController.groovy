package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class DoccodeController {

    DoccodeService doccodeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond doccodeService.list(params), model:[doccodeCount: doccodeService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond doccodeService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Doccode(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Doccode doccode) {
        if (doccode == null) {
            notFound()
            return
        }

        try {
            doccodeService.save(doccode)
        } catch (ValidationException e) {
            respond doccode.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'doccode.label', default: 'Doccode'), doccode.id])
                redirect doccode
            }
            '*' { respond doccode, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond doccodeService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Doccode doccode) {
        if (doccode == null) {
            notFound()
            return
        }

        try {
            doccodeService.save(doccode)
        } catch (ValidationException e) {
            respond doccode.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'doccode.label', default: 'Doccode'), doccode.id])
                redirect doccode
            }
            '*'{ respond doccode, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        doccodeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'doccode.label', default: 'Doccode'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'doccode.label', default: 'Doccode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
