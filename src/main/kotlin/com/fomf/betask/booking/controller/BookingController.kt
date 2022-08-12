package com.fomf.betask.booking.controller

import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.fomf.betask.booking.model.EventBooking
import com.fomf.betask.booking.model.Ticket
import com.fomf.betask.booking.service.EventBookingService
import com.fomf.betask.booking.utils.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import java.time.LocalDate

@RestController
@RequestMapping("")
class HomeController {

    @GetMapping
    fun helloWorld(): String = "<h1> Hello </h1>"
}

@RestController
@RequestMapping("/api/book")
class BookingController(private val service: EventBookingService) {

    @ExceptionHandler(
        InvalidEventTicketsException::class,
        InvalidTicketDateException::class,
        InvalidTicketIntegrityException::class,
    )
    fun handleBadRequest(e: Exception): ResponseEntity<String> =
        ResponseEntity(e.localizedMessage , HttpStatus.BAD_REQUEST)

    @PostMapping
    fun calculate( @RequestBody event: EventBooking): Int {
        println(event)
        val price = service.calculateBookingPrice(event)
        println(price)
        return price
    }
}