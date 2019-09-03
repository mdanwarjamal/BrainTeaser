package com.asif_pc.brainteaser;

import android.provider.BaseColumns;

/**
 * Created by ASIF-PC on 17-07-18.
 */

public final class QuizContract {
    private QuizContract(){}

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME="quiz_questions";
        public static final String COLUMN_QUESTION="question";
        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_OPTION4="option4";
        public static final String COLUMN_ANSWERE_NR="answer_nr";
    }
}
