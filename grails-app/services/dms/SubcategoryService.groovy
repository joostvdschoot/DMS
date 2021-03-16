package dms

import grails.gorm.services.Service

@Service(Subcategory)
interface SubcategoryService {

    Subcategory get(Serializable id)

    List<Subcategory> list(Map args)

    Long count()

    void delete(Serializable id)

    Subcategory save(Subcategory subcategory)

}