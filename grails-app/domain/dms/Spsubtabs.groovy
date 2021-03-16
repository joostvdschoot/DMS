package dms

class Spsubtabs {

    String cd
    String cdSubTab
    String description
    String tablabel


    static belongsTo = [cdMainTab:Sptabs,cdEntity:Entity]

    static constraints = {
        cd(maxSize:3, unique:true)
        cdMainTab()
        cdSubTab(maxSize:20)
        cdEntity()
        description()
        tablabel()
    }

    String toString() {
        return cd + "-" + cdEntity + "-" + cdMainTab + "-" + cdSubTab
    }

}
