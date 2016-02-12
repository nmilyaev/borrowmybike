package com.borrowmybike

import grails.test.GrailsUnitTestCase

/**
 *
 */
class UserIntegrationSpec extends GrailsUnitTestCase {


    def setup() {
    }

    def cleanup() {
    }

    void testCreateAndUpdateUser() {
        def user = new User(userId: "nestor", password: "secret")
        assertNotNull(user.save())
        assertNotNull(user.id)
        def foundUser = User.get(user.id)
        foundUser.password = "sesame"
        foundUser.save()
        foundUser = User.get(user.id)
        assertEquals("sesame", foundUser.password)
    }

    void testCreateAndDeleteUser() {
        def user = new User(userId: "nestor", password: "secret")
        assertNotNull(user.save())
        def foundUser = User.get(user.id)
        foundUser.delete()
        foundUser = User.get(user.id)
        assertFalse(User.exists(foundUser))
    }

    void testCreateUserWithProfile() {
        def user = new User(userId: "nestor", password: "secret")
        assertNotNull(user.save())
        def profile = new Profile(email: "n@m.com", fullName: "N M", about: "about N M", postcode: "CE1 2QY",country: "UK")
        user.setProfile(profile);
        user.save();
        def foundUser = User.get(user.id);
        assertNotNull(foundUser.profile)
    }

    void testValidateUserProfile(){
        def user = new User(userId: "nestor", password: "tiny")
        assertFalse(user.validate())
        assertTrue(user.hasErrors())
        assertNull(user.save())
        user.password = "secret"
        assertTrue(user.validate())
        assertNotNull(user.save())

    }

}
