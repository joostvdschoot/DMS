package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class DocgroupController {

    DocgroupService docgroupService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond docgroupService.list(params), model:[docgroupCount: docgroupService.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def show(Long id) {
        respond docgroupService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def create() {
        respond new Docgroup(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def save(Docgroup docgroup) {
        if (docgroup == null) {
            notFound()
            return
        }

        try {
            docgroupService.save(docgroup)
        } catch (ValidationException e) {
            respond docgroup.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'docgroup.label', default: 'Docgroup'), docgroup.id])
                redirect docgroup
            }
            '*' { respond docgroup, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def edit(Long id) {
        respond docgroupService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def update(Docgroup docgroup) {
        if (docgroup == null) {
            notFound()
            return
        }

        try {
            docgroupService.save(docgroup)
        } catch (ValidationException e) {
            respond docgroup.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'docgroup.label', default: 'Docgroup'), docgroup.id])
                redirect docgroup
            }
            '*'{ respond docgroup, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        docgroupService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'docgroup.label', default: 'Docgroup'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'docgroup.label', default: 'Docgroup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
