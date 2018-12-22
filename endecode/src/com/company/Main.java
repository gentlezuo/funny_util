package com.company;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Code code = new Code();
        // System.out.println("编码请输入：en，解码请输入：de");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("编码请输入：en，解码请输入：de");
            switch (scanner.next()) {
                case "en":
                    System.out.println("请输入待编码的内容");
                    String res = code.enCode(code.toUTF8ToIndex(scanner.next()));
                    System.out.println(res);
                    break;
                case "de":
                    try {
                        System.out.println("请输入待解码的内容");
                        String old = code.decode(scanner.next());
                        System.out.println(old);
                    } catch (Exception e) {
                        System.out.println("输入不符合编码规则");
                    }
                    break;
                default:
                    //System.out.println("编码请输入：en，解码请输入：de");
                    break;
            }
        }
    }
}
