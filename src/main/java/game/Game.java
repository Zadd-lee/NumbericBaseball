package game;

import java.util.HashMap;
import java.util.Map;

public class Game {

    public static final String STRIKE = "Strike";
    public static final String BALL = "Ball";
    public static final String OUT = "Out";
    int tryCnt;
    int[] answer;
    Map<String, Integer> score = new HashMap<>();

    public void start() {
        //값 가져오기

        //정답 생성
        answer = new Answer(3).getAnswer();
        Parser parser = new Parser();

        do {
            //입력값 받기
            int[] input = parser.getUserAnswer();
            //입력값과 정답이 같은지 확인
            clearScore();
            getScore(input);

        }while (score.get(STRIKE)==3);



    }

    private void getScore(int[] input) {
        //strike
        for (int i = 0; i < input.length; i++) {
            if (input[i] == answer[i]) {
                score.put(STRIKE, score.get(STRIKE));
            }
        }

        //ball

        //out
    }

    public int getTryCnt() {
        return tryCnt;
    }

    private void clearScore() {
        score.clear();
        score.put(STRIKE,0);
        score.put(BALL, 0);
        score.put(OUT, 0);
    }

    public Game() {
        //점수 초기화
        clearScore();
        tryCnt=1;
    }
}
