package dms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FolderServiceSpec extends Specification {

    FolderService folderService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Folder(...).save(flush: true, failOnError: true)
        //new Folder(...).save(flush: true, failOnError: true)
        //Folder folder = new Folder(...).save(flush: true, failOnError: true)
        //new Folder(...).save(flush: true, failOnError: true)
        //new Folder(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //folder.id
    }

    void "test get"() {
        setupData()

        expect:
        folderService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Folder> folderList = folderService.list(max: 2, offset: 2)

        then:
        folderList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        folderService.count() == 5
    }

    void "test delete"() {
        Long folderId = setupData()

        expect:
        folderService.count() == 5

        when:
        folderService.delete(folderId)
        sessionFactory.currentSession.flush()

        then:
        folderService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Folder folder = new Folder()
        folderService.save(folder)

        then:
        folder.id != null
    }
}
