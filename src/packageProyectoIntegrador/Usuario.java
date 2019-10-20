package packageProyectoIntegrador;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String mail;
	private Integer numero;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Usuario(String nombre, String apellido, String mail, Integer numero) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setMail(mail);
		this.setNumero(numero);;
	}
}
