package org.GrupoNavarro;

public class UsuarioAdm extends PersonaDatos{
    private String codigoUser;
    private String nombreUser;

    public UsuarioAdm(String nombreCompleto, String dni, String numero_celular, String direccion, String codigoUser, String nombreUser) {
        super(nombreCompleto, dni, numero_celular, direccion);
        this.codigoUser = codigoUser;
        this.nombreUser = nombreUser;
    }
}
