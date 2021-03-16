package dms

class Department {

    String cd
    String description

    static constraints = {
        cd(maxSize:20, unique: true)
        description(maxSize:50)
    }

    String toString() {
        return cd
    }
}
