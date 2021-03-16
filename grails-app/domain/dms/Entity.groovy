package dms

class Entity {

    String cd
    String description
    String endPointContrMgt

    static belongsTo = [cdCountry:Country]

    static hasMany = [adgroups: Adgroup]


    static constraints = {

        cd(maxSize:10, unique:true)
        description(maxSize:100)
        endPointContrMgt(maxSize:50)
        cdCountry()
        adgroups()
    }

    String toString() {
        return cd
    }
}
