
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
public class OperacionVector extends JFrame {

    ButtonGroup btnOpc;
    JTextField txtVector1, txtVector2;
    JTextArea txtSalida;
    JLabel lblVector1, lblVector2, lblEjemplo, lblEjemplo1;
    JRadioButton botones[];

    public OperacionVector() {
        setLayout(new FlowLayout());
        ManejadorBotones mnjBtn = new ManejadorBotones();
        lblVector1 = new JLabel("Vector 1 ");
        lblVector2 = new JLabel("     Vector 2 ");
        lblEjemplo = new JLabel("                             Ej: (3, 4.1)");
        lblEjemplo1 = new JLabel("                                                                Ej: (8.5, 2)                     ");
        btnOpc = new ButtonGroup();
        txtVector1 = new JTextField(10);
        txtVector2 = new JTextField(10);
        txtSalida = new JTextArea(11, 35);
        btnOpc = new ButtonGroup();
        botones = new JRadioButton[4];
        botones[0] = new JRadioButton("Sumar");
        botones[1] = new JRadioButton("Restar");
        botones[2] = new JRadioButton("Producto escalar");
        botones[3] = new JRadioButton("Producto vectorial");
        for (int i = 0; i < 4; i++) {
            btnOpc.add(botones[i]);
        }
        lblVector1.setFont(new Font("Helvetica", Font.BOLD, 18));
        lblVector2.setFont(new Font("Helvetica", Font.BOLD, 18));
        lblEjemplo.setFont(new Font("Helvetica", Font.PLAIN, 12));
        lblEjemplo1.setFont(new Font("Helvetica", Font.PLAIN, 12));

        txtVector1.setFont(new Font("Helvetica", Font.PLAIN, 15));
        txtVector2.setFont(new Font("Helvetica", Font.PLAIN, 15));

        txtSalida.setEditable(false);
        txtSalida.setFont(new Font("Helvetica", Font.PLAIN, 16));

        add(lblVector1);
        add(txtVector1);
        add(lblVector2);
        add(txtVector2);
        add(lblEjemplo);
        add(lblEjemplo1);
        for (int i = 0; i < 4; i++) {
            botones[i].addActionListener(mnjBtn);
            add(botones[i]);
            botones[i].setFont(new Font("Helvetica", Font.PLAIN, 16));
        }

        add(txtSalida);
        setSize(550, 325);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    public void generarAccion(){
        String vector1,vector2;
        vector1 = txtVector1.getText(); vector2 = txtVector2.getText();
        if(!validarVector(vector2)||!validarVector(vector1)){
            String texto = "Vector 2";
            if(!validarVector(vector2)&&!validarVector(vector1)){
                texto = "Vector 1 y Vector 2";
            }else if(!validarVector(vector1)){
                texto = "Vector 1";
            }
            
            JOptionPane.showMessageDialog(this, "Ingrese el "+texto+" con el formato proporcionado debajo del recuadro", "ERROR", JOptionPane.ERROR_MESSAGE);
            
            btnOpc.clearSelection();
            
        }else{
            double compVct1[] = convertirAVector(vector1);
            double compVct2[] = convertirAVector(vector2);
            
            double resultado[];
            if(botones[0].isSelected()){
                resultado = sumaVectores(compVct1, compVct2);
                txtSalida.setText("La suma de los vectores:\n"+crearFormato(compVct1)+" + "+crearFormato(compVct2)+" = "+crearFormato(resultado));
            }
            else if(botones[1].isSelected()){
                resultado = restaVectores(compVct1, compVct2);
                txtSalida.setText("La resta de los vectores:\n"+crearFormato(compVct1)+" - "+crearFormato(compVct2)+" = "+crearFormato(resultado));
            }
            else if(botones[2].isSelected()){
                double prodEsc = productoEscalar(compVct1, compVct2);
                txtSalida.setText("El producto escalar de los vectores:\n"+prodEsc);
            }
            else if(botones[3].isSelected()){
                if((compVct1.length!=3) || (compVct2.length!=3)){
                    JOptionPane.showMessageDialog(this, "Ambos vectores deben ser de tres dimensiones","ERROR",JOptionPane.ERROR_MESSAGE);
                    btnOpc.clearSelection();
                }else{
                    double prodPunto[] = productoCruz(compVct1, compVct2);
                    txtSalida.setText("El producto punto de los vectores:\n"+crearFormato(prodPunto));
                }
            }
            
        }
    }
    
    public static String crearFormato(double vector[]){
        StringBuilder sb = new StringBuilder();
        
        sb.append("(");
        for (int i = 0; i < vector.length-1; i++) {
            sb.append(String.format("%.2f", vector[i])).append(", ");
        }
        sb.append(String.format("%.2f", vector[vector.length-1])).append(")");
        
        return sb.toString();
    }
    
    public double[] restaVectores(double v1[],double v2[]){
        int tamanio = v1.length;
        if(tamanio<v2.length){
            tamanio = v2.length;
        }
        
        double[] vectorResultante = new double[tamanio];
        
        double valor1,valor2;
        for (int i = 0; i < tamanio; i++) {
            valor1 = 0;
            valor2 = 0;
            if(i<=(v1.length-1)){
                valor1 = v1[i];
            }
            if(i<=(v2.length-1)){
                valor2 = v2[i];
            }
            
            vectorResultante[i] = valor1-valor2;
        }
        
        return vectorResultante;
    }
    
    public double[] sumaVectores(double v1[],double v2[]){
        int tamanio = v1.length;
        if(tamanio<v2.length){
            tamanio = v2.length;
        }
        
        double[] vectorResultante = new double[tamanio];
        
        double valor1,valor2;
        for (int i = 0; i < tamanio; i++) {
            valor1 = 0;
            valor2 = 0;
            if(i<=(v1.length-1)){
                valor1 = v1[i];
            }
            if(i<=(v2.length-1)){
                valor2 = v2[i];
            }
            
            vectorResultante[i] = valor1+valor2;
        }
        
        return vectorResultante;
    }
    
    public double productoEscalar(double v1[],double v2[]){
        int tamanio = v1.length;
        if(tamanio<v2.length){
            tamanio = v2.length;
        }
        
        double productoEscalar = 0;
        
        double valor1,valor2;
        for (int i = 0; i < tamanio; i++) {
            valor1 = 0;
            valor2 = 0;
            if(i<=(v1.length-1)){
                valor1 = v1[i];
            }
            if(i<=(v2.length-1)){
                valor2 = v2[i];
            }
            
            productoEscalar += (valor1*valor2);
        }
        
        return productoEscalar;
    }
    
    public double[] convertirAVector(String v1){
        String componentes1[] = v1.replaceAll("\\(|\\)", "").split(",");
        double cmp1[] = new double[componentes1.length];
        
        for (int i = 0; i < componentes1.length; i++) {
            cmp1[i] = Double.parseDouble(componentes1[i]);
        }
        
        return cmp1;
    }
    
    public double[] productoCruz(double vector1[],double vector2[]){
        double[] producto = new double[3];
        producto[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        producto[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        producto[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];

        return producto;
    }

    public static boolean validarVector(String s) {
        return s.matches("\\((\\+|-)?[0-9]+(.[0-9]+)?(, (\\+|-)?[0-9]+(.[0-9]+)?){1,2}\\)");
    }

    
    private class ManejadorBotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            generarAccion();
        }
        
    }

    public static void main(String[] args) {
        OperacionVector ov = new OperacionVector();
        System.out.println(validarVector("(12.524, 12.524)"));
    }

}
