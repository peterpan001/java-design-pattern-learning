package com.panli.prototype.prototype_pattern_deep_copy_1;

import com.panli.prototype.domain.SearchWord;

import java.util.HashMap;
import java.util.List;

/**
 * @author lipan
 * @date 2020-09-06
 * @desc 原型设计模式深拷贝实现方式，递归拷贝对象、对象的引用对象以及引用对象的引用对象...直到要拷贝的对象只包含基本数据类型数据，没有引用对象为止。
 */
public class Demo {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<String, SearchWord>();

    private long lastUpdateTime = -1;

    public void refresh() {
        // deep copy，第一种方法
        HashMap<String, SearchWord> newKeywords = new HashMap<String, SearchWord>();
        for (HashMap.Entry<String, SearchWord> ele : currentKeywords.entrySet()) {
            SearchWord searchWord = ele.getValue();
            SearchWord newSearchWord = new SearchWord(searchWord.getKeyword(), searchWord.getCount(), searchWord.getLastUpdateTime());
            newKeywords.put(ele.getKey(), newSearchWord);
        }

        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;

        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyword());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyword(), searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间 > lastUpdateTime 的数据
        return null;
    }
}
