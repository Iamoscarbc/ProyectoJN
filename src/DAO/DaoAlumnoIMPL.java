package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.BeanAlumno;
import Interfaz.DaoAlumno;
import Tools.ToolLista;


public class DaoAlumnoIMPL implements DaoAlumno {

	
	private final  DaoConexion mysql;
	String SQL="";
	int i=0;
	public DaoAlumnoIMPL() 
	{
		this.mysql = new DaoConexion();
	}
	
	public void ingresar(BeanAlumno al) throws Exception 
	{
		
		SQL="INSERT INTO alumno (DNI, Nombre, Ape_Paterno, Ape_Materno, Direccion, Telefono, Edad, Grado) VALUES(?,?,?,?,?,?,?,?)";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setString(1, al.getDNI());
			pst.setString(2, al.getNombre());
			pst.setString(3, al.getApe_Paterno());
			pst.setString(4, al.getApe_Materno());
			pst.setString(5, al.getDireccion());
			pst.setString(6, al.getTelefono());
                        pst.setString(7, al.getEdad());
			pst.setString(8, al.getGrado());
			pst.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally 
		{
			mysql.cerrarConexion();
		}
	}

	public void modificar(BeanAlumno al) throws Exception 
	{
		SQL="UPDATE alumno SET DNI=?, Nombre=?, Ape_Paterno=?, Ape_Materno=?, Direccion=?, Telefono=?, Edad=?, Grado=?  where idAlumno=?";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setString(1, al.getDNI());
			pst.setString(2, al.getNombre());
			pst.setString(3, al.getApe_Paterno());
			pst.setString(4, al.getApe_Materno());
			pst.setString(5, al.getDireccion());
			pst.setString(6, al.getTelefono());
                        pst.setString(7, al.getEdad());
			pst.setString(8, al.getGrado());
			pst.setString(9, al.getIdAlumno());
			pst.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally 
		{
			mysql.cerrarConexion();
		}
		// TODO Auto-generated method stub
		
	}

	public void eliminar(BeanAlumno al) throws Exception 
	{
		SQL="DELETE FROM alumno where idAlumno=?";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setString(1, al.getIdAlumno());
			pst.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally 
		{
			mysql.cerrarConexion();
		}
		
	}

	public ArrayList<BeanAlumno> lista() throws Exception 
	{
		ArrayList<BeanAlumno> lista = new ArrayList<BeanAlumno>();
		SQL="SELECT * FROM alumno";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		BeanAlumno al= new BeanAlumno();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) 
			{
				al.setIdAlumno(rst.getString("idAlumno"));
				al.setDNI(rst.getString("DNI"));
				al.setNombre(rst.getString("Nombre"));
				al.setApe_Paterno(rst.getString("Ape_Paterno"));
				al.setApe_Materno(rst.getString("Ape_Materno"));
				al.setDireccion(rst.getString("Direccion"));
				al.setTelefono(rst.getString("Telefono"));
                                al.setEdad(rst.getString("Edad"));
				al.setGrado(rst.getString("Grado"));
				lista.add(al);
				
				System.out.println(lista.get(i).getIdAlumno()+" / "+lista.get(i).getNombre()+" /  "+lista.get(i).getApe_Paterno()+" /  "
						+ ""+lista.get(i).getApe_Materno()+" /  "+lista.get(i).getDireccion()+" /  "+lista.get(i).getTelefono()
						+" /  "+lista.get(i).getEdad()+ " / "+lista.get(i).getGrado());
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
		BeanAlumno bean=null;
		String sql="SELECT * FROM alumno";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		ResultSet rst;
		PreparedStatement stm=conectado.prepareStatement(sql);
		rst=stm.executeQuery(sql);
		
		while(rst.next())
		{	bean=new BeanAlumno();
			
			bean.setIdAlumno(rst.getString(1));
			bean.setDNI(rst.getString(2));
			bean.setNombre(rst.getString(3));
			bean.setApe_Paterno(rst.getString(4));
			bean.setApe_Materno(rst.getString(5));
			bean.setDireccion(rst.getString(6));
			bean.setTelefono(rst.getString(7));
                        bean.setEdad(rst.getString(8));
			bean.setGrado(rst.getString(9));
			
			lis_usu.setElemento(bean);
		}
		
		rst.close();
		stm.close();
		conectado.close();
		
		return lis_usu;
	}
	
	public static void main(String [] arg) 
	{
		BeanAlumno al = new BeanAlumno();
		DaoAlumnoIMPL dpi= new DaoAlumnoIMPL();
		al.setIdAlumno("1");
		al.setDNI("123123");
		al.setNombre("oma");
		al.setApe_Paterno("avalos");
		al.setApe_Materno("urcia");
		al.setDireccion("av. los alamos");
		al.setTelefono("789456123");
		al.setGrado("5to");
		
		try
		{
			dpi.lista();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
