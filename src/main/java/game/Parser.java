package game;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Parser  {
    public int[] getUserAnswer(int n) {

        Scanner sc = new Scanner(System.in);
        int[] input;
        
        while(true) {
            try {
                System.out.println(n+"자릿수의 값을 입력해주세요");

                String inputInt = sc.nextLine();

                if (inputInt.length() != n) {
                    throw new ArrayIndexOutOfBoundsException();
                }

                input = Arrays.stream(inputInt.split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 값입니다. 다시 입력해주세요");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("잘못된 값입니다 "+ n+"자릿수를 입력해주세요");
            } catch (Exception e) {

            }
        }

        return input;
    }

}
