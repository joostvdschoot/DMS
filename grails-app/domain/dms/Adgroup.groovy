package dms

class Adgroup {

    String cd
    String description

    static constraints = {
        cd(maxSize:100, unique:true)
        description(maxSize:100)
        cdEntity()
    }
    
    static belongsTo = [cdEntity:Entity]


    String toString() {
        return cd
    }
}
