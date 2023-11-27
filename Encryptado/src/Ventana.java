import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JTextField txtCaracteres;
    private JSpinner spnDesplazamiento;
    private JButton btnEncryptar;
    private JButton btnDesencryptar;
    private JList<Character> lstDesplazamiento;
    private JList<Character> lstDesencryptado;
    private DefaultListModel<Character> listModelDesplazamiento;
    private DefaultListModel<Character> listModelDesencryptado;
    private int desplazamientoOriginal;

    private void actualizarLista(DefaultListModel<Character> model, String cadena) {
        model.clear();
        for (char c : cadena.toCharArray()) {
            model.addElement(c);
        }
    }

    public Ventana() {
        EncryptarCaracteres encryptarCaracteres = new EncryptarCaracteres();
        listModelDesplazamiento = new DefaultListModel<>();
        lstDesplazamiento.setModel(listModelDesplazamiento);
        listModelDesencryptado = new DefaultListModel<>();
        lstDesencryptado.setModel(listModelDesencryptado);

        btnEncryptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena = txtCaracteres.getText();
                desplazamientoOriginal = (int) spnDesplazamiento.getValue();
                String encryptado = encryptarCaracteres.encryptar(cadena, desplazamientoOriginal);
                actualizarLista(listModelDesplazamiento, encryptado);
            }
        });
        btnDesencryptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena = "";
                for (int i = 0; i < listModelDesplazamiento.size(); i++) {
                    cadena += listModelDesplazamiento.getElementAt(i);
                }
                String desencryptado = encryptarCaracteres.desencryptar(cadena, desplazamientoOriginal);
                actualizarLista(listModelDesencryptado, desencryptado);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}



