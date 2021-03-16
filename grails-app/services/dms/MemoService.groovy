package dms

import grails.gorm.services.Service

@Service(Memo)
interface MemoService {

    Memo get(Serializable id)

    List<Memo> list(Map args)

    Long count()

    void delete(Serializable id)

    Memo save(Memo memo)

}