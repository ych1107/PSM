package com.ujiuye.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: PSM
 * @description: 对后台获取前台的数据进行解析，得到我们想要的格式
 * @author: Mr.C
 * @create: 2019-12-03 15:19
 **/
public class MapUtils {

    public  static Map<String, Object> paramMapTomybatisMap(Map<String,Object> paramMap){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Set<Map.Entry<String, Object>> entries = paramMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object o = paramMap.get(key);
            if (key.startsWith("like")) {
                key = key.substring(key.indexOf("_" )+1);
                o = "%" + o + "%";
            }
            resultMap.put(key, o);
        }
        return resultMap;
    }

    public static String parseParamMapToQueryStr(Map<String,Object> paramMap){
        StringBuilder result = new StringBuilder();
        Set<Map.Entry<String, Object>> entries = paramMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
            result.append("&").append("search_").append(key).append("=").append(value);
        }
        return result.toString();
    }
}
