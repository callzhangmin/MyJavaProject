package com.bang;

import com.bang.persion.Customer;
import com.bang.supermarket.Merchandise;
import com.bang.supermarket.LittleSuperMarket;

import java.util.Scanner;

/**
 * 超市程序
 */
public class RunLittleSupperMarketAppMain {
    public static void main(String[] args) {
        //创建一个超市小类
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        //依次给超市属性赋值
        littleSuperMarket.address = "西湖区世纪大道22号";
        littleSuperMarket.superMarketName = "zm天猫小店";
        littleSuperMarket.parkingCount = 150;
        //超市商品种类赋值
        littleSuperMarket.merchandises = new Merchandise[200];
        //统计用的数组
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];
        //为了方便创建一个商品数组引用，和littleSuperMarket.merchandises指向同一数组对象
        Merchandise[] all = littleSuperMarket.merchandises;

        //遍历给200件商品赋值
        for (int i = 0; i < all.length; i++) {
            Merchandise m = new Merchandise();
            m.name = "商品" + i;
            m.count = 200;
            m.id = "id" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (1 + Math.random()) * 200;
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            all[i] = m;
        }
        System.out.println("超市开张了");
        boolean open = true;
        Scanner in = new Scanner(System.in);
        while (open) {
            System.out.println("本店叫做" + littleSuperMarket.superMarketName);
            System.out.println("地址在" + littleSuperMarket.address);
            System.out.println("共有停车位" + littleSuperMarket.parkingCount + "个");
            System.out.println("今天的营业额为" + littleSuperMarket.incomingSum);
            System.out.println("共有商品" + littleSuperMarket.merchandises.length + "种");

            Customer customer = new Customer();
            customer.name = "顾客编号" + ((int) (Math.random() * 1000000));
            customer.money = (1 + Math.random() * 100000);
            customer.isDrivingCar = Math.random() > 0.5;

            //-----------开始接待客户--------
            //给开车的客户分配车位，如果没空位了就不让进
            if (customer.isDrivingCar) {
                if (littleSuperMarket.parkingCount > 0) {
                    System.out.println("欢迎" + customer.name + "驾车而来。本店已经为您安排了车位，停车免费哦。车位编号为" + littleSuperMarket.parkingCount);
                    littleSuperMarket.parkingCount -= 1;
                } else {
                    System.out.println("不好意思已经没有车位了哦。欢迎您下次光临！");
                    continue;
                }
            } else {
                System.out.println("欢迎" + customer.name + "光临本店");
            }

            //接待客户
            double totalCost = 0;
            boolean isContinue = true;
            while (isContinue) {
                System.out.println("本店提供" + littleSuperMarket.merchandises.length + "种商品，请输入您要购买的商品编号：");
                int merchandiseId = in.nextInt();
                // 输入负数表示买好了。
                if (merchandiseId < 0) {
                    break;
                }

                // 商品没有，让顾客继续选择
                if (merchandiseId >= all.length) {
                    System.out.println("次商品本店没有这种商品，请挑选编号在0到" + (all.length - 1) + "之间的编号");
                    continue;
                }

                // 商品有，问顾客要购买多少个
                Merchandise toBuy = all[merchandiseId];
                System.out.println(toBuy.name + "单价" + toBuy.soldPrice + "。请问购买几个？");

                int numToBuy = in.nextInt();

                // 不想买，看看也欢迎
                if (numToBuy <= 0) {
                    System.out.println("不买看看也好，欢迎继续选购");
                    continue;
                }

                // 买的太多，库存不够
                if (numToBuy > toBuy.count) {
                    System.out.println(toBuy.name + "只有" + toBuy.count + "件了，不够" + numToBuy + "。欢迎继续选购。");
                    continue;
                }

                // 顾客钱不够
                if (numToBuy * toBuy.soldPrice + totalCost > customer.money) {
                    System.out.println("您带的钱不够结账，请您理智消费。");
                    continue;
                }

                // 钱也够，货也够
                // 更新顾客此次消费的总额
                totalCost += numToBuy * toBuy.soldPrice;
                // 更新商品库存
                toBuy.count -= numToBuy;
                // 更新今日销货数据
                littleSuperMarket.merchandiseSold[merchandiseId] += numToBuy;
                isContinue = in.nextBoolean();
            }
            customer.money -= totalCost;
            //归还车位
            if (customer.isDrivingCar) {
                littleSuperMarket.parkingCount++;
            }
            System.out.println(customer.name + "共消费" + totalCost + "。欢迎再次光临。");
            littleSuperMarket.incomingSum += totalCost;

            System.out.println("请问继续营业吗？");
            open = in.nextBoolean();
        }
        System.out.println("超市关门啦！");
        System.out.println("今日销售额为" + littleSuperMarket.incomingSum + "。营业统计如下：");
        for (int i = 0; i < littleSuperMarket.merchandiseSold.length; i++) {
            int sold = littleSuperMarket.merchandiseSold[i];
            if (sold > 0) {
                Merchandise m = littleSuperMarket.merchandises[i];
                double netIncoming = sold * (m.soldPrice - m.purchasePrice);
                double incoming = sold * m.soldPrice;
                System.out.println(littleSuperMarket.merchandises[i].name + "售出" + sold + "个。销售额" + incoming + "。毛利润" + netIncoming);
            }

        }
    }


}

