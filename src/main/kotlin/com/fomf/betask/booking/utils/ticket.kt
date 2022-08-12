package com.fomf.betask.booking.utils

import com.fomf.betask.booking.model.Ticket

fun calculateOneTicketPrice(occupationType: OccupationType, ticket: Ticket):Int{
    val criteria = listOf<String>( occupationType.name, ticket.ticketType.name,ticket.participation.name)
    val price = when(criteria.joinToString(",")){
        "DOCTOR,ENTIRE_EVENT,LIVESTREAM" -> 450
        "DOCTOR,ENTIRE_EVENT,ON_SITE" -> 500
        "DOCTOR,DAY,LIVESTREAM" -> 100
        "DOCTOR,DAY,ON_SITE" -> 150
        "DOCTOR,HALF_DAY,LIVESTREAM" -> 50

        "ASSISTANT_DOCTOR,ENTIRE_EVENT,LIVESTREAM" -> 300
        "ASSISTANT_DOCTOR,ENTIRE_EVENT,ON_SITE" -> 400
        "ASSISTANT_DOCTOR,DAY,LIVESTREAM" -> 50
        "ASSISTANT_DOCTOR,DAY,ON_SITE" -> 100
        "ASSISTANT_DOCTOR,HALF_DAY,LIVESTREAM" -> 25
        else -> 0
    }

    return price
}