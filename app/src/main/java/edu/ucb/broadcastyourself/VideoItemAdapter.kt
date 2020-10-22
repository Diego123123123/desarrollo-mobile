package edu.ucb.broadcastyourself

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import edu.ucb.broadcastyourself.VideoItemAdapter.VideoViewHolder

class VideoItemAdapter(videos: List<VideoItem>) :RecyclerView.Adapter<VideoViewHolder>(){

    private var videoList: List<VideoItem> = videos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_container_video,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.setVideoData(videoList.get(position))
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    inner class VideoViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        private var videoView: VideoView = itemView.findViewById(R.id.videoView)
        private var textVideoTitle: TextView? = itemView.findViewById(R.id.textVideoTitle)
        private var textVideoDescription: TextView? = itemView.findViewById(R.id.textVideoDescription)
        private var videoProgressBar: ProgressBar? = itemView.findViewById(R.id.videoProgressBar)

        fun setVideoData(videoItem: VideoItem) {
            textVideoTitle?.setText(videoItem.videoTitle)
            textVideoDescription?.setText(videoItem.videoDescription)
            videoView.setVideoPath(videoItem.videoURL)
            videoView.setOnPreparedListener(MediaPlayer.OnPreparedListener {
                fun onPrepared(mp: MediaPlayer) {
                    videoProgressBar?.visibility = View.GONE
                    mp.start()
                    var videoRatio = mp.videoWidth / mp.videoHeight
                    var screenRatio = videoView.width / videoView.height
                    var scale = videoRatio / screenRatio
                    if (scale >= 1f) {
                        videoView.scaleX = scale.toFloat()
                    } else {
                        videoView.scaleY = 1f/scale
                    }
                }
            })
            videoView.setOnCompletionListener { MediaPlayer.OnCompletionListener {
                fun onCompletion(mp: MediaPlayer) {
                    mp.start()
                }
            } }
        }
    }
}