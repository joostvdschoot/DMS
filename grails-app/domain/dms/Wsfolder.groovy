package dms

class Wsfolder {

    String cd

    static belongsTo = [cdEntity:Entity,cdWs:Workspace,cdFolder:Folder]

    static constraints = {
        cd(maxSize:3, unique:true)
        cdEntity()
        cdWs()
        cdFolder()
    }

}
