package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SptabsServiceSpec extends Specification {

    SptabsService sptabsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Sptabs(...).save(flush: true, failOnError: true)
        //new Sptabs(...).save(flush: true, failOnError: true)
        //Sptabs sptabs = new Sptabs(...).save(flush: true, failOnError: true)
        //new Sptabs(...).save(flush: true, failOnError: true)
        //new Sptabs(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sptabs.id
    }

    void "test get"() {
        setupData()

        expect:
        sptabsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Sptabs> sptabsList = sptabsService.list(max: 2, offset: 2)

        then:
        sptabsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sptabsService.count() == 5
    }

    void "test delete"() {
        Long sptabsId = setupData()

        expect:
        sptabsService.count() == 5

        when:
        sptabsService.delete(sptabsId)
        sessionFactory.currentSession.flush()

        then:
        sptabsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Sptabs sptabs = new Sptabs()
        sptabsService.save(sptabs)

        then:
        sptabs.id != null
    }
}
