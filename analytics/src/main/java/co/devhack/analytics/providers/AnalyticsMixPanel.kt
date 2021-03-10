package co.devhack.analytics.providers

import co.devhack.analytics.dsl.AnalyticEvent
import com.mixpanel.android.mpmetrics.MixpanelAPI
import org.json.JSONObject
import timber.log.Timber


class AnalyticsMixPanel(
    private val mixPanelAPI: MixpanelAPI
) : AnalyticProvider {

    override fun register(analyticEvent: AnalyticEvent) {
        analyticEvent.params?.let { params ->
            val props = JSONObject()
            params.forEach { paramEvent ->
                Timber.v("Mixpanel Event Param Name => ${paramEvent.name}")
                Timber.v("Mixpanel Event Param Name => ${paramEvent.value}")
                props.put(paramEvent.name, paramEvent.value.toString())
            }
            props
        }?.let { props ->
            Timber.v("Mixpanel Event Name => ${analyticEvent.eventName}")
            mixPanelAPI.track(analyticEvent.eventName, props)
        } ?: mixPanelAPI.track(analyticEvent.eventName)
    }
}
