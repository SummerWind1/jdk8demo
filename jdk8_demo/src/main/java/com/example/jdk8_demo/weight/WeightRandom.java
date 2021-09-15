package com.example.jdk8_demo.weight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 根据treemap 实现权重随机算法
 */
public class WeightRandom {



    public static void main(String[] args) {

        // 怪物随机 0< x <=19 19< x <= 38 39-57 58-77 78-87

//        Map<String, BigDecimal> weightList = new HashMap<>(8);
        Map<BigDecimal, String> weightList = new HashMap<>(8);

        // 总权重全部累加然后得到一个区间范围节点值
        weightList.put(new BigDecimal(25), "1");
        weightList.put(new BigDecimal(60), "2");
        weightList.put(new BigDecimal(250), "3");
        weightList.put(new BigDecimal(440), "4");
        weightList.put(new BigDecimal(630), "5");
        weightList.put(new BigDecimal(820), "6");
        weightList.put(new BigDecimal(910), "7");
        weightList.put(new BigDecimal(1000), "8");
        TreeMap<BigDecimal, String> weightMap = new TreeMap<>(weightList);
//        TreeMap<String, BigDecimal> weightMap = new TreeMap<>(weightList);
//        TreeMap<Integer[], String> weightMap = new TreeMap<>(weightList);

        AtomicInteger integer = new AtomicInteger();

        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < 100000; i++) {
            int random = current.nextInt(1, 1001);
            System.out.println("当前随机数：" + random);
            SortedMap<BigDecimal, String> bigDecimalStringSortedMap = weightMap.tailMap(new BigDecimal(random));
//            System.out.println(bigDecimalStringSortedMap);
            Map.Entry<BigDecimal, String> bigDecimalStringEntry = bigDecimalStringSortedMap.entrySet().stream().findFirst().get();
            String value = bigDecimalStringEntry.getValue();
            System.out.println("当前随机取得的怪物ID：" + value);
            if ("3".equals(value)) {
                integer.incrementAndGet();
            }
//            bigDecimalStringSortedMap.entrySet().forEach(entry ->{
//                System.out.println(entry.getKey());
//                System.out.println(entry.getValue());
//            });
        }
        System.out.println("id为1的怪物10w次中出现的次数为：" + integer.get());
    }

}
