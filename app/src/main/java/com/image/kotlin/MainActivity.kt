package com.image.kotlin

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.bumptech.glide.util.Util
import com.gang.imageloader.java.GlideUtils
import com.gang.imageloader.java.ScreenShoot
import com.gang.imageloader.kotlin.transform.BlurTransformation
import com.gang.imageloader.kotlin.transform.GrayscaleTransformation
import com.image.kotlin.databinding.ActivityMainBinding
import com.image.kotlin.utils.Constants
import com.image.kotlin.utils.PopuUtil


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding


    val picUrl = "https://image.xmdede.com/dana/rwxd.png"
    val picUrl1 =
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

        GlideUtils.setGlideImg(this, picUrl1, R.drawable.default_image, mainBinding.articleIma1)

        mainBinding.articleIma2.load(picUrl1) {
            // 淡入淡出
            crossfade(true)
            //占位图
            placeholder(R.drawable.default_image)
            //错误图
            error(R.drawable.default_image)
            //圆形
            transformations(CircleCropTransformation())
            //模糊--指定模糊程度
            transformations(BlurTransformation(this@MainActivity, 20f))
            //灰度
            transformations(GrayscaleTransformation())
            //圆角--指定上下左右圆角弧度
            transformations(
                GrayscaleTransformation(),
                RoundedCornersTransformation(
                    topLeft = 20f,
                    topRight = 20f,
                    bottomLeft = 20f,
                    bottomRight = 20f
                )
            )

        }
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