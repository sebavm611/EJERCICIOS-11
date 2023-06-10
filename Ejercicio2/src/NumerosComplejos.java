/*
2. Realizar un programa que utilizando el administrador de esquemas FlowLayout y
un menú, permita realizar operaciones utilizando números complejos.

 *
 * @author Pablo Vélez y Rodrigo Ortiz  MARZO - JULIO 2023
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class NumerosComplejos extends JFrame {

    DecimalFormat formato = new DecimalFormat("#,##0.000");
    JLabel lblNumero1, lblNumero2;
    JTextField txtNumero1, txtNumero2;
    JTextArea taRes;
    JMenu MnCalcular, MnAyuda, MnModulo, MnArgumento, MnPolar, MnOpuesto, MnConjugado;
    JMenuBar MbBarra;
    JMenuItem MiArgumento, MiPolar, MiOpuesto, MiConjugado, MiSuma, MiResta, MiMultiplicacion, MiDivision, MiIgualdad, MiSalir, MiAcercaDe, Mi1M, Mi2M, Mi1A, Mi2A, Mi1P, Mi2P, Mi1O, Mi2O, Mi1C, Mi2C;

    NumerosComplejos() {

        lblNumero1 = new JLabel("Numero 1 ");
        lblNumero2 = new JLabel("Numero 2 ");
        txtNumero1 = new JTextField(5);
        txtNumero2 = new JTextField(5);
        taRes = new JTextArea(3, 26);
        MnCalcular = new JMenu("Calcular");
        MnModulo = new JMenu("Modulo");
        MnArgumento = new JMenu("Argumento");
        MnPolar = new JMenu("Polar");
        MnOpuesto = new JMenu("Opuesto");
        MnConjugado = new JMenu("Conjugado");
        MnAyuda = new JMenu("Ayuda");
        MbBarra = new JMenuBar();
        MiSuma = new JMenuItem("Suma");
        MiResta = new JMenuItem("Resta");
        MiMultiplicacion = new JMenuItem("Multiplicacion");
        MiDivision = new JMenuItem("Division");
        MiIgualdad = new JMenuItem("Igualdad");
        MiSalir = new JMenuItem("Salir");
        MiAcercaDe = new JMenuItem("Acerca de");
        Mi1M = new JMenuItem("Numero 1");
        Mi2M = new JMenuItem("Numero 2");
        Mi1A = new JMenuItem("Numero 1");
        Mi2A = new JMenuItem("Numero 2");
        Mi1P = new JMenuItem("Numero 1");
        Mi2P = new JMenuItem("Numero 2");
        Mi1O = new JMenuItem("Numero 1");
        Mi2O = new JMenuItem("Numero 2");
        Mi1C = new JMenuItem("Numero 1");
        Mi2C = new JMenuItem("Numero 2");

        setLayout(new FlowLayout());

        setJMenuBar(MbBarra);
        MbBarra.add(MnCalcular);
        MbBarra.add(MnAyuda);
        MnCalcular.add(MnModulo);
        MnCalcular.add(MnArgumento);
        MnCalcular.add(MnPolar);
        MnCalcular.add(MnOpuesto);
        MnCalcular.add(MnConjugado);
        MnCalcular.add(MiSuma);
        MiSuma.addActionListener(new ManejoEventos());
        MnCalcular.add(MiResta);
        MiResta.addActionListener(new ManejoEventos());
        MnCalcular.add(MiMultiplicacion);
        MiMultiplicacion.addActionListener(new ManejoEventos());
        MnCalcular.add(MiDivision);
        MiDivision.addActionListener(new ManejoEventos());
        MnCalcular.add(MiIgualdad);
        MiIgualdad.addActionListener(new ManejoEventos());
        MnCalcular.add(MiSalir);
        MiSalir.addActionListener(new ManejoEventos());
        MnModulo.add(Mi1M);
        Mi1M.addActionListener(new ManejoEventos());
        MnModulo.add(Mi2M);
        Mi2M.addActionListener(new ManejoEventos());
        MnArgumento.add(Mi1A);
        Mi1A.addActionListener(new ManejoEventos());
        MnArgumento.add(Mi2A);
        Mi2A.addActionListener(new ManejoEventos());
        MnPolar.add(Mi1P);
        Mi1P.addActionListener(new ManejoEventos());
        MnPolar.add(Mi2P);
        Mi2P.addActionListener(new ManejoEventos());
        MnOpuesto.add(Mi1O);
        Mi1O.addActionListener(new ManejoEventos());
        MnOpuesto.add(Mi2O);
        Mi2O.addActionListener(new ManejoEventos());
        MnConjugado.add(Mi1C);
        Mi1C.addActionListener(new ManejoEventos());
        MnConjugado.add(Mi2C);
        Mi2C.addActionListener(new ManejoEventos());
        MnAyuda.add(MiAcercaDe);
        MiAcercaDe.addActionListener(new ManejoEventos());
        add(lblNumero1);
        add(txtNumero1);
        add(lblNumero2);
        add(txtNumero2);
        add(taRes);
        taRes.setEditable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setResizable(false);
        setTitle("Operaciones con numeros complejos");
        setLocation(800, 300);
        setVisible(true);

    }

    public boolean validarNum(JTextField txtNum) {

        String n = txtNum.getText();

        if (!n.matches("^(\\+|-)?\\d+((\\.|,)(\\+|-)?\\d+)i$")) {

            return false;
        }

        return true;

    }

    public void modulo(JTextField txtNum, String s) {

        String texto = txtNum.getText();
        texto = texto.replace("i", "");
        texto = texto.replace(",", ".");
        String a[] = texto.split("\\.");

        double num1 = Double.parseDouble(a[0]);
        double num2 = Double.parseDouble(a[1]);

        double modulo = Math.sqrt((Math.pow(num1, 2)) + (Math.pow(num2, 2)));
        taRes.setText("El modulo de Numero " + s + " es: " + formato.format(modulo));

    }

    public void argumento(JTextField txtNum, String s) {

        String texto = txtNum.getText();
        texto = texto.replace("i", "");
        texto = texto.replace(",", ".");
        String a[] = texto.split("\\.");

        double num1 = Double.parseDouble(a[0]);
        double num2 = Double.parseDouble(a[1]);

        double cociente = num2 / num1;
        double argumento = (Math.atan(cociente) * 180) / Math.PI;
        taRes.setText("El argumento de Numero " + s + " es: " + formato.format(argumento) + " grados");
    }

    public void polar(JTextField txtNum, String s) {

        String texto = txtNum.getText();
        texto = texto.replace("i", "");
        texto = texto.replace(",", ".");
        String a[] = texto.split("\\.");

        double num1 = Double.parseDouble(a[0]);
        double num2 = Double.parseDouble(a[1]);

        double cociente = num2 / num1;
        double argumento = (Math.atan(cociente) * 180) / Math.PI;
        double modulo = Math.sqrt((Math.pow(num1, 2)) + (Math.pow(num2, 2)));

        taRes.setText("La forma polar de Numero " + s + " es: " + "(" + formato.format(modulo) + " ; " + formato.format(argumento) + ")");
    }

    public void opuesto(JTextField txtNum, String s) {

        String texto = txtNum.getText();
        texto = texto.replace(",", ".");
        String a[] = texto.split("\\.");

        if (a[0].contains("-") && a[1].contains("-")) {

            a[0] = a[0].replace("-", "");
            a[1] = a[1].replace("-", "");

            taRes.setText("El opuesto de Numero " + s + " es: " + "+" + a[0] + "," + "+" + a[1]);

        } else if (a[0].contains("-")) {

            a[0] = a[0].replace("-", "");
            a[1] = a[1].replace("+", "");

            taRes.setText("El opuesto de Numero " + s + " es: " + "+" + a[0] + "," + "-" + a[1]);

        } else if (a[1].contains("-")) {

            a[0] = a[0].replace("+", "");
            a[1] = a[1].replace("-", "");

            taRes.setText("El opuesto de Numero " + s + " es: " + "-" + a[0] + "," + "+" + a[1]);
        } else {

            a[0] = a[0].replace("+", "");
            a[1] = a[1].replace("+", "");

            taRes.setText("El opuesto de Numero " + s + " es: " + "-" + a[0] + "," + "-" + a[1]);
        }

    }

    public void conjugada(JTextField txtNum, String s) {

        String texto = txtNum.getText();
        texto = texto.replace(",", ".");
        String a[] = texto.split("\\.");

        if (a[1].contains("-")) {

            a[1] = a[1].replace("-", "+");

            taRes.setText("La conjugada de Numero " + s + " es: " + a[0] + "," + a[1]);

        } else {

            a[1] = a[1].replace("+", "");

            taRes.setText("La conjugada de Numero " + s + " es: " + a[0] + "," + "-" + a[1]);

        }
    }

    public void suma(JTextField txtNum1, JTextField txtNum2) {

        String texto1 = txtNum1.getText();
        String texto2 = txtNum2.getText();
        texto1 = texto1.replace(",", ".");
        texto1 = texto1.replace("i", "");
        texto2 = texto2.replace("i", "");
        texto2 = texto2.replace(",", ".");
        String a1[] = texto1.split("\\.");
        String a2[] = texto2.split("\\.");

        double num1 = Double.parseDouble(a1[0]);
        double num2 = Double.parseDouble(a1[1]);
        double num3 = Double.parseDouble(a2[0]);
        double num4 = Double.parseDouble(a2[1]);

        double suma1 = num1 + num3;
        double suma2 = num2 + num4;

        taRes.setText("La suma de N1 + N2 = (" + Math.round(suma1) + ")" + ",(" + Math.round(suma2) + ")i");
    }

    public void resta(JTextField txtNum1, JTextField txtNum2) {

        String texto1 = txtNum1.getText();
        String texto2 = txtNum2.getText();
        texto1 = texto1.replace(",", ".");
        texto1 = texto1.replace("i", "");
        texto2 = texto2.replace("i", "");
        texto2 = texto2.replace(",", ".");
        String a1[] = texto1.split("\\.");
        String a2[] = texto2.split("\\.");

        double num1 = Double.parseDouble(a1[0]);
        double num2 = Double.parseDouble(a1[1]);
        double num3 = Double.parseDouble(a2[0]);
        double num4 = Double.parseDouble(a2[1]);

        double resta1 = num1 - num3;
        double resta2 = num2 - num4;

        taRes.setText("La suma de N1 + N2 = (" + Math.round(resta1) + ")" + ",(" + Math.round(resta2) + ")i");
    }

    public void multiplicacion(JTextField txtNum1, JTextField txtNum2) {

        String texto1 = txtNum1.getText();
        String texto2 = txtNum2.getText();
        texto1 = texto1.replace(",", ".");
        texto1 = texto1.replace("i", "");
        texto2 = texto2.replace("i", "");
        texto2 = texto2.replace(",", ".");
        String a1[] = texto1.split("\\.");
        String a2[] = texto2.split("\\.");

        double num1 = Double.parseDouble(a1[0]);
        double num2 = Double.parseDouble(a1[1]);
        double num3 = Double.parseDouble(a2[0]);
        double num4 = Double.parseDouble(a2[1]);

        double multiplicacion1 = (num1 * num3) - (num2 * num4);
        double multiplicacion2 = (num2 * num3) + (num1 * num4);

        taRes.setText("La multiplicacion de N1 * N2 = (" + Math.round(multiplicacion1) + ")" + ",(" + Math.round(multiplicacion2) + ")i");
    }

    public void division(JTextField txtNum1, JTextField txtNum2) {

        String texto1 = txtNum1.getText();
        String texto2 = txtNum2.getText();
        texto1 = texto1.replace(",", ".");
        texto1 = texto1.replace("i", "");
        texto2 = texto2.replace("i", "");
        texto2 = texto2.replace(",", ".");
        String a1[] = texto1.split("\\.");
        String a2[] = texto2.split("\\.");

        double num1 = Double.parseDouble(a1[0]);
        double num2 = Double.parseDouble(a1[1]);
        double num3 = Double.parseDouble(a2[0]);
        double num4 = Double.parseDouble(a2[1]);

        if (num3 == 0 && num4 == 0) {

            txtNum1.setText("");
            txtNum2.setText("");
            taRes.setText("");

            JOptionPane.showMessageDialog(null, "No se puede realizar una division para cero, ingrese datos validos ", "ERROR#", JOptionPane.ERROR_MESSAGE);

        } else {

            double division1 = ((num1 * num3) + (num2 * num4)) / ((Math.pow(num3, 2)) + Math.pow(num4, 2));
            double division2 = ((num2 * num3) + (num1 * num4)) / ((Math.pow(num3, 2)) + Math.pow(num4, 2));

            taRes.setText("La division de N1 / N2 = (" + formato.format(division1) + ")" + ",(" + formato.format(division2) + ")i");
        }

    }

    public void igualdad(JTextField txtNum1, JTextField txtNum2) {

        String texto1 = txtNum1.getText();
        String texto2 = txtNum2.getText();
        texto1 = texto1.replace(",", ".");
        texto1 = texto1.replace("i", "");
        texto2 = texto2.replace("i", "");
        texto2 = texto2.replace(",", ".");
        String a1[] = texto1.split("\\.");
        String a2[] = texto2.split("\\.");

        double num1 = Double.parseDouble(a1[0]);
        double num2 = Double.parseDouble(a1[1]);
        double num3 = Double.parseDouble(a2[0]);
        double num4 = Double.parseDouble(a2[1]);

        if (num1 == num3 && num2 == num4) {

            taRes.setText("La igualdad entre N1 y N2 es VERDADERA!");

        } else {

            taRes.setText("La igualdad entre N1 y N2 es FALSA!");
        }
    }

    private class ManejoEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == MiSalir) {

                System.exit(0);

            } else if (e.getSource() == MiAcercaDe) {

                JOptionPane.showMessageDialog(null, "Ejercicio numeros complejos\nMayo 2023  Pablo Vélez y Rodrigo Ortiz");

            } else if (e.getSource() == Mi1M && (validarNum(txtNumero1))) {

                modulo(txtNumero1, "1");

            } else if (e.getSource() == Mi2M && (validarNum(txtNumero2))) {

                modulo(txtNumero2, "2");

            } else if (e.getSource() == Mi1A && (validarNum(txtNumero1))) {

                argumento(txtNumero1, "1");

            } else if (e.getSource() == Mi2A && (validarNum(txtNumero2))) {

                argumento(txtNumero2, "2");

            } else if (e.getSource() == Mi1P && (validarNum(txtNumero1))) {

                polar(txtNumero1, "1");

            } else if (e.getSource() == Mi2P && (validarNum(txtNumero2))) {

                polar(txtNumero2, "2");

            } else if (e.getSource() == Mi1O && (validarNum(txtNumero1))) {

                opuesto(txtNumero1, "1");

            } else if (e.getSource() == Mi2O && (validarNum(txtNumero2))) {

                opuesto(txtNumero2, "2");

            } else if (e.getSource() == Mi1C && (validarNum(txtNumero1))) {

                conjugada(txtNumero1, "1");

            } else if (e.getSource() == Mi2C && (validarNum(txtNumero2))) {

                conjugada(txtNumero2, "2");

            } else if (e.getSource() == MiSuma && (validarNum(txtNumero1)) && (validarNum(txtNumero2))) {

                suma(txtNumero1, txtNumero2);

            } else if (e.getSource() == MiResta && (validarNum(txtNumero1)) && (validarNum(txtNumero2))) {

                resta(txtNumero1, txtNumero2);

            } else if (e.getSource() == MiMultiplicacion && (validarNum(txtNumero1)) && (validarNum(txtNumero2))) {

                multiplicacion(txtNumero1, txtNumero2);

            } else if (e.getSource() == MiDivision && (validarNum(txtNumero1)) && (validarNum(txtNumero2))) {

                division(txtNumero1, txtNumero2);

            } else if (e.getSource() == MiIgualdad && (validarNum(txtNumero1)) && (validarNum(txtNumero2))) {

                igualdad(txtNumero1, txtNumero2);

            } else {

                txtNumero1.setText("");
                txtNumero2.setText("");
                taRes.setText("");
                JOptionPane.showMessageDialog(null, "Ingrese dos numeros complejos segun el ejemplo, sin espacios ni caracteres especiales (N1 = a, bi N2 = c, di)", "ERROR!", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    public static void main(String[] args) {

        NumerosComplejos s = new NumerosComplejos();
    }
}
