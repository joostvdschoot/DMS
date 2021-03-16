package dms

class Spadws {

    String cd
    String idInclExcl

    static belongsTo = [cdAD:Adgroup,cdWS:Workspace,cdFolder:Folder]
    static hasMany = [spadwsgroups: Spadwsgroup]


    static constraints = {
        cd(maxSize:3, unique:true)
        cdAD()
        cdWS()
        cdFolder()
        idInclExcl(inList: ['A', 'I', 'E'])
        spadwsgroups()
    }

    String toString() {
        return cd + "-" + cdAD + "-" + cdWS + "-" + cdFolder
    }
}
