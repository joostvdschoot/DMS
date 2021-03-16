package dms

import grails.gorm.services.Service

@Service(Doctype)
interface DoctypeService {

    Doctype get(Serializable id)

    List<Doctype> list(Map args)

    Long count()

    void delete(Serializable id)

    Doctype save(Doctype doctype)

}