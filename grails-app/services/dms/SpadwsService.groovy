package dms

import grails.gorm.services.Service

@Service(Spadws)
interface SpadwsService {

    Spadws get(Serializable id)

    List<Spadws> list(Map args)

    Long count()

    void delete(Serializable id)

    Spadws save(Spadws spadws)

}