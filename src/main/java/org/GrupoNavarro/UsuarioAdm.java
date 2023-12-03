package org.GrupoNavarro;

import javax.swing.*;
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

    public void setCodigoUser(String codigoUser) {
        this.codigoUser = codigoUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }
    public String getCodigoUser() {
        return codigoUser;
    }

    public String getPassword() {
        return password;
    }
    public void loginVerificationUser() {
        boolean credencialesCorrectas = false;

        while (!credencialesCorrectas) {
            String userId = JOptionPane.showInputDialog("Usuario:");

            if (userId == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada. Cierre del programa.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            JPasswordField passwordField = new JPasswordField();
            int option = JOptionPane.showConfirmDialog(null, passwordField, "Contraseña:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (option == JOptionPane.OK_OPTION) {
                String password = new String(passwordField.getPassword());

                if (verificarUsuario(userId)) {
                    if (verificarContrasena(password)) {
                        JOptionPane.showMessageDialog(null, "Bienvenido al Sistema");
                        credencialesCorrectas = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "Error de Contraseña", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario es inválido", "Error de Usuario", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operación cancelada. Cierre del programa.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }

    private boolean verificarUsuario(String userId) {
        return userId.equals(getCodigoUser());
    }
    private boolean verificarContrasena(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
    }

}
