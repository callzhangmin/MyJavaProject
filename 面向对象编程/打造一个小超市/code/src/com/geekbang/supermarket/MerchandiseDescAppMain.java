package com.geekbang.supermarket;

public class MerchandiseDescAppMain {
    public static void main(String[] args) {
        MerchandiseV2 merchandiseV2 = new MerchandiseV2();
        merchandiseV2.name = "哇哈哈";
        merchandiseV2.id = "EXDF";
        merchandiseV2.purchasePrice=500;
        merchandiseV2.soldPrice=920;
        merchandiseV2.count=40;
        merchandiseV2.madeIn = "China";
        merchandiseV2.describe();
    }
}
