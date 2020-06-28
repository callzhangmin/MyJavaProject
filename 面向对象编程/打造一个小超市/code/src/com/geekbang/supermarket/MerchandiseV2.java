package com.geekbang.supermarket;

import com.geekbang.mockthis.MerchandiseV2MockThis;

public class MerchandiseV2 {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;
    public String madeIn;

    public void describe() {
        System.out.println("商品名称叫做" + name + ",id是" + id + "。商品售价" + soldPrice + "。商品进价" + purchasePrice + "。商品毛利" + count + "。生产产地是" + madeIn);
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        if (profit <= 0) {
            return 0;
        }
        return profit;
    }

    //如果返回值是负数，就代表购买失败，库存不足
    public double buy(int countToBuy) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            return -1;
        }
        System.out.println("商品单价为" + soldPrice);
        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = fullPriceCount * soldPrice + (halfPriceCount * soldPrice / 2);
        count -= countToBuy;
        return totalCost;
    }

    public double buyAndPrintLeft(int countToBuy, boolean printLeft) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            if (printLeft) {
                System.out.println("商品剩余库存为" + count);
            }
            return -1;
        }
        System.out.println("商品单价为" + soldPrice);
        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = fullPriceCount * soldPrice + (halfPriceCount * soldPrice / 2);
        count -= countToBuy;
        if (printLeft) {
            System.out.println("商品剩余的库存为" + printLeft);
        }
        return totalCost;
    }

    public boolean totalValueBiggerThan(MerchandiseV2 merchandiseV2) {
        return count * purchasePrice > merchandiseV2.purchasePrice * merchandiseV2.count;
    }

    public boolean isTheBiggerTotalValueOne(LittleSuperMarket littleSuperMarket) {
        double totalValue = count * purchasePrice;
        for (int i = 0; i < littleSuperMarket.merchandises.length; i++) {
            MerchandiseV2 m = littleSuperMarket.merchandises[i];
            double newTotalValue = m.count * m.purchasePrice;
            if (totalValue < newTotalValue) {
                return false;
            }
        }
        return true;
    }

    public double getCurrentCount() {
        return count;
    }

    public int getIntSolePrice() {
        return (int) soldPrice;
    }

    public boolean hasEnoughCountFor(int count) {
        return this.count >= count;
    }

    public void makeEnoughFor(int count) {
        boolean hasEnough = hasEnoughCountFor(count);
        if (!hasEnough) {
            int toBeAdd = count - this.count;
            addCount(toBeAdd);
        }
    }

    public void makeEnoughForOneByOne(int count) {
        boolean hasEnough = this.hasEnoughCountFor(count);
        if (!hasEnough) {
            this.addCount(1);
            makeEnoughForOneByOne(count);
        }
    }

    //当方法参数与成员变量重名，方法内隐藏了this自引用
    public void addCount(int count) {
        this.count += count;
        System.out.println("addCount方法的引用对象是" + this);
    }

}


