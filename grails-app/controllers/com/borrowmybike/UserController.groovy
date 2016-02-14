package com.borrowmybike

class UserController {

    def scaffold = true

    def list = {

    }

    def create = {
        def user = new User(params)
        if (user.validate()){
            user.save()
            flash.message = "Successfully created user" + user.userId;
            redirect(uri: '/')
        }
        else {
            flash.message = "Error registering user"
            return [user:user]
        }

    }

}
