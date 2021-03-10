package co.devhack.analytics.providers

import co.devhack.analytics.dsl.AnalyticEvent
import com.google.firebase.analytics.FirebaseAnalytics
import io.mockk.mockk
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

class ProviderFirebase : Spek({
    Feature("FirebaseProvider") {

        Scenario("Tracking the event only with the name correctly") {

            val firebaseAnalytics = mockk<FirebaseAnalytics>()
            lateinit var analyticProvider: AnalyticsFirebase
            lateinit var analyticEvent: AnalyticEvent
            val eventName = "Unit Test Event"

            Given("Creating mocks and stubs") {
                analyticProvider = AnalyticsFirebase(firebaseAnalytics)
                // TODO: unit test missing
            }

            When("Run the analytic register") {
                analyticProvider.register(analyticEvent)
            }

            Then("Validating calls to dependencies correctly") {

            }
        }
    }
})
