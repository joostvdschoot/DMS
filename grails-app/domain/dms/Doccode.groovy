package dms

class Doccode {

    String cd
    String description

    static constraints = {
        cd(maxSize:10, unique:true)
        description(maxSize:50)
    }

    String toString() {
        return cd
    }
}
