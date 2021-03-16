package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DoctypeServiceSpec extends Specification {

    DoctypeService doctypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Doctype(...).save(flush: true, failOnError: true)
        //new Doctype(...).save(flush: true, failOnError: true)
        //Doctype doctype = new Doctype(...).save(flush: true, failOnError: true)
        //new Doctype(...).save(flush: true, failOnError: true)
        //new Doctype(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //doctype.id
    }

    void "test get"() {
        setupData()

        expect:
        doctypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Doctype> doctypeList = doctypeService.list(max: 2, offset: 2)

        then:
        doctypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        doctypeService.count() == 5
    }

    void "test delete"() {
        Long doctypeId = setupData()

        expect:
        doctypeService.count() == 5

        when:
        doctypeService.delete(doctypeId)
        sessionFactory.currentSession.flush()

        then:
        doctypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Doctype doctype = new Doctype()
        doctypeService.save(doctype)

        then:
        doctype.id != null
    }
}
