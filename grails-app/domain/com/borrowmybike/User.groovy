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
        userId (size: 5..20, unique: true)
        password (size: 6..12, nullable: false, validator: { password, obj ->
            def password2 = obj.confirmPassword
            password2 ? true: ['invalid.missingpasswordconfirmation']
            password2 == password ? true : ['invalid.matchingpasswords']
            })
        confirmPassword (bindable: true, nullable: false)
        dateCreated()
        profile(nullable: true)
        offers (nullable: true)
        hires (nullable: true)
    }

}
