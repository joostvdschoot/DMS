package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class SpsubtabsController {

    SpsubtabsService spsubtabsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond spsubtabsService.list(params), model:[spsubtabsCount: spsubtabsService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond spsubtabsService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Spsubtabs(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Spsubtabs spsubtabs) {
        if (spsubtabs == null) {
            notFound()
            return
        }

        try {
            spsubtabsService.save(spsubtabs)
        } catch (ValidationException e) {
            respond spsubtabs.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'spsubtabs.label', default: 'Spsubtabs'), spsubtabs.id])
                redirect spsubtabs
            }
            '*' { respond spsubtabs, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond spsubtabsService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Spsubtabs spsubtabs) {
        if (spsubtabs == null) {
            notFound()
            return
        }

        try {
            spsubtabsService.save(spsubtabs)
        } catch (ValidationException e) {
            respond spsubtabs.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'spsubtabs.label', default: 'Spsubtabs'), spsubtabs.id])
                redirect spsubtabs
            }
            '*'{ respond spsubtabs, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        spsubtabsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'spsubtabs.label', default: 'Spsubtabs'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'spsubtabs.label', default: 'Spsubtabs'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
