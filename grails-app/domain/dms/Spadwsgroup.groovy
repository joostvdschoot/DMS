package dms

class Spadwsgroup {

    String cd

    static belongsTo = [cdADWSF:Spadws,cdDocGroup:Docgroup]

    static constraints = {
        cd(maxSize:3, unique:true)
        cdADWSF()
        cdDocGroup()
    }

    String toString() {
        return cd + "-" + cdADWSF + "-" + cdDocGroup
    }


}
