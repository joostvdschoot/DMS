package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class AdgroupController {

    AdgroupService adgroupService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond adgroupService.list(params), model:[adgroupCount: adgroupService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond adgroupService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Adgroup(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Adgroup adgroup) {
        if (adgroup == null) {
            notFound()
            return
        }

        try {
            adgroupService.save(adgroup)
        } catch (ValidationException e) {
            respond adgroup.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'adgroup.label', default: 'Adgroup'), adgroup.id])
                redirect adgroup
            }
            '*' { respond adgroup, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond adgroupService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Adgroup adgroup) {
        if (adgroup == null) {
            notFound()
            return
        }

        try {
            adgroupService.save(adgroup)
        } catch (ValidationException e) {
            respond adgroup.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'adgroup.label', default: 'Adgroup'), adgroup.id])
                redirect adgroup
            }
            '*'{ respond adgroup, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        adgroupService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'adgroup.label', default: 'Adgroup'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'adgroup.label', default: 'Adgroup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
