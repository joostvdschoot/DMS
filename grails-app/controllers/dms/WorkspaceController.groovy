package dms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class WorkspaceController {

    WorkspaceService workspaceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond workspaceService.list(params), model:[workspaceCount: workspaceService.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        respond workspaceService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Workspace(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Workspace workspace) {
        if (workspace == null) {
            notFound()
            return
        }

        try {
            workspaceService.save(workspace)
        } catch (ValidationException e) {
            respond workspace.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'workspace.label', default: 'Workspace'), workspace.id])
                redirect workspace
            }
            '*' { respond workspace, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond workspaceService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Workspace workspace) {
        if (workspace == null) {
            notFound()
            return
        }

        try {
            workspaceService.save(workspace)
        } catch (ValidationException e) {
            respond workspace.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'workspace.label', default: 'Workspace'), workspace.id])
                redirect workspace
            }
            '*'{ respond workspace, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        workspaceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'workspace.label', default: 'Workspace'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'workspace.label', default: 'Workspace'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
