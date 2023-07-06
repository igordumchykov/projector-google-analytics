package com.jdum.projector.analytics.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class AnalyticsEvent(
    var name: String,
    var params: AnalyticsEventParams
)
