package com.geekbang;

import com.geekbang.person.Customer;
import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.MerchandiseV2;

import java.util.Scanner;

public class RunLittleSuperMaketAppMain {
    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarKet = new LittleSuperMarket();
        littleSuperMarKet.address = "西湖区古墩路222号";
        littleSuperMarKet.superMarketName = "张哥超市";
        littleSuperMarKet.parkingCount = 200;
        littleSuperMarKet.merchandises = new MerchandiseV2[200];
        littleSuperMarKet.merchandiseSole = new int[littleSuperMarKet.merchandises.length];
        MerchandiseV2[] all = littleSuperMarKet.merchandises;
        for (int i = 0; i < all.length; i++) {
            MerchandiseV2 m = new MerchandiseV2();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = Math.random() * 200;
            m.madeIn = "Chian";
            all[i] = m;
        }
        System.out.println("下面是利润最高的商品的介绍");
        littleSuperMarKet.getBiggestProfitMerchindise().describe();
//        System.out.println("超市开门了");
//        boolean open = true;
//        Scanner scanner = new Scanner(System.in);
//        while (open) {
//            System.out.println("本超市叫" + littleSuperMarKet.superMarketName);
//            System.out.println("本店地址" + littleSuperMarKet.address);
//            System.out.println("一共有停车位" + littleSuperMarKet.parkingCount + "个");
//            System.out.println("今天营业额" + littleSuperMarKet.incomingSum);
//            System.out.println("共有商品" + littleSuperMarKet.merchandises.length + "件");
//            Customer customer = new Customer();
//            customer.name = "顾客编号" + ((int) (Math.random() * 10000));
//            customer.isDrivingCar = Math.random() > 0.5;
//            customer.money = (1 + Math.random()) * 1000;
//            if (customer.isDrivingCar) {
//                if (littleSuperMarKet.parkingCount > 0) {
//                    System.out.println("欢迎" + customer.name + "驾车而来。本店已经为您安排了车位，停车免费");
//                    littleSuperMarKet.parkingCount--;
//                } else {
//                    System.out.println("不好意思本店车位已满，欢迎下次光临！");
//                }
//            } else {
//                System.out.println("欢迎" + customer.name + "光临本店");
//            }
//            double totalCost = 0;
//            while (true) {
//                System.out.println("本店提供" + all.length + "种商品，欢迎选购。请输入商品编码");
//                int index = scanner.nextInt();
//                if (index < 0) {
//                    break;
//                }
//                if (index >= all.length) {
//                    System.out.println("本店没有这种商品，请输入编号0到" + (all.length - 1) + "之间的商品编号");
//                    continue;
//                }
//                MerchandiseV2 m = all[index];
//                System.out.println("您选购的商品名字" + m.name + "。单价是" + m.soldPrice + "。请问您要购买多少个？");
//                int numToBuy = scanner.nextInt();
//                if (numToBuy <= 0) {
//                    System.out.println("不买看看也好，欢迎继续挑选。");
//                    continue;
//                }
//                if (numToBuy > m.count) {
//                    System.out.println("本店此商品的库存没有这么多，请到前台进行预约，我们将安排调货");
//                    continue;
//                }
//                if (numToBuy * m.soldPrice + totalCost > customer.money) {
//                    System.out.println("您带的钱不够，欢迎继续挑选");
//                    continue;
//                }
//                totalCost += numToBuy * m.soldPrice;
//                m.count -= numToBuy;
//                littleSuperMarKet.merchandiseSole[index] += numToBuy;
//            }
//            customer.money -= totalCost;
//            if (customer.isDrivingCar) {
//                littleSuperMarKet.parkingCount++;
//            }
//            System.out.println("顾客" + customer.name + "共消费了" + totalCost);
//            littleSuperMarKet.incomingSum = totalCost;
//            System.out.println("还继续营业吗");
//            open = scanner.nextBoolean();
//        }
//        System.out.println("超市关门了！");
//        System.out.println("今天总的营业额为" + littleSuperMarKet.incomingSum + "。营业情况如下：");
//        for (int i = 0; i < littleSuperMarKet.merchandiseSole.length; i++) {
//            MerchandiseV2 m = all[i];
//            int numSole = littleSuperMarKet.merchandiseSole[i];
//            if (numSole > 0) {
//                double incomming = m.soldPrice * numSole;
//                double netIncomming = (m.soldPrice - m.purchasePrice) * numSole;
//                System.out.println(m.name + "售出了" + numSole + "个。销售额为" + incomming + "。净利润为" + netIncomming);
//            }
//        }
    }
}
