package com.image.kotlin.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.imageloader.initImage
import com.image.kotlin.BuildConfig

/**
 * @ProjectName: JetPack_Simple
 * @Package: com.simple.kotlin
 * @ClassName: LoadImageApp
 * @Description: java类作用描述
 * @Author: haoruigang
 * @CreateDate: 2022/3/7 16:30
 */
class LoadImageApp : Application() {
    override fun onCreate() {

        super.onCreate()

        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }

        ARouter.init(this)

        initImage.initLoadImage(this)

    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
}