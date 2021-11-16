package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        IntStream limit = Arrays.stream(array).filter(x -> x > 2).limit(2);
        //Arrays.stream(array).peek(x -> System.out.println(x)).sum();

        IntStream skip = Arrays.stream(array).skip(2);

        IntStream distinct = skip.distinct();




        // IntStream intStream = Arrays.stream(array).filter(x -> x > 2);
        //    intStream.limit(2);
       // IntStream distinct = intStream.distinct();
        //  distinct.limit(1);

        //  System.out.println(intStream.findAny());
        //long count = intStream.count();
        // System.out.println(count);

      //  Integer[] array2 = new Integer[]{1, 2, 3, 4, 5};
      //  Stream<Integer> stream = Arrays.stream(array2).filter(x -> x > 2);
      //  List<Integer> collect = stream.collect(Collectors.toList());


/*
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        // list.stream().collect(Collectors.toList());
        Stream<Integer> stream = list.stream().filter(x -> x > 2);
        stream.collect(Collectors.toList());

 */
    }
}
