# ImageSelector
Image selector library for Android. Support single choice、multi-choice、cropping image and preview image.

![](https://raw.githubusercontent.com/ioneday/ImageSelector/master/screenshot/Screenshot1.jpg)
![](https://raw.githubusercontent.com/ioneday/ImageSelector/master/screenshot/Screenshot2.jpg)
![](https://raw.githubusercontent.com/ioneday/ImageSelector/master/screenshot/Screenshot3.jpg)

![](https://raw.githubusercontent.com/ioneday/ImageSelector/master/screenshot/Screenshot4.jpg)
![](https://raw.githubusercontent.com/ioneday/ImageSelector/master/screenshot/Screenshot5.jpg)

## Quick start

1) Add Library module as a dependency in your build.gradle file.

or

```xml
dependencies {
    compile 'com.android.support:recyclerview-v7:22.2.1'
    compile 'com.github.bumptech.glide:glide:3.6.1'
    compile 'com.commit451:PhotoView:1.2.4'
    compile 'com.isseiaoki:simplecropview:1.0.13'
    compile 'com.yongchun:com.yongchun.imageselector:1.1.0'
}
```

2) Call ImageSelectorActivity in your code

```java
ImageSelectorActivity.start(MainActivity.this, maxSelectNum, mode, isShow,isPreview,isCrop);
```
same this

```java
public static void start(Activity activity, int maxSelectNum, int mode, boolean isShow, boolean enablePreview, boolean enableCrop) {
    Intent intent = new Intent(activity, ImageSelectorActivity.class);
    intent.putExtra(EXTRA_MAX_SELECT_NUM, maxSelectNum);
    intent.putExtra(EXTRA_SELECT_MODE, mode);
    intent.putExtra(EXTRA_SHOW_CAMERA, isShow);
    intent.putExtra(EXTRA_ENABLE_PREVIEW, enablePreview);
    intent.putExtra(EXTRA_ENABLE_CROP, enableCrop);
    activity.startActivityForResult(intent, REQUEST_IMAGE);
}
```
4) Receive result in your onActivityResult Method

``` java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(resultCode == RESULT_OK && requestCode == ImageSelectorActivity.REQUEST_IMAGE){
        ArrayList<String> images = (ArrayList<String>) data.getSerializableExtra(ImageSelectorActivity.REQUEST_OUTPUT);
        // do something
    }
}
```

## Thanks

* [Glide](https://github.com/bumptech/glide)

* [PhotoView](https://github.com/chrisbanes/PhotoView)

* [simplecropview](https://github.com/IsseiAoki/SimpleCropView)

###License
>The MIT License (MIT)

>Copyright (c) 2015 Dee

>Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

>The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
