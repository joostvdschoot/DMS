package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DoccodeServiceSpec extends Specification {

    DoccodeService doccodeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Doccode(...).save(flush: true, failOnError: true)
        //new Doccode(...).save(flush: true, failOnError: true)
        //Doccode doccode = new Doccode(...).save(flush: true, failOnError: true)
        //new Doccode(...).save(flush: true, failOnError: true)
        //new Doccode(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //doccode.id
    }

    void "test get"() {
        setupData()

        expect:
        doccodeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Doccode> doccodeList = doccodeService.list(max: 2, offset: 2)

        then:
        doccodeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        doccodeService.count() == 5
    }

    void "test delete"() {
        Long doccodeId = setupData()

        expect:
        doccodeService.count() == 5

        when:
        doccodeService.delete(doccodeId)
        sessionFactory.currentSession.flush()

        then:
        doccodeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Doccode doccode = new Doccode()
        doccodeService.save(doccode)

        then:
        doccode.id != null
    }
}
