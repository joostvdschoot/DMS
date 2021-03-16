package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class SpsubtabswsController {

    SpsubtabswsService spsubtabswsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond spsubtabswsService.list(params), model:[spsubtabswsCount: spsubtabswsService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond spsubtabswsService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Spsubtabsws(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Spsubtabsws spsubtabsws) {
        if (spsubtabsws == null) {
            notFound()
            return
        }

        try {
            spsubtabswsService.save(spsubtabsws)
        } catch (ValidationException e) {
            respond spsubtabsws.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'spsubtabsws.label', default: 'Spsubtabsws'), spsubtabsws.id])
                redirect spsubtabsws
            }
            '*' { respond spsubtabsws, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond spsubtabswsService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Spsubtabsws spsubtabsws) {
        if (spsubtabsws == null) {
            notFound()
            return
        }

        try {
            spsubtabswsService.save(spsubtabsws)
        } catch (ValidationException e) {
            respond spsubtabsws.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'spsubtabsws.label', default: 'Spsubtabsws'), spsubtabsws.id])
                redirect spsubtabsws
            }
            '*'{ respond spsubtabsws, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        spsubtabswsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'spsubtabsws.label', default: 'Spsubtabsws'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'spsubtabsws.label', default: 'Spsubtabsws'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
