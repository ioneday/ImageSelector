package com.yongchun.library.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dee on 2015/8/5.
 */
public class LocalMediaFolder implements Serializable {
    private String name;
    private String path;
    private String firstImagePath;
    private int imageNum;
    private List<LocalMedia> images = new ArrayList<LocalMedia>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFirstImagePath() {
        return firstImagePath;
    }

    public void setFirstImagePath(String firstImagePath) {
        this.firstImagePath = firstImagePath;
    }

    public int getImageNum() {
        return imageNum;
    }

    public void setImageNum(int imageNum) {
        this.imageNum = imageNum;
    }

    public List<LocalMedia> getImages() {
        return images;
    }

    public void setImages(List<LocalMedia> images) {
        this.images = images;
    }
}
