package dms

import grails.gorm.services.Service

@Service(Wsfolder)
interface WsfolderService {

    Wsfolder get(Serializable id)

    List<Wsfolder> list(Map args)

    Long count()

    void delete(Serializable id)

    Wsfolder save(Wsfolder wsfolder)

}