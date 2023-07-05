package unittest.ch06;

import java.util.HashMap;
import java.util.Map;

public class Profile {
    private Map<String, Answer> answers = new HashMap<>();  // 답변
    private int score;              // 점수
    private String name;            // 이름

    public Profile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Answer answer) {
        answers.put(answer.getQuestionText(), answer);
    }

    public boolean matches(Criteria criteria) {
        score = 0;

        boolean kill = false;
        boolean anyMatches = false;
//        for (Criterion criterion: criteria) {
//            // 해당 기준이 프로파일에 있는 답변과 맞는지 결정
//            Answer answer = answers.get(
//                    criterion.getAnswer().getQuestionText());
//            boolean match =
//                    criterion.getWeight() == Weight.DontCare ||
//                            answer.match(criterion.getAnswer());
//
//            if (!match && criterion.getWeight() == Weight.MustMatch) {
//                kill = true;
//            }
//            if (match) {
//                score += criterion.getWeight().getValue();
//            }
//            anyMatches |= match;
//        }
        if (kill)
            return false;
        return anyMatches;
    }

    public int score() {
        return score;
    }
}
