package com.jdum.projector.analytics.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherCurrent(
    @JsonProperty("temp_c")
    var temperature: Double,
    @JsonProperty("wind_mph")
    var wind: Double,
    @JsonProperty("pressure_in")
    var pressure: Double,
    @JsonProperty("humidity")
    var humidity: Double
)
