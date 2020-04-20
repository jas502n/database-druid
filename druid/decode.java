package com.druid;

import com.alibaba.druid.filter.config.ConfigTools;

import java.util.Scanner;


public class decode {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Set publicKey: ");
            String publicKey = sc.nextLine();

            System.out.print("Set password: ");
            String password = sc.nextLine();

            System.out.println("解密明文密码: " + ConfigTools.decrypt(publicKey, password) + "\n");


        }


    }
}
