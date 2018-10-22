package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.BeanEmpleado;
import Interfaz.DaoEmpleado;
import Tools.ToolLista;


public class DaoEmpleadoIMPL implements DaoEmpleado {

	
	private final  DaoConexion mysql;
	String SQL="";
	int i=0;
	public DaoEmpleadoIMPL() 
	{
		this.mysql = new DaoConexion();
	}
	
	public void ingresar(BeanEmpleado em) throws Exception 
	{
		
		SQL="INSERT INTO empleado (DNI, Nombre, Apellidos, Direccion, Telefono, Edad, Cargo) VALUES(?,?,?,?,?,?,?)";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setString(1, em.getDNI());
			pst.setString(2, em.getNombre());
			pst.setString(3, em.getApellidos());
			pst.setString(4, em.getDireccion());
			pst.setString(5, em.getTelefono());
                        pst.setString(6, em.getEdad());
			pst.setString(7, em.getCargo());
			pst.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally 
		{
			mysql.cerrarConexion();
		}
	}

	public void modificar(BeanEmpleado em) throws Exception 
	{
		SQL="UPDATE empleado SET DNI=?, Nombre=?, Apellidos=?, Direccion=?, Telefono=?, Edad=?, Cargo=?  where idEmpleado=?";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setString(1, em.getDNI());
			pst.setString(2, em.getNombre());
			pst.setString(3, em.getApellidos());
			pst.setString(4, em.getDireccion());
			pst.setString(5, em.getTelefono());
                        pst.setString(6, em.getEdad());
			pst.setString(7, em.getCargo());
			pst.setString(8, em.getIdEmpleado());
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
		SQL="SELECT * FROM empleado";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		BeanEmpleado em= new BeanEmpleado();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) 
			{
				em.setIdEmpleado(rst.getString("idEmpleado"));
				em.setDNI(rst.getString("DNI"));
				em.setNombre(rst.getString("Nombre"));
				em.setApellidos(rst.getString("Apellidos"));
				em.setDireccion(rst.getString("Direccion"));
				em.setTelefono(rst.getString("Telefono"));
                                em.setEdad(rst.getString("Edad"));
				em.setCargo(rst.getString("Cargo"));
				lista.add(em);
				
				System.out.println(lista.get(i).getIdEmpleado()+" / "+lista.get(i).getNombre()+" /  "+lista.get(i).getApellidos()+" /  "
						+" /  "+lista.get(i).getDireccion()+" /  "+lista.get(i).getTelefono()+" /  "+lista.get(i).getEdad()
                                                + " / "+lista.get(i).getCargo());
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
		String sql="SELECT * FROM empleado";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		ResultSet rst;
		PreparedStatement stm=conectado.prepareStatement(sql);
		rst=stm.executeQuery(sql);
		
		while(rst.next())
		{	bean=new BeanEmpleado();
			
			bean.setIdEmpleado(rst.getString(1));
			bean.setDNI(rst.getString(2));
			bean.setNombre(rst.getString(3));
			bean.setApellidos(rst.getString(4));
			bean.setDireccion(rst.getString(5));
			bean.setTelefono(rst.getString(6));
                        bean.setEdad(rst.getString(7));
			bean.setCargo(rst.getString(8));
			
			lis_usu.setElemento(bean);
		}
		
		rst.close();
		stm.close();
		conectado.close();
		
		return lis_usu;
	}
}
