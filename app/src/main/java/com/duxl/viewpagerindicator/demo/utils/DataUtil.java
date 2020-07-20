package com.duxl.viewpagerindicator.demo.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * create by duxl 2020/7/20
 */
public class DataUtil {

    public static List<String> getItemsA() {
        List<String> items = new ArrayList<>();
        items.add("所有");
        items.add("未关闭");
        items.add("由我创建");
        items.add("指派给我");
        items.add("由我解决");
        items.add("待关闭");
        items.add("未解决");
        items.add("更多");
        return items;
    }

    public static List<String> getItemsB() {
        List<String> items = new ArrayList<>();
        items.add("所有订单");
        items.add("未支付");
        items.add("待收货");
        items.add("已完成");
        return items;
    }

    public static List<String> getItemC() {
        List<String> items = new ArrayList<>();
        items.add("正式环境");
        items.add("测试环境");
        return items;
    }

}
