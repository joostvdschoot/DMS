package dms

import grails.gorm.services.Service

@Service(Ardepartments)
interface ArdepartmentsService {

    Ardepartments get(Serializable id)

    List<Ardepartments> list(Map args)

    Long count()

    void delete(Serializable id)

    Ardepartments save(Ardepartments ardepartments)

}