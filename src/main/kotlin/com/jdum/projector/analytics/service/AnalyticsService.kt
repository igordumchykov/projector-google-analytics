package com.jdum.projector.analytics.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.jdum.projector.analytics.client.GoogleAnalyticsClient
import com.jdum.projector.analytics.client.WeatherClient
import com.jdum.projector.analytics.model.AnalyticsEvent
import com.jdum.projector.analytics.model.AnalyticsEventParams
import com.jdum.projector.analytics.model.PostAnalyticsRequest
import com.jdum.projector.analytics.model.WeatherResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class AnalyticsService(
    private val weatherClient: WeatherClient,
    private val analyticsClient: GoogleAnalyticsClient,

    @Value("\${application.analytics.clientId}")
    private val clientId: String,

    @Value("\${application.analytics.eventWeather}")
    private val eventWeather: String,

    ) {

    private val log = LoggerFactory.getLogger(javaClass)
    private val mapper: ObjectMapper = ObjectMapper()

    @Scheduled(fixedRate = 200000)
    fun getBankExchangeRatio() {
        val response = this.weatherClient.getWeatherInfo()
        this.log.info("Getting weather: ${this.mapper.writeValueAsString(response)}")

        val payload = prepareAnalyticsPayload(response)
        analyticsClient.postAnalytics(payload)

        this.log.info("Analytics was sent with payload: ${this.mapper.writeValueAsString(payload)}")
    }

    fun prepareAnalyticsPayload(src: WeatherResponse) = PostAnalyticsRequest(
        clientId = this.clientId,
        events = listOf(
            AnalyticsEvent(
                name = eventWeather,
                params = AnalyticsEventParams(
                    temperature = src.current.temperature,
                    wind = src.current.wind,
                    pressure = src.current.pressure,
                    humidity = src.current.humidity,
                    timestamp = Instant.now().toEpochMilli()
                )
            )
        )
    )
}
