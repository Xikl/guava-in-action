package com.ximo.guavainaction.config;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 朱文赵
 * @date 2018/2/26 10:17
 * @description
 */
public class ScheduleConfigTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.stream().map((a) -> a + 1).forEach(System.out::println);
        Integer account = list.stream().map((a) -> a + 1).reduce((sum, cost) -> sum + cost).get();
        System.out.println(account);
        List<Integer> collect = list.stream().map(a -> a + 1).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}