package Bean;

import DAO.DaoConexion;
import java.sql.*;


public class Acceso 
{
	DaoConexion db = new DaoConexion();
	String sql="";
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public Acceso() {
		
	}
	
	public int validar(String usuario, String contra) 
	{ int tipo=0;
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getContra());
			sql="select tipo from usuarios where usuario='"+usuario+"' and password='"+contra+"'";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				tipo=rs.getInt(1);
			}
			con.close();
			rs.close();
			return tipo;
					
		} catch (SQLException | ClassNotFoundException e) {
			return tipo;
		}		
	}
	
}
