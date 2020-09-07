package com.panli.prototype.scene_1;

import com.panli.prototype.domain.SearchWord;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lipan
 * @date 2020-09-06
 * @desc 此代码存在的缺陷：更新时存在一个更新的过程，在此更新过程中存在一个服务不可用，即中间状态转换。由a1版本转换为a2版本的过程
 */
public class Demo {
    private ConcurrentHashMap<String, SearchWord> currentKeywords = new ConcurrentHashMap<String, SearchWord>();

    private long lastUpdateTime = -1;

    public void refresh() {
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (currentKeywords.contains(searchWord.getKeyword())) {
                currentKeywords.replace(searchWord.getKeyword(), searchWord);
            } else {
                currentKeywords.put(searchWord.getKeyword(), searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间 > lastUpdateTime 的数据
        return null;
    }
}
