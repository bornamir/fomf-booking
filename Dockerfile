FROM openjdk:11
EXPOSE 8000
ADD /build/libs/booking-0.0.1-SNAPSHOT.jar booking.jar
ENTRYPOINT ["java", "-jar", "booking.jar"]