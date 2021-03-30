package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class ArdepartmentsController {


    ArdepartmentsService ardepartmentsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ardepartmentsService.list(params), model:[ardepartmentsCount: ardepartmentsService.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def show(Long id) {
        respond ardepartmentsService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def create() {
        respond new Ardepartments(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def save(Ardepartments ardepartments) {
        if (ardepartments == null) {
            notFound()
            return
        }

        try {
            ardepartmentsService.save(ardepartments)
        } catch (ValidationException e) {
            respond ardepartments.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ardepartments.label', default: 'Ardepartments'), ardepartments.id])
                redirect ardepartments
            }
            '*' { respond ardepartments, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def edit(Long id) {
        respond ardepartmentsService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def update(Ardepartments ardepartments) {
        if (ardepartments == null) {
            notFound()
            return
        }

        try {
            ardepartmentsService.save(ardepartments)
        } catch (ValidationException e) {
            respond ardepartments.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ardepartments.label', default: 'Ardepartments'), ardepartments.id])
                redirect ardepartments
            }
            '*'{ respond ardepartments, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ardepartmentsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ardepartments.label', default: 'Ardepartments'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ardepartments.label', default: 'Ardepartments'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
