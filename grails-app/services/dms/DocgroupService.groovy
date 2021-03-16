package dms

import grails.gorm.services.Service

@Service(Docgroup)
interface DocgroupService {

    Docgroup get(Serializable id)

    List<Docgroup> list(Map args)

    Long count()

    void delete(Serializable id)

    Docgroup save(Docgroup docgroup)

}