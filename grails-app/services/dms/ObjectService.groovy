package dms

import grails.gorm.services.Service

@Service(Object)
interface ObjectService {

    Object get(Serializable id)

    List<Object> list(Map args)

    Long count()

    void delete(Serializable id)

    Object save(Object object)

}