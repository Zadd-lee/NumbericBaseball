import game.Game;
import game.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> history = new ArrayList<>();


    public static void main(String[] args) {
        //게임 실행
        //게임 반복 실행

        Scanner sc = new Scanner(System.in);
        String command;
        int digits=3;
        Parser parser = new Parser();

        System.out.println("---------------------");
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        do {
            System.out.println("---------------------");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            command = parser.getCommand();


            if (command.equals("0")) {
                digits = parser.getDigits();
                startGame(digits);
            }
            if (command.equals("1")) {
                startGame(digits);
            } else if (command.equals("2")) {
                printHistory();
            } else if (command.equals("3")) {
                history.clear();
                System.out.println("< 숫자 야구 게임을 종료합니다 >");
            }


        } while (!command.equals("3"));
    }

    private static void startGame(int digit) {
        System.out.println("< 게임을 시작합니다. >");
        Game game = new Game(digit);
        game.start();
        history.add(game.getTryCnt());
    }

    private static void printHistory() {
        if (history.isEmpty()) {
            System.out.println("기록이 없습니다");
        }
        for (int i = 0; i < history.size(); i++) {
            System.out.println(i + "번째 게임: 시도 횟수 - " + history.get(i));
        }
    }
}