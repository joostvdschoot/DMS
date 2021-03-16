package dms

import grails.gorm.services.Service

@Service(Sptabs)
interface SptabsService {

    Sptabs get(Serializable id)

    List<Sptabs> list(Map args)

    Long count()

    void delete(Serializable id)

    Sptabs save(Sptabs sptabs)

}