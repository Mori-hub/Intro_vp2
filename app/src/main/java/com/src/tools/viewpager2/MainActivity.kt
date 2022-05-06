package com.src.tools.viewpager2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.src.tools.vp2introduction.IntroPage
import com.src.tools.vp2transfer.Transfer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // First add Activity in Manifest
        //  <activity android:name="com.src.tools.vp2introduction.IntroPage"/>
        this.startActivity(Intent(this, IntroPage::class.java))

        val item1 = IntroPage.ViewPager2Adapter.SetPages()
        item1.image = android.R.drawable.btn_star_big_on
        item1.title = "Item One"
        item1.description ="🎫 getString(R.string.app_desc)"
        item1.background = Color.parseColor("#446A46")

        val item2 = IntroPage.ViewPager2Adapter.SetPages()
        item2.image = android.R.drawable.ic_media_play
        item2.title = "Item Two"
        item2.description ="🎭 getString(R.string.app_desc)"
        item2.background = Color.parseColor("#112B3C")
        item2.titleColor=Color.parseColor("#A1E3D8")
        item2.textColor=Color.parseColor("#F7FF93")

        val item3 = IntroPage.ViewPager2Adapter.SetPages()
        item3.image = android.R.drawable.ic_delete
        item3.title = "Item Three"
        item3.description ="🎭 getString(R.string.app_desc)"
        item3.background = Color.parseColor("#FFD59E")

        val item4 = IntroPage.ViewPager2Adapter.SetPages()
        item4.image = android.R.drawable.checkbox_on_background
        item4.title = "Item Four"
        item4.description ="🎭 getString(R.string.app_desc)"
        item4.background = Color.parseColor("#125B50")
        item2.titleColor=Color.parseColor("#F7FF93")
        item2.textColor=Color.parseColor("#E4AEC5")

        val item5 = IntroPage.ViewPager2Adapter.SetPages()
        item5.image = android.R.drawable.ic_btn_speak_now
        item5.title = "Item Five"
        item5.description ="🎭 getString(R.string.app_desc)"
        item5.background = Color.parseColor("#E9D5DA")

        val all = IntroPage.ViewPager2Adapter.SetPages()
        // Last page and Button , set Function
        all.done( "So Good", Color.parseColor("#FF6363") , {
            Toast.makeText(this, "getString(R.string.now_lets_start)", Toast.LENGTH_SHORT).show()}
            , true)
        // Add Theme for page , see the list
        all.theme(1)
       // Add Transformer for pages
       //    implementation 'com.github.Mori-hub:ViewPager2_Transfer:1.0.0'
        all.transformer(Transfer.RotateDown(),true)

    }
}