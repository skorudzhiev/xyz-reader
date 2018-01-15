# XYZ Reader
**Version 1.0 2018/01/07**

This is a Book reader app which populates Books in a Staggered Grid of cards loaded from a network resource into a RecyclerView, with the provided functionality to open an individual item on a separate view and read the contents with an overall look that meets Material Design specs.

![alt text](https://github.com/skorudzhiev/xyz-reader/blob/master/readme/XYZ_Reader1%20-%20Nexus_5X_API_24_5554.png) ![alt text](https://github.com/skorudzhiev/xyz-reader/blob/master/readme/XYZ_Reader2%20-%20Nexus_5X_API_24_5554.png) 

### Device permissions
*App needs the following user's permissions to provide the featured functionality*
* Request user's permission to access the internet
```XML
<uses-permission android:name="android.permission.INTERNET"/>
```
* Request user's permission to access device network state
```XML
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

* Request user's permission to broadcast sticky intents
```XML
<uses-permission android:name="android.permission.BROADCAST_STICKY" />>
```

* Request user's permission to write to external storage
```XML
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

## General Usage Notes

```Gradle
defaultConfig {
        minSdkVersion 21
        targetSdkVersion 25
    }
```
* On the main screen of the app the user is presented with a grid of Books
* Every book can be opened on a new activity screen with [CollapsingToolbarLayout](https://developer.android.com/reference/android/support/design/widget/CollapsingToolbarLayout.html) and attached **Share** button functionality
* [ViewPager](https://developer.android.com/training/animation/anim_screenslide.mp4) provides the ability to slide across the separate books items in their detailed contents view

### Gradle dependencies
**Module:**
```Gradle
dependencies {
    compile "com.android.support:support-v4:$androidSupportVersion"
    compile "com.android.support:support-v13:$androidSupportVersion"
    compile "com.android.support:appcompat-v7:$androidSupportVersion"
    compile "com.android.support:palette-v7:$androidSupportVersion"
    compile "com.android.support:recyclerview-v7:$androidSupportVersion"
    compile "com.android.support:cardview-v7:$androidSupportVersion"
    compile 'com.squareup.okhttp3:okhttp:3.1.2'
    compile files('libs/volley.jar')
    compile 'com.android.support:design:25.4.0'
}
```

**Project:**
```Gradle
allprojects {
    repositories {
        jcenter()
        google()
    }
    ext {
        androidSupportVersion = "25.4.0"

    }
}
```

## Features

* UI consists of some of the following items including
  * [CoordinatorLayout](https://developer.android.com/reference/android/support/design/widget/CoordinatorLayout.html) 
  * Swipe feature to refresh the contents
  * RecyclerView
  * CardView
  * Custom class which extends [NetworkImageView](https://github.com/google/volley/blob/master/src/main/java/com/android/volley/toolbox/NetworkImageView.java) to provide additional customization options relative to ImageView 
  * [ViewPager](https://developer.android.com/reference/android/support/v4/view/ViewPager.html)
  * [CollapsingToolbarLayout](https://material.io/components/android/catalog/collapsing-toolbar-layout/)
  * FloatingActionButton attached to the AppBar, with the provided functionality to fades out when the user is engaged with the main content
  * Fragment
* App mains logic is to fetch data from provided network resource to load the books
  * This functionality is implemented with the help of [Volley](https://developer.android.com/training/volley/index.html) - used to make Networking process easier
* Database used to store temp files in case of losing internet connectivity
* Helper classes used to improve the overall UI design
