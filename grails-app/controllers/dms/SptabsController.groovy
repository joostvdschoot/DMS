package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class SptabsController {

    SptabsService sptabsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sptabsService.list(params), model:[sptabsCount: sptabsService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond sptabsService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Sptabs(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Sptabs sptabs) {
        if (sptabs == null) {
            notFound()
            return
        }

        try {
            sptabsService.save(sptabs)
        } catch (ValidationException e) {
            respond sptabs.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sptabs.label', default: 'Sptabs'), sptabs.id])
                redirect sptabs
            }
            '*' { respond sptabs, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond sptabsService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Sptabs sptabs) {
        if (sptabs == null) {
            notFound()
            return
        }

        try {
            sptabsService.save(sptabs)
        } catch (ValidationException e) {
            respond sptabs.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sptabs.label', default: 'Sptabs'), sptabs.id])
                redirect sptabs
            }
            '*'{ respond sptabs, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sptabsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sptabs.label', default: 'Sptabs'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sptabs.label', default: 'Sptabs'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
