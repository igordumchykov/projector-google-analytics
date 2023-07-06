package com.jdum.projector.analytics.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class PostAnalyticsRequest(
    @JsonProperty("client_id")
    var clientId: String,
    var events: List<AnalyticsEvent>
)
