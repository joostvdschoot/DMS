package dms

import grails.gorm.services.Service

@Service(Spsubtabs)
interface SpsubtabsService {

    Spsubtabs get(Serializable id)

    List<Spsubtabs> list(Map args)

    Long count()

    void delete(Serializable id)

    Spsubtabs save(Spsubtabs spsubtabs)

}