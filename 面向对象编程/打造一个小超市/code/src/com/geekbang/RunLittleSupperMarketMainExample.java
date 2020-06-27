package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.MerchandiseV2;

import java.util.Scanner;

public class RunLittleSupperMarketMainExample {
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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("今日超市大特惠，所有商品第二件半价！请输入要购买的商品索引：");
            int index = scanner.nextInt();
            if (index < 0) {
                break;
            }
            if (index > all.length) {
                System.out.println("我们没有这种商品");
                continue;
            }
            MerchandiseV2 m = all[index];
            System.out.println("商品" + m.name + "售价为" + m.soldPrice + "。请问购买几件？");
            int numToBuy = scanner.nextInt();
            if (numToBuy > m.count) {
                System.out.println("库存不足");
                continue;
            }
            int fullPriceCount = numToBuy / 2 + numToBuy % 2;
            int halfPriceCount = numToBuy - fullPriceCount;
            double totalCost = fullPriceCount * m.soldPrice + (halfPriceCount * m.soldPrice / 2);
            m.count -= numToBuy;
            System.out.println("选购的商品总价为"+totalCost+"全价件数"+fullPriceCount+"半价件数"+halfPriceCount);
        }
    }
}
