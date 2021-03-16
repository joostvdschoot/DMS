package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class FolderController {

    FolderService folderService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond folderService.list(params), model:[folderCount: folderService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond folderService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Folder(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Folder folder) {
        if (folder == null) {
            notFound()
            return
        }

        try {
            folderService.save(folder)
        } catch (ValidationException e) {
            respond folder.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'folder.label', default: 'Folder'), folder.id])
                redirect folder
            }
            '*' { respond folder, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond folderService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Folder folder) {
        if (folder == null) {
            notFound()
            return
        }

        try {
            folderService.save(folder)
        } catch (ValidationException e) {
            respond folder.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'folder.label', default: 'Folder'), folder.id])
                redirect folder
            }
            '*'{ respond folder, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        folderService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'folder.label', default: 'Folder'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'folder.label', default: 'Folder'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
