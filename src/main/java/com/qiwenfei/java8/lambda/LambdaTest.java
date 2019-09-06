package com.qiwenfei.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 2019/7/30
 * sunshine
 */
public class LambdaTest {

    @Test
    public void  test1(){
        String msg = "world";
        new Thread(()-> System.out.println("hello "+msg)).start();
    }
    @Test
    public void test2(){

        List<Integer> integers = Arrays.asList(1,2,4,6,723,23,42);
        integers.sort((a,b)->a.compareTo(b));
        integers.forEach(System.out::println);

    }
    @Test
    public void test3(){
        List<Person> people = Arrays.asList(new Person("张三",12),new Person("李四",28));

        people.sort((a,b)-> Integer.compare(a.getAge(),b.getAge()));

//        people.forEach(a-> System.out.println(a.getAge()));

        people.forEach(a->{if(a.getAge()>20){
            System.out.println(a.getName()+"---"+a.getAge());
        }});

    }
    @Test
    public void test4(){
        Runnable runnable = ()-> System.out.println("hello");
        new Thread(runnable).start();
    }

    @Test
    public void test5(){
        TreeSet<Integer> integers = new TreeSet<Integer>(((o1, o2) -> Integer.compare(o1,o2)));

        integers.add(2);
        integers.add(1);
        integers.add(3);
        integers.forEach(System.out::println);
    }

    @Test
    public void test6() {
        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);

        nums.stream().filter(num->num != null && num > 5 ).mapToInt(num->num*2).peek(num-> System.out.println(num*2)).skip(2).limit(4).sum();

//        nums.stream().filter(num->num != null && num > 5 ).mapToInt(num ->num*2).forEach(System.out::println);

//        System.out.println("sum is:" + nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).sum());
    }

}
