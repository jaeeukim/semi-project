package semi_pro;

import java.util.Scanner;

public class DesireView {
	Scanner sc = new Scanner(System.in);
	private Menu menu = new Menu();
	private DesireVO dv = new DesireVO();
	private DesireDAO dd = new DesireDAO();

	public void show() {
		while(true) {
			menu.getMenu();
			
			System.out.print(" >>>  ");
			String input = sc.nextLine();

			switch(input) {
				case "1":
					//목록보기
					break;
				case "2":
					this.modify_menu();
					break;
				case "3":
					System.exit(0);
				default :
					System.out.println("잘못된 번호 입력.");	
			}		
		}		
		
	
	}

	private void modify_menu() {
		menu.getMenu_modify();
		DesireVO data = new DesireVO();
				
		while(true) {
			System.out.print(" >>>  ");
			String input = sc.nextLine();
			switch(input) {
				case "1":
					dd.add_prod(data);
					break;
				case "2":
					//this.modify_prod();
					break;
				case "3":
					//this.delete_prod();
					break;
				case "4":
					System.exit(0);
				default :
					System.out.println("잘못된 번호 입력.");	
			}		
		}		
		
	}

	
	
	
	
	
	
	
}
