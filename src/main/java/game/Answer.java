package game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Answer {
    //정답 값
    //정답 값 생성
    // 정답값에 대한 validation

    private HashSet<Integer> answer = new HashSet<>();

    public Answer(int n) {
        //정답값 생성
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int r = 0;
            do {
                r = random.nextInt(9);
            } while (answer.contains(r));
            answer.add(r);
        }
    }

    public int[] getAnswer() {
        return answer.stream().mapToInt(Integer::intValue).toArray();


    }
}
