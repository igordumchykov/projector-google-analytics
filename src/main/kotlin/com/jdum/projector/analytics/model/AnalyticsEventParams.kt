package com.jdum.projector.analytics.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class AnalyticsEventParams(
    var temperature: Double,
    var wind: Double,
    var pressure: Double,
    var humidity: Double,
    var timestamp: Long,
)
