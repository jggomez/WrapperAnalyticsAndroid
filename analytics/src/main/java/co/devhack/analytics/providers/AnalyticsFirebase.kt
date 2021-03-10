package co.devhack.analytics.providers

import co.devhack.analytics.dsl.AnalyticEvent
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import timber.log.Timber

class AnalyticsFirebase(
    private val firebaseAnalytics: FirebaseAnalytics = Firebase.analytics,
) : AnalyticProvider {
    override fun register(analyticEvent: AnalyticEvent) {
        firebaseAnalytics.logEvent(analyticEvent.eventName) {
            Timber.v("Firebase Event Name => ${analyticEvent.eventName}")
            analyticEvent.params?.forEach { paramEvent ->
                Timber.v("Firebase Event Param Name => ${paramEvent.name}")
                Timber.v("Firebase Event Param Name => ${paramEvent.value}")
                param(paramEvent.name, paramEvent.value.toString())
            }
        }
    }
}
