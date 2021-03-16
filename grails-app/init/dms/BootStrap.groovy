package dms

import dms.Role
import dms.User
import dms.UserRole

class BootStrap {

  String usr = "me"
  String pw = "password"
  String radm = "ROLE_ADMIN"
  String rusr = "ROLE_USER"

    def init = { servletContext ->

      def b1 = new Book(title:"The Stand").save()
      def b2 = new Book(title:"The Shining").save()

      def testUser = new User(username:usr, password:pw, fullname:"Me", enabled:true, accountExpired:false,accountLocked:false,passwordExpired:false ).save()

      def adminRole = new Role(authority:radm).save()
      def userRole = new Role(authority:rusr).save()

      UserRole.create testUser, adminRole, true

      assert User.count() == 1
      assert Role.count() == 2
      assert UserRole.count() == 1
      
    }
    def destroy = {
    }
}
