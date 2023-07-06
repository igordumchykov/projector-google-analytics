package com.jdum.projector.analytics.client

import com.jdum.projector.analytics.model.PostAnalyticsRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(value = "google-analytics-4-client", url = "\${application.analytics.url}")
interface GoogleAnalyticsClient {

    @PostMapping("/mp/collect?api_secret=\${application.analytics.apiSecret}&measurement_id=\${application.analytics.measurementId}")
    fun postAnalytics(request: PostAnalyticsRequest)
}
