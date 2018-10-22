package Bean;
import Tools.Bean;

public class BeanPago extends Bean{
      
	  String idEmpleado;
      String Salario;
      String Fechadepago;

    public BeanPago(String idEmpleado, String Salario, String Fechadepago) {
        super();
        this.idEmpleado = idEmpleado;
        this.Salario = Salario;
        this.Fechadepago = Fechadepago;
    }
    
    public BeanPago() {}
    
    public String getidEmpleado() {
        return idEmpleado;
    }

    public void setidEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getSalario() {
        return Salario;
    }

    public void setSalario(String Salario) {
        this.Salario = Salario;
    }

    public String getFechadepago() {
        return Fechadepago;
    }

    public void setFechadepago(String Fechadepago) {
        this.Fechadepago = Fechadepago;
    }
      
      
      
}
