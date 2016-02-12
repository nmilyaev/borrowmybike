package com.borrowmybike

class User {

    String userId
    String password
    Date dateCreated
    Profile profile
    static hasMany = [ offers : Offer, hires : Hire ]

    static mapping = {
        profile lazy: false
    }
    static constraints = {
        userId (size: 5..20)
        password (size: 6..10, nullable: false)
        dateCreated()
        profile(nullable: true)
        offers (nullable: true)
        hires (nullable: true)
    }

}
