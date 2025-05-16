package ui;

import db.Conexion;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class RegistroForm extends JFrame {
    JTextField txtNombre = new JTextField(15);
    JTextField txtUsuario = new JTextField(15);
    JPasswordField txtClave = new JPasswordField(15);

    public RegistroForm() {
        setTitle("Registro de Usuario");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nombre:")); add(txtNombre);
        add(new JLabel("Usuario:")); add(txtUsuario);
        add(new JLabel("Clave:")); add(txtClave);

        JButton btnRegistrar = new JButton("Registrar");
        JButton volverButton = new JButton("volver");
        add(btnRegistrar);
        add(volverButton) ;

        btnRegistrar.addActionListener(e -> registrarUsuario());
        volverButton.addActionListener(e -> new LoginForm());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void registrarUsuario() {
        try (Connection con = Conexion.conectar()) {
            String sql = "INSERT INTO usuarios(nombre, usuario, clave) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtUsuario.getText());
            ps.setString(3, new String(txtClave.getPassword()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Usuario registrado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
