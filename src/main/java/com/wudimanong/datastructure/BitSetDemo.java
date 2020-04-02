package com.wudimanong.datastructure;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jiangqiao
 * @desc 有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来？
 */
public class BitSetDemo {

    public static void main(String[] args) {
        //随机值
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            //从1千万中获取随机数
            int randomResult = random.nextInt(10000000);
            list.add(randomResult);
        }

        //System.out.println("产生的随机数有：");
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/

        //现在将这1千万随机数存入BitSet
        BitSet bitSet = new BitSet(10000000);
        for (int i = 0; i < 10000000; i++) {
            bitSet.set(list.get(i));
        }

        System.out.println("0-1亿不在随机数中的有;->" + bitSet.size());
        long startTime = System.currentTimeMillis();
        AtomicLong count = new AtomicLong();
        AtomicLong count2 = new AtomicLong();
        for (int i = 0; i < 100000000; i++) {
            if (!bitSet.get(i)) {
                count.incrementAndGet();
                //System.out.println(i);
            } else {
                count2.incrementAndGet();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时->" + (endTime - startTime) + " 毫秒|不在的数据总数为->" + count + ";在的总数为->" + count2);
    }

}
