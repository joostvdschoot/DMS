package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class S2ptabsServiceSpec extends Specification {

    S2ptabsService s2ptabsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new S2ptabs(...).save(flush: true, failOnError: true)
        //new S2ptabs(...).save(flush: true, failOnError: true)
        //S2ptabs s2ptabs = new S2ptabs(...).save(flush: true, failOnError: true)
        //new S2ptabs(...).save(flush: true, failOnError: true)
        //new S2ptabs(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //s2ptabs.id
    }

    void "test get"() {
        setupData()

        expect:
        s2ptabsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<S2ptabs> s2ptabsList = s2ptabsService.list(max: 2, offset: 2)

        then:
        s2ptabsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        s2ptabsService.count() == 5
    }

    void "test delete"() {
        Long s2ptabsId = setupData()

        expect:
        s2ptabsService.count() == 5

        when:
        s2ptabsService.delete(s2ptabsId)
        sessionFactory.currentSession.flush()

        then:
        s2ptabsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        S2ptabs s2ptabs = new S2ptabs()
        s2ptabsService.save(s2ptabs)

        then:
        s2ptabs.id != null
    }
}
