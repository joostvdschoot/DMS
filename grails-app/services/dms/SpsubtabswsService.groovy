package dms

import grails.gorm.services.Service

@Service(Spsubtabsws)
interface SpsubtabswsService {

    Spsubtabsws get(Serializable id)

    List<Spsubtabsws> list(Map args)

    Long count()

    void delete(Serializable id)

    Spsubtabsws save(Spsubtabsws spsubtabsws)

}