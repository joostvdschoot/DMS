package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SpadwsgroupServiceSpec extends Specification {

    SpadwsgroupService spadwsgroupService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Spadwsgroup(...).save(flush: true, failOnError: true)
        //new Spadwsgroup(...).save(flush: true, failOnError: true)
        //Spadwsgroup spadwsgroup = new Spadwsgroup(...).save(flush: true, failOnError: true)
        //new Spadwsgroup(...).save(flush: true, failOnError: true)
        //new Spadwsgroup(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //spadwsgroup.id
    }

    void "test get"() {
        setupData()

        expect:
        spadwsgroupService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Spadwsgroup> spadwsgroupList = spadwsgroupService.list(max: 2, offset: 2)

        then:
        spadwsgroupList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        spadwsgroupService.count() == 5
    }

    void "test delete"() {
        Long spadwsgroupId = setupData()

        expect:
        spadwsgroupService.count() == 5

        when:
        spadwsgroupService.delete(spadwsgroupId)
        sessionFactory.currentSession.flush()

        then:
        spadwsgroupService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Spadwsgroup spadwsgroup = new Spadwsgroup()
        spadwsgroupService.save(spadwsgroup)

        then:
        spadwsgroup.id != null
    }
}
