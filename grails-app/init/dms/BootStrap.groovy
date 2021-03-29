package dms

import dms.Role
import dms.User
import dms.UserRole
import dms.Book

class BootStrap {

  String usr = "admin"
  String pw = "password"
  String radm = "ROLE_ADMIN"
  String rusr = "ROLE_USER"

    def init = { servletContext ->


//      def b1 = new Book(title:'The Stand').save(flush:true,failOnError: true)
//      def b2 = new Book(title:'The Shining').save(flush:true,failOnError: true)
//      def b3 = new Book(title:'The Bible').save(flush:true,failOnError: true)


      def admUser = new User(username:"admin", password:"password", fullname:"Admin", enabled:true, accountExpired:false,accountLocked:false,passwordExpired:false ).save(flush:true)

      def endUser = new User(username:"user", password:"secret", fullname:"User", enabled:true, accountExpired:false,accountLocked:false,passwordExpired:false ).save(flush:true)

      def adminRole = new Role(authority:radm).save(flush:true,)
      def userRole = new Role(authority:rusr).save(flush:true,)
//      def testRole = new Role(authority:"ROLE_TEST").save(flush:true,)

      UserRole.create admUser, adminRole, true
      UserRole.create endUser, userRole, true

      //assert User.count() == 1
      //assert Role.count() == 2
      //assert UserRole.count() == 1
      
    }
    def destroy = {
    }
}
