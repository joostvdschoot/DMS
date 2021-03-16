package dms

import grails.gorm.services.Service

@Service(Doccodeodm)
interface DoccodeodmService {

    Doccodeodm get(Serializable id)

    List<Doccodeodm> list(Map args)

    Long count()

    void delete(Serializable id)

    Doccodeodm save(Doccodeodm doccodeodm)

}