package com.offer.foundation.class5;

import java.util.HashMap;

/**
 * @author pengcheng
 * @date 2019/3/29 - 14:56
 * @content: O(1)时间范围内：可以加入数据，删除数据，且等概率随机返回结构中的任何一个数据
 */
public class RandomPool<T> {

    private HashMap<T, Integer> map1;
    private HashMap<Integer, T> map2;
    private int size;  // 记录有多少个元素，且保证：0 ~ (size - 1) 里面一定是有元素的

    // 初始化
    public RandomPool(){
        map1 = new HashMap<T, Integer>();
        map2 = new HashMap<Integer, T>();   // 第二个map中的key是连续的，用来保证O(1)的随机获取
        size = 0;
    }

    // 将某个key加入到该结构中，做到不重复加入
    public void insert(T key){
        if(!map1.containsKey(key)){
            map1.put(key, size);    // key -> index
            map2.put(size, key);    // index -> key
            size++;
        }
    }

    // 将原本结构中的某个key删除
    // 为了保证哈希表的连续性，将最后一个元素移到删除元素的位置，避免出现空洞
    public void delete(T key){
        // 如果包含再删除
        if(map1.containsKey(key)){
            int deleteIndex = map1.get(key);    // 要删除元素的index
            int lastIndex = --size;             // 最后一个元素的index，同时数据个数减1了
            T lastKey = map2.get(lastIndex);

            // 用最后一个位置上的元素覆盖掉要删除位置上的元素
            map1.put(lastKey, deleteIndex);
            map2.put(deleteIndex, lastKey);

            // 保证的是map2中的数据是连续的，map1中无需保证
            map1.remove(key);        // 删除mp1中key为key的数据
            map2.remove(lastIndex);  // 删除mp2中key为lastIndex的数据
        }
    }

    // 等概率返回结构中的任何一个key
    public T getRandom(){
        if(size == 0){
            return null;
        }
        // Math.random()产生的是一个0-1区间double类型的小数
        int index = (int)(Math.random() * size);
        return map2.get(index);   // map2是连续的
    }
}
