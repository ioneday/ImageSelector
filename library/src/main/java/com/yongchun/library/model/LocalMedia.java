package com.yongchun.library.model;

import java.io.Serializable;

/**
 * Created by dee on 2015/8/5.
 */
public class LocalMedia implements Serializable {
    private String path;
    private long duration;
    private long lastUpdateAt;


    public LocalMedia(String path, long lastUpdateAt, long duration) {
        this.path = path;
        this.duration = duration;
        this.lastUpdateAt = lastUpdateAt;
    }

    public LocalMedia(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getLastUpdateAt() {
        return lastUpdateAt;
    }

    public void setLastUpdateAt(long lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

    public long getDuration() {
        return duration;
    }
    public void setDuration(long duration) {
        this.duration = duration;
    }
}
