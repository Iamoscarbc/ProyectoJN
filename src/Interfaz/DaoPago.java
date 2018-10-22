package Interfaz;

import Bean.BeanPago;
import Tools.ToolLista;
import java.util.ArrayList;

public interface DaoPago {
    
        public void ingresar (BeanPago al) throws Exception;
	public void modificar (BeanPago al) throws Exception;
	public void eliminar(BeanPago al) throws Exception;
	public ArrayList<BeanPago> lista() throws Exception;
	public ToolLista listarUsuarios() throws Exception;
        
}
