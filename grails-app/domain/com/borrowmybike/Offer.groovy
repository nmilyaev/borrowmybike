package com.borrowmybike

class Offer {

    static belongsTo = User
    // Null means from forever
    Date startPeriod
    // Null means from now till forever
    Date duration
    BigDecimal pricePerDay
    BigDecimal deposit
    OfferStatus status
    BikeSet bikeSet

    static constraints = {
        startPeriod (nullable: true)
        duration (nullable: true)
        pricePerDay (nullable:false)
        deposit (nullable: false)
    }

    enum OfferStatus {
        AVAILABLE, UNDER_OFFER, RENTED_OUT
    }

}
