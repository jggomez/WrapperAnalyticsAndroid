package co.devhack.analytics.dsl

import android.content.Context
import co.devhack.analytics.providers.Provider
import com.ironsource.aura.dslint.annotations.DSLMandatory
import com.ironsource.aura.dslint.annotations.DSLint

@Analytics
@DSLint
class AnalyticEventBuilder(
    private val context: Context
) {
    companion object {
        const val EMPTY_NAME_EVENT = ""
        const val MESSAGE_EVENT_NAME_PARAM_DECLARED = "eventName must be declared"
    }

    var provider: Provider? = Provider.FIREBASE

    @set:DSLMandatory(message = MESSAGE_EVENT_NAME_PARAM_DECLARED)
    var eventName: String = EMPTY_NAME_EVENT

    private var params = mutableListOf<ParamEvent>()

    fun params(block: ParamsEvent.() -> Unit) {
        params.addAll(ParamsEvent().apply(block))
    }

    fun build() = AnalyticEvent(eventName, params, provider, context)
}

@Analytics
class ParamsEvent : ArrayList<ParamEvent>() {

    fun param(block: ParamBuilder.() -> Unit) {
        add(ParamBuilder().apply(block).build())
    }
}

@Analytics
@DSLint
class ParamBuilder {
    companion object {
        const val EMPTY = ""
        const val MESSAGE_NAME_PARAM_DECLARED = "nameParam must be declared"
        const val MESSAGE_VALUE_PARAM_DECLARED = "valueParam must be declared"
    }

    @set:DSLMandatory(message = MESSAGE_NAME_PARAM_DECLARED)
    var nameParam: String = EMPTY

    @set:DSLMandatory(message = MESSAGE_VALUE_PARAM_DECLARED)
    var valueParam: Any = EMPTY

    fun build() = ParamEvent(nameParam, valueParam)
}
