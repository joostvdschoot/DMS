package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DocgroupServiceSpec extends Specification {

    DocgroupService docgroupService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Docgroup(...).save(flush: true, failOnError: true)
        //new Docgroup(...).save(flush: true, failOnError: true)
        //Docgroup docgroup = new Docgroup(...).save(flush: true, failOnError: true)
        //new Docgroup(...).save(flush: true, failOnError: true)
        //new Docgroup(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //docgroup.id
    }

    void "test get"() {
        setupData()

        expect:
        docgroupService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Docgroup> docgroupList = docgroupService.list(max: 2, offset: 2)

        then:
        docgroupList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        docgroupService.count() == 5
    }

    void "test delete"() {
        Long docgroupId = setupData()

        expect:
        docgroupService.count() == 5

        when:
        docgroupService.delete(docgroupId)
        sessionFactory.currentSession.flush()

        then:
        docgroupService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Docgroup docgroup = new Docgroup()
        docgroupService.save(docgroup)

        then:
        docgroup.id != null
    }
}
