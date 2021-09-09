package com.example.youtubeshortsclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class AdapterXX(val context: Context, val list: List<String>) :
    RecyclerView.Adapter<AdapterXX.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val youtube_player_view: YouTubePlayerView = itemView.findViewById(R.id.youtube_player_view)
        val youtube_player_view_text: TextView =
            itemView.findViewById(R.id.youtube_player_view_text)

        fun setData(s1: String, s: String, position: Int) {
            youtube_player_view.enterFullScreen()
            youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    if (position == bindingAdapterPosition) {
                        val videoId = s1
                        youTubePlayer.cueVideo(videoId, 0f)
                    }
                }
            })
            youtube_player_view_text.text = s
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_youtube_player, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list.get(position), "Item number : ${position + 1}", position)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}