import assignment.Score;
import assignment.Student;
import assignment.Subject;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    //패키지 내 클래스를 import하여 객체를 선언
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> scoreStore;

    //과목 타입 생성(필수, 선택)
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    //index관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    //스캐너 생성
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setInitData();
        try{
            displayMainview();
        }catch (Exception e){
            System.out.println("\n 오류 발생! \n 프로그램을 종료합니다.");
        }
    }


    //초기 과목 데이터 설정
    private static void setInitData(){
        studentStore = new ArrayList<>();  //학생
        scoreStore = new ArrayList<>();    //점수
        subjectStore = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence (INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        SUBJECT_TYPE_CHOICE
                )
        );
    }

    //Index 자동 증가 연산
    private static String sequence(String type){
        switch (type){
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }
    //메인 뷰
    private static void displayMainview() throws InterruptedException {
        boolean flag = true;
        while(flag){
            System.out.println("\n==========================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중....");
            System.out.println("1. 수강생관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요");
            int input = Integer.parseInt(sc.nextLine());

            switch(input){
                case 1 -> displayStudentView(); //수강생 관리
                case 2 -> displayScoreview();//점수 관리
                case 3 -> flag = false; //프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
    private static void displayStudentView() throws InterruptedException {
        boolean flag = true;
        while(flag) {
            System.out.println("======================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 메인 화면 이동");
            System.out.println("관리 항목을 선택하세요....");
            int input = Integer.parseInt(sc.nextLine());

            switch (input) {
                case 1 -> createStudent();
                case 2 -> inquireStudet();
                case 3-> displayMainview();
                default -> {
                    System.out.println("잘못 입력하였습니다.\n 메인화면 으로 이동합니다.");
                    flag = false;
                }
            }
        }
    }
    private static void displayScoreview() throws InterruptedException {
    boolean flag = true;
    while(true){
        System.out.println("=====================");
        System.out.println("수강생 관리 실행 중....");
        System.out.println("1. 수강생 등록");
        System.out.println("2. 수강생 목록 조회");
        System.out.println("3. 메인 화면 이동");
        System.out.print("관리 항목을 선택하세요..");
        int input = Integer.parseInt(sc.nextLine());

        switch (input) {
            case 1 -> createStudent(); //수강생 등록
            case 2 -> inquireStudet(); //수강생 목록 조회
            case 3 -> displayMainview(); //메인화면 이동
            default -> {
                System.out.println("잘못된 입력입니다.\n 메인화면 이동....");
                displayMainview();
            }
        }
    }
    }

    //수강생 등록
    private static void createStudent(){
        System.out.println("\n수강생을 등록합니다..");
        System.out.print("수강생 이름 입력 : ");
        String studentName = sc.nextLine();

        //기능 구현 (필수과목, 선택과목 선택하기)
        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName); // 수강생 인스턴스 생성 예시 코드

        int mandatoryCount = 0;
        int choiceCount = 0;

        System.out.println("3개 이상의 필수과목, 2개 이상의 선택과목을 선택해주세요.");

        while((mandatoryCount < 3) || (choiceCount < 2)) {

            System.out.println("목록 " + "(필수과목 : " + mandatoryCount + " , "+ "선택과목 : " + choiceCount + ")");

            for(int i = 0; i < subjectStore.size(); i++) {
                String subjectName = subjectStore.get(i).getSubjectName();
                String subjectType = subjectStore.get(i).getSubjectType();
                System.out.println(i + " : " + subjectName + " (" + subjectType + ")");
            }

            System.out.print("선택하세요 : ");
            int input = Integer.parseInt(sc.nextLine());

            String subjectType = subjectStore.get(input).getSubjectType();

            if(subjectType.equals(SUBJECT_TYPE_MANDATORY)){
                mandatoryCount++;
            }
            else if(subjectType.equals(SUBJECT_TYPE_CHOICE)){
                choiceCount++;
            }

            student.setSubjectList(subjectStore.get(input));
        }

        studentStore.add(student);
        System.out.println("수강생 등록 성공!\n");
    }

    //수강생 목록 조회
    private static void inquireStudet() {
        System.out.println("\n 수강생 목록을 조회합니다...\n");
        //기능구현
        for(Student student : studentStore) {
            System.out.println("고유번호 : " + student.getStudentId());
            System.out.println("이름 : " + student.getStudentName());
        }
        System.out.println("수강생 목록 조회 성공!");
    }

    private static void displayScoreView() throws InterruptedException {
        boolean flag = true;
        while(flag) {
            System.out.println("======================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.println("관리 항목을 선택하세요....");
            int input = Integer.parseInt(sc.nextLine());

            switch(input){
                case 1 -> createScore(); // 수강생의 과목별 시험회차 및 점수등록
                case 2 -> updateRoundeScoreBySubject(); //수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다. \n 메인 화면으로 이동합니다");
                    flag = false;
                }
            }
        }
    }

    private static String getStudentId() {
        System.out.println("\n 관리할 수강생의 번호를 입력하시오..");
        return sc.nextLine();
    }
    private static Student getStudent(String studentId){
        Student studentData = null;

        for(Student student : studentStore){
            if(studentData.getStudentId().equals(studentId)){
                studentData = student;
            }
        }
        return studentData;
    }
    //수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore(){
        String studentId = getStudentId();
        System.out.println("시험 점수를 등록합니다..");

        //기능 구현
        Student student = getStudent(studentId);

        System.out.println("입력하고자 하는 과목을 선택해주세요.");
        for(int i = 0; i<student.getSubjectList().size(); i++){
            System.out.println(i+ "." + student.getSubjectList().get(i).getSubjectName());
        }
        System.out.println("입력 : ");
        int subjectChoice = Integer.parseInt(sc.nextLine());

        Subject subject = student.getSubjectList().get(subjectChoice);

        //Todo : 이미 등록,회차, 점수에따른 처리 해줘야한다.
        System.out.println("회차를 입력해주세요 (1~10) : ");
        int round = Integer.parseInt(sc.nextLine());
        if(round < 1 || round > 10){
            System.out.println("유효하지 않은 회차 입니다. 1부터 10까지의 숫자를 입력해주세요");
            return; // 함수가 종료된다.
        }
        System.out.println("점수를 입력해주세요 (0 ~ 100) :");
        int point =Integer.parseInt(sc.nextLine());
        if(point < 0 || point > 100){
            System.out.println("유효하지 않은 점수입니다. 0부터 100까지의 숫자를 입력해주세요");
            return; //함수는 종료된다.
        }
        Score score = null;

        boolean scoreAlreadyExists =false;

        for(Score element : scoreStore){
            if(element.getStudentId().equals(subject.getSubjectId()) && element.getStudentId().equals(student.getStudentId())){
                if(element.getRoundGrade().containsKey(round)){
                    System.out.println("이미 점수가 등록되어 있는 과목입니다.");
                    scoreAlreadyExists = true;
                    break;
                }else {
                    element.setRoundGrade(subject.getSubjectType(), round, point);
                    scoreAlreadyExists = true;
                    break;
                }
            }
        }
        if(!scoreAlreadyExists){
            score = new Score(sequence(INDEX_TYPE_SCORE), studentId, subject.getSubjectId());
            score.setRoundGrade(subject.getSubjectType(), round, point);
            scoreStore.add(score);
        }

        System.out.println("\n 점수 등록 성공!");
    }

    //수강생의 과목별 회차 점수 수정
    private static void updateRoundeScoreBySubject(){
        String studentId = getStudentId(); //관리할 수강생 고유번호
        Student student = getStudent(studentId);

        //기능 구현(수정할 과목 및 회차 ,점수)
        System.out.println("시험 점수를 수정합니다...");
        System.out.println("수정을 원하는 과목을 선택하세요\n");

        for(int i = 0; i<student.getSubjectList().size(); i++){
            System.out.println(i + "." + student.getSubjectList().get(i).getSubjectName());
        }
        System.out.println("입력 : ");
        int subjectChoice = Integer.parseInt(sc.nextLine());

        Subject subject = student.getSubjectList().get(subjectChoice);
        String subjectId = subject.getSubjectId();

        Score score = null;

        for(Score element : scoreStore) {
            if(element.getStudentId().equals(studentId) && element.getStudentId().equals(subjectId)){
                score = element;
            }
        }

        if(score == null){
            System.out.println("수정하고자 하는 과목의 점수가 존재하지 않습니다.");
            return;
        }
        else{
            System.out.println("회차를 입력해주세요 (1~10) : ");
            int round = Integer.parseInt(sc.nextLine());
            if (round < 1 || round > 10) {
                System.out.println("유효하지 않은 회차입니다. 1부터 10까지의 숫자를 입력해주세요.");
                return;
            }

            System.out.println("점수를 입력해주세요 (0 ~100) :");
            int point = Integer.parseInt(sc.nextLine());
            if(point < 0 || point > 100){
                System.out.println("유효하지 않은 점수입니다. 0부터 100까지의 숫자를 입력해주세요.");
                return;
            }

            score.setRoundGrade(subject.getSubjectType(), round, point);
        }
        System.out.println("\n 점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        String studentId = getStudentId(); //관리할 수강생 고유번호
        Student student = getStudent(studentId);


        //기능 구현(조회할 특정 과목)
        System.out.println("회차별 등급을 조회합니다..");
        System.out.println("조회할 과목을 선택하세요.");

        for (int i = 0; i < student.getSubjectList().size(); i++) {
            System.out.println(i + "." + student.getSubjectList().get(i).getSubjectName());
        }
        System.out.println("입력 : ");
        int subjectchoice = Integer.parseInt(sc.nextLine());

        Subject subject = student.getSubjectList().get(subjectchoice);
        String subjectId = subject.getSubjectId();
        Score score = null;

        for (Score element : scoreStore) {
            if (element.getStudentId().equals(studentId) && element.getStudentId().equals(subjectId)) {
                score = element;
            }
        }
        if (score == null) {
            System.out.println("해당 과목의 점수가 존재하지 않는다.");
            return;
        } else {
            HashMap<Integer, Integer> roundGrade = score.getRoundGrade();
            System.out.println("과목명 : " + subject.getSubjectName());
            for (int key : roundGrade.keySet()) {
                System.out.println("회차 : " + key);
                System.out.println("등급 : " + score.calculateGrade(subject.getSubjectName(), roundGrade.get(key)));
            }
        }
        System.out.println("\n등급 조회 성공!");
    }

    }



