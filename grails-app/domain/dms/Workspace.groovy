package dms

class Workspace {

    String cd
    String description
    Boolean idCaseType 

    static constraints = {
        cd(maxSize:20, unique:true)
        description(maxSize:100)
        idCaseType()
    }
    
    String toString() {
        return cd
    }
}
