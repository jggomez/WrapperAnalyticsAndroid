package co.devhack.analytics.dsl

import android.content.Context
import co.devhack.analytics.BuildConfig
import co.devhack.analytics.providers.FactoryAnalyticProvider
import co.devhack.analytics.providers.Provider
import timber.log.Timber
import timber.log.Timber.DebugTree

data class AnalyticEvent(
    val eventName: String,
    val params: List<ParamEvent>? = null,
    val provider: Provider? = null,
    private val context: Context,
) {
    fun track() {

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }

        fun selectProvider() =
            when (provider) {
                null -> Provider.FIREBASE
                else -> provider
            }

        val provider = selectProvider()

        Timber.d("Provider selected => ${provider.name}")

        val providerInstances = FactoryAnalyticProvider
            .createInstance(provider, context)

        providerInstances.forEach { providerInstance ->
            providerInstance.register(this)
        }
    }
}


data class ParamEvent(
    val name: String,
    val value: Any
)
