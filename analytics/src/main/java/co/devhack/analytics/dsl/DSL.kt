package co.devhack.analytics.dsl

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

@Analytics
fun FragmentActivity.createAnalytic(block: AnalyticEventBuilder.() -> Unit) =
    AnalyticEventBuilder(this.applicationContext).apply(block).build()

@Analytics
fun Fragment.createAnalytic(block: AnalyticEventBuilder.() -> Unit) =
    this.context?.let { AnalyticEventBuilder(it).apply(block).build() }

@Analytics
fun AppCompatActivity.createAnalytic(block: AnalyticEventBuilder.() -> Unit) =
    AnalyticEventBuilder(this.applicationContext).apply(block).build()

@DslMarker
annotation class Analytics
