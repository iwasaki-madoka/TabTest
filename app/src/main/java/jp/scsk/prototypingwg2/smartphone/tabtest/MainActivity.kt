package jp.scsk.prototypingwg2.smartphone.tabtest

import android.app.TabActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : TabActivity(){


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 録画タブの作成
        val recordSpec = tabHost.newTabSpec("Record")
        recordSpec.setIndicator("Record")
        val recordIntent = Intent(this, RecordActivity::class.java)
        recordSpec.setContent(recordIntent)

        // 動画一覧タブの作成
        val videoListSpec = tabHost.newTabSpec("VideoList")
        videoListSpec.setIndicator("VideoList")
        val videoListIntent = Intent(this, VideoListActivity::class.java)
        videoListSpec.setContent(videoListIntent)

        // 地図タブの作成
        val MapSpec = tabHost.newTabSpec("Map")
        MapSpec.setIndicator("Map")
        val videosIntent = Intent(this, MapActivity::class.java)
        MapSpec.setContent(videosIntent)

        // タブの追加
        tabHost.addTab(recordSpec)
        tabHost.addTab(videoListSpec)
        tabHost.addTab(MapSpec)

    }

    fun tabHandler(target: View) {
        record_button.setSelected(false)
        videolist_button.setSelected(false)
        map_button.setSelected(false)
        if (target.id == R.id.record_button) {
            tabHost.currentTab = 0
            record_button.setSelected(true)
        } else if (target.id == R.id.videolist_button) {
            tabHost.currentTab = 1
            videolist_button.setSelected(true)
        } else if (target.id == R.id.map_button) {
            tabHost.currentTab = 2
            map_button.setSelected(true)
        }
    };

}
