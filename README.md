# kotlin Image加载框架扩展

引入方式：

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

    dependencies {
         implementation 'com.github.R-Gang:Image-loader:latest.integration'
    }


## Usage

### 初始化 View

```
    // 在Application onCreate 中初始化
    initImage.initLoadImage(this)
```

### 使用演示

    layout 加载图片:

```
        <androidx.appcompat.widget.AppCompatImageView
			android:id="@+id/articleIma"
			load_image="@{mainData.picUrl}"
			load_image_circle_crop="@{true}"
			load_image_default_img="@{@drawable/default_image}"
			load_image_height="@{75}"
			load_image_roundedRadius="@{12}"
			load_image_width="@{120}"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:scaleType="centerCrop" />
```

    activity 加载图片:

```
		loadImage(
			imageView = imageIcon,
			url = medalInfo.appLogoUrl,
			width = 56.dp,
			height = 56.dp,
			defaultImg = AppCompatResources.getDrawable(
				this@CreatCenterActivity,
				R.mipmap.ic_medal_awarded_default
			)
		)
```

    多 view 截屏:

```
        截取当前view
        ScreenShoot.Companion.viewSaveToImage(mainBinding.rlBtn)
```

## Reference

[Coil图片加载框架](https://github.com/coil-kt/coil/)
简单介绍
完全使用kotlin编写，使用了kotlin的协程，图片网络请求方式默认为Okhttp,相比较于我们常用的Picasso，Glide或者Fresco，它有以下几个特点：
足够快速，它在内存、图片存储、图片的采样、Bitmap重用、暂停\取消下载等细节方面都有很大的优化(相比于上面讲的三大框架)； 足够轻量，只有大概1500个核心方法，当然也是相对于PGF而言的；
足够新，也足够现代！使用了最新的Kotlin协程所编写，充分发挥了CPU的性能，同时也使用了OKHttp、Okio、LifeCycle等比较新式的Android库。
