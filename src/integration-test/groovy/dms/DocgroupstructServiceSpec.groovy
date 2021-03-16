package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DocgroupstructServiceSpec extends Specification {

    DocgroupstructService docgroupstructService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Docgroupstruct(...).save(flush: true, failOnError: true)
        //new Docgroupstruct(...).save(flush: true, failOnError: true)
        //Docgroupstruct docgroupstruct = new Docgroupstruct(...).save(flush: true, failOnError: true)
        //new Docgroupstruct(...).save(flush: true, failOnError: true)
        //new Docgroupstruct(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //docgroupstruct.id
    }

    void "test get"() {
        setupData()

        expect:
        docgroupstructService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Docgroupstruct> docgroupstructList = docgroupstructService.list(max: 2, offset: 2)

        then:
        docgroupstructList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        docgroupstructService.count() == 5
    }

    void "test delete"() {
        Long docgroupstructId = setupData()

        expect:
        docgroupstructService.count() == 5

        when:
        docgroupstructService.delete(docgroupstructId)
        sessionFactory.currentSession.flush()

        then:
        docgroupstructService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Docgroupstruct docgroupstruct = new Docgroupstruct()
        docgroupstructService.save(docgroupstruct)

        then:
        docgroupstruct.id != null
    }
}
