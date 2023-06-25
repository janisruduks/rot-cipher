package io.codelex.custom.encryptions;

import java.util.Scanner;

public class RotCipher {

    private static final char UPPERCASE_MAX = 'Z';
    private static final char UPPERCASE_MIN = 'A';
    private static final char LOWERCASE_MAX = 'z';
    private static final char LOWERCASE_MIN = 'a';
    private static final int ROT_CIPHER_ROTATIONS = 25;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome ROT cipher encoder and decoder");
        System.out.println("Enter text you want to encrypt or decrypt.");
        StringBuilder rotatedText = new StringBuilder();
        char[] plainTextCharArray = in.nextLine().toCharArray();

        for (int i = 0; i <= ROT_CIPHER_ROTATIONS; i++) {
            for (char letter : plainTextCharArray) {
                if (Character.isUpperCase(letter)) {
                    letter = rotate(letter, i, UPPERCASE_MAX, UPPERCASE_MIN);
                } else if (Character.isLowerCase(letter)) {
                    letter = rotate(letter, i, LOWERCASE_MAX, LOWERCASE_MIN);
                }
                rotatedText.append(letter);
            }
            System.out.println("ROT" + i + ": " + rotatedText);
            rotatedText = new StringBuilder();
        }
    }

    private static char rotate(char letter, int shift, char max, char min) {
        letter += shift;
        if (letter > max) {
            letter = (char) (min + (letter - max - 1));
        }
        return letter;
    }
}
