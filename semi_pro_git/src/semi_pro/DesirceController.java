package semi_pro;

import java.util.Scanner;

// 중간 제어용 객체
public class DesirceController {
	Scanner sc = new Scanner(System.in);
	private DesireDAO dao = new DesireDAO();
	private DeConn dc;
	
	// 추가용
//	public boolean join(DesireVO data) {
//		DesireVO check = dao.get(data.getProd_name());
//		
//		boolean result = dao.add_prod(data);
//		return result;
//	}
}
