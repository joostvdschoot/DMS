package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class DocgroupstructController {

    DocgroupstructService docgroupstructService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond docgroupstructService.list(params), model:[docgroupstructCount: docgroupstructService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond docgroupstructService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Docgroupstruct(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Docgroupstruct docgroupstruct) {
        if (docgroupstruct == null) {
            notFound()
            return
        }

        try {
            docgroupstructService.save(docgroupstruct)
        } catch (ValidationException e) {
            respond docgroupstruct.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'docgroupstruct.label', default: 'Docgroupstruct'), docgroupstruct.id])
                redirect docgroupstruct
            }
            '*' { respond docgroupstruct, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond docgroupstructService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Docgroupstruct docgroupstruct) {
        if (docgroupstruct == null) {
            notFound()
            return
        }

        try {
            docgroupstructService.save(docgroupstruct)
        } catch (ValidationException e) {
            respond docgroupstruct.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'docgroupstruct.label', default: 'Docgroupstruct'), docgroupstruct.id])
                redirect docgroupstruct
            }
            '*'{ respond docgroupstruct, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        docgroupstructService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'docgroupstruct.label', default: 'Docgroupstruct'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'docgroupstruct.label', default: 'Docgroupstruct'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
