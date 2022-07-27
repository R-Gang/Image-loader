package com.image.kotlin

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.bumptech.glide.util.Util
import com.gang.imageloader.java.ScreenShoot
import com.image.kotlin.base.Constants
import com.image.kotlin.databinding.ActivityMainBinding
import com.image.kotlin.utils.PopuUtil


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding


    val picUrl =
        "https://avatars.githubusercontent.com/u/16377799?s=400&u=d9bc6b37bd847c1143aa7ffb59f368d069a9f5bd&v=4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 原始方式
        // setContentView(R.layout.activity_main)

        /*
        方式1 视图绑定
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        */

        /*
        方式2 数据绑定
        */
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        mainBinding.mainData = this

    }

    fun onToUpdateApp() {
        ARouter.getInstance()
            .build(Constants.ACTIVITY_URL_UPDATEAPP)
            .navigation(this)
    }

    fun onScreenShoot(v: View) {
        val bitmap: Bitmap = ScreenShoot.Companion.viewSaveToImage(mainBinding.rlBtn)
        PopuUtil.showPopu(this, bitmap, v)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (Util.isOnMainThread() && !this.isFinishing) {
            Glide.with(applicationContext).pauseRequests()
        }
    }

}