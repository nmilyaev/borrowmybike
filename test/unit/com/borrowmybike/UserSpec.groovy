package com.borrowmybike

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "Successfully create a user"() {
        given: "A brand new user"
        def user = new User(userId: "nestor", password: "secret", confirmPassword: "secret")

        when: "A user is saved"
        user.save()

        then: "It's saved successfully and can be found in the DB"
        user.errors.errorCount == 0
        user.id != null
        User.get(user.id).userId == user.userId
    }

    def "Successfully create and update a user"() {
        given: "A brand new user"
        def user = new User(userId: "nestor", password: "secret", confirmPassword: "secret")

        when: "A user is saved"
        user.save()

        then: "It's saved successfully and can be found in the DB"
        user.errors.errorCount == 0
        user.id != null
        User.get(user.id).userId == user.userId

        when: "Updating user's password and saving the user"
        user.setPassword("sesame")
        user.setConfirmPassword("sesame")
        user.save()

        then: "The user is updated successfully and the new password is assigned to it"
        user.errors.errorCount == 0
        User.get(user.id).password == user.password

    }

    void "Make sure user id is unique"() {
        given: "A brand new user"
        def validUser = new User(userId: "nestor", password: "secret", confirmPassword: "secret")

        when: "A user is saved"
        def saved = validUser.save(flush:true, failOnError:true)
        mockForConstraintsTests(User, [validUser])

        then: "User should be unique"
        def invalidUser = new User(userId: "nestor", password: "secret", confirmPassword: "secret")
        !invalidUser.validate()
//        println(">>>>> " + invalidUser.errors)
        invalidUser.errors.errorCount == 2
    }

}
