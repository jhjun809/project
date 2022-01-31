package project;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Behind {
	
	//스캐너 생성
	 Scanner scan = new Scanner(System.in);
	 
	 static Cash cash = new Cash();
	
	// id
	public String id;
	// password
	public String password;
	// point
	public int point;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 메인 카테고리
	 */
	public void category() {
		System.out.println("=====================");
		System.out.println("******|자바영화제|******");
		System.out.println("1. 영화제 일정");
		System.out.println("2. 상영작 예매하기");
		System.out.println("3. 공지 사항");
		System.out.println("4. 레드 회원 가입");

		System.out.print("\n번호를 선택 해주세요:) :");

		try {
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				date();
				break;

			case 2:
				timeTable();
				break;

			case 3:
				notice();
				break;

			case 4:
				joinU();
				break;

			case 99:
				hidden();
				break;

			default:
				System.out.println("지원하지 않는 번호입니다 ;) ");
				category();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("인식되지 못하여 종료되었습니다;) ");

		}

	}

	/**
	 * 1. 영화제 일정
	 */
	private void date() {
		System.out.println("=====================");
		System.out.println("영화제는" + "\n" + "11월 12일부터 13일까지 진행됩니다");
		System.out.println("\n \n");
		System.out.println("00. 돌아가기");

		// 예외 처리
		try {
			int enter = scan.nextInt();
			if (enter == 00) {
				category();
			} else {
				System.out.println("종료되었습니다. \\n이용해주셔서 감사합니다 :) ");
				System.exit(0);
			}
		} catch (InputMismatchException e) {
			System.out.println("종료되었습니다. \n이용해주셔서 감사합니다 :) ");
		}
	}

	/*
	 * 2. 상영작 예매하기
	 */
	public void timeTable() {

		System.out.println("=====================");
		System.out.println("[ 상영일 ]");
		System.out.println("11월 (12일/ 13일)\n\n");
		System.out.print("날짜를 입력하세요: ");

		String dday = scan.next();
		switch (dday) {
		case "12일":

			first();
			break;
		case "12":

			first();
			break;
		case "13일":

			second();
			break;
		case "13":

			second();
			break;
		default:

			System.out.println("아쉽게도 그 날은 상영일이 아닙니다. ");
			System.exit(0);
			break;
		}

	}

	/**
	 * 2. 상영작 예매하기 -> 영화 예매
	 */
	 Map<Integer, String> first = new TreeMap<>();
	 Map<Integer, String> second = new TreeMap<>();

	/**
	 * 11월 12일 날 영화
	 */
	public  void first() {

		first.put(1, "니가 지난 여름에");
		first.put(2, "건저링");
		first.put(3, "봤다(saw)");
		first.put(4, "심야 개담회");

		System.out.println("=====================");
		System.out.println("======|11월12일|======");
		first.forEach((n, t) -> System.out.println(n + "번 " + t));
		System.out.print("\n\n원하는 영화 번호를 입력해주세요=> ");

		// 글자 입력시 예외처리
		try {
			int userNo = scan.nextInt();

			if (4 >= userNo) {
				cash.ticketing();
			} else {
				System.out.println("아쉽게도 주체측에서 준비하지 못한 영화입니다.");
			}
		} catch (InputMismatchException e) {
			System.out.println();
		}
	}

	/**
	 * 11월 13일 영화
	 */
	public  void second() {

		second.put(1, "나는 니가 지난 봄에");
		second.put(2, "컨자링");
		second.put(3, "보았다(saw)");
		second.put(4, "심야 냥담회");

		System.out.println("=====================");
		System.out.println("======|11월13일|======");
		second.forEach((n, t) -> System.out.println(n + "번 " + t));

		System.out.print("\n\n원하는 영화 번호를 입력해주세요=> ");

		// 글자 입력시 예외처리
		try {
			int userNo = scan.nextInt();

			if (4 >= userNo) {
				cash.ticketing();
			} else {
				System.out.println("아쉽게도 주체측에서 준비하지 못한 영화입니다.");
			}
		} catch (InputMismatchException e) {
			System.out.println();
		}

	}

	/**
	 * 3. 공지 페이지
	 */
	private  void notice() {
		System.out.println("=====================");
		System.out.println("========<공지>========");
		System.out.println("숨겨진 페이지를 찾아보세요");

		System.out.println("\n \n");
		try {
			Thread.sleep(2000);
			System.out.println("힌트를 얻겠습니까?(y/n) ");
			String hint = scan.next();
			switch (hint) {
			case "y":
				System.out.println("메인 페이지에 아래 숫자를 입력해주세요");
				System.out.println("\n레드회원 우대 가격 \n(나누기) 1000 \n(곱하기) \"_\"번 봤다 + \"_\"번 보았다");
				System.out.println("\n \n");

				System.out.println("00. 돌아가기");

				// 예외 처리
				try {
					int back = scan.nextInt();
					if (back == 00) {
						category();
					}
				} catch (InputMismatchException e) {
					System.out.println("이용해주셔서 감사합니다 :) ");
				}
				break;
			case "n":
				System.out.println("00. 돌아가기");

				// 예외 처리
				try {
					int back = scan.nextInt();
					if (back == 00) {
						category();
					}
				} catch (InputMismatchException e) {
					System.out.println("이용해주셔서 감사합니다 :) ");
				}

				break;
			default:
				System.out.println("00. 돌아가기");

				// 예외 처리
				try {
					int back = scan.nextInt();
					if (back == 00) {
						category();
					}
				} catch (InputMismatchException e) {
					System.out.println("이용해주셔서 감사합니다 :) ");
				}

			}

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	/**
	 * 레드회원 가입하기
	 */
	public  void joinU() {
		Behind behind = new Behind();
		
		System.out.println("=====================");
		System.out.println("레드 회원 가입창입니다");

		String id = input(1);
		@SuppressWarnings("unused")
		String password = input(2);

		System.out.printf("%s님 회원 가입 완료됐습니다 \n", id);

		/**
		 * 딜레이 시키기
		 */
		try {
			Thread.sleep(500);
			System.out.printf("*%s님 반갑습니다 ;) \n", id);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(1000);
			System.out.println("*50000포인트가 지급 되었습니다");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println();
		System.out.println("00, 영화 예매 계속하기");
		System.out.println("11, 처음으로 돌아가기");

		try {
			int and = scan.nextInt();
			if (and == 00) {
				cash.redUCash();
			} else if (and == 11) {
				behind.category();
			}
		} catch (InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다 처음으로 돌아갑니다:) ");
			behind.category();
		}

	}

	private  String input(int join) {

		String result = null;

		switch (join) {
		case 1:
			while (true) {
				System.out.println("원하는 아이디를 입력해주세요");

				result = scan.nextLine();

				if (result.trim().isEmpty()) {
					System.out.println("공백 없이 적어주세요");
				} else {
					break;
				}
			}
			break;
		case 2:
			while (true) {

				System.out.println("원하시는 비밀번호를 입력해주세요!");
				result = scan.nextLine();

				System.out.println("다시 한번 더 입력해주세요");
				String passwordCheck = scan.nextLine();

				if (result.trim().isEmpty() || passwordCheck.trim().isEmpty()) {
					System.out.println("비밀번호 또는 비밀번호 확인이 공백입니다!");
				} else if (!result.equals(passwordCheck)) {
					System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다!");
				} else {
					break;
				}
			}
			break;
		case 3:
			while (true) {
				System.out.println("비밀번호를 입력하세요!");
				result = scan.nextLine();

				if (result.trim().isEmpty()) {
					System.out.println("비밀번호가 공백입니다!");
				} else {
					break;
				}
			}
			break;
		}

		return result;
	}
	

	/**
	 * 99. 이스터 에그 페이지
	 */
	public  void hidden() {

		System.out.println("=====================");
		System.out.println("숨겨진 페이지에 접속하셨습니다");
		System.out.println("=====<로든 피망>======");
		System.out.println("[당신에겐 공식적인 영화 평가 기회가 주어졌습니다]");

		System.out.println("\n \n");
		System.out.println("평가할 영화를 입력해주세요: ");
		String title = scan.next();

		System.out.printf("%s 맞습니까?(y/n)? ", title);

		String answer = scan.next();

		switch (answer) {
		case "y":
			System.out.println("=====================");
			peemang(title);

			break;
		case "n":
			System.out.println("=====================");
			System.out.println("다시 입력해주세요");
			hidden();
			break;
		default:
			category();
		}

	}

	/**
	 * 이스터 에그-영화 평론
	 */
	private  void peemang(String title) {

		System.out.println("0점에서 100점까지 줄 수 있습니다");
		System.out.println("영화를 평가해보세요 :) ");
		int score = scan.nextInt();
		String result;

		if (score < 101) {
			if (score >= 80) {
				result = "멋진";
			} else if (score > 10) {
				result = "평범한";
			} else {
				result = "썩은";
			}

			System.out.println("감사합니다 평론가님;)");
			System.out.println("당신의 평가에 도합하여");
			System.out.println("두구두구두구");

			try {
				Thread.sleep(2000);
				System.out.printf("%s는 %s 피망입니다:) ", title, result);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			System.out.println("한계치를 넘었습니다..) ");
			System.out.println("다시 처음으로 돌아갑니다 ");
			category();
		}

	}


	/**
	 * 
	 */
	protected String grade;
	protected int price;
	protected int remainingStock;
	private String cashGrade;

	public void setCashGrade(String cashGrade) {
		this.cashGrade = cashGrade;
	};

	public String getCashGrade() {
		return this.cashGrade;
	};

	public String getGrade() {
		return this.grade;
	}

	public int getPrice() {
		return this.price;
	}

	public int getRemainingStock() {
		return this.remainingStock;
	}

	public void deductRemainingStock() {
		this.remainingStock--;

	}
}
