package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Interfaz.DaoNotas;
import Tools.ToolLista;

import Bean.BeanNotas;


public class DaoNotasIMPL implements DaoNotas {

	
	private final  DaoConexion mysql;
	String SQL="";
	int i=0;
	public DaoNotasIMPL() 
	{
		this.mysql = new DaoConexion();
	}
	
	@Override
	public void ingresar(BeanNotas al) throws Exception 
	{
		
		SQL="INSERT INTO alumno (DNI, Nombres, Apellidos, Grado, LM, CI, CA, Computo, PS, Religion, EF, Minichef, Tutoria) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setString(1, al.getDNI());
			pst.setString(2, al.getNombres());
			pst.setString(3, al.getApellidos());
			pst.setString(4, al.getGrado());
			pst.setString(5, al.getLM());
			pst.setString(6, al.getCI());
			pst.setString(7, al.getCA());
			pst.setString(8, al.getComputo());
			pst.setString(9, al.getPS());
			pst.setString(10, al.getReligion());
			pst.setString(11, al.getEF());
			pst.setString(12, al.getMinichef());
			pst.setString(13, al.getTutoria());
			pst.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally 
		{
			mysql.cerrarConexion();
		}
	}

	@Override
	public void modificar(BeanNotas al) throws Exception 
	{
		SQL="UPDATE alumno SET DNI=?, Nombres=?, Apellidos=?, Grado=?, LM=?, CI=?, CA=?, Computo=?, PS=?, Religion=?, EF=?, Minichef=?, Tutoria=?  where idAlumno=?";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			pst.setString(1, al.getDNI());
			pst.setString(2, al.getNombres());
			pst.setString(3, al.getApellidos());
			pst.setString(4, al.getGrado());
			pst.setString(5, al.getLM());
			pst.setString(6, al.getCI());
			pst.setString(7, al.getCA());
			pst.setString(8, al.getComputo());
			pst.setString(9, al.getPS());
			pst.setString(10, al.getReligion());
			pst.setString(11, al.getEF());
			pst.setString(12, al.getMinichef());
			pst.setString(13, al.getTutoria());
			pst.setString(14, al.getIdAlumno());
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

	@Override
	public void eliminar(BeanNotas al) throws Exception 
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

	@Override
	public ArrayList<BeanNotas> lista() throws Exception 
	{
		ArrayList<BeanNotas> lista = new ArrayList<BeanNotas>();
		SQL="SELECT * FROM alumno";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		BeanNotas al= new BeanNotas();
		
		try 
		{
			PreparedStatement pst = conectado.prepareStatement(SQL);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) 
			{
				al.setIdAlumno(rst.getString("idAlumno"));
				al.setDNI(rst.getString("DNI"));
				al.setNombres(rst.getString("Nombres"));
				al.setApellidos(rst.getString("Apellidos"));
				al.setGrado(rst.getString("Grado"));
				al.setLM(rst.getString("LM"));
				al.setCI(rst.getString("CI"));
				al.setCA(rst.getString("CA"));
				al.setComputo(rst.getString("Computo"));
				al.setPS(rst.getString("PS"));
				al.setReligion(rst.getString("Religion"));
				al.setEF(rst.getString("EF"));
				al.setMinichef(rst.getString("Minichef"));
				al.setTutoria(rst.getString("Tutoria"));
				lista.add(al);
				
				System.out.println(lista.get(i).getIdAlumno()+" / "+lista.get(i).getNombres()+" /  "+lista.get(i).getApellidos()+" /  "
						+ ""+lista.get(i).getGrado()+" /  "+lista.get(i).getLM()+" /  "+lista.get(i).getCI()+" /  "+lista.get(i).getCA()
						+ " / "+lista.get(i).getComputo()+ " / "+lista.get(i).getPS()+ " / "+lista.get(i).getReligion()+ " / "+lista.get(i).getEF()
						+ " / "+lista.get(i).getEF()+ " / "+lista.get(i).getMinichef()+ " / "+lista.get(i).getTutoria());
				i++;
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public ToolLista listarUsuarios() throws Exception 
	{
		ToolLista lis_usu=new ToolLista();
		BeanNotas bean=null;
		String sql="SELECT * FROM notas";
		mysql.establecerConexion();
		Connection conectado = mysql.getConnection();
		ResultSet rst;
		PreparedStatement stm=conectado.prepareStatement(sql);
		rst=stm.executeQuery(sql);
		
		while(rst.next())
		{	bean=new BeanNotas();
			
			bean.setIdAlumno(rst.getString(1));
			bean.setDNI(rst.getString(2));
			bean.setNombres(rst.getString(3));
			bean.setApellidos(rst.getString(4));
			bean.setGrado(rst.getString(5));
			bean.setLM(rst.getString(6));
			bean.setCI(rst.getString(7));
			bean.setCA(rst.getString(8));
			bean.setComputo(rst.getString(9));
			bean.setPS(rst.getString(10));
			bean.setReligion(rst.getString(11));
			bean.setEF(rst.getString(12));
			bean.setMinichef(rst.getString(13));
			bean.setTutoria(rst.getString(14));
			
			lis_usu.setElemento(bean);
		}
		
		rst.close();
		stm.close();
		conectado.close();
		
		return lis_usu;
	}	
	
}
