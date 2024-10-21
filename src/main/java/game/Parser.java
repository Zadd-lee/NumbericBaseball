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

                input = Arrays.stream(inputInt.split(""))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());

                if (inputInt.length() != n) {
                    throw new ArrayIndexOutOfBoundsException();
                }


                if (input.size() != input.stream().distinct().collect(Collectors.toList()).size()) {
                    throw new Exception("중복된 숫자는 허용되지 않습니다.");
                }


                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 값입니다. 숫자값을 입력해주세요");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("잘못된 값입니다 "+ n+"자릿수를 입력해주세요");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return input;
    }

}
