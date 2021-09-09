package com.example.youtubeshortsclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity2 : AppCompatActivity() {

    lateinit var vertical_view_pager : ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportActionBar?.hide()


        vertical_view_pager = findViewById(R.id.vertical_view_pager)

        val pagerAdapter = PagerAdapter(this,getLinks())
        vertical_view_pager.adapter = pagerAdapter
    }

    fun getLinks() : ArrayList<String>{
        val youtube_link = ArrayList<String>()

        //https://www.youtube.com/embed/1lqzxLYBpqg
        //https://www.youtube.com/embed/hShz2mM8OqM
        //https://www.youtube.com/embed/Tz2j1dqp5ww
        //https://www.youtube.com/embed/ygXFDm23TtM
        //https://www.youtube.com/embed/NjjIB1mIVHQ
        //https://www.youtube.com/embed/2OSOr9pSyJ0
        //https://www.youtube.com/embed/j3FQNIG_kDE

        //https://youtu.be/1lqzxLYBpqg

        youtube_link.add("1lqzxLYBpqg")
        youtube_link.add("hShz2mM8OqM")
        youtube_link.add("Tz2j1dqp5ww")
        youtube_link.add("ygXFDm23TtM")
        youtube_link.add("NjjIB1mIVHQ")
        youtube_link.add("2OSOr9pSyJ0")
        youtube_link.add("j3FQNIG_kDE")


        return youtube_link
    }

}