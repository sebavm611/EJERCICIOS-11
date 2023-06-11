
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.*;

/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
public class Bits extends JFrame {

    JMenuBar mnu;
    JMenuItem items[];
    JMenu mnu1, mnu2;
    JLabel lbl1, lbl2;
    JTextField txt1, txt2, txt3;

    public Bits() {
        setLayout(new FlowLayout());
        ManejadorEventos mnj = new ManejadorEventos();
        mnu = new JMenuBar();
        items = new JMenuItem[5];
        items[0] = new JMenuItem("Modulo y signo");
        items[1] = new JMenuItem("Complemento a 1");
        items[2] = new JMenuItem("Complemento a 2");
        items[3] = new JMenuItem("Exceso a 2 elevado a n-1");
        items[4] = new JMenuItem("Acerca de");
        mnu1 = new JMenu("Codificaciones");
        mnu2 = new JMenu("Ayuda");
        mnu1.add(items[0]);
        mnu1.add(items[1]);
        mnu1.add(items[2]);
        mnu1.add(items[3]);
        mnu2.add(items[4]);
        mnu.add(mnu1);
        mnu.add(mnu2);
        lbl1 = new JLabel("Ingrese un numero entero");
        lbl2 = new JLabel("            Ingrese cantidad de bits (8,16,32,64)");
        txt1 = new JTextField(10);
        txt2 = new JTextField(6);
        txt3 = new JTextField(43);
        txt3.setEditable(false);
        mnu.setFont(new Font("Helvetica", Font.BOLD, 14));
        mnu1.setFont(new Font("Helvetica", Font.BOLD, 14));
        mnu2.setFont(new Font("Helvetica", Font.BOLD, 14));
        items[0].setFont(new Font("Helvetica", Font.BOLD, 14));
        items[1].setFont(new Font("Helvetica", Font.BOLD, 14));
        items[2].setFont(new Font("Helvetica", Font.BOLD, 14));
        items[3].setFont(new Font("Helvetica", Font.BOLD, 14));
        items[4].setFont(new Font("Helvetica", Font.BOLD, 14));
        lbl1.setFont(new Font("Helvetica", Font.PLAIN, 19));
        lbl2.setFont(new Font("Helvetica", Font.PLAIN, 19));
        txt1.setFont(new Font("Helvetica", Font.PLAIN, 19));
        txt2.setFont(new Font("Helvetica", Font.PLAIN, 19));
        txt3.setFont(new Font("Helvetica", Font.PLAIN, 24));
        JLabel espacio = new JLabel("                                       ");
        espacio.setFont(new Font("Helvetica", Font.PLAIN, 34));
        JLabel espacio1 = new JLabel("                                                                                                                                                                                      ");
        espacio1.setFont(new Font("Helvetica", Font.PLAIN, 14));

        items[0].addActionListener(mnj);
        items[1].addActionListener(mnj);
        items[2].addActionListener(mnj);
        items[3].addActionListener(mnj);
        items[4].addActionListener(mnj);

        setJMenuBar(mnu);
        add(espacio1);
        add(lbl1);
        add(txt1);
        add(lbl2);
        add(txt2);
        add(espacio);
        add(txt3);
        setSize(930, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public boolean validarBits(String s) {
        return s.matches("(16)|(8)|(32)|(64)");
    }

    public boolean validarNum(String s) {
        return s.matches("(\\+|-)?[0-9]+");
    }

    public static String codificacionModuloSignoBits(Long numero, int bits) {
        Long valorAbsoluto = Math.abs(numero);

        StringBuilder codigo = new StringBuilder();

        if (numero > 0) {
            codigo.append("0");
        } else {
           return complementoADos(valorAbsoluto, bits);
        }

        String binario = Long.toBinaryString(valorAbsoluto);
        int cerosFaltantes = (bits - 1) - binario.length();

        for (int i = 0; i < cerosFaltantes; i++) {
            codigo.append("0");
        }
        codigo.append(binario);

        return codigo.toString();
    }

    public static String complemento1(Long num, int bits) {
        String binario = codificacionModuloSignoBits(num, bits);

        StringBuilder complemento = new StringBuilder();

        for (int i = 0; i < binario.length(); i++) {
            char bit = binario.charAt(i);
            if (bit == '0') {
                complemento.append('1');
            } else {
                complemento.append('0');
            }
        }

        return complemento.toString();

    }

    public boolean validarRecuadros(String num, String bits) {

        if (!validarNum(num) || !validarBits(bits)) {
            if (!validarNum(num) && !validarBits(bits)) {
                JOptionPane.showMessageDialog(this, "Ingrese un numero entero valido y una codificacion valida", "ERROR", JOptionPane.ERROR_MESSAGE);
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
            } else if (!validarNum(num)) {
                JOptionPane.showMessageDialog(this, "Ingrese un numero entero valido", "ERROR", JOptionPane.ERROR_MESSAGE);
                txt1.setText("");
                txt3.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese una codificacion valida", "ERROR", JOptionPane.ERROR_MESSAGE);
                txt2.setText("");
                txt3.setText("");
            }
            return false;
        }

        return true;
    }

    public void codificarModuloSigno() {
        String num = txt1.getText(), bits = txt2.getText();

        if (validarRecuadros(num, bits)) {
            Long numInt = Long.parseLong(num);
            int bitsInt = Integer.parseInt(bits);

            switch (bitsInt) {
                case 8:
                    if ((numInt < -128) || (numInt > 127)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 8 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(codificacionModuloSignoBits(numInt, 8));
                    }
                    break;
                case 16:
                    if ((numInt < Short.MIN_VALUE) || (numInt > Short.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 16 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(codificacionModuloSignoBits(numInt, 16));
                    }
                    break;
                case 32:
                    if ((numInt < Integer.MIN_VALUE) || (numInt > Integer.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 32 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(codificacionModuloSignoBits(numInt, 32));
                    }
                    break;
                case 64:
                    if ((numInt < Long.MIN_VALUE) || (numInt > Long.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 64 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(codificacionModuloSignoBits(numInt, 64));
                    }
                    break;
            }
        }
    }

    public void codificarComplemento1() {
        String num = txt1.getText(), bits = txt2.getText();

        if (validarRecuadros(num, bits)) {
            Long numInt = Long.parseLong(num);
            int bitsInt = Integer.parseInt(bits);

            switch (bitsInt) {
                case 8:
                    if ((numInt < -128) || (numInt > 127)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 8 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(complemento1(numInt, 8));
                    }
                    break;
                case 16:
                    if ((numInt < Short.MIN_VALUE) || (numInt > Short.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 16 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(complemento1(numInt, 16));
                    }
                    break;
                case 32:
                    if ((numInt < Integer.MIN_VALUE) || (numInt > Integer.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 32 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(complemento1(numInt, 32));
                    }
                    break;
                case 64:
                    if ((numInt < Long.MIN_VALUE) || (numInt > Long.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 64 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(complemento1(numInt, 64));
                    }
                    break;
            }
        }
    }

    public void codificarComplemento2() {
        String num = txt1.getText(), bits = txt2.getText();

        if (validarRecuadros(num, bits)) {
            Long numInt = Long.parseLong(num);
            int bitsInt = Integer.parseInt(bits);

            switch (bitsInt) {
                case 8:
                    if ((numInt < -128) || (numInt > 127)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 8 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(complementoADos(numInt, 8));
                    }
                    break;
                case 16:
                    if ((numInt < Short.MIN_VALUE) || (numInt > Short.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 16 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(complementoADos(numInt, 16));
                    }
                    break;
                case 32:
                    if ((numInt < Integer.MIN_VALUE) || (numInt > Integer.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 32 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(complementoADos(numInt, 32));
                    }
                    break;
                case 64:
                    if ((numInt < Long.MIN_VALUE) || (numInt > Long.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 64 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(complementoADos(numInt, 64));
                    }
                    break;
            }
        }
    }
    
    public void codificarExceso() {
        String num = txt1.getText(), bits = txt2.getText();

        if (validarRecuadros(num, bits)) {
            Long numInt = Long.parseLong(num);
            int bitsInt = Integer.parseInt(bits);

            switch (bitsInt) {
                case 8:
                    if ((numInt < -128) || (numInt > 127)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 8 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(exceso2n(numInt, 8));
                    }
                    break;
                case 16:
                    if ((numInt < Short.MIN_VALUE) || (numInt > Short.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 16 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(exceso2n(numInt, 16));
                    }
                    break;
                case 32:
                    if ((numInt < Integer.MIN_VALUE) || (numInt > Integer.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 32 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(exceso2n(numInt, 32));
                    }
                    break;
                case 64:
                    if ((numInt < Long.MIN_VALUE) || (numInt > Long.MAX_VALUE)) {
                        JOptionPane.showMessageDialog(this, "Ingrese un rango valido para 64 bits", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txt3.setText(exceso2n(numInt, 64));
                    }
                    break;
            }
        }
    }

    public static String complementoADos(Long num, int bits) {
        String complementoUno = complemento1(num, bits);

        StringBuilder complementoDos = new StringBuilder();
        int carry = 1;
        for (int i = complementoUno.length() - 1; i >= 0; i--) {
            char bit = complementoUno.charAt(i);
            if (bit == '0' && carry == 1) {
                complementoDos.insert(0, '1');
                carry = 0;
            } else if (bit == '1' && carry == 1) {
                complementoDos.insert(0, '0');
                carry = 1;
            } else {
                complementoDos.insert(0, bit);
            }
        }

        return complementoDos.toString();
    }
    
    public static String exceso2n(Long num,int bits){
        
        Long ne = (long) (num + Math.pow(2,bits-1));
        
        return codificacionModuloSignoBits(ne, bits);    
    }

    public class ManejadorEventos implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == items[0]) {
                codificarModuloSigno();
            } else if (e.getSource() == items[1]) {
                codificarComplemento1();
            } else if (e.getSource() == items[2]) {
                codificarComplemento2();
            }else if(e.getSource() == items[3]){
                codificarExceso();
            }
        }

    }

    public static void main(String[] args) {
        Bits b = new Bits();
    }
}
