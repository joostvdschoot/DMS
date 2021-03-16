package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WorkspaceServiceSpec extends Specification {

    WorkspaceService workspaceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Workspace(...).save(flush: true, failOnError: true)
        //new Workspace(...).save(flush: true, failOnError: true)
        //Workspace workspace = new Workspace(...).save(flush: true, failOnError: true)
        //new Workspace(...).save(flush: true, failOnError: true)
        //new Workspace(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //workspace.id
    }

    void "test get"() {
        setupData()

        expect:
        workspaceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Workspace> workspaceList = workspaceService.list(max: 2, offset: 2)

        then:
        workspaceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        workspaceService.count() == 5
    }

    void "test delete"() {
        Long workspaceId = setupData()

        expect:
        workspaceService.count() == 5

        when:
        workspaceService.delete(workspaceId)
        sessionFactory.currentSession.flush()

        then:
        workspaceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Workspace workspace = new Workspace()
        workspaceService.save(workspace)

        then:
        workspace.id != null
    }
}
