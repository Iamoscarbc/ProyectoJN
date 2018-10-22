package Interfaz;
import java.util.ArrayList;
import Bean.BeanEmpleado;
import Tools.ToolLista;

public interface DaoEmpleado 
{
	public void ingresar (BeanEmpleado al) throws Exception;
	public void modificar (BeanEmpleado al) throws Exception;
	public void eliminar(BeanEmpleado al) throws Exception;
	public ArrayList<BeanEmpleado> lista() throws Exception;
	public ToolLista listarUsuarios() throws Exception;
}
