package com.panli.prototype.prototype_pattern_shallow_copy_2;

import com.panli.prototype.domain.SearchWord;

import java.util.HashMap;
import java.util.List;

/**
 * @author lipan
 * @date 2020-09-07
 * @desc 原型设计：先采用浅拷贝的方式创建newKeywords。对于需要更新的SearchWord对象，再使用深度拷贝的方式创建一份新的对象，替换newKeywords中的老对象。（因更新数据较少，利用浅拷贝的方式节省时间和空间，又能保证currentKeywords中的数据都是老版本的数据）
 */
public class Demo {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<String, SearchWord>();

    private long lastUpdateTime = -1;

    public void refresh() {
        // 原型模式，拷贝已有对象的数据，更新少量差值
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone(); // 此处为浅克隆

        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                newKeywords.remove(searchWord.getKeyword());
            }
            newKeywords.put(searchWord.getKeyword(), searchWord);
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }


    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间 > lastUpdateTime 的数据
        return null;
    }
}
