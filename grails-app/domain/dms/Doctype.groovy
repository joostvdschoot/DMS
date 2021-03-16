package dms

class Doctype {
    String docTypeNr
    String docTypeName


    static belongsTo = [cdEntity:Entity,cdWorkspace:Workspace,cdFolder:Folder]

    static constraints = {

        docTypeNr(maxSize:6, unique:true)
        docTypeName(maxSize:100)
        cdEntity()
        cdWorkspace()
        cdFolder()
    }

    String toString() {
        return docTypeNr
    }
}
