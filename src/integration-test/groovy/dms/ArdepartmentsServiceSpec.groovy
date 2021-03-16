package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ArdepartmentsServiceSpec extends Specification {

    ArdepartmentsService ardepartmentsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ardepartments(...).save(flush: true, failOnError: true)
        //new Ardepartments(...).save(flush: true, failOnError: true)
        //Ardepartments ardepartments = new Ardepartments(...).save(flush: true, failOnError: true)
        //new Ardepartments(...).save(flush: true, failOnError: true)
        //new Ardepartments(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ardepartments.id
    }

    void "test get"() {
        setupData()

        expect:
        ardepartmentsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ardepartments> ardepartmentsList = ardepartmentsService.list(max: 2, offset: 2)

        then:
        ardepartmentsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ardepartmentsService.count() == 5
    }

    void "test delete"() {
        Long ardepartmentsId = setupData()

        expect:
        ardepartmentsService.count() == 5

        when:
        ardepartmentsService.delete(ardepartmentsId)
        sessionFactory.currentSession.flush()

        then:
        ardepartmentsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ardepartments ardepartments = new Ardepartments()
        ardepartmentsService.save(ardepartments)

        then:
        ardepartments.id != null
    }
}
