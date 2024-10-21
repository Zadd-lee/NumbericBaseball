package game;

import java.util.*;

public class Game {

    public static final String STRIKE = "Strike";
    public static final String BALL = "Ball";
    public static final String OUT = "Out";
    int tryCnt;
    List<Integer> answer;
    int digits;
    Map<String, Integer> scoreBoard = new HashMap<>();

    public void start() {

        System.out.println("숫자 야구 게임 시작!");

        //정답 생성
        answer = new Answer(digits).getAnswer();
        System.out.println(answer);
        Parser parser = new Parser();

        do {
            //입력값 받기
            List<Integer> input = parser.getUserAnswer(digits);

            //입력값과 정답이 같은지 확인
            clearScore();
            getScore(input);

            tryCnt++;

            //결과 값 출력
            System.out.println("---------------------");
            System.out.println("STRIKE :"+scoreBoard.get(STRIKE));
            System.out.println("BALL :"+scoreBoard.get(BALL));
            System.out.println("OUT :"+scoreBoard.get(OUT));
            System.out.println("---------------------");

        }while (scoreBoard.get(STRIKE)!=digits);
        System.out.println("축하합니다! 성공했습니다");
        System.out.println("정답은 "+answer.toString()+" 입니다!");
        System.out.println("이번 게임의 시도 횟수는 "+tryCnt+ "입니다.");

    }

    private void getScore(List<Integer> input) {
        //strike
        for (int i = 0; i < digits; i++) {
            if (input.get(i) == answer.get(i)) {
                scoreBoard.put(STRIKE, scoreBoard.get(STRIKE)+1);
            }
        }

        //ball
        int ballCnt =0;
        for (int i = 0; i < digits; i++) {
            if (input.contains(answer.get(i))) {
                ballCnt++;
            }

        }
        //숫자가 같은 경우 중 자릿수가 같은 경우 제외
        scoreBoard.put(BALL, ballCnt- scoreBoard.get(STRIKE));

        //out
        scoreBoard.put(OUT, digits - scoreBoard.get(STRIKE) - scoreBoard.get(BALL));
    }

    public int getTryCnt() {
        return tryCnt;
    }

    private void clearScore() {
        scoreBoard.clear();
        scoreBoard.put(STRIKE,0);
        scoreBoard.put(BALL, 0);
        scoreBoard.put(OUT, 0);
    }

    public Game(int digits) {
        //점수 초기화
        clearScore();
        this.tryCnt=0;
        this.digits = digits;

    }
}
