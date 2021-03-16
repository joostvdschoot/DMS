package dms

class Folder {

    String cd
    String description

    static constraints = {
        cd(maxSize:20, unique:true)
        description(maxSize:100)
    }

    String toString() {
        return cd
    }
}
