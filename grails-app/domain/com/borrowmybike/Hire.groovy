package com.borrowmybike

class Hire {

    static belongsTo = User
    Date startPeriod
    // Null means from now till forever
    Date endPeriod
    BigDecimal agreedPrice
    Boolean isPaid
    BikeSet bikeSet

    static constraints = {
        startPeriod (nullable: true)
        endPeriod(nullable: true)
        isPaid (nullable: false)
        bikeSet (nullable: false)
    }
}
