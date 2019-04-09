package com.company;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Code {
    private static final char[] value = {'天', '地', '玄', '黄', '宇', '宙', '洪', '荒', '日', '月', '盈', '昃', '辰', '宿', '列', '张'};
    private static final char[] fNum = {'乾', '震', '坎', '艮', '坤', '巽', '离', '兑','风'};
    private static final char[] _0_Num = {'子', '丑', '寅', '卯', '酉', '巳', '午', '未','申'};
    public List<Integer> toUTF8ToIndex(String s) throws UnsupportedEncodingException {
        List<Integer> list = new ArrayList<>();
        if (s == null) {
            return list;
        }
        byte[] byteArray1 = s.getBytes("UTF-8");
        for (byte b : byteArray1) {
            int fCount = 0;
            //char[] hex=Integer.toHexString(b).toCharArray();
            String tempstr = Integer.toHexString(b);
            int j = tempstr.length() - 1;
            char[] hex ;
            if (b<=0){
                //多余
                hex=Integer.toHexString(b).toCharArray();
            }else {
                hex=new char[8];
                for (int i = 7; i >= 0; i--) {
                    hex[i] = j >= 0 ? tempstr.charAt(j--) : '0';
                }
            }
            int i = 0;
            if (b <= 0) {
                while (hex[i] == 'f') {
                    fCount += 1;
                    ++i;
                }
                list.add(-1);
            } else {
                while (hex[i] == '0') {
                    fCount += 1;
                    ++i;
                }
                list.add(-2);
            }
            list.add(fCount);
            while (i < hex.length) {
                if (hex[i] <= '9') {
                    list.add(hex[i] - '0');
                } else {
                    list.add(hex[i] - 'a' + 10);
                }
                i += 1;
            }
        }
        return list;
    }

    public String enCode(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0, len = list.size();
        while (i < len) {
            if (list.get(i) == -1) {
                ++i;
                sb.append(fNum[list.get(i++)]);
            } else if (list.get(i) == -2) {
                ++i;
                sb.append(_0_Num[list.get(i++)]);
            } else {
                sb.append(value[list.get(i++)]);
            }
        }
        return sb.toString();
    }

    public String decode(String s) throws UnsupportedEncodingException {
        char[] hexs = new char[s.length() * 8];
        byte[] res = new byte[s.length()];
        int i = 0, k = 0, len = s.length();
        char[] sc = s.toCharArray();
        while (i < len) {
            switch (sc[i]) {
                case '乾': {
                    i += 1;
                    continue;
                }
                case '震': {
                    hexs[k++] = 'f';
                    i += 1;
                    continue;
                }
                case '坎': {
                    hexs[k++] = 'f';
                    hexs[k++] = 'f';
                    i += 1;
                    continue;
                }
                case '艮': {
                    hexs[k++] = 'f';
                    hexs[k++] = 'f';
                    hexs[k++] = 'f';
                    i += 1;
                    continue;
                }
                case '坤': {
                    for (int j = 0; j < 4; j++) {
                        hexs[k++] = 'f';
                    }
                    i += 1;
                    continue;
                }
                case '巽': {
                    for (int j = 0; j < 5; j++) {
                        hexs[k++] = 'f';
                    }
                    i += 1;
                    continue;
                }
                case '离': {
                    for (int j = 0; j < 6; j++) {
                        hexs[k++] = 'f';
                    }
                    i += 1;
                    continue;
                }
                case '兑': {
                    for (int j = 0; j < 7; j++) {
                        hexs[k++] = 'f';
                    }
                    i += 1;
                    continue;
                }
                case '风':{
                    for (int j = 0; j < 8; j++) {
                        hexs[k++] = 'f';
                    }
                    i += 1;
                    continue;
                }
                case '子': {
                    i += 1;
                    continue;
                }
                case '丑': {
                    hexs[k++] = '0';
                    i += 1;
                    continue;
                }
                case '寅': {
                    hexs[k++] = '0';
                    hexs[k++] = '0';
                    i += 1;
                    continue;
                }
                case '卯': {
                    hexs[k++] = '0';
                    hexs[k++] = '0';
                    hexs[k++] = '0';
                    i += 1;
                    continue;
                }
                case '酉': {
                    for (int j = 0; j < 4; j++) {
                        hexs[k++] = '0';
                    }
                    i += 1;
                    continue;
                }
                case '巳': {
                    for (int j = 0; j < 5; j++) {
                        hexs[k++] = '0';
                    }
                    i += 1;
                    continue;
                }
                case '午': {
                    for (int j = 0; j < 6; j++) {
                        hexs[k++] = '0';
                    }
                    i += 1;
                    continue;
                }
                case '未': {
                    for (int j = 0; j < 7; j++) {
                        hexs[k++] = '0';
                    }
                    i += 1;
                    continue;
                }
                case '申': {
                    for (int j = 0; j < 8; j++) {
                        hexs[k++] = '0';
                    }
                    i += 1;
                    continue;
                }
            }
            if (sc[i] == value[0]) {
                hexs[k++] = '0';
            } else if (sc[i] == value[1]) {
                hexs[k++] = '1';
            } else if (sc[i] == value[2]) {
                hexs[k++] = '2';
            } else if (sc[i] == value[3]) {
                hexs[k++] = '3';
            } else if (sc[i] == value[4]) {
                hexs[k++] = '4';
            } else if (sc[i] == value[5]) {
                hexs[k++] = '5';
            } else if (sc[i] == value[6]) {
                hexs[k++] = '6';
            } else if (sc[i] == value[7]) {
                hexs[k++] = '7';
            } else if (sc[i] == value[8]) {
                hexs[k++] = '8';
            } else if (sc[i] == value[9]) {
                hexs[k++] = '9';
            } else if (sc[i] == value[10]) {
                hexs[k++] = 'a';
            } else if (sc[i] == value[11]) {
                hexs[k++] = 'b';
            } else if (sc[i] == value[12]) {
                hexs[k++] = 'c';
            } else if (sc[i] == value[13]) {
                hexs[k++] = 'd';
            } else if (sc[i] == value[14]) {
                hexs[k++] = 'e';
            } else if (sc[i] == value[15]) {
                hexs[k++] = 'f';
            }
            ++i;
        }
        int size = s.length() * 8;
        k = 0;
        for (int j = 0; j < size; j += 8) {
            String hex = new String(hexs, j, 8);
            if (!hex.trim().equals("")) {
                //System.out.println(hex);
                res[k++] = new BigInteger(hex.trim(), 16).byteValue();
            }

        }
        return new String(res, "UTF-8");
    }

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
        //System.out.println(new BigInteger("61".trim(),16).byteValue());
        /*String str1 = "a";
        byte[] byteArray1 = str1.getBytes("UTF-8");
        String g = new String(byteArray1);
        for (byte b : byteArray1) {
            System.out.println(b);
            System.out.println(Integer.toHexString(b));
        }
        String res=code.enCode(code.toUTF8ToIndex(str1));
        System.out.println(res);
        String old=code.decode(res);
        System.out.println(old);*/
    }
}

