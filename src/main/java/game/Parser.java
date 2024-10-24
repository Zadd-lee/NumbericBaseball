package game;

import java.util.*;
import java.util.stream.Collectors;

public class Parser  {
    Scanner sc;

    public Parser() {
        sc = new Scanner(System.in);
    }

    public List<Integer> getUserAnswer(int n) {

        List<Integer> result = new ArrayList<>();

        do {
            try {
                System.out.println(n + "자리수의 값을 입력해주세요");

                String inputString = sc.nextLine();

                result = Arrays.stream(inputString.split(""))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());

                //입력값이 자리수와 다른 경우
                if (inputString.length() != n) {
                    throw new ArrayIndexOutOfBoundsException();
                }

                //중복 값이 없는지 확인
                if (result.size() != result.stream().distinct().collect(Collectors.toList()).size()) {
                    throw new Exception("중복된 숫자는 허용되지 않습니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자값을 입력해주세요");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("잘못된 값입니다 " + n + "자리수를 입력해주세요");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!result.isEmpty());

        return result;
    }

    public int getDigits() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자리수를 입력해주세요");
        String digits="";
        do {
            try {
                digits = sc.nextLine();
                if (!digits.matches("^[3-5]{1}")) {
                    throw new Exception("자리수는 3~5 사이에서 선택 가능합니다 다시 입력해주세요");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자값을 입력해주세요");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!digits.matches("^[3-5]{1}"));

        System.out.println(digits+" 자리수로 설정되었습니다");

        return Integer.parseInt(digits);
    }

    public String getCommand() {
        String command = "";

        do {

            try {
                command = sc.nextLine();
                 if (!command.matches("^[0-3]{1}")) {
                    throw new Exception("올바른 숫자를 입력해주세요");
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자값을 입력해주세요");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (!command.matches("^[0-3]{1}"));
        return command;
    }
}
