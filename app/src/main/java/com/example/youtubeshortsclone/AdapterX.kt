package com.example.youtubeshortsclone

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class AdapterX(val context: Context , val list: List<String>) : RecyclerView.Adapter<AdapterX.ViewHolder>() {


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val videoView : VideoView = itemView.findViewById(R.id.video_view)
        val textView : TextView = itemView.findViewById(R.id.caption)
        val progress_bar : ProgressBar = itemView.findViewById(R.id.progress_bar)


        fun setData(videoUrl:String, caption:String){
            textView.text = caption

            videoView.setVideoPath(videoUrl)
            videoView.setOnPreparedListener {
                progress_bar.visibility = View.GONE
                it.start()
            }

            videoView.setOnCompletionListener {
                it.start()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_shorts_layout2,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list.get(position),"Item number :${position + 1}")
    }

    override fun getItemCount(): Int {
        return list.size
    }
}