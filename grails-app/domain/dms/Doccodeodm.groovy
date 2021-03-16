package dms

class Doccodeodm {
 
    String cd

    static belongsTo = [cdDocCode:Doccode,cdEntity:Entity,cdWorkspace:Workspace,cdRelatedWs1:Workspace,cdRelatedWs2:Workspace,cdFolder:Folder,docTypeNr:Doctype]

    static constraints = {
        cd(maxSize:3, unique:true)
        cdDocCode()
        cdEntity()
        cdWorkspace()
        cdRelatedWs1()
        cdRelatedWs2()
        cdFolder()
        docTypeNr()
    }
    
}
