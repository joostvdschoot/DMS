package dms

import grails.gorm.services.Service

@Service(S2ptabs)
interface S2ptabsService {

    S2ptabs get(Serializable id)

    List<S2ptabs> list(Map args)

    Long count()

    void delete(Serializable id)

    S2ptabs save(S2ptabs s2ptabs)

}