package co.devhack.analytics.dsl

import androidx.activity.ComponentActivity
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

@Analytics
fun ComponentActivity.createAnalytic(block: AnalyticEventBuilder.() -> Unit) =
    AnalyticEventBuilder(this.applicationContext).apply(block).build()

@Analytics
fun FragmentActivity.createAnalytics(block: AnalyticsEventBuilder.() -> Unit) =
    AnalyticsEventBuilder(this.applicationContext).apply(block)

@Analytics
fun Fragment.createAnalytics(block: AnalyticsEventBuilder.() -> Unit) =
    this.context?.let { AnalyticsEventBuilder(it).apply(block) }

@Analytics
fun AppCompatActivity.createAnalytics(block: AnalyticsEventBuilder.() -> Unit) =
    AnalyticsEventBuilder(this.applicationContext).apply(block)

@Analytics
fun ComponentActivity.createAnalytics(block: AnalyticsEventBuilder.() -> Unit) =
    AnalyticsEventBuilder(this.applicationContext).apply(block)

@DslMarker
annotation class Analytics

