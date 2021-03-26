# Wrapper Analytics for Android

> The simplest library to record analytical events in an Android application.

[![Kotlin](https://img.shields.io/badge/Kotlin-1.4.30-blueviolet.svg)](https://kotlinlang.org)
![Minimum SDK Version](https://img.shields.io/badge/minSdkVersion-14-brightgreen.svg)

"What cannot be measured cannot be improved" by William Thomson Kelvin

We need to have metrics or analytics in our application to better understand our users, thus improving our applications. This library is a Kotlin DSL that allows you to record events to:
```
- Firebase Analytics
- Mixpanel
```

## Installation
You can [download](https://url) and install `Wrapper Analytics` with `Maven` and `Gradle`:

```gradle
dependencies {
    implementation("co.devhack:analytics:0.9")
}
```

Make sure to include `maven()` in your repositories
```gradle
repositories {
  maven()
}
```

## Quick Start
Send an event for default to firebase:

```kotlin
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
```

Or send the event to mixpanel:

First, you need to add the mixpanel token as metadata in the manifest file:

```xml
  <meta-data
    android:name="co.devhack.analytics.mixpanel.TOKEN"
    android:value="MIXPANEL_TOKEN" />
```

Afterward...

```kotlin
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
```

And you can send the events to both.

```kotlin
  createAnalytic {
      provider = Provider.ALL
      eventName = "Event"
      params {
          param {
              nameParam = "Param 1"
              valueParam = 1
          }
          param {
              nameParam = "Param 2"
              valueParam = "valor"
          }
      }
  }.track()
```

Made with ❤ by  [jggomez](https://devhack.co).

[![Twitter Badge](https://img.shields.io/badge/-@jggomezt-1ca0f1?style=flat-square&labelColor=1ca0f1&logo=twitter&logoColor=white&link=https://twitter.com/jggomezt)](https://twitter.com/jggomezt) 
[![Linkedin Badge](https://img.shields.io/badge/-jggomezt-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/jggomezt/)](https://www.linkedin.com/in/jggomezt/) 
[![Medium Badge](https://img.shields.io/badge/-@jggomezt-03a57a?style=flat-square&labelColor=000000&logo=Medium&link=https://medium.com/@jggomezt)](https://medium.com/@jggomezt)

## License

    Copyright 2021 Juan Guillermo Gómez

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
