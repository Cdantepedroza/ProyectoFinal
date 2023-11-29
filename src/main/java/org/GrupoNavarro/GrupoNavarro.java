package org.GrupoNavarro;

import java.security.PrivilegedAction;
import java.util.ArrayList;

public class GrupoNavarro {
    private String nombre;
    private ArrayList<UsuarioAdm> usuariosAdm = new ArrayList<>();
    private ArrayList<PersonalTecnico> tecnicos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<String> especialidades = new ArrayList<>();

    public GrupoNavarro(String nombre) {
        this.nombre = nombre;
    }
}
