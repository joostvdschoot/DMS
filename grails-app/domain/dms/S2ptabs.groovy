package dms

class S2ptabs {

    String cd
    String description
    String tablabel

    static constraints = {
        cd(maxSize:20, unique:true)
        description(maxSize:100)
        tablabel(maxSize:20)
    }

    String toString() {
        return cd
    }
}
