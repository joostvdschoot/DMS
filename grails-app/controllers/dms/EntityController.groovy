package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class EntityController {

    EntityService entityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond entityService.list(params), model:[entityCount: entityService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond entityService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Entity(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Entity entity) {
        if (entity == null) {
            notFound()
            return
        }

        try {
            entityService.save(entity)
        } catch (ValidationException e) {
            respond entity.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'entity.label', default: 'Entity'), entity.id])
                redirect entity
            }
            '*' { respond entity, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond entityService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Entity entity) {
        if (entity == null) {
            notFound()
            return
        }

        try {
            entityService.save(entity)
        } catch (ValidationException e) {
            respond entity.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'entity.label', default: 'Entity'), entity.id])
                redirect entity
            }
            '*'{ respond entity, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        entityService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'entity.label', default: 'Entity'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entity.label', default: 'Entity'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
