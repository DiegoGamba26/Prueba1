import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CajeroAutomaticoGUI {
    private double saldo = 2350000;
    private String contraseña = "1234";

    public CajeroAutomaticoGUI() {
        JFrame frame = new JFrame("Cajero Automático");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        JLabel label = new JLabel("Seleccione una operación:", SwingConstants.CENTER);
        frame.add(label);

        JButton btnSaldo = new JButton("Consultar Saldo");
        JButton btnRetiro = new JButton("Retirar Dinero");
        JButton btnCambioClave = new JButton("Cambiar Contraseña");
        JButton btnSalir = new JButton("Finalizar");

        frame.add(btnSaldo);
        frame.add(btnRetiro);
        frame.add(btnCambioClave);
        frame.add(btnSalir);

        // Acción para consultar saldo
        btnSaldo.addActionListener(e -> 
            JOptionPane.showMessageDialog(frame, "Saldo actual: $" + saldo));

        // Acción para retirar dinero
        btnRetiro.addActionListener(e -> {
            String montoStr = JOptionPane.showInputDialog(frame, "Ingrese monto a retirar:");
            if (montoStr != null) {
                try {
                    double monto = Double.parseDouble(montoStr);
                    if (monto > 0 && monto <= saldo) {
                        saldo -= monto;
                        JOptionPane.showMessageDialog(frame, "Retiro exitoso.\nSaldo actual: $" + saldo);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Monto inválido o insuficiente.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un número válido.");
                }
            }
        });

        // Acción para cambiar contraseña
        btnCambioClave.addActionListener(e -> {
            String actual = JOptionPane.showInputDialog(frame, "Ingrese contraseña actual:");
            if (actual != null && actual.equals(contraseña)) {
                String nuevaClave = JOptionPane.showInputDialog(frame, "Ingrese nueva contraseña:");
                if (nuevaClave != null && !nuevaClave.isEmpty()) {
                    contraseña = nuevaClave;
                    JOptionPane.showMessageDialog(frame, "Contraseña cambiada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(frame, "La nueva contraseña no puede estar vacía.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Contraseña incorrecta.");
            }
        });

        // Acción para salir
        btnSalir.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CajeroAutomaticoGUI();
    }
}
