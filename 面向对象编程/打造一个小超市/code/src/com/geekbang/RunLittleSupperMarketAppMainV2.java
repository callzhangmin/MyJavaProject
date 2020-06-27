package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.MerchandiseV2;

import java.util.Scanner;

public class RunLittleSupperMarketAppMainV2 {
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
        MerchandiseV2 m0 = all[0];
        while (true) {
            System.out.println("今日超市大特惠，所有商品第二件半价！请输入要购买的商品索引：");
            int index = scanner.nextInt();
            if (index < 0) {
                System.out.println("欢迎再次光临！");
                break;
            }
            System.out.println("请输入需要购买的数量");
            int count = scanner.nextInt();
            MerchandiseV2 m = littleSuperMarKet.merchandises[index];
            System.out.println("用户选择的商品是超市里价值最高的："+ m.isTheBiggerTotalValueOne(littleSuperMarKet));
            double totalCost = m.buyAndPrintLeft(count, true);
            boolean moBiggerThan = m0.totalValueBiggerThan(m);
            System.out.println("m0的总价值比用户选择的要大：" + moBiggerThan);
            System.out.println("商品总价为" + totalCost);
        }
    }
}
