package ui;

import db.Conexion;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class LoginForm extends JFrame {
    JTextField txtUsuario = new JTextField(15);
    JPasswordField txtClave = new JPasswordField(15);

    public LoginForm() {
        setTitle("Login");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Usuario:"));
        add(txtUsuario);
        add(new JLabel("Clave:"));
        add(txtClave);

        JButton btnLogin = new JButton("Ingresar");
        JButton registroButton = new JButton("registro");
        add(btnLogin);
        add (registroButton);

        btnLogin.addActionListener(e -> login());
        registroButton.addActionListener(e-> new RegistroForm());
            

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void login() {
        try (Connection con = Conexion.conectar()) {
            String sql = "SELECT * FROM usuarios WHERE usuario=? AND clave=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, txtUsuario.getText());
            ps.setString(2, new String(txtClave.getPassword()));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login exitoso");
                new ventasForm();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
