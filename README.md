[![](https://jitpack.io/v/MichaelSiddi/WhatsNew.svg)](https://jitpack.io/#MichaelSiddi/WhatsNew)

# What's New
Beautiful way to showcase new features of your app.

## 🙏 Credits

This is a fork of the original [WhatsNew library by Anders Cheow](https://github.com/anderscheow/WhatsNew).

The original library was created and maintained by Anders Cheow. This fork has been updated to support modern Android versions (API 35/36) with proper window insets handling and edge-to-edge display.

## 💻 Installation

```groovy
dependencies {
  implementation 'com.github.MichaelSiddi:WhatsNew:2.0.2'
}
```

## ❓ Usage
Setup features
````kotlin
val features = ArrayList<Feature>().apply {

    // Recommended: Use builder (Support more configurations)
    this.add(Feature.Builder()
            .setIconRes(R.drawable.access_point)
            .setIconColor(Color.RED)
            .setTitleRes(R.string.title_one)
            .setTitleTextColor(Color.BLACK)
            .setDescriptionRes(R.string.description_one)
            .setDescriptionTextColor(Color.BLACK)
            .build())

    // or use constructor
    this.add(Feature(R.drawable.account, Color.RED, R.string.title_two, Color.BLACK, R.string.description_two, Color.BLACK))
}
````

Setup and show What's New
````kotlin
// Only show partial configurations, please refer WhatsNew.Builder to view more configurations
WhatsNew.Builder(this)
        .setTitleRes(R.string.app_name)
        .setTitleColor(Color.BLACK)
        .setBackgroundRes(android.R.color.white)
        .setPrimaryButtonBackgroundColor(Color.RED)
        .setPrimaryButtonTextColor(Color.WHITE)
        .setPrimaryButtonTextRes(R.string.lets_go)
        .enablePrimaryButtonAllCaps(false)
        .setSecondaryButtonTextColor(Color.RED)
        .setSecondaryButtonTextRes(R.string.learn_more)
        .enableSecondaryButtonAllCaps(false)
        .enableFadeAnimation(true)
        .setFadeAnimationDuration(500L)
        .setFeatureItemAnimator(FeatureItemAnimator.FADE_IN_UP)
        .setFeatureItemAnimatorDuration(500L)
        .setFeatures(features)
        .setListener(object : WhatsNewListener {
            override fun onWhatsNewShowed(whatsNew: WhatsNew) {
                Log.d(TAG, "onWhatsNewShowed")
            }

            override fun onWhatsNewDismissed() {
                Log.d(TAG, "onWhatsNewDismissed")
            }

            override fun onPrimaryButtonClicked(whatsNew: WhatsNew) {
                Log.d(TAG, "onPrimaryButtonClicked")
            }

            override fun onSecondaryButtonClicked(whatsNew: WhatsNew) {
                Log.d(TAG, "onSecondaryButtonClicked")
            }
        })
        .build()
````

### Support different animation when display features. 
Thanks to [RecyclerView Animators by wasabeef](https://github.com/wasabeef/recyclerview-animators)

* NONE
* SCALE_IN
* SCALE_IN_TOP
* SCALE_IN_BOTTOM
* SCALE_IN_LEFT
* SCALE_IN_RIGHT
* FADE_IN
* FADE_IN_UP
* FADE_IN_DOWN
* FADE_IN_LEFT
* FADE_IN_RIGHT
* SLIDE_IN_UP
* SLIDE_IN_DOWN
* SLIDE_IN_LEFT
* SLIDE_IN_RIGHT
* OVERSHOOT_IN_LEFT
* OVERSHOOT_IN_RIGHT

## Changelog

**2.0.0** (This Fork)

* **BREAKING CHANGE**: Minimum SDK version raised from 16 to 21
* Updated to support API 35/36 (Android 15)
* Replaced deprecated `systemUiVisibility` with modern `WindowInsetsControllerCompat`
* Added proper window insets handling for edge-to-edge display
* Fixed title overlapping status bar issue
* Fixed continue button going behind navigation bar issue
* Updated Gradle to 8.2 and Android Gradle Plugin to 8.1.0
* Updated Kotlin from 1.3.21 to 1.9.20
* Updated Java version from 8 to 17
* Added AndroidX Core KTX dependency for modern window insets support
* Changed package namespace from `io.github.anderscheow` to `com.michaelsiddi`

**1.1.0** (Original Repository)

* Updated Gradle and Kotlin version
* Changed Android Support artifacts to AndroidX
* Removed some install dependencies from README

**1.0.1** (Original Repository)

* Add support for AndroidX

**1.0.0** (Original Repository)

* Introduce What's New library

## Contributions
Any contribution is more than welcome! You can contribute through pull requests and issues on GitHub.

## License
What's New is released under the [MIT License](https://github.com/anderscheow/Validator/blob/master/LICENSE)