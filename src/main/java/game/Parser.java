package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Parser  {
    public int[] getUserAnswer(int n) {

        Scanner sc = new Scanner(System.in);
        int[] input = new int[n];
        try {

            for (int i = 0; i >= 3; i++) {
                input[i] = sc.nextInt();
            }
        } catch (InputMismatchException e) {
            System
        }


        for (int i = 0; i < 3; i++) {
            while (true) {
                try {

                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력값입니다. 숫자를 입력");
                }
            }
        }
    }
    //받아 오는 값 체크
}
