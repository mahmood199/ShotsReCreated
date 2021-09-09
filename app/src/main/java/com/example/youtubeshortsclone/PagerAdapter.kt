package com.example.youtubeshortsclone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity,val links: ArrayList<String>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return links.size
    }

    override fun createFragment(position: Int): Fragment {
        val videoFragment = VideoFragment.newInstance(links.get(position))
        videoFragment.currentLink = links.get(position)
        return videoFragment
    }




}