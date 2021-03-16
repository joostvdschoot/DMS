package dms

import grails.gorm.services.Service

@Service(Doccode)
interface DoccodeService {

    Doccode get(Serializable id)

    List<Doccode> list(Map args)

    Long count()

    void delete(Serializable id)

    Doccode save(Doccode doccode)

}