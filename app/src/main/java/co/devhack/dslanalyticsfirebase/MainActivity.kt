package co.devhack.dslanalyticsfirebase

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import co.devhack.analytics.dsl.createAnalytic
import co.devhack.analytics.providers.Provider
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAnalytics()
        addListeners()
    }

    private fun initAnalytics() {
        FirebaseApp.initializeApp(this)
    }

    private fun addListeners() {
        findViewById<Button>(R.id.btnEventDefaultProvider).setOnClickListener {
            createAnalyticDefaultProvider()
        }

        findViewById<Button>(R.id.btnEventFirebaseProvider).setOnClickListener {
            createAnalyticProviderFirebase()
        }

        findViewById<Button>(R.id.btnEventMixpanelProvider).setOnClickListener {
            createAnalyticProviderMixpanel()
        }

        findViewById<Button>(R.id.btnEventAllProviders).setOnClickListener {
            createAnalyticAllProvider()
        }
    }

    private fun createAnalyticDefaultProvider() {
        // for default provider Firebase
        createAnalytic {
            provider = Provider.FIREBASE
            eventName = "Test Event"
            params {
                param {
                    nameParam = "Test param"
                    valueParam = 16
                }
                param {
                    nameParam = "Test param2"
                    valueParam = 20
                }
            }
        }.track()

        Toast.makeText(
            this,
            "Sending analytic Default Provider",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun createAnalyticProviderFirebase() {
        // provider Firebase
        createAnalytic {
            eventName = FirebaseAnalytics.Event.ADD_PAYMENT_INFO
            params {
                param {
                    nameParam = FirebaseAnalytics.Param.ITEM_ID
                    valueParam = 1
                }
                param {
                    nameParam = FirebaseAnalytics.Param.ITEM_NAME
                    valueParam = "Jean"
                }
            }
        }.track()

        Toast.makeText(
            this,
            "Sending analytic Firebase Provider",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun createAnalyticProviderMixpanel() {

        // provider MixPanel
        createAnalytic {
            provider = Provider.MIX_PANEL
            eventName = "Event MixPanel"
            params {
                param {
                    nameParam = "Param 1 Mixpanel"
                    valueParam = 1
                }
                param {
                    nameParam = "Param 2 Mixpanel"
                    valueParam = "valor"
                }
            }
        }.track()

        Toast.makeText(
            this,
            "Sending analytic Mixpanel Provider",
            Toast.LENGTH_SHORT
        ).show()

    }

    private fun createAnalyticAllProvider() {
        // provider All
        createAnalytic {
            provider = Provider.ALL
            eventName = "Event ALL"
            params {
                param {
                    nameParam = "Param 1 ALL"
                    valueParam = 1
                }
                param {
                    nameParam = "Param 2 ALL"
                    valueParam = "valor"
                }
            }
        }.track()

        Toast.makeText(
            this,
            "Sending analytic All Providers",
            Toast.LENGTH_SHORT
        ).show()
    }
}
