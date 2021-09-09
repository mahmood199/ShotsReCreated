package com.example.youtubeshortsclone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlin.math.log

class VideoFragment : Fragment() {

    lateinit var currentLink : String
    lateinit var youTubePlayerView : YouTubePlayerView

    companion object {
        fun newInstance(link: String): VideoFragment {
            val fragment = VideoFragment()
            val args = Bundle()
            args.putString("link", link)
            fragment.setArguments(args)
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_video, container, false)
        youTubePlayerView = view.findViewById(R.id.youtube_player_view2)

/*
        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                Log.i("Current_Link_Tag", currentLink)
                youTubePlayer.loadVideo(currentLink,0f)
            }
        })
*/

        return view
    }

    override fun onResume() {
        super.onResume()


        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                Log.i("Current_Link_Tag", currentLink)
                youTubePlayer.loadVideo(currentLink,0f)

            }

            override fun onPlaybackQualityChange(youTubePlayer: YouTubePlayer, playbackQuality: PlayerConstants.PlaybackQuality) {
                super.onPlaybackQualityChange(youTubePlayer, playbackQuality)

            }
        })

    }


    override fun onStart() {
        super.onStart()
    }

}