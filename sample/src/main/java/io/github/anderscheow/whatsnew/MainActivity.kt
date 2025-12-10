package com.michaelsiddi.whatsnew

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.michaelsiddi.library.WhatsNew
import com.michaelsiddi.library.listener.WhatsNewListener
import com.michaelsiddi.library.model.Feature
import com.michaelsiddi.library.util.FeatureItemAnimator

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_demo).setOnClickListener {
            buildWhatsNew()
        }
    }

    private fun buildWhatsNew() {
        val features = ArrayList<Feature>().apply {
            this.add(Feature.Builder()
                    .setIconRes(R.drawable.access_point)
                    .setIconColor(Color.RED)
                    .setTitleRes(R.string.title_one)
                    .setTitleTextColor(Color.BLACK)
                    .setDescriptionRes(R.string.description_one)
                    .setDescriptionTextColor(Color.BLACK)
                    .build())

            this.add(Feature(R.drawable.account, Color.RED, R.string.title_two, Color.BLACK, R.string.description_two, Color.BLACK))

            this.add(Feature.Builder()
                    .setIconRes(R.drawable.alert_circle)
                    .setIconColor(Color.RED)
                    .setTitleRes(R.string.title_three)
                    .setTitleTextColor(Color.BLACK)
                    .setDescriptionRes(R.string.description_three)
                    .setDescriptionTextColor(Color.BLACK)
                    .build())

            this.add(Feature.Builder()
                    .setIconRes(R.drawable.camera_iris)
                    .setIconColor(Color.RED)
                    .setTitleRes(R.string.title_four)
                    .setTitleTextColor(Color.BLACK)
                    .setDescriptionRes(R.string.description_four)
                    .setDescriptionTextColor(Color.BLACK)
                    .build())
        }

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
                        Toast.makeText( this@MainActivity, "onWhatsNewShowed", Toast.LENGTH_SHORT).show()
                    }

                    override fun onWhatsNewDismissed() {
                        Log.d(TAG, "onWhatsNewDismissed")
                        Toast.makeText( this@MainActivity, "onWhatsNewDismissed", Toast.LENGTH_SHORT).show()
                    }

                    override fun onPrimaryButtonClicked(whatsNew: WhatsNew) {
                        Log.d(TAG, "onPrimaryButtonClicked")
                        Toast.makeText( this@MainActivity, "onPrimaryButtonClicked", Toast.LENGTH_SHORT).show()
                    }

                    override fun onSecondaryButtonClicked(whatsNew: WhatsNew) {
                        Log.d(TAG, "onSecondaryButtonClicked")
                        Toast.makeText( this@MainActivity, "onSecondaryButtonClicked", Toast.LENGTH_SHORT).show()
                    }
                })
                .build()
    }
}
