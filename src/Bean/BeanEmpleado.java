package Bean;
import Tools.Bean;

public class BeanEmpleado extends Bean
{
	String idEmpleado;
	String DNI; 
	String Nombre;
	String Apellidos;
	String Direccion;
	String Telefono;
    String Edad;
	String Cargo;
    String Salario;
    String Fechadepago;
    
	public BeanEmpleado(String idEmpleado, String dNI, String nombre, String ape_Paterno, String apellidos, String direccion,
			String telefono, String edad, String cargo, String salario, String fechadepago) {
		super();
		this.idEmpleado = idEmpleado;
		DNI = dNI;
		Nombre = nombre;
		Apellidos = apellidos;
		Direccion = direccion;
		Telefono = telefono;
		Cargo = cargo;
        Edad = edad;
        Salario = salario;
        Fechadepago = fechadepago;
	}
	public BeanEmpleado() {}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
        public String getEdad() {
		return Edad;
	}
	public void setEdad(String edad) {
		this.Edad = edad;
	}
        public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	public String getSalario() {
		return Salario;
	}
	public void setSalario(String salario) {
		Salario = salario;
	}
	public String getFechadepago() {
		return Fechadepago;
	}
	public void setFechadepago(String fechadepago) {
		Fechadepago = fechadepago;
	}	
	
}