package com.borrowmybike

class Profile {

    static belongsTo = User
    String email
    String fullName
    String about
    String postcode
    String country
    byte[] photo

    static constraints = {
        email (email: true, nullable: false, unique: true)
        fullName (nullable: true)
        about (nullable: true, maxSize: 1000)
        postcode (nullable: true)
        country (nullable: true)
        photo (nullable: true)
    }
}
