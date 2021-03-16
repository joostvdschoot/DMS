package dms

class S2pstruct {

    String cd

    static belongsTo = [cdTab:S2ptabs,cdDept:Department,cdDocGroup:Docgroup]

    static constraints = {
        cd(maxSize:3, unique:true)
        cdTab()
        cdDept()
        cdDocGroup()
    }

}
