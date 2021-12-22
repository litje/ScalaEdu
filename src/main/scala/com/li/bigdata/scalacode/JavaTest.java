package com.li.bigdata.scalacode;

/**
 * @author litianjie
 * @time 2021-12-03 17:40
 */
public class JavaTest {
    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i*j) + "\t");
            }
            System.out.println();
        }
    }
}
