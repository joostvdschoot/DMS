package dms

class Docgroup {

    String cd
    String description
    Boolean idSTP

    static hasMany = [spadwsgroups: Spadwsgroup]

    static constraints = {
        cd(maxSize:200, unique:true)
        description(maxSize:100)
        idSTP()
        spadwsgroups()
    }

    String toString() {
        return cd
    }
}
