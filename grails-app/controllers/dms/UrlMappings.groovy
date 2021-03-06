package dms

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
//        "/login/$action?"(controller: "login")
 //       "/logout/$action?"(controller: "logout")
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        "403"(view: "/forbidden")
    }
}
