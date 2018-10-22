package Bean;

import Tools.Bean;

public class BeanNotas extends Bean
{
	String idAlumno;
	String DNI; 
	String Nombres;
	String Apellidos;
	String Grado;
	String LM;
	String CI;
	String CA;
	String Computo;
	String PS;
	String Religion;
	String EF;
	String Minichef;
	String Tutoria;
	
	public BeanNotas() {
		super();		
	}

	public BeanNotas(String idAlumno, String dNI, String nombres, String apellidos, String grado, String lM, String cI,
			String cA, String computo, String pS, String religion, String eF, String minichef, String tutoria) {
		super();
		this.idAlumno = idAlumno;
		DNI = dNI;
		Nombres = nombres;
		Apellidos = apellidos;
		Grado = grado;
		LM = lM;
		CI = cI;
		CA = cA;
		Computo = computo;
		PS = pS;
		Religion = religion;
		EF = eF;
		Minichef = minichef;
		Tutoria = tutoria;
	}

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

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getGrado() {
		return Grado;
	}

	public void setGrado(String grado) {
		Grado = grado;
	}

	public String getLM() {
		return LM;
	}

	public void setLM(String lM) {
		LM = lM;
	}

	public String getCI() {
		return CI;
	}

	public void setCI(String cI) {
		CI = cI;
	}

	public String getCA() {
		return CA;
	}

	public void setCA(String cA) {
		CA = cA;
	}

	public String getComputo() {
		return Computo;
	}

	public void setComputo(String computo) {
		Computo = computo;
	}

	public String getPS() {
		return PS;
	}

	public void setPS(String pS) {
		PS = pS;
	}

	public String getReligion() {
		return Religion;
	}

	public void setReligion(String religion) {
		Religion = religion;
	}

	public String getEF() {
		return EF;
	}

	public void setEF(String eF) {
		EF = eF;
	}

	public String getMinichef() {
		return Minichef;
	}

	public void setMinichef(String minichef) {
		Minichef = minichef;
	}

	public String getTutoria() {
		return Tutoria;
	}

	public void setTutoria(String tutoria) {
		Tutoria = tutoria;
	}
				
}
