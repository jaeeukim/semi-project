package semi_pro;

import java.util.Scanner;

public class DesireView {
	Scanner sc = new Scanner(System.in);
	private Menu menu = new Menu();
	private DesireVO dv = new DesireVO();
	private DesireDAO dao = new DesireDAO();
	private DesireController dc = new DesireController();
	
	public void show() {
		while(true) {
			menu.getMenu();
			
			System.out.print(" >>>  ");
			String input = sc.nextLine();

			switch(input) {
				case "1":
					// 목록보기
					this.look_list();
					break;
				case "2":
					// 수정프로그램실행
					this.modify_menu();
					break;
				case "3":
					// 프로그램 종료
					System.exit(0);
				default :
					System.out.println("잘못된 번호 입력.");	
			}		
		}		
	}
	
	// 목록보기 실행
	private void look_list() {
		System.out.println("어떤 아이템의 정보를 확인하시겠습니까?");
		System.out.print("물건 명 입력 : ");
		String str = sc.nextLine();
		
		DesireVO data = dao.get(str);
		System.out.println("물건 이름    : " + data.getProd_name());
		System.out.println("물건 타입    : " + data.getProd_type());
		System.out.println("물건 가격    : " + data.getProd_price());
		System.out.println("필요 이유    : " + data.getReason());
		System.out.println("예상사용빈도  : " + data.getExp_use());
		System.out.println("구매욕구(%)  : " + data.getDes_percentage());
		
		System.out.println("===================================");
		System.out.println("\n\n\n");
	}
	
	
	// 수정프로그램 실행
	private void modify_menu() {
		DesireVO data = new DesireVO();
				
		while(true) {
			menu.getMenu_modify();
			System.out.print(" >>>  ");
			String input = sc.nextLine();
			
			switch(input) {
				case "1":
					// 추가메뉴
					this.add_list();
					break;
				case "2":
					// 수정메뉴
					//this.modify_prod();
					break;
				case "3":
					// 삭제메뉴
					this.delete_list();
					break;
				case "4":
					// 프로그램제거
					System.exit(0);
				default :
					System.out.println("잘못된 번호 입력.");	
			}		
		}		
		
	}


	private void add_list() {
		DesireVO data = new DesireVO(); 
		System.out.print("갖고싶은 물건 : ");
		data.setProd_name(sc.nextLine());
		System.out.print("물건의 종류 : ");
		data.setProd_type(sc.nextLine());
		System.out.print("물건의 가격 : ");
		data.setProd_price(sc.nextLine());
		System.out.print("필요한 이유 : ");
		data.setReason(sc.nextLine());
		System.out.print("예상사용빈도(상/중/하) : ");	
		data.setExp_use(sc.nextLine());
		System.out.print("구매욕구(0 ~ 100 숫자입력) : ");	
		data.setDes_percentage(sc.nextLine());
		
		boolean result = dc.add_check(data);
		
		if(result) {
			System.out.println("목록에 추가되었습니다.");
		} else {
			System.out.println("목록 추가에 실패했습니다.");
		}
		
		
	}

	
	
	
	private void delete_list() {
		System.out.println("어떤 물건의 정보를 지우시겠습니까?");
		System.out.print("물건의 이름 : ");
		String find_name = sc.nextLine();
		DesireVO data = dao.get(find_name);
	
		if(dc.delete_prod(data)) {
			System.out.println("삭제 처리가 완료되었습니다.");
		} else {
			System.out.println("삭제를 수행할 수 없습니다.");
		}
	}
	
	
	
}
