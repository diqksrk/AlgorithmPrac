import java.util.*;
import java.util.stream.IntStream;

class Solution {

    public class StudentInfo {
        int studentNumber;
        int[] studentAnswer;
        int studentScore = 0;
        int answerLength;

        public void setStudentScore(int studentScore) {
            this.studentScore = studentScore;
        }

        public StudentInfo(int studentNumber, int[] studentAnswer, int answerLength) {
            this.studentNumber = studentNumber;
            this.studentAnswer = studentAnswer;
            this.answerLength = answerLength;
        }

        public int getStudentNumber() {
            return studentNumber;
        }

        public void setStudentNumber(int studentNumber) {
            this.studentNumber = studentNumber;
        }

        public int getStudentScore() {
            return studentScore;
        }

        @Override
        public String toString() {
            return "StudentInfo{" +
                    "studentNumber=" + studentNumber +
                    ", studentAnswer=" + Arrays.toString(studentAnswer) +
                    ", studentScore=" + studentScore +
                    ", answerLength=" + answerLength +
                    '}';
        }
    }

    public int[] solution(int[] answers) {
        int[] answer = {};

        // setting init value
        StudentInfo firstStudentInfo = new StudentInfo(1, new int[]{1, 2, 3, 4, 5}, 5);
        StudentInfo secondStudentInfo = new StudentInfo(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}, 8);
        StudentInfo thirdStudentInfo = new StudentInfo(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, 10);
        
        List<StudentInfo> studentInfoList = new ArrayList<>();
        studentInfoList.add(firstStudentInfo);
        studentInfoList.add(secondStudentInfo);
        studentInfoList.add(thirdStudentInfo);
       
        // get Correct Answer Number
        IntStream.range(0, answers.length).forEach(i -> {
            studentInfoList.stream()
                    .forEach(part -> {
                        if (part.studentAnswer[i % part.answerLength] == answers[i]) {
                            part.studentScore += 1;
                        }
                    }); 
        });
        
        // get max Number
        int totalMax = studentInfoList.stream()
                .mapToInt(StudentInfo::getStudentScore)
                .max()
                .getAsInt();

        // get student that have maxed number
        answer = studentInfoList.stream()
                .filter(part -> part.getStudentScore() == totalMax)
                .mapToInt(part -> part.getStudentNumber())
                .toArray();

        return answer;
    }
}
