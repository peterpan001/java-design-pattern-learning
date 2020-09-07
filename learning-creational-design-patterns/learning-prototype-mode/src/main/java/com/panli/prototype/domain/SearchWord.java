package com.panli.prototype.domain;

import java.io.Serializable;

/**
 * @author lipan
 * @date 2020-09-06
 */
public class SearchWord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String keyword;
    private long count;
    private long lastUpdateTime;


    public SearchWord() {

    }

    public SearchWord(String keyword, long count, long lastUpdateTime) {
        this.keyword = keyword;
        this.count = count;
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public long getCount() {
        return this.count;
    }
}
