package dms

class Country {

    String cd
    String description

    static hasMany = [entities: Entity]


    static constraints = {
        cd(size:2..3, unique:true)
        description(maxSize:50)
        entities()
    }

    String toString() {
        return cd
    }

}
