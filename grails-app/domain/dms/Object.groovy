package dms

class Object {

    String cd

    static belongsTo = [cdEntity:Entity, cdWorkspace:Workspace]

    static hasMany = [memos: Memo]

    static constraints = {
        cd(maxSize:20, unique:true)
        cdEntity()
        cdWorkspace()
        memos()
    }

    String toString() {
        return cd
    }
}
