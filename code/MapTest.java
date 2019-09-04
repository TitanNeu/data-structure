package indi.datastructure;

import java.util.*;

public class MapTest {
    public static void main(String[] args){
        Map<String, List<String>> hashMap = new HashMap<>();
        hashMap.put("1", new ArrayList<String>());
        hashMap.put("2", new ArrayList<String>());

        hashMap.get("1").add("a");
        hashMap.get("1").add("b");
        hashMap.get("2").add("a");
        hashMap.get("2").add("b");

        //获得HashMap中所有元素的键的KeySet
        Set<String> keySet = hashMap.keySet();

        System.out.println(keySet);

        //获得HashMap中所有元素的值values的Collection集合
        Collection<List<String>> values = hashMap.values();

        System.out.println(values);

        //迭代Entry元素
        for(Map.Entry<String, List<String>> entry : hashMap.entrySet()){
            System.out.println(entry);
            //获得这个元素的key
            String key = entry.getKey();
            System.out.println(key);
            //获得这个元素的value
            List<String> value = entry.getValue();
            System.out.println(value);

        }
    }
}
