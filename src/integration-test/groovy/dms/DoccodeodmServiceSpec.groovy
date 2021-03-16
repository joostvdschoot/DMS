package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DoccodeodmServiceSpec extends Specification {

    DoccodeodmService doccodeodmService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Doccodeodm(...).save(flush: true, failOnError: true)
        //new Doccodeodm(...).save(flush: true, failOnError: true)
        //Doccodeodm doccodeodm = new Doccodeodm(...).save(flush: true, failOnError: true)
        //new Doccodeodm(...).save(flush: true, failOnError: true)
        //new Doccodeodm(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //doccodeodm.id
    }

    void "test get"() {
        setupData()

        expect:
        doccodeodmService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Doccodeodm> doccodeodmList = doccodeodmService.list(max: 2, offset: 2)

        then:
        doccodeodmList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        doccodeodmService.count() == 5
    }

    void "test delete"() {
        Long doccodeodmId = setupData()

        expect:
        doccodeodmService.count() == 5

        when:
        doccodeodmService.delete(doccodeodmId)
        sessionFactory.currentSession.flush()

        then:
        doccodeodmService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Doccodeodm doccodeodm = new Doccodeodm()
        doccodeodmService.save(doccodeodm)

        then:
        doccodeodm.id != null
    }
}
