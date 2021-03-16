package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SpsubtabswsServiceSpec extends Specification {

    SpsubtabswsService spsubtabswsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Spsubtabsws(...).save(flush: true, failOnError: true)
        //new Spsubtabsws(...).save(flush: true, failOnError: true)
        //Spsubtabsws spsubtabsws = new Spsubtabsws(...).save(flush: true, failOnError: true)
        //new Spsubtabsws(...).save(flush: true, failOnError: true)
        //new Spsubtabsws(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //spsubtabsws.id
    }

    void "test get"() {
        setupData()

        expect:
        spsubtabswsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Spsubtabsws> spsubtabswsList = spsubtabswsService.list(max: 2, offset: 2)

        then:
        spsubtabswsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        spsubtabswsService.count() == 5
    }

    void "test delete"() {
        Long spsubtabswsId = setupData()

        expect:
        spsubtabswsService.count() == 5

        when:
        spsubtabswsService.delete(spsubtabswsId)
        sessionFactory.currentSession.flush()

        then:
        spsubtabswsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Spsubtabsws spsubtabsws = new Spsubtabsws()
        spsubtabswsService.save(spsubtabsws)

        then:
        spsubtabsws.id != null
    }
}
