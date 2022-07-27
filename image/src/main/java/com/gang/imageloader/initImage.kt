package com.gang.imageloader

import android.app.Application
import android.content.Context

/**
 * @CreateDate:     2022/7/22 15:17
 * @ClassName:      initImage
 * @Description:    类作用描述
 * @Author:         haoruigang
 */
object initImage {

    val TAG = "initImage"

    var imgContext: Context? = null

    fun initLoadImage(app: Application): Application {
        imgContext = app.applicationContext
        return app
    }

}