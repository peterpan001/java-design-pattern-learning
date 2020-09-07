package com.panli.prototype.scene_2;

import com.panli.prototype.domain.SearchWord;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author lipan
 * @date 2020-09-06
 * @desc 此代码解决了上一个设计中的中间状态转换过程，在转换过程中，老版本起作用，但是一个转换完毕，新版本起作用。
 * 但是，此处存在一个浅拷贝的问题。当数据量比较大时，拷贝的过程也会花销巨大的时间。故引出原型模式。
 */
public class Demo {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<String, SearchWord>();

    public void refresh() {
        HashMap<String, SearchWord> newKeywords = new LinkedHashMap<String, SearchWord>();

        // 从数据库中取出所有的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords();
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            newKeywords.put(searchWord.getKeyword(), searchWord);
        }
        currentKeywords = newKeywords; // 注意此处为浅拷贝
    }

    private List<SearchWord> getSearchWords() {
        // TODO: 从数据库中取出更新时间 > lastUpdateTime 的数据
        return null;
    }
}
