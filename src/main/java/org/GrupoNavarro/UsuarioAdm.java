package org.GrupoNavarro;

import java.util.Date;

public class UsuarioAdm extends PersonaDatos{
    private String codigoUser;
    private String nombreUser;
    private String password;


    public UsuarioAdm(String nombreCompleto, String dni, String numero_celular, String direccion, String codigoUser, String nombreUser) {
        super(nombreCompleto, dni, numero_celular, direccion);
        this.codigoUser = codigoUser;
        this.nombreUser = nombreUser;
    }

    public UsuarioAdm(String codigoUser, String password) {
        this.codigoUser = codigoUser;
        this.password = password;
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


}
