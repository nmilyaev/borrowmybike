package com.borrowmybike

class BikeSet {

    static belongsTo = Hire
    String postcode
    Integer bikeCount
    BikeClass bikeClass
    byte[] photo

    static constraints = {
        postcode (size: 4..10, nullable: false)
        bikeCount (min: 1, nullable: false)
        bikeClass (nullable: false)
        photo (nullable: true)
    }

    enum BikeClass {
        MOUNTAIN, ROAD, KIDS, BMX, ANY
    }

}
