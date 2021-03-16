package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AdgroupServiceSpec extends Specification {

    AdgroupService adgroupService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Adgroup(...).save(flush: true, failOnError: true)
        //new Adgroup(...).save(flush: true, failOnError: true)
        //Adgroup adgroup = new Adgroup(...).save(flush: true, failOnError: true)
        //new Adgroup(...).save(flush: true, failOnError: true)
        //new Adgroup(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //adgroup.id
    }

    void "test get"() {
        setupData()

        expect:
        adgroupService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Adgroup> adgroupList = adgroupService.list(max: 2, offset: 2)

        then:
        adgroupList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        adgroupService.count() == 5
    }

    void "test delete"() {
        Long adgroupId = setupData()

        expect:
        adgroupService.count() == 5

        when:
        adgroupService.delete(adgroupId)
        sessionFactory.currentSession.flush()

        then:
        adgroupService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Adgroup adgroup = new Adgroup()
        adgroupService.save(adgroup)

        then:
        adgroup.id != null
    }
}
