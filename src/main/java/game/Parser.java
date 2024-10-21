package game;

import java.util.*;
import java.util.stream.Collectors;

public class Parser  {
    public List<Integer> getUserAnswer(int n) {

        Scanner sc = new Scanner(System.in);
        List<Integer> input;

        while(true) {
            try {
                System.out.println(n+"자릿수의 값을 입력해주세요");

                String inputInt = sc.nextLine();

                if (inputInt.length() != n) {
                    throw new ArrayIndexOutOfBoundsException();
                }

                //todo 문자 작성 안됨
                //todo 중복된 값 가져올 수 없음
                //todo 이 부분 좀 깔끔하게 하는 방법 찾기
                input = Arrays.stream(inputInt.split(""))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());

                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 값입니다. 숫자값을 입력해주세요");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("잘못된 값입니다 "+ n+"자릿수를 입력해주세요");
            } catch (Exception e) {

            }
        }

        return input;
    }

}
