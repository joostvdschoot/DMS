package dms

import grails.gorm.services.Service

@Service(S2pstruct)
interface S2pstructService {

    S2pstruct get(Serializable id)

    List<S2pstruct> list(Map args)

    Long count()

    void delete(Serializable id)

    S2pstruct save(S2pstruct s2pstruct)

}