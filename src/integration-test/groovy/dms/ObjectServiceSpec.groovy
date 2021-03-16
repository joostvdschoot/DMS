package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ObjectServiceSpec extends Specification {

    ObjectService objectService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Object(...).save(flush: true, failOnError: true)
        //new Object(...).save(flush: true, failOnError: true)
        //Object object = new Object(...).save(flush: true, failOnError: true)
        //new Object(...).save(flush: true, failOnError: true)
        //new Object(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //object.id
    }

    void "test get"() {
        setupData()

        expect:
        objectService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Object> objectList = objectService.list(max: 2, offset: 2)

        then:
        objectList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        objectService.count() == 5
    }

    void "test delete"() {
        Long objectId = setupData()

        expect:
        objectService.count() == 5

        when:
        objectService.delete(objectId)
        sessionFactory.currentSession.flush()

        then:
        objectService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Object object = new Object()
        objectService.save(object)

        then:
        object.id != null
    }
}
