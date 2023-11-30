package org.GrupoNavarro;

public class UsuarioAdm extends PersonaDatos{
    private String codigoUser;
    private String nombreUser;

    public UsuarioAdm(String nombreCompleto, String dni, String numero_celular, String direccion, String codigoUser, String nombreUser) {
        super(nombreCompleto, dni, numero_celular, direccion);
        this.codigoUser = codigoUser;
        this.nombreUser = nombreUser;
    }
    public String getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(String codigoUser) {
        this.codigoUser = codigoUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }
    public  void  generarPedido(){
        String codigoSolicitud= codigoSOlicitud;
        Date fechaAtencion= fechaAtencion;
        Date fechaEmision= fechaEmision;
        String comentarios= comentarios;
        String estado= estado;
    }
}
