package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.BeanEmpleado;
import Interfaz.DaoEmpleado;
import Tools.ToolLista;

public class DaoPagoIMPL implements DaoEmpleado {
    
        private final  DaoConexion mysql;
	String SQL="";
	int i=0;
	public DaoPagoIMPL() 
	{
		this.mysql = new DaoConexion();
	}
	
	public void ingresar(BeanEmpleado pa) throws Exception 
	{
		
		SQL="INSERT INTO empleado (idEmpleado, Salario, FechadePago) VALUES(?,?,?)";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setString(1, pa.getIdEmpleado());
			pst.setString(2, pa.getSalario());
			pst.setString(3, pa.getFechadepago());			
			pst.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally 
		{
			mysql.cerrarConexion();
		}
	}

	public void modificar(BeanEmpleado pa) throws Exception 
	{
		SQL="UPDATE empleado SET Salario=?, FechadePago=?  where idEmpleado=?";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setString(1, pa.getSalario());
			pst.setString(2, pa.getFechadepago());
			pst.setString(3, pa.getIdEmpleado());
			pst.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally 
		{
			mysql.cerrarConexion();
		}
		
	}

	public void eliminar(BeanEmpleado em) throws Exception 
	{
		SQL="DELETE FROM empleado where idEmpleado=?";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setString(1, em.getIdEmpleado());
			pst.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally 
		{
			mysql.cerrarConexion();
		}
		
	}

	public ArrayList<BeanEmpleado> lista() throws Exception 
	{
		ArrayList<BeanEmpleado> lista = new ArrayList<BeanEmpleado>();
		SQL="SELECT idEmpleado, DNI, Nombre, Apellidos, Cargo, Salario, FechadePago FROM empleado";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		BeanEmpleado pa= new BeanEmpleado();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) 
			{
				pa.setIdEmpleado(rst.getString("idEmpleado"));
				pa.setSalario(rst.getString("Salario"));
				pa.setFechadepago(rst.getString("Fechadepago"));
				lista.add(pa);
				
				System.out.println(lista.get(i).getIdEmpleado()+" / "+lista.get(i).getSalario()+" /  "+lista.get(i).getFechadepago());
				i++;
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return lista;
	}

	public ToolLista listarUsuarios() throws Exception 
	{
		ToolLista lis_usu=new ToolLista();
		BeanEmpleado bean=null;
		String sql="SELECT idEmpleado, DNI, Nombre, Apellidos, Cargo, Salario, FechadePago FROM empleado";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		ResultSet rst;
		PreparedStatement stm=conectado.prepareStatement(sql);
		rst=stm.executeQuery(sql);
		
		while(rst.next())
		{	bean=new BeanEmpleado();
			
			bean.setIdEmpleado(rst.getString(1));
			bean.setSalario(rst.getString(2));
			bean.setFechadepago(rst.getString(3));
			
			lis_usu.setElemento(bean);
		}
		
		rst.close();
		stm.close();
		conectado.close();
		
		return lis_usu;
	}
    
}
