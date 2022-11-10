package org.example;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        return getSoDoiXung(x) == x;
    }

    public int getSoDoiXung(int soBanDau) {
        int soDoiXung = 0;
        while(soBanDau > 0) {
            int i = soBanDau % 10;
            soDoiXung = soDoiXung * 10 + i;
            soBanDau /= 10;
        }
        return soDoiXung;
    }
}
