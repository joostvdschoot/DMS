package dms

import grails.gorm.services.Service

@Service(Spadwsgroup)
interface SpadwsgroupService {

    Spadwsgroup get(Serializable id)

    List<Spadwsgroup> list(Map args)

    Long count()

    void delete(Serializable id)

    Spadwsgroup save(Spadwsgroup spadwsgroup)

}