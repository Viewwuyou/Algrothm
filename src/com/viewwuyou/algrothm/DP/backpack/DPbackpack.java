package com.viewwuyou.algrothm.DP.backpack;

import static java.lang.Math.max;

public class DPbackpack {
    private final Item[] items = new Item[4];
    private final int[][] value = new int[5][9];

    public DPbackpack() {
        initValue();
        initItem();
        backpack();
    }

    private void initItem() {
        for (int i = 0; i < 4; i++) {
            items[i] = new Item();
        }

        items[0].weight = 2;
        items[1].weight = 3;
        items[2].weight = 4;
        items[3].weight = 5;
        items[0].value = 3;
        items[1].value = 4;
        items[2].value = 5;
        items[3].value = 6;
    }

    private static class Item {
        int weight;
        int value;
    }

    // 减少一些边界条件
    private void initValue() {
        for (int i = 0; i < 9; i++) {
            value[0][i] = 0;
        }
        for (int i = 0; i < 5; i++) {
            value[i][0] = 0;
            value[i][1] = 0;
        }
    }

    private void backpack() {
        for (int i = 1; i < 5; i++) {
            for (int j = 2; j < 9; j++) {
                if (j < items[i-1].weight) {
                    value[i][j] = value[i-1][j];
                }
                else {
                    value[i][j] = max(value[i-1][j], value[i-1][j-items[i-1].weight] + items[i-1].value);
                }
            }
        }
    }

    public int getValue(int ID, int weight) {
        return value[ID][weight];
    }

    public void printTable() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(value[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        DPbackpack dPbackpack = new DPbackpack();
        dPbackpack.printTable();
        long timeStop = System.currentTimeMillis();
        System.out.println("所用时间：" + (timeStop - timeStart) + "毫秒");
    }
}
