package com.example.marqueevertical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.marquee_vertical.MarqueeVertical

class MainActivity : AppCompatActivity() {
    private var aa:ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ff:MarqueeVertical = findViewById(R.id.guytest);
        aa.add("guyZa1")
        aa.add("guyZa2")
        aa.add("guyZa3")
        ff.setInOutAnimation(R.anim.left_in,R.anim.right_out)
        ff.startWithArray(aa)
        ff.startFlipping()
    }
}