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
    compile 'com.yongchun:com.yongchun.ImageSelector:1.1.0'
}
```

2) Declare permission in your AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```
```java
<activity android:name="com.yongchun.library.view.ImageSelectorActivity"/>
<activity android:name="com.yongchun.library.view.ImagePreviewActivity"/>
<activity android:name="com.yongchun.library.view.ImageCropActivity"/>
```

3) Call ImageSelectorActivity in your code

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

