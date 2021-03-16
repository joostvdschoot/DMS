package dms

class Spsubtabsws {

    String cd


    static belongsTo = [cdSubTabs:Spsubtabs,cdWS:Workspace,cdFolder:Folder]

    static constraints = {
        cd(maxSize:3, unique:true)
        cdSubTabs()
        cdWS()
        cdFolder()
    }
}
