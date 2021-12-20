package co.devhack.analytics.providers

import android.content.Context
import android.content.pm.PackageManager
import com.mixpanel.android.mpmetrics.MixpanelAPI
import timber.log.Timber

enum class Provider {
    FIREBASE,
    MIX_PANEL,
    ALL
}

object FactoryAnalyticProvider {

    private const val PACKAGE_NAME_TOKEN = "ai.wordbox.analytics.mixpanel.TOKEN"
    private const val MESSAGE_TOKEN_NOT_FOUND = "Mixpanel Token is not found"

    fun createInstance(
        provider: Provider,
        context: Context,
    ): List<AnalyticProvider> =
        when (provider) {
            Provider.FIREBASE ->
                mutableListOf<AnalyticProvider>(AnalyticsFirebase())
            Provider.MIX_PANEL ->
                getMixPanelInstance(context).run {
                    mutableListOf(
                        AnalyticsMixPanel(this)
                    )
                }
            Provider.ALL ->
                getMixPanelInstance(context).run {
                    mutableListOf(
                        AnalyticsFirebase(),
                        AnalyticsMixPanel(this)
                    )
                }
        }

    private fun getMixPanelInstance(context: Context): MixpanelAPI {
        val appInfo = context.packageManager.getApplicationInfo(
            context.packageName,
            PackageManager.GET_META_DATA
        )
        val token = appInfo.metaData.getString(PACKAGE_NAME_TOKEN)
            ?: throw NullPointerException(MESSAGE_TOKEN_NOT_FOUND)
        Timber.v("Mixpanel Token => $token")
        return MixpanelAPI.getInstance(context, token)
    }
}
