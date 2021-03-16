package dms

class Docgroupstruct {

    String cd

    static belongsTo = [cdDocGroup:Docgroup,cdDocCode:Doccode]

    static constraints = {
        cd(maxSize:3, unique:true)
        cdDocGroup()
        cdDocCode()
    }


}
