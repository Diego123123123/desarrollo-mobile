package edu.ucb.broadcastyourself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var arrVideoModel = ArrayList<VideoItem>()
    var videoAdapter:VideoItemAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrVideoModel.add(VideoItem("https://assets.mixkit.co/videos/preview/mixkit-tree-with-yellow-flowers-1173-large.mp4","The branches of a tree wave in the breeze, with pointy leaves ","aa"))
        arrVideoModel.add(VideoItem("https://assets.mixkit.co/videos/preview/mixkit-man-under-multicolored-lights-1237-large.mp4","A man with a small beard and mustache wearing a white sweater, sunglasses, and a backwards black baseball cap turns his head in different directions under changing colored lights.","ddd"))
        arrVideoModel.add(VideoItem("https://assets.mixkit.co/videos/preview/mixkit-man-under-multicolored-lights-1237-large.mp4","Bald man with a short beard wearing a large jean jacket holds a long tubular neon light thatch","aaa"))
        arrVideoModel.add(VideoItem("https://assets.mixkit.co/videos/preview/mixkit-sun-over-hills-1183-large.mp4","The sun sets or rises over hills, a body of water beneath them.","eee"))

        videoAdapter = VideoItemAdapter(arrVideoModel)
        viewPager.adapter = videoAdapter
    }
}