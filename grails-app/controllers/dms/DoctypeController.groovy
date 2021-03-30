package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class DoctypeController {

    DoctypeService doctypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond doctypeService.list(params), model:[doctypeCount: doctypeService.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def show(Long id) {
        respond doctypeService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def create() {
        respond new Doctype(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def save(Doctype doctype) {
        if (doctype == null) {
            notFound()
            return
        }

        try {
            doctypeService.save(doctype)
        } catch (ValidationException e) {
            respond doctype.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'doctype.label', default: 'Doctype'), doctype.id])
                redirect doctype
            }
            '*' { respond doctype, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def edit(Long id) {
        respond doctypeService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def update(Doctype doctype) {
        if (doctype == null) {
            notFound()
            return
        }

        try {
            doctypeService.save(doctype)
        } catch (ValidationException e) {
            respond doctype.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'doctype.label', default: 'Doctype'), doctype.id])
                redirect doctype
            }
            '*'{ respond doctype, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        doctypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'doctype.label', default: 'Doctype'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctype.label', default: 'Doctype'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
