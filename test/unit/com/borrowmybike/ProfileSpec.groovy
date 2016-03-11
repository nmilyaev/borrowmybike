package com.borrowmybike

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class ProfileSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "Successfully create a user with profile"() {
        given: "A brand new user"
        def user = new User(userId: "nestor", password: "secret", confirmPassword: "secret")
        def profile  = new Profile(email: 'n@m', fullName: 'Nestor Milyaev', about: 'about', postcode: 'AA1 9ZZ', countrty: 'UK', user: user)
        user.profile = profile

        when: "A user is saved"
        profile.save()
        user.save()

        then: "It's saved successfully and can be found in the DB"
        user.errors.errorCount == 0
        user.id != null
        User.get(user.id).userId == user.userId
        User.get(user.profile) == profile
    }
}
