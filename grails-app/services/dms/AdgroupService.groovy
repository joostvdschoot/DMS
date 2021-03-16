package dms

import grails.gorm.services.Service

@Service(Adgroup)
interface AdgroupService {

    Adgroup get(Serializable id)

    List<Adgroup> list(Map args)

    Long count()

    void delete(Serializable id)

    Adgroup save(Adgroup adgroup)

}