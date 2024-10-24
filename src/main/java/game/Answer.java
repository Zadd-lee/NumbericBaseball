package game;

import java.util.*;

public class Answer {
    /**
     * 자리수에 따른 중복되지 않은 숫자 생성하는 객체
     */

    private HashSet<Integer> answer = new HashSet<>();

    public Answer(int digit) {
        //정답값 생성
        Random random = new Random();
        for (int i = 0; i < digit; i++) {
            int r = 0;
            do {
                r = random.nextInt(9);
            } while (answer.contains(r));
            answer.add(r);
        }
    }

    public List<Integer> getAnswer() {
        List<Integer> list = new ArrayList<>(answer.stream()
                .mapToInt(Integer::intValue)
                .boxed()
                .toList());

        Collections.shuffle(list);
        return list;


    }

}
