package model;

public class Usuario {
    private int id;
    private String nombre;
    private String usuario;
    private String clave;

    public Usuario(String nombre, String usuario, String clave) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getNombre() { return nombre; }
    public String getUsuario() { return usuario; }
    public String getClave() { return clave; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setClave(String clave) { this.clave = clave; }
}
