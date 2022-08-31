import org.gradle.api.artifacts.dsl.RepositoryHandler
import java.net.URI

/**
 * 作者: hrg
 * 创建时间: 2022-04-07 11:11:48
 * 描述: 新框架依赖项，统一管理，同时也方便其他组件引入
 */

/**
 * App
 */
object App {
    const val applicationId = "com.gang.image"
}

/**
 * Android
 */
object Android {
    const val kotlin = "1.7.10"
    const val gradle = "7.0.3"
    const val compileSdkVersion = 32
    const val minSdkVersion = 26
    const val targetSdkVersion = 32
    const val versionCode = 1
    const val versionName = "1.0"

    const val coil = "2.2.0"
    const val glide = "4.11.0"
}

/**
 * 系统库依赖
 * */
object Support {

    const val junit = "junit:junit:4.13.2"
    const val junit_ext = "androidx.test.ext:junit:1.1.2"
    const val espresso_core = "androidx.test.espresso:espresso-core:3.3.0"

    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val appcompat = "androidx.appcompat:appcompat:1.5.0"
    const val kotlin_stdlib_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Android.kotlin}"

    const val build_gradle = "com.android.tools.build:gradle:${Android.gradle}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Android.kotlin}"
}

/**
 * 第三方库依赖
 * */
object Dependencies {


    const val androidx_multidex = "androidx.multidex:multidex:2.0.1" // Dex处理
    const val gang_tools = "com.github.R-Gang:Tools-Utils:v1.0.1-beta"
    const val android_common = "com.github.R-Gang:Android-Common:v0.1.6-beta.10@aar"
    // 常用类封装(以上为基本类关联依赖)


    // recyclerview
    const val recyclerview = "androidx.recyclerview:recyclerview:1.2.1@aar"

    // arouter
    const val arouter_register = "com.alibaba:arouter-register:1.0.2"
    const val arouter_api = "com.alibaba:arouter-api:1.5.2"
    const val arouter_compiler = "com.alibaba:arouter-compiler:1.5.2"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Android.glide}"

    //Coil图片加载框架
    const val coil = "io.coil-kt:coil:${Android.coil}"
    const val coil_gif = "io.coil-kt:coil-gif:${Android.coil}"
    const val coil_svg = "io.coil-kt:coil-svg:${Android.coil}"
    const val coil_video = "io.coil-kt:coil-video:${Android.coil}"
    const val gif_drawable = "pl.droidsonroids.gif:android-gif-drawable:1.2.23"


    val addRepos: (handler: RepositoryHandler) -> Unit = {
        it.google()
        it.jcenter()
        it.mavenCentral()
        it.maven { url = URI("https://maven.aliyun.com/repository/gradle-plugin") }
        it.maven { url = URI("https://maven.aliyun.com/repository/public") }
        it.maven { url = URI("https://maven.aliyun.com/repository/central") }
        it.maven { url = URI("https://maven.aliyun.com/repository/google") }
        it.maven { url = URI("https://maven.aliyun.com/repository/jcenter") }
        it.maven { url = URI("https://jitpack.io") }
        it.maven { url = URI("https://developer.huawei.com/repo/") }
        it.maven { url = URI("https://dl.google.com/dl/android/maven2/") }
        it.maven { url = URI("https://maven.youzanyun.com/repository/maven-releases") }
        it.maven { url = URI("https://maven.google.com") }
        it.maven { url = URI("https://dl.bintray.com/thelasterstar/maven/") }
        it.maven { url = URI("https://dl.bintray.com/kotlin/kotlin-eap") }
        it.maven { url = URI("https://dl.bintray.com/umsdk/release") }
    }
}
