package com.asif_pc.brainteaser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASIF-PC on 17-07-18.
 */

public class QuizDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="BrainTeaser.db";
    private static final int DATABASE_VERSION=3;

    private SQLiteDatabase db;
    public QuizDBHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;

        final String SQL_CREATE_QUESTION_TABLE= "CREATE TABLE "+
                QuizContract.QuestionsTable.TABLE_NAME+"("+
                QuizContract.QuestionsTable._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                QuizContract.QuestionsTable.COLUMN_QUESTION+" TEXT, "+
                QuizContract.QuestionsTable.COLUMN_OPTION1+" TEXT, "+
                QuizContract.QuestionsTable.COLUMN_OPTION2+" TEXT, "+
                QuizContract.QuestionsTable.COLUMN_OPTION3+" TEXT, "+
                QuizContract.QuestionsTable.COLUMN_OPTION4+" TEXT, "+
                QuizContract.QuestionsTable.COLUMN_ANSWERE_NR+" INTEGER "+
                ")";
        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionTable();
    }

    private void fillQuestionTable() {
        Question q1=new Question("If a:b:c=3:4:7, then the ratio (a+b+c):c is equal to","2:1","14:3","7:2","1:2",1);
        addQuestion(q1);
        Question q2=new Question("If A and B are in the ratio 3:4, and B and C in the ratio 12:13, then A and C will be in the ratio","3:13","9:13","36:13","13:9",2);
        addQuestion(q2);
        Question q3=new Question("A Box has 210 coins of denominations one-rupee and fifty paise only. The ratio of their respective values is 13:11. The number of one-rupee coin is","65","66","77","78",4);
        addQuestion(q3);
        Question q4=new Question("Find the 15th term of the sequence 20, 15, 10...","-45","-55","-50","0",3);
        addQuestion(q4);
        Question q5=new Question("Find the first term of an AP whose 8th & 12th terms are respectively 39 and 59.","5","6","4","3",3);
        addQuestion(q5);
        Question q6=new Question("How many terms are there in 20, 25, 30.....140","22","25","23","24",2);
        addQuestion(q6);
        Question q7=new Question("A person sold a horse at a gain of 15%. Had he bought for 25% less and sold it for Rs. 600 less, he would have made a profit of 32%. The cost price of horse was:","Rs. 3,750","Rs. 3,250","Rs. 2,750","Rs. 2,250",1);
        addQuestion(q7);
        Question q8=new Question("By selling a bicycle for Rs. 2,850, a shopkeeper gains 14%. If the profit is reduced to 8%, then the selling price will be:","Rs. 3,750","Rs. 2,700","Rs. 3,250","Rs. 2,800",2);
        addQuestion(q8);
        Question q9=new Question("A shopkeeper earns a profit of 12% on selling a book at 10% discount on the printed price. The ratio of the cost price and the printed price of the book is :","45:56","45:51","47:56","47:51",1);
        addQuestion(q9);
        Question q10=new Question("The banker's gain of a certain sum due 2 years hence at 10% per annum is Rs. 24. The present worth is:","Rs. 480","Rs. 520","Rs. 600","Rs. 700",3);
        addQuestion(q10);
        Question q11=new Question("The greatest number of 4 digits which is divisble by 15, 25, 40 and 75 is :","9000","9500","9600","9800",3);
        addQuestion(q11);
        Question q12=new Question("The H.C.F of two numbers is 23 and the other two factors of their L.C.M. are 13 and 14. The larger if the two number is:","276","322","299","345",2);
        addQuestion(q12);
        Question q13=new Question("Find the greatest number that will divide 43, 91 and 183 so as to leave the same remainder in each case","4","7","9","13",1);
        addQuestion(q13);
        Question q14=new Question("In how many ways 4 boys and 3 girls can be seated in a row so that they are alternate.","144","288","12","256",1);
        addQuestion(q14);
        Question q15=new Question("In how many ways can 10 examination papers be arranged so that the best and the worst paper never come together?","8*9!","8*8!","7*9!","9*81",1);
        addQuestion(q15);
        Question q16=new Question("How many permutations of the letters of the word APPLE are there?","600","120","240","60",4);
        addQuestion(q16);
        Question q17=new Question("In how many ways can 8 Indians and, 4 American and $ Englishmen can be seated in a row so that all person of the same nationality sit together?","3!4!8!4!","3!8!","4!4!","8!4!4!",1);
        addQuestion(q17);
        Question q18=new Question("How many times are the hands of a clock at right angle in a day?","22","24","44","48",3);
        addQuestion(q18);
        Question q19=new Question("How many times in a day, are the hands of a clock in straight line but opposite in direction?","20","22","24","48",2);
        addQuestion(q19);
        Question q20=new Question("There are two examinations rooms A and B. If 10 students are sent from A to B, then the number of student in each room is the same.If 20 candidates are sent from B to A, then The number of students in A is double the number of students in B. The number of student in Room A is","20","80","100","200",3);
        addQuestion(q20);
        Question q21=new Question("A man has Rs. 480 in the dominations of one-rupee notes, five-rupee notes and ten-rupee notes. The number of notes of each denomination is equal. What is the total no. of notes that he has?","45","60","75","90",4);
        addQuestion(q21);
        Question q22=new Question("A hall is 15m long and 12m broad. If the sum of the areas of the floor and the ceiling is equal to the sum of the areas of the four walls, the volume of the hall is:","720","900","1200","1800",3);
        addQuestion(q22);
        Question q23=new Question("In a shower, 5 cm of rain falls. The volume of water that falls on 1.5 hectares of ground is:","75 cu.m","750 cu.m","75000 cu.m","7500 cu.m",2);
        addQuestion(q23);
        Question q24=new Question("If log27=1.431, then the value of log9 is:","0.934","0.956","0.954","0.958",3);
        addQuestion(q24);
        Question q25=new Question("The cube root of 0.000216 is:","0.6","0.06","77","0.67",2);
        addQuestion(q25);
        Question q26=new Question("Women are better teacher at primary level because","They behave more patiently with children","They are ready to work with low salary","Higher qualification is not needed in this profession","They have less chances in other profession",1);
        addQuestion(q26);
        Question q27=new Question("Environmental education should be tought in schools because","It will affect environmental pollution","It is important part of life","It will provide job to teachers","We cannot escape from environment",2);
        addQuestion(q27);
        Question q28=new Question("Most important work of teacher is","To organize teaching work","To deliver lecture in class","To take care of children","To evaluate the student",1);
        addQuestion(q28);
        Question q29=new Question("Today is monday. After 61 days, it will be:","Wednesday","Saturday","Tuesday","Thursday",2);
        addQuestion(q29);
        Question q30=new Question("What will be the day of the week 15th August,2010","Sunday","Monday","Tuesday","Friday",1);
        addQuestion(q30);
        Question q31=new Question("It was Sunday on Jan 1,2016. What was the day of the week Jan 1,2010?","Sunday","Saturday","Friday","Wednesday",3);
        addQuestion(q31);
        Question q32=new Question("A and B take part in 100m race. A runs at 5 kmph. A gives B a start of 8m and still beats him by 8sec. The speed of B is:","5.15 kmph","4.14 kmph","5.25 kmph","5.4 kmph",2);
        addQuestion(q32);
        Question q33=new Question("In a 100m race, A can give B 10m and C 28m. In the same race B can give C","18m","20m","27m","9m",2);
        addQuestion(q33);
        Question q34=new Question("What is the probability of getting a sum 9 from two throws of a dice?","1/6","1/2","1/8","1/9",4);
        addQuestion(q34);
        Question q35=new Question("A bag contains 2 red, 3 green and 2 blue balls. Two balls are drawn at random. What is the probability that none of the balls drawn is blue","10/21","11/21","2/7","5/7",1);
        addQuestion(q35);
        Question q36=new Question("In order to obtain an income of Rs. 650 from 10% stock at Rs. 96, one must take ant investment of:","3100","6240","6500","9600",2);
        addQuestion(q36);
        Question q37=new Question("The average of 1st 5 multiples of 9 is:","20","27","28","30",2);
        addQuestion(q37);
        Question q38=new Question("Find thje least number which will leaves remainder 5 when divided by 8, 12, 16 and 20.","240","265","235","245",4);
        addQuestion(q38);
        Question q39=new Question("Three numbers are in ratio 1:2:3 and HCF is 12. The number is:","12,24,36","11,22,33","13,26,39","5,10,15",1);
        addQuestion(q39);
        Question q40=new Question("A doctor gives you 3 pills telling you to take one every half hour. How many minutes will the pills last?","20","40","60","80",3);
        addQuestion(q40);
        Question q41=new Question("A farmer has 17 sheep, and all but 9 die. How many are left?","1","3","5","9",4);
        addQuestion(q41);
        Question q42=new Question("How many 2 cent stamps are there in a dozen?","1","3","9","12",4);
        addQuestion(q42);
        Question q43=new Question("If there are 3 apples and you take 2 away, how many do you have?","1","2","3","5",2);
        addQuestion(q43);
        Question q44=new Question("Devide 30 by 1/2 and add 10. What is the answer?","10","25","50","70",4);
        addQuestion(q44);
        Question q45=new Question("Some months have 31 days. How many have 28?","1","2","3","12",4);
        addQuestion(q45);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }
    private void addQuestion(Question question){
        ContentValues cv=new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWERE_NR,question.getAnswerNr());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME,null, cv);
    }
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<Question>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWERE_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
