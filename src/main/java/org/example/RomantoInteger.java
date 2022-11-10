package org.example;

public class RomantoInteger {
    public int romanToInt(String s) {

        int num = 0;
        int prev = 0;
        int cur = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    cur = 1000;
                    break;
                case 'D':
                    cur = 500;
                    break;
                case 'C':
                    cur = 100;
                    break;
                case 'L':
                    cur = 50;
                    break;
                case 'X':
                    cur = 10;
                    break;
                case 'V':
                    cur = 5;
                    break;
                case 'I':
                    cur = 1;
                    break;
            }
            if (prev < cur) {
                num -= 2 * prev;
            }
            num += cur;
            prev = cur;
        }
        return num;
    }
}
