package com.geekbang.supermarket;


import javax.swing.plaf.PanelUI;

public class LittleSuperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public MerchandiseV2[] merchandises;
    public int[] merchandiseSole;

    /**
     * 初始化超市类
     *
     * @param superMarketName
     * @param address
     * @param parkingCount
     * @param mechandiseCount 商品种类数
     * @param count           每种商品缺省库存
     */
    public void init(String superMarketName, String address, int parkingCount, int mechandiseCount, int count) {
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;
        merchandises = new MerchandiseV2[mechandiseCount];
        for (int i = 0; i < merchandises.length; i++) {
            //创建并给商品属性赋值
            MerchandiseV2 m = new MerchandiseV2();
            m.count = count;
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = Math.random() * 200;
            m.madeIn = "Chian";
            merchandises[i] = m;
        }
        merchandiseSole = new int[merchandises.length];
    }

    public MerchandiseV2 getBiggestProfitMerchindise() {
        System.out.println("LittleSuperMarket的getBiggestProfitMerchandise方法使用的对象是：" + this);
        MerchandiseV2 curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            MerchandiseV2 m = merchandises[i];
            if (curr == null) {
                curr = m;
            } else {
                if (curr.calculateProfit() < m.calculateProfit()) {
                    curr = m;
                }
            }
        }
        return curr;
    }

    public String getSuperMarketName() {
        return superMarketName;
    }

    public String getAddress() {
        return address;
    }

    public int getParkingCount() {
        return parkingCount;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setParkingCount(int parkingCount) {
        this.parkingCount = parkingCount;
    }
}