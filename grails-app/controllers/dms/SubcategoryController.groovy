package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class SubcategoryController {

    SubcategoryService subcategoryService


    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond subcategoryService.list(params), model:[subcategoryCount: subcategoryService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond subcategoryService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Subcategory(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Subcategory subcategory) {
        if (subcategory == null) {
            notFound()
            return
        }

        try {
            subcategoryService.save(subcategory)
        } catch (ValidationException e) {
            respond subcategory.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'subcategory.label', default: 'Subcategory'), subcategory.id])
                redirect subcategory
            }
            '*' { respond subcategory, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond subcategoryService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Subcategory subcategory) {
        if (subcategory == null) {
            notFound()
            return
        }

        try {
            subcategoryService.save(subcategory)
        } catch (ValidationException e) {
            respond subcategory.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'subcategory.label', default: 'Subcategory'), subcategory.id])
                redirect subcategory
            }
            '*'{ respond subcategory, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        subcategoryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'subcategory.label', default: 'Subcategory'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'subcategory.label', default: 'Subcategory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
