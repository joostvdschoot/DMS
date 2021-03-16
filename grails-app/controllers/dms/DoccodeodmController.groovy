package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class DoccodeodmController {

    DoccodeodmService doccodeodmService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond doccodeodmService.list(params), model:[doccodeodmCount: doccodeodmService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond doccodeodmService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Doccodeodm(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Doccodeodm doccodeodm) {
        if (doccodeodm == null) {
            notFound()
            return
        }

        try {
            doccodeodmService.save(doccodeodm)
        } catch (ValidationException e) {
            respond doccodeodm.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'doccodeodm.label', default: 'Doccodeodm'), doccodeodm.id])
                redirect doccodeodm
            }
            '*' { respond doccodeodm, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond doccodeodmService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Doccodeodm doccodeodm) {
        if (doccodeodm == null) {
            notFound()
            return
        }

        try {
            doccodeodmService.save(doccodeodm)
        } catch (ValidationException e) {
            respond doccodeodm.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'doccodeodm.label', default: 'Doccodeodm'), doccodeodm.id])
                redirect doccodeodm
            }
            '*'{ respond doccodeodm, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        doccodeodmService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'doccodeodm.label', default: 'Doccodeodm'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'doccodeodm.label', default: 'Doccodeodm'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
