package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SubcategoryServiceSpec extends Specification {

    SubcategoryService subcategoryService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Subcategory(...).save(flush: true, failOnError: true)
        //new Subcategory(...).save(flush: true, failOnError: true)
        //Subcategory subcategory = new Subcategory(...).save(flush: true, failOnError: true)
        //new Subcategory(...).save(flush: true, failOnError: true)
        //new Subcategory(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //subcategory.id
    }

    void "test get"() {
        setupData()

        expect:
        subcategoryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Subcategory> subcategoryList = subcategoryService.list(max: 2, offset: 2)

        then:
        subcategoryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        subcategoryService.count() == 5
    }

    void "test delete"() {
        Long subcategoryId = setupData()

        expect:
        subcategoryService.count() == 5

        when:
        subcategoryService.delete(subcategoryId)
        sessionFactory.currentSession.flush()

        then:
        subcategoryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Subcategory subcategory = new Subcategory()
        subcategoryService.save(subcategory)

        then:
        subcategory.id != null
    }
}
