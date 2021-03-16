package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SpsubtabsServiceSpec extends Specification {

    SpsubtabsService spsubtabsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Spsubtabs(...).save(flush: true, failOnError: true)
        //new Spsubtabs(...).save(flush: true, failOnError: true)
        //Spsubtabs spsubtabs = new Spsubtabs(...).save(flush: true, failOnError: true)
        //new Spsubtabs(...).save(flush: true, failOnError: true)
        //new Spsubtabs(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //spsubtabs.id
    }

    void "test get"() {
        setupData()

        expect:
        spsubtabsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Spsubtabs> spsubtabsList = spsubtabsService.list(max: 2, offset: 2)

        then:
        spsubtabsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        spsubtabsService.count() == 5
    }

    void "test delete"() {
        Long spsubtabsId = setupData()

        expect:
        spsubtabsService.count() == 5

        when:
        spsubtabsService.delete(spsubtabsId)
        sessionFactory.currentSession.flush()

        then:
        spsubtabsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Spsubtabs spsubtabs = new Spsubtabs()
        spsubtabsService.save(spsubtabs)

        then:
        spsubtabs.id != null
    }
}
