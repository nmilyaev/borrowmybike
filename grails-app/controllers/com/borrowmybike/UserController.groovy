package com.borrowmybike

import grails.transaction.Transactional

class UserController {

    def scaffold = true

    def create = {
        if (request.method == "POST") {
            def user = new User(params)
            println user.dump()
            if (user.validate()) {
                user.save()
                flash.message = "Successfully created user" + user.userId;
                redirect(uri: '/user')
            }
            else {
                flash.message = "Error registering user"
                return [user:user]
            }
        }
    }

}
