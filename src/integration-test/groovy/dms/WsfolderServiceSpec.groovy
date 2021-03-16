package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WsfolderServiceSpec extends Specification {

    WsfolderService wsfolderService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Wsfolder(...).save(flush: true, failOnError: true)
        //new Wsfolder(...).save(flush: true, failOnError: true)
        //Wsfolder wsfolder = new Wsfolder(...).save(flush: true, failOnError: true)
        //new Wsfolder(...).save(flush: true, failOnError: true)
        //new Wsfolder(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //wsfolder.id
    }

    void "test get"() {
        setupData()

        expect:
        wsfolderService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Wsfolder> wsfolderList = wsfolderService.list(max: 2, offset: 2)

        then:
        wsfolderList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        wsfolderService.count() == 5
    }

    void "test delete"() {
        Long wsfolderId = setupData()

        expect:
        wsfolderService.count() == 5

        when:
        wsfolderService.delete(wsfolderId)
        sessionFactory.currentSession.flush()

        then:
        wsfolderService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Wsfolder wsfolder = new Wsfolder()
        wsfolderService.save(wsfolder)

        then:
        wsfolder.id != null
    }
}
