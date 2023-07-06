package com.jdum.projector.analytics.client

import com.jdum.projector.analytics.model.WeatherResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "weather-client", url = "\${application.weather.url}")
interface WeatherClient {

    @GetMapping("/v1/current.json?key=\${application.weather.apiKey}&q=Kiev")
    fun getWeatherInfo(): WeatherResponse
}
