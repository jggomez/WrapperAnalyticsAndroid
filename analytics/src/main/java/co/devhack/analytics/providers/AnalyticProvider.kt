package co.devhack.analytics.providers

import co.devhack.analytics.dsl.AnalyticEvent

interface AnalyticProvider {
    fun register(analyticEvent: AnalyticEvent)
}
