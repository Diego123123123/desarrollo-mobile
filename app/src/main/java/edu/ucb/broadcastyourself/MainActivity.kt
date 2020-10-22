package edu.ucb.broadcastyourself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var videosViewPager : ViewPager2 = findViewById(R.id.videoViewPager)
        var videoItems = ArrayList<VideoItem>()
        var video1 = VideoItem(videoURL = "https://www.infinityandroid.com/videos/video1.mp4", videoTitle = "celebration", videoDescription = "celebrationb video")
        var video2 = VideoItem(videoURL = "https://www.infinityandroid.com/videos/video1.mp4", videoTitle = "technogy", videoDescription = "video of technology")
        var video3 = VideoItem(videoURL = "https://www.infinityandroid.com/videos/video1.mp4", videoTitle = "fun", videoDescription = "See how people have fun")
        var video4 = VideoItem(videoURL = "https://www.infinityandroid.com/videos/video1.mp4", videoTitle = "education", videoDescription = "This kids is capable of using his calculator")
        var video5 = VideoItem(videoURL = "https://www.infinityandroid.com/videos/video1.mp4", videoTitle = "sports", videoDescription = "Cristiano ronaldo have another gol")
        var video6 = VideoItem(videoURL = "https://www.infinityandroid.com/videos/video1.mp4", videoTitle = "family", videoDescription = "Watch this video for increasing family relation")
        videoItems.add(video1)
        videoItems.add(video2)
        videoItems.add(video3)
        videoItems.add(video4)
        videoItems.add(video5)
        videoItems.add(video6)
        videosViewPager.adapter = VideoItemAdapter(videoItems)
    }
}