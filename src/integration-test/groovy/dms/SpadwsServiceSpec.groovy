package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SpadwsServiceSpec extends Specification {

    SpadwsService spadwsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Spadws(...).save(flush: true, failOnError: true)
        //new Spadws(...).save(flush: true, failOnError: true)
        //Spadws spadws = new Spadws(...).save(flush: true, failOnError: true)
        //new Spadws(...).save(flush: true, failOnError: true)
        //new Spadws(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //spadws.id
    }

    void "test get"() {
        setupData()

        expect:
        spadwsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Spadws> spadwsList = spadwsService.list(max: 2, offset: 2)

        then:
        spadwsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        spadwsService.count() == 5
    }

    void "test delete"() {
        Long spadwsId = setupData()

        expect:
        spadwsService.count() == 5

        when:
        spadwsService.delete(spadwsId)
        sessionFactory.currentSession.flush()

        then:
        spadwsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Spadws spadws = new Spadws()
        spadwsService.save(spadws)

        then:
        spadws.id != null
    }
}
