package semi_pro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 데이터베이스에 엑세스하기 위한 객체로 활용
public class DesireDAO {
	private DeConn dc;
	private DesireVO data;
	
//	public boolean add_prod(DesireVO data) {
//		String query = "INSERT INTO desire_t VALUES(?, ?, ?, ?, ?, ?)";
//		
//		try {
//			PreparedStatement pstat = dc.getPstat(query);
//			
//			pstat.setString(1, data.getProd_name());
//			pstat.setString(2, data.getProd_type());
//			pstat.setInt(3, data.getProd_price());
//			pstat.setString(4, data.getReason());
//			pstat.setString(5, data.getExp_use());
//			pstat.setInt(6, data.getDes_percentage());
//			
//			int rs = dc.sendInsertQuery();
//			if(rs == 1) {
//				dc.commit();
//				return true;
//			}
//			dc.rollback();
//			return false;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	public DesireDAO() {
		try {
			dc = new DeConn("localhost", "1521", "XEPDB1", "for_semi", "for_semi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean add_prod(DesireVO data) {
		String query = String.format("INSERT INTO DESIRE_T VALUES('%s', '%s', '%d', '%s', '%s', '%d')"
				, data.getProd_name()
				, data.getProd_type()
				, data.getProd_price()
				, data.getReason()
				, data.getExp_use()
				, data.getDes_percentage());
		try {
			int rs = dc.sendInsertQuery(query);
			if(rs == 1) {
				dc.commit();
				return true;
			}
			dc.rollback();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

//	public DesireVO get(String prod_name) {
//		String query = "SELECT * FROM accounts WHERE USERID = ?";
//		try {
//			PreparedStatement pstat = dc.getPstat(query);
//			pstat.setString(1, prod_name);
//			
//			ResultSet rs = dc.sendSelectQuery();
//			if(rs.next()) {
//				DesireVO data = new DesireVO();
//				data.setProd_name(rs.getString("prod_name"));
//				data.setProd_type(rs.getString("prod_type"));
//				data.setProd_price(rs.getInt("prod_price"));
//				data.setReason(rs.getString("reason"));
//				data.setExp_use(rs.getString("exp_use"));
//				data.setDes_percentage(rs.getInt("des_percentage"));
//				return data;
//			}
//			rs.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	

}
