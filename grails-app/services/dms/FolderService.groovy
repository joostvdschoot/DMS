package dms

import grails.gorm.services.Service

@Service(Folder)
interface FolderService {

    Folder get(Serializable id)

    List<Folder> list(Map args)

    Long count()

    void delete(Serializable id)

    Folder save(Folder folder)

}