package com.fomf.betask.booking.service

import com.fomf.betask.booking.model.EventBooking
import com.fomf.betask.booking.utils.*
import org.springframework.stereotype.Service

@Service
class EventBookingService {
//    fun validate( eventBooking: EventBooking):List

    fun calculateBookingPrice(eventBooking: EventBooking): Int {
        // validating
        validateEventBooking(eventBooking)
        // calculating price
        val prices = mutableListOf<Int>()
        for (ticket in eventBooking.tickets) {
            prices.add(calculateOneTicketPrice(eventBooking.occupationType, ticket))
        }
        return prices.sum()
    }

    fun validateEventBooking(eventBooking: EventBooking): Boolean {
        // event scope validation
        if (eventBooking.tickets.any { it.ticketType == TicketType.ENTIRE_EVENT } && eventBooking.tickets.size > 1) {
            throw InvalidEventTicketsException("a DAY or HALF_DAY ticket cannot get booked with an ENTIER_EVENT ticket")
        }

        // one day scope validation
        val ticketDateValidationList = eventBooking.tickets.map { it.date.toString() }
        if (ticketDateValidationList.size != ticketDateValidationList.distinct().size) {
            throw InvalidTicketDateException("Only one ticket per day can be selected")
        }

        // ticket validation
        if (eventBooking.tickets.any { it.participation == ParticipationType.ON_SITE && it.ticketType == TicketType.HALF_DAY }) {
            throw InvalidTicketIntegrityException("ONSITE HALF_DAY ticket cannot be booked")
        }
        return true
    }
}