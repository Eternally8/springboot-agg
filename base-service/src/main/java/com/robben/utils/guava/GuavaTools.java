package com.robben.utils.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * @author hjz
 * @version 1.0
 * @date 2022/6/27 17:00
 * https://blog.csdn.net/tc979907461/article/details/105394977?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-105394977-blog-120974851.pc_relevant_paycolumn_v3&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-105394977-blog-120974851.pc_relevant_paycolumn_v3&utm_relevant_index=1
 *
 * 主要是记录一些guava的给工具类使用
 */
public class GuavaTools {


    public static void main(String[] args) {

        //字符串拼接
        List<String> list = Lists.newArrayList("a","b","c");
        String value = Joiner.on("-").skipNulls().join(list);
        System.out.println(value);
        //输出为： a-b-c

        //Splitter用来分割字符串
        String testString = "Monday,Tuesday,,Thursday,Friday,,";
        //英文分号分割；忽略空字符串
        Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
        System.out.println(splitter.split(testString).toString());
        //转换为了：[Monday, Tuesday, Thursday, Friday]

        //CharMatcher常用来从字符串里面提取特定字符串。
        //比如想从字符串中得到所有的数字.
        String value2 = CharMatcher.any().retainFrom("some text 2046 and more");
        //value=2046
        System.out.println(value2);


        //集合创建,各种以S结尾的工厂类简化了集合的创建。在创建泛型实例的时候，它们使代码更加简洁
        List<String> list2 =Lists.newArrayList();
        List<String> list3 = Lists.newArrayList("a","b","c");
        Set<Integer> set = Sets.newHashSet();

        //集合的交集、并集和差集
//        Sets.intersection(setA, setB);
//        Sets.union(setA, setB);
//        Sets.difference(setA, setB);






    }


}
