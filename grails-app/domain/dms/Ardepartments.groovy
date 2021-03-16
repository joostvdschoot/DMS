package dms

class Ardepartments {

    String cd
    String invoicetype
    String supplierNr
    String customerNr
    String department

    static belongsTo = [cdSubcategory:Subcategory, cdEntity:Entity]

    static constraints = {
        cd(maxSize:20, unique:true)
        cdSubcategory()
        invoicetype(maxSize:20, nullable: true)
        cdEntity()
        supplierNr(nullable: true)
        customerNr(nullable: true)
        department()
    }

    String toString() {
        return cd
    }
}
