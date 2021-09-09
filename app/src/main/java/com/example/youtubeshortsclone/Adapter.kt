package com.example.youtubeshortsclone

import android.content.Context
import android.media.browse.MediaBrowser
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class Adapter(val context: Context, val list: List<String>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerView: PlayerView = itemView.findViewById(R.id.player_view)
        lateinit var player: SimpleExoPlayer
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_shorts_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.player = SimpleExoPlayer.Builder(context).build()
        holder.playerView.player = holder.player


        val mediaItem: MediaItem = MediaItem.fromUri(list.get(position))
        holder.player.setMediaItem(mediaItem)

        holder.player.prepare()
        holder.player.setPlayWhenReady(true)
        holder.playerView.useController = false

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.player.prepare()
        holder.player.setPlayWhenReady(true)
        holder.playerView.useController = false
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.player.stop()
    }

}