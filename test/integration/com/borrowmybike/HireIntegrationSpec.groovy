package com.borrowmybike

import grails.test.GrailsUnitTestCase

/**
 *
 */
class HireIntegrationSpec extends GrailsUnitTestCase {

    def setup() {
    }

    def cleanup() {
    }

    void testCreateAndSaveHire() {
        def user = new User(userId: "nestor", password: "secret")
        assertNotNull(user.save())
        def bikeSet = new com.borrowmybike.BikeSet(postcode: "SE4 1SE", bikeCount: 1, bikeClass: com.borrowmybike.BikeSet.BikeClass.MOUNTAIN)
        bikeSet.save()
        def hire = new com.borrowmybike.Hire(startPeriod: new Date(), agreedPrice: 20, isPaid: true, bikeSet:bikeSet)
        hire.save(failOnError: true)
        user.addToHires(hire)
        println(hire.bikeSet.postcode)
        println(user.hires.size())
        def foundUser = User.findByUserId("nestor")
        foundUser.addToHires(hire)
        assertEquals(1, foundUser.hires.size())
    }
}
