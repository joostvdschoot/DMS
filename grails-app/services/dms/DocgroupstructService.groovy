package dms

import grails.gorm.services.Service

@Service(Docgroupstruct)
interface DocgroupstructService {

    Docgroupstruct get(Serializable id)

    List<Docgroupstruct> list(Map args)

    Long count()

    void delete(Serializable id)

    Docgroupstruct save(Docgroupstruct docgroupstruct)

}