package com.wordz.domain;

public class Score {
    private final String correct;

    private Letter result = Letter.INCORRECT ;

    public Score(String correct) {
        this.correct = correct;
    }

    public Letter letter() {
        return result;
    }

    public void assess(int position, String attempt) {
        // Si la letra es correcta, se mantiene el valor de result.
        for (int i = position; i < attempt.length(); i++) {
            if (correct.charAt(i) == attempt.
                    charAt(i)) {
                result = Letter.CORRECT;
            } else if (correct.charAt(i) != attempt.charAt(i) && (i == 4)){
               result = Letter.PART_CORRECT;
            } else {
                result = Letter.INCORRECT;
                break;
            }
        }
    }
}
