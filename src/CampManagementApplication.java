import model.Score;
import model.Student;
import model.Subject;

import java.util.*;

/**
 * Notification * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.  
 * main 메서드를 실행하면 프로그램이 실행됩니다.  
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!  
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!  
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!  
 */
public class CampManagementApplication {
    // 데이터 저장소  
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> scoreStore;

    // 과목 타입  
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드  
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너  
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        setInitData();
        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }
    }

    // 초기 데이터 생성  
    private static void setInitData() {
        studentStore = new ArrayList<>();
        scoreStore = new ArrayList<>();
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
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_MANDATORY
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

    // index 자동 증가  
    private static String sequence(String type) {
        switch (type) {
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

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = Integer.parseInt(sc.nextLine());

            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리  
                case 2 -> displayScoreView(); // 점수 관리  
                case 3 -> flag = false; // 프로그램 종료  
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 정보 수정");
            System.out.println("3. 수강생 정보 삭제");
            System.out.println("4. 수강생 목록 조회");
            System.out.println("5. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = Integer.parseInt(sc.nextLine());

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록  
                case 2 -> {
                    try {
                        updateStudent(); // 수강생 정보 수정
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        deleteStudent(); // 수강생 정보 수정
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        inquireStudent(); // 수강생 목록 조회
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생 등록  
    private static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();

        // 수강생 상태 입력
        System.out.println("상태 종류 ( 1: Green(좋음)  2: Yellow(보통)  3: Red(나쁨) )");
        System.out.print("수강생 상태 입력: ");
        int num = sc.nextInt();
        sc.nextLine(); // 버퍼 내 개행 제거
        String studentStatus = null;
        switch (num) {
            case 1 -> studentStatus = "Green";
            case 2 -> studentStatus = "Yellow";
            case 3 -> studentStatus = "Red";
            default -> System.out.println("올바른 번호를 입력하세요...");
        }

        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName, studentStatus); // 수강생 인스턴스 생성 예시 코드

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

            System.out.print("\n선택하세요 : ");
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
        System.out.println("\n수강생 등록 성공!");
    }

    // 수강생 정보 수정
    private static void updateStudent() throws IllegalArgumentException{
        System.out.println("\n수강생 정보를 수정합니다...\n");
        System.out.print("수정할 수강생 번호를 입력: ");
        String studentId = sc.next();
        sc.nextLine(); // 버퍼 내 개행 제거

        // 입력받은 번호를 갖는 수강생 존재 여부 판별
        if (Objects.equals(inquireStudentIndexById(studentId), -1)) { throw new IllegalArgumentException(studentId + "를 번호로 갖는 수강생이 존재하지 않습니다..."); }

        // 고유 번호, 이름 중 수정할 정보 선택
        System.out.println("정보 (1: 이름 수정,  2: 상태 수정)");
        System.out.print("수정할 정보 입력: ");

        // 정보 수정
        switch (sc.nextInt()) {
            case 1 -> {
                // 이름 수정
                System.out.print("수정할 이름 입력: ");
                studentStore.get(inquireStudentIndexById(studentId)).setStudentName(sc.next());
            }
            case 2 -> {
                // 상태 수정
                System.out.print("수정할 상태 입력: ");
                studentStore.get(inquireStudentIndexById(studentId)).setStudentStatus(sc.next());
            }
            default -> throw new IllegalArgumentException("올바른 번호를 입력하세요...");
        }
        sc.nextLine(); // 버퍼 내 개행 제거
        System.out.println("\n수강생 정보 수정 성공!");
    }

    // 수강생 목록 삭제
    private static void deleteStudent() throws IllegalArgumentException {
        System.out.println("\n수강생 정보를 삭제합니다...\n");
        System.out.print("삭제할 수강생 번호를 입력: ");
        String studentId = sc.next();
        int studentIndex = inquireStudentIndexById(studentId);
        sc.nextLine(); // 버퍼 내 개행 제거

        // 입력받은 번호를 갖는 수강생 존재 여부 판별
        if (Objects.equals(studentIndex, -1)) { throw new IllegalArgumentException(studentId + "를 번호로 갖는 수강생이 존재하지 않습니다..."); }

        // 입력받은 번호를 갖는 수강생 정보 삭제
        studentStore.remove(studentIndex);  // 수강생 리스트에서 삭제
        scoreStore.removeIf(score -> Objects.equals(score.getStudentId(), studentId));  // 점수 리스트에서 삭제

        System.out.println("수강생 정보 삭제 성공!");
    }

    // 수강생 목록 조회  
    private static void inquireStudent() throws IllegalArgumentException {
        System.out.println("\n수강생 목록을 조회합니다...\n");

        // 조회 방법 선택
        System.out.println("방법 (1: 모두 조회,  2: 'Green' 상태 조회,  3: 'Yellow' 상태 조회,  2: 'Red' 상태 조회)");
        System.out.print("수정할 정보 입력: ");

        // 조건에 따라 수강생 목록 조회
        switch (sc.nextInt()) {
            case 1 -> { printStudentByStatus("All"); }      // 모든 수강생 정보 조회
            case 2 -> { printStudentByStatus("Green"); }    // 'Green' 상태 수강생 조회
            case 3 -> { printStudentByStatus("Yellow"); }   // 'Yellow' 상태 수강생 조회
            case 4 -> { printStudentByStatus("Red"); }      // 'Red' 상태 수강생 조회
            default -> throw new IllegalArgumentException("올바른 번호를 입력하세요...");
        }

        sc.nextLine(); // 버퍼 내 개행 제거
        System.out.println("수강생 목록 조회 성공!");
    }

    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = Integer.parseInt(sc.nextLine());

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록  
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정  
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회  
                case 4 -> flag = false; // 메인 화면 이동  
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.nextLine();
    }

    private static Student getStudent(String studentId){
        Student studentData = null;

        for(Student student : studentStore) {
            if(student.getStudentId().equals(studentId)){
                studentData = student;
            }
        }

        return studentData;
    }

    // 수강생의 과목별 시험 회차 및 점수 등록  
    private static void createScore() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호  
        System.out.println("시험 점수를 등록합니다...");

        // 기능 구현  
        Student student = getStudent(studentId);

        System.out.println("입력하고자 하는 과목을 선택해주세요.");
        for(int i = 0; i < student.getSubjectList().size(); i++){
            System.out.println(i + ". " + student.getSubjectList().get(i).getSubjectName());
        }
        System.out.print("입력 : ");
        int subjectChoice = Integer.parseInt(sc.nextLine());

        Subject subject = student.getSubjectList().get(subjectChoice);

        // TODO : 이미 등록, 회차, 점수에 따른 처리 해줘야함  
        System.out.print("회차를 입력해주세요 (1 ~ 10) : ");
        int round = Integer.parseInt(sc.nextLine());
        if (round < 1 || round > 10) {
            System.out.println("유효하지 않은 회차입니다. 1부터 10까지의 숫자를 입력해주세요.");
            return; // 함수 종료  
        }

        System.out.print("점수를 입력해주세요 (0 ~ 100 ) : ");
        int point = Integer.parseInt(sc.nextLine());
        if (point < 0 || point > 100) {
            System.out.println("유효하지 않은 점수입니다. 0부터 100까지의 숫자를 입력해주세요.");
            return; // 함수 종료
        }

        Score score = null;

        boolean scoreAlreadyExists = false;

        for (Score element : scoreStore) {
            if (element.getSubjectId().equals(subject.getSubjectId()) && element.getStudentId().equals(student.getStudentId())) {
                if (element.getRoundGrade().containsKey(round)) {
                    System.out.println("이미 점수가 등록되어 있는 과목입니다.");
                    scoreAlreadyExists = true;
                    break;
                } else {
                    element.setRoundGrade(subject.getSubjectType(), round, point);
                    scoreAlreadyExists = true;
                    break;
                }
            }
        }

        if (!scoreAlreadyExists) {
            score = new Score(sequence(INDEX_TYPE_SCORE), studentId, subject.getSubjectId());
            score.setRoundGrade(subject.getSubjectType(), round, point);
            scoreStore.add(score);
        }

        System.out.println("\n점수 등록 성공!");
    }

    // 수강생의 과목별 회차 점수 수정  
    private static void updateRoundScoreBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호  
        Student student = getStudent(studentId);

        // 기능 구현 (수정할 과목 및 회차, 점수)  
        System.out.println("시험 점수를 수정합니다...");
        System.out.println("수정을 원하는 과목을 선택하세요.\n");

        for(int i = 0; i < student.getSubjectList().size(); i++){
            System.out.println(i + ". " + student.getSubjectList().get(i).getSubjectName());
        }
        System.out.print("입력 : ");
        int subjectChoice = Integer.parseInt(sc.nextLine());

        Subject subject = student.getSubjectList().get(subjectChoice);
        String subjectId = subject.getSubjectId();
        Score score = null;

        for(Score element : scoreStore) {
            if(element.getSubjectId().equals(subjectId) && element.getStudentId().equals(studentId)){
                score = element;
            }
        }

        if(score == null){
            System.out.println("수정하고자 하는 과목의 점수가 존재하지 않습니다.");
            return;
        }
        else{
            System.out.print("회차를 입력해주세요 (1 ~ 10) : ");
            int round = Integer.parseInt(sc.nextLine());
            if (round < 1 || round > 10) {
                System.out.println("유효하지 않은 회차입니다. 1부터 10까지의 숫자를 입력해주세요.");
                return;
            }

            System.out.print("점수를 입력해주세요 (0 ~ 100 ) : ");
            int point = Integer.parseInt(sc.nextLine());
            if (point < 0 || point > 100) {
                System.out.println("유효하지 않은 점수입니다. 0부터 100까지의 숫자를 입력해주세요.");
                return;
            }

            score.setRoundGrade(subject.getSubjectType(), round, point);
        }

        // 기능 구현  
        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회  
    private static void inquireRoundGradeBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호  
        Student student = getStudent(studentId);

        // 기능 구현 (조회할 특정 과목)  
        System.out.println("회차별 등급을 조회합니다...");
        System.out.println("조회할 과목을 선택하세요.");
        for(int i = 0; i < student.getSubjectList().size(); i++){
            System.out.println(i + ". " + student.getSubjectList().get(i).getSubjectName());
        }
        System.out.print("입력 : ");
        int subjectChoice = Integer.parseInt(sc.nextLine());

        Subject subject = student.getSubjectList().get(subjectChoice);
        String subjectId = subject.getSubjectId();
        Score score = null;

        for(Score element : scoreStore) {
            if(element.getSubjectId().equals(subjectId) && element.getStudentId().equals(studentId)){
                score = element;
            }
        }

        if(score == null){
            System.out.println("해당 과목의 점수가 존재하지 않습니다.");
            return;
        }
        else{
            HashMap<Integer, Integer> roundGrade = score.getRoundGrade();
            System.out.println("과목명 : " + subject.getSubjectName());
            for(int key : roundGrade.keySet()){
                System.out.println("회차 : " + key);
                System.out.println("등급 : " + score.calculateGrade(subject.getSubjectType(), roundGrade.get(key)));
            }

        }


        // 기능 구현  
        System.out.println("\n등급 조회 성공!");
    }

    // 고유번호로 수강생 인스턴스 검색
    public static int inquireStudentIndexById(String studentId) {
        for (int i = 0; i < studentStore.size(); i++) { if (Objects.equals(studentStore.get(i).getStudentId(), studentId)) { return i; } }
        return -1;
    }

    // 수강생 정보 출력
    public static void printStudentByStatus(String status) {
        for(Student student : studentStore) {
            if (Objects.equals(student.getStudentStatus(), status) || Objects.equals(status, "All")) {
                System.out.println("고유번호 : " + student.getStudentId());
                System.out.println("이름 : " + student.getStudentName());
                System.out.println("상태 : " + student.getStudentStatus());
                System.out.print("수강 과목목록 : ");
                for (Subject value : student.getSubjectList()) { System.out.print(value.getSubjectName() + " "); }
                System.out.println("\n");
            }
        }
    }
}