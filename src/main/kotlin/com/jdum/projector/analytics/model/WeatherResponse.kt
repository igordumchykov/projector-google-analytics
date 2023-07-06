package com.jdum.projector.analytics.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherResponse(
    var current: WeatherCurrent
)
