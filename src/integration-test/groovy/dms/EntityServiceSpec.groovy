package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EntityServiceSpec extends Specification {

    EntityService entityService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Entity(...).save(flush: true, failOnError: true)
        //new Entity(...).save(flush: true, failOnError: true)
        //Entity entity = new Entity(...).save(flush: true, failOnError: true)
        //new Entity(...).save(flush: true, failOnError: true)
        //new Entity(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //entity.id
    }

    void "test get"() {
        setupData()

        expect:
        entityService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Entity> entityList = entityService.list(max: 2, offset: 2)

        then:
        entityList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        entityService.count() == 5
    }

    void "test delete"() {
        Long entityId = setupData()

        expect:
        entityService.count() == 5

        when:
        entityService.delete(entityId)
        sessionFactory.currentSession.flush()

        then:
        entityService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Entity entity = new Entity()
        entityService.save(entity)

        then:
        entity.id != null
    }
}
