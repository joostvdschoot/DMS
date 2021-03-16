package dms

class Memo {

    String cdTitle
    String cdBody
    Date dateTime
    String cdUser

    static belongsTo = [cdObject:Object]

    static constraints = {
        cdTitle(maxSize:20)
//        cdBody(maxSize:255)
        cdUser(maxSize:20)
    }

    static mapping = {
        cdBody type: 'text'
    }
}
