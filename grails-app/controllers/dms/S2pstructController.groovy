package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class S2pstructController {

    S2pstructService s2pstructService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond s2pstructService.list(params), model:[s2pstructCount: s2pstructService.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def show(Long id) {
        respond s2pstructService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def create() {
        respond new S2pstruct(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def save(S2pstruct s2pstruct) {
        if (s2pstruct == null) {
            notFound()
            return
        }

        try {
            s2pstructService.save(s2pstruct)
        } catch (ValidationException e) {
            respond s2pstruct.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 's2pstruct.label', default: 'S2pstruct'), s2pstruct.id])
                redirect s2pstruct
            }
            '*' { respond s2pstruct, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def edit(Long id) {
        respond s2pstructService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def update(S2pstruct s2pstruct) {
        if (s2pstruct == null) {
            notFound()
            return
        }

        try {
            s2pstructService.save(s2pstruct)
        } catch (ValidationException e) {
            respond s2pstruct.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 's2pstruct.label', default: 'S2pstruct'), s2pstruct.id])
                redirect s2pstruct
            }
            '*'{ respond s2pstruct, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_CONFIG'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        s2pstructService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 's2pstruct.label', default: 'S2pstruct'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 's2pstruct.label', default: 'S2pstruct'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
