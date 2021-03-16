package dms

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ObjectSpec extends Specification implements DomainUnitTest<Object> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
