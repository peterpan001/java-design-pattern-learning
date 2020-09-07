package com.panli.prototype.prototype_pattern_deep_copy_2;

import com.panli.prototype.domain.SearchWord;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * @author lipan
 * @date 2020-09-06
 * @desc 深拷贝第二种方式：先将对象序列化，然后再反序列化成新的对象
 */
public class Demo {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<String, SearchWord>();

    private long lastUpdateTime = -1;

    public void refresh() throws IOException, ClassNotFoundException {

        // deep copy
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) deepCopy(currentKeywords);

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

    public Object deepCopy(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(object);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}
