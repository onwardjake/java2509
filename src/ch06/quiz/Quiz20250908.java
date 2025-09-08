package ch06.quiz;

public class Quiz20250908 {
    public static void main(String[] args) {
        String name = "철수";
        int age = 16;
		double height = 175.3;
		boolean isStudent = true;
        char grade = 'A';

        System.out.println("Quiz 1.");
        printStudentInfo(name, age, height, isStudent, grade);

        System.out.println("Quiz 4.");
        mTable();
    }

    static void printStudentInfo(String name, int age, double height, boolean isStudent, char grade){
        System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + (int)height);
		System.out.println("학생여부 : " + isStudent);
		System.out.println("성적 : " + grade);
    }

    static void mTable(){
        for(int i=2; i<10; i++){
            System.out.println(i + "단");
            for(int j=1; j<10; j++){
                System.out.println(i + " * " + j + " = " + i*j);
            }
        }
    }
}

/*
 * 이정재


1.  변수 선언, 데이터 타입, 타입 캐스팅

public class Student {
	public static void main(String args[]){
		String name = “철수”;
		int age = 16;
		double height = 175.3;
		boolean isStudent = true;
		char grade = ‘A’;

		void printStudentInfo(String name, int age, double height, boolean isStudent, char grade){
			System.out.println(“이름 : “ + name);
			System.out.println(“나이 : “ + age);
			System.out.println(“키 : “ + String.toInt(height));
			System.out.println(“학생여부 : “ + isStudent);
			System.out.println(“성적 : “ + grade);
		}

		printStudentInfo(name, age, height, isStudent, grade);
	}
}


2. 연산자

int a = 10;
int b = 3;

1) 산술연산자
  a + b = 13; 덧셈
  a - b = 7; 뺄셈
  a * b = 30; 곱셈
  a / b = 3; 나눗셈.
  a % b = 1; 나머지

2) 비교연산자
  a < b : true. a가 b 미만
  a == b : false. 서로 값이 다름

3) 논리 연산자
  && : and 조건
  || : or 조건
  ! : not


3. if, switch, break


int score = 85;

if (score >= 90)
	System.out.println(“A학점 입니다.”);
else if (score >= 80)
	System.out.println(“B학점 입니다.”);
else if (score >= 70)
	System.out.println(“C학점 입니다.”);
else if (score >= 60)
	System.out.println(“D학점 입니다.”);
else
	System.out.println(“F학점 입니다.”);


삼항연산자
(score >= 60) ? strResult = “합격” : strResult = “불합격”;
System.out.println(“결과 : “ + strResult);

switch(score) {
	case 100:
	case 99:
	case 98:
	case 97:
	,,, (중략)
	case 90 :
		System.out.println(“A학점 입니다.”);
		break;
	case 89 :
	,,, (중략)
	case 80 :
		System.out.println(“B학점 입니다.”);
		break;
	,,, (중략)
	default :
		System.out.println(“F학점 입니다.”);
}



4. for

for(int i=2; i<10; i++){
	System.out.println(i + “단”);
	for(int j=1; j<10; j++){
		System.out.println(i + “ * “ + j + “ = “ + i*j);
	}
}


 */