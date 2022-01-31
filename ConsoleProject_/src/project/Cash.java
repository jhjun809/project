package project;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Cash {

	// 스캐너
	 Scanner scan = new Scanner(System.in);
	 
	 static Behind behind = new Behind();

	// 변수 지정
	 int point = 50000; // 레드 회원에게 지원되는 포인트
	 int total = 0; // 합계
	 int price; // 영화표 가격
	 int cash; // 현금
	 int difference; // 차액
	 int pcash; // 차액
	 int dcash;

	// 레드 회원, 비회원 리스트
	 Map<String, Integer> rCashGrade = new LinkedHashMap<>();
	 Map<String, Integer> nCashGrade = new LinkedHashMap<>();

	/**
	 * 예매 페이지
	 */
	protected  void ticketing() {

		System.out.println("=====================");
		System.out.println("1. 레드 회원 예매하기");
		System.out.println("2. 비회원 예매하기");
		System.out.println();
		System.out.print("번호를 입력해주세요: ");
		try {
			int userNo = scan.nextInt();
			if (userNo == 1) {
				redGrade();
			}

			else if (userNo == 2) {
				notGrade();
			} else {
				System.out.println("안내 되지 않은 번호입니다");
				System.out.println("다시 처음으로 돌아갑니다");
				behind.category();
			}
		} catch (NullPointerException e) {
			System.out.println("오류발생");
		}

	}

	/**
	 * 비회원
	 */
	public  void notUCash() {

		nCashGrade.put("성인", 12000);
		nCashGrade.put("청소년", 9000);
		nCashGrade.put("어린이", 5000);
		nCashGrade.put("우대", 5000);

		nCashGrade.forEach((k, v) -> System.out.println(k + ", " + v));
	}

	/**
	 * 레드회원
	 */
	public  void redUCash() {

		rCashGrade.put("성인", 9000);
		rCashGrade.put("청소년", 5000);
		rCashGrade.put("어린이", 3000);
		rCashGrade.put("우대", 3000);

		rCashGrade.forEach((k, v) -> System.out.println(k + ", " + v));

	}

	/**
	 * 비회원 결제
	 */
	public  void notGrade() {
		System.out.println("=====================");
		System.out.println("========비회원========");
		notUCash();
		System.out.println("*, 레드 회원 가입하기");
		System.out.println("\n본인의 연령대를 문자로 입력해주세요");
		System.out.print("연령대 입력: ");

		String age = scan.next();

		switch (age) {
		case "성인":

			int price = nCashGrade.get("성인");
			nCheckout(price);
			break;
		case "청소년":

			price = nCashGrade.get("청소년");
			nCheckout(price);
			break;
		case "어린이":

			price = nCashGrade.get("어린이");
			nCheckout(price);
			break;
		case "우대":

			price = nCashGrade.get("우대");
			nCheckout(price);
			break;
		case "*":

			behind.joinU();
			break;
		default:
			System.out.println("=====================");
			System.out.println("잘못 입력하여 다시 예매 페이지로 돌아갑니다");
			ticketing();

		}
	}

	/**
	 * 레드 회원 결제
	 */
	public  void redGrade() {
		System.out.println("=====================");
		System.out.println("=========레드=========");
		redUCash();
		System.out.println("\n본인의 연령대를 글자로 입력해주세요");
		System.out.print("연령대 입력: ");

		String age = scan.next();

		switch (age) {
		case "성인":

			int price = rCashGrade.get("성인");
			rCheckout(price);
			break;
		case "청소년":

			price = rCashGrade.get("청소년");
			rCheckout(price);
			break;
		case "어린이":

			price = rCashGrade.get("어린이");
			rCheckout(price);
			break;
		case "우대":

			price = rCashGrade.get("우대");
			rCheckout(price);
			break;
		default:
			System.out.println("=====================");
			System.out.println("잘못 입력하여 다시 예매 페이지로 돌아갑니다");
			ticketing();

		}

	}

	/**
	 * 비회원 결제창
	 */
	public  void nCheckout(int price) {

		System.out.printf("결제하실 금액은 %d원 입니다.\n", price);
		System.out.println("결제 방법을 선택해주십시오");
		System.out.println("1 : 현금");
		System.out.println("2 : 카드");
		System.out.print("선택 -> ");

		int payment = scan.nextInt();

		switch (payment) {
		case 1:

			paymentOnCash(price);
			break;
		case 2:

			paymentOnCard(price);
			break;
		default:

			System.out.println("범위를 벗어났습니다. \n다시 시작합니다");
			behind.category();
			break;
		}
	}

	/**
	 * 레드 회원 결제창
	 */
	public  void rCheckout(int price) {

		System.out.printf("결제하실 금액은 %d원 입니다.\n", price);
		System.out.println("결제 방법을 선택해주십시오");
		System.out.println("1 : 현금");
		System.out.println("2 : 카드");
		System.out.println("3 : 포인트");
		System.out.print(" 선택 -> ");

		int payment = scan.nextInt();

		switch (payment) {
		case 1:

			paymentOnCash(price);
			break;
		case 2:

			paymentOnCard(price);
			break;
		case 3:

			paymentOnPoint(price);
			break;

		default:

			System.out.println("범위를 벗어났습니다. \n 다시 시작합니다");
			behind.category();
			break;
		}
	}

	/**
	 * 현금 결제하기
	 */
	public  void paymentOnCash(int price) {

		System.out.println("=====================");
		System.out.printf("지불하실 현금을 입력해주세요 : ");

		cash = scan.nextInt();

		if (cash >= price) {

			System.out.println("=====================");
			System.out.printf("%d원을 지불하셨습니다. 거스름돈은 %d원 입니다.\n", cash, cash - price);
			System.out.println("계산이 완료되었습니다. 안녕히 가세요.");
		} else {

			System.out.println("=====================");
			System.out.printf("%d원이 모자랍니다 \n", price - cash);
			System.out.println("처음으로 돌아갑니다");

			behind.category();
		}

	}

	/**
	 * 포인트 결제하기
	 */
	public  void paymentOnPoint(int price) {

		System.out.println("=====================");
		System.out.printf("결제 금액 : %d원 \n", price);
		System.out.printf("현재 소유하고 계신 포인트 : %d\n\n", point);

		System.out.printf("사용하실 포인트를 입력해주세요 : ");

		pcash = scan.nextInt(); // 입력한(지불한) 포인트 금액
		if (pcash > price) {
			System.out.println("=====================");
			System.out.println("포인트를 초과해서 지불하셨습니다;) ");
			System.out.println("결체창으로 다시 돌아갑니다");
			ticketing();
		} else if (pcash == price) {

			System.out.println("=====================");
			System.out.printf("%d포인트를 사용하셨습니다:) \n남은 포인트는 %d원 입니다.\n", pcash, point - pcash);
			System.out.println("즐거운 관람 되십시오;) ");
		} else {

			System.out.println("=====================");
			System.out.printf("%d원을 현금으로 더 지불하셔야 합니다 \n", pcash - price);
			System.out.print("\n현금 결제창으로 이동합니다");
			dcash = pcash - price;
			differencePayment(-dcash);
		}

	}

	/**
	 * 카드 계산
	 */
	public  void paymentOnCard(int price) {

		System.out.println("=====================");
		System.out.println("영수증을 발급하시겠나요?(y/n)");
		System.out.printf("선택 -> ");

		String isNeedRecipt = scan.next();

		switch (isNeedRecipt) {
		case "y":

			System.out.println("=====================");
			System.out.println("영수증 발급이 완료되었습니다;)");
			System.out.println("즐거운 관람 되십시오;)");
			break;
		case "n":

			System.out.println("=====================");
			System.out.println("계산이 완료되었습니다. 안녕히 가세요.");
			System.out.println("즐거운 관람 되십시오;)");
			break;
		default:

			System.out.println("=====================");
			System.out.println("범위를 벗어났습니다. 프로그램을 종료합니다.");

			System.exit(0);
			break;
		}
	}

	/**
	 * 현금 차액 지불하기
	 */
	public  void differencePayment(int dcash) {

		System.out.printf("\n지불하실 차액을 입력해주세요 : ");

		int difference = scan.nextInt();
		// 포인트와 차액을 입금하고도 계산 하지못한 금액 = 추가로 입금한 차액 - 포인트 결제때 계산하지 못한 금액
		total = difference - dcash;

		if (difference < -total) {
			System.out.println("=====================");
			System.out.println("금액이 부족하여 결제에 실패했습니다;) ");
			System.out.println("=====================");

			System.out.println("몇초뒤 다시 처음으로 돌아갑니다.");

			try {
				Thread.sleep(2000);
				behind.category();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (difference > -total) {
			System.out.printf("거스름돈은 %d원 입니다",  difference - dcash);
			System.out.println("\n즐거운 관람되십시오:) ");
		} else {

			System.out.println("=====================");
			System.out.println("프로그램이 종료되었습니다.");
		}
	}

}
