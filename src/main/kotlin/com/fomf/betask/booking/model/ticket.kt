package com.fomf.betask.booking.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fomf.betask.booking.utils.OccupationType
import com.fomf.betask.booking.utils.ParticipationType
import com.fomf.betask.booking.utils.TicketType
import java.time.LocalDate


data class Ticket(
    @JsonProperty("date")
    val date: LocalDate,

    @JsonProperty("ticket_type")
    val ticketType: TicketType,

    @JsonProperty("participation")
    val participation: ParticipationType,
)

data class EventBooking(
    @JsonProperty("event")
    val event: String,

    @JsonProperty("occupation_type")
    val occupationType: OccupationType,

    @JsonProperty("tickets")
    val tickets: Collection<Ticket>,
)