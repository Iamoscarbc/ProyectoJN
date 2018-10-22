package Bean;
import Tools.Bean;

public class BeanAlumno extends Bean
{
	String idAlumno;
	String DNI; 
	String Nombre;
	String Ape_Paterno;
	String Ape_Materno;
	String Direccion;
	String Telefono;
    String Edad;
	String Grado;
	public BeanAlumno(String idAlumno, String dNI, String nombre, String ape_Paterno, String ape_Materno, String direccion,
			String telefono, String edad, String grado) {
		super();
		this.idAlumno = idAlumno;
		DNI = dNI;
		Nombre = nombre;
		Ape_Paterno = ape_Paterno;
		Ape_Materno = ape_Materno;
		Direccion = direccion;
		Telefono = telefono;
		Grado = grado;
                Edad = edad;
	}
	public BeanAlumno() {}
	public String getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
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
	public String getApe_Paterno() {
		return Ape_Paterno;
	}
	public void setApe_Paterno(String ape_Paterno) {
		Ape_Paterno = ape_Paterno;
	}
	public String getApe_Materno() {
		return Ape_Materno;
	}
	public void setApe_Materno(String ape_Materno) {
		Ape_Materno = ape_Materno;
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
	public void setEdad(String Edad) {
		this.Edad = Edad;
	}
        public String getGrado() {
		return Grado;
	}
	public void setGrado(String grado) {
		Grado = grado;
	}
	
	
	
	
}