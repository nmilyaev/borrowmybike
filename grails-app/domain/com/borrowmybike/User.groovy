package com.borrowmybike

class User {

    //User name
    String userId
    String password
    String confirmPassword
    Date dateCreated

    static hasOne = [profile:Profile]

    static hasMany = [ offers : Offer, hires : Hire ]

    static mapping = {
        profile lazy: false
    }

    static transients = ['confirmPassword']

    static constraints = {
        // TODO: check username is unique
        userId (size: 5..20)
        // TODO: make sure confirmPassword validation works
        password (size: 6..10, nullable: false, validator: { password, obj ->
            def password2 = obj.properties['confirmPassword']
            if (password2 == null) return true // skip matching password validation (only important when setting/resetting pass)
            password2 == password ? true : ['invalid.matchingpasswords']
            })
        dateCreated()
        profile(nullable: true)
        offers (nullable: true)
        hires (nullable: true)
    }

}
