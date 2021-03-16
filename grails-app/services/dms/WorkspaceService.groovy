package dms

import grails.gorm.services.Service

@Service(Workspace)
interface WorkspaceService {

    Workspace get(Serializable id)

    List<Workspace> list(Map args)

    Long count()

    void delete(Serializable id)

    Workspace save(Workspace workspace)

}