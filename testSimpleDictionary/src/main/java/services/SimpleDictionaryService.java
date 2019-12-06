package services;

import java.util.*;

public class SimpleDictionaryService {
    private static Map<String, String> dic = new HashMap<>();

    static {
        initDictionary();
    }

    private static void initDictionary() {
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");
    }

    public static Map<String,String> getAllValue() {
        return dic;
    }
}
