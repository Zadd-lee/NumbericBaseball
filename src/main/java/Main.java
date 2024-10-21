import game.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> history = new ArrayList<>();


    public static void main(String[] args) {
        //게임 실행
        //게임 반복 실행

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("숫자 야구 게임!");
            System.out.println("게임 시작");
            System.out.println("----------");

            Game game = new Game();
            game.start();
            history.add(game.getTryCnt());



            System.out.println("----------");
            System.out.println("계속 하시겠습니까?(Y/N중 입력)");

        } while (sc.nextLine().equals("Y"));
    }
}