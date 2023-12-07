package org.GrupoNavarro;

import javax.swing.*;
import java.util.Date;

public class UsuarioAdm extends PersonaDatos{
    private String codigoUser;
    private String nombreUser;
    private String password;
    private static UsuarioAdm instanciaUnica;

    // Constructor privado para evitar la creación de instancias desde afuera
    private UsuarioAdm(String nombreCompleto, String dni, String numero_celular, String direccion, String codigoUser, String nombreUser, String password) {
        super(nombreCompleto, dni, numero_celular, direccion);
        this.codigoUser = codigoUser;
        this.nombreUser = nombreUser;
        this.password = password;
    }
    // Método público para obtener la instancia única de la clase
    public static UsuarioAdm getInstance() {
        if (instanciaUnica == null) {
            // Si no existe ninguna instancia, crea una nueva con los datos del usuario maestro
            instanciaUnica = new UsuarioAdm("Usuario administrador", "79456378", "914336789","Calle administrador","admin","administrador","Passw0rd");
        }
        return instanciaUnica;
    }

    public String getCodigoUser() {
        return codigoUser;
    }


    public void loginVerificationUser() {
        // Obtener la instancia única del usuario admin
        UsuarioAdm usuarioAdm = UsuarioAdm.getInstance();
        boolean credencialesCorrectas = false;

        while (!credencialesCorrectas) {
            String userId = JOptionPane.showInputDialog("Usuario:");

            if (userId == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada. Cierre del programa.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            JPasswordField passwordField = new JPasswordField();
            int option = JOptionPane.showConfirmDialog(null, passwordField, "Contraseña:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            // Validar datos de inicio de sesión
            if (option == JOptionPane.OK_OPTION) {
                String password = new String(passwordField.getPassword());
                // Iniciar sesión correctamente
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
        return password.equals(this.password);
    }

}
