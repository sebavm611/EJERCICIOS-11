
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author pablo
 */
public class OpcMult extends JFrame {

    ButtonGroup btnGrp[];
    JRadioButton respuestas[];
    JLabel lbls[];
    JRadioButton botones[]; 
    JMenuBar mnu;
    JMenuItem itm1, itm2, itm3, itm4;
    JMenu mnu1, mnu2;
    JTextArea txtSalida;

    public OpcMult() {
        setLayout(new FlowLayout());
        ManejadorBotones mb = new ManejadorBotones();
        mnu = new JMenuBar();
        mnu1 = new JMenu("Operaciones");
        mnu2 = new JMenu("Ayuda");
        itm1 = new JMenuItem("Evaluar");
        itm2 = new JMenuItem("Restablecer");
        itm3 = new JMenuItem("Salir");
        itm4 = new JMenuItem("Acerca de");
        itm1.addActionListener(mb);
        itm2.addActionListener(mb);
        itm3.addActionListener(mb);
        itm4.addActionListener(mb);
        lbls = new JLabel[5];
        botones = new JRadioButton[20];
        lbls[0] = new JLabel("1. ¿Qué paradigma de programación permite construir programas instrucción a instrucción utilizando las tres estructuras básicas de control?");
        lbls[1] = new JLabel("2. ¿Qué característica no corresponde al lenguaje de programación java?                                                                                                                ");
        lbls[2] = new JLabel("3. ¿Qué edición de java se utiliza para desarrollar aplicaciones para dispositivos móviles?                                                                                     ");
        lbls[3] = new JLabel("4. Unicode utiliza para la representación de los caracteres:                                                                                                                                         ");
        lbls[4] = new JLabel("5. ¿Qué método debe codificarse si se implementa la interface ActionListener?                                                                                                      ");
        lbls[0].setFont(new Font("Helvetica", Font.PLAIN, 19));
        lbls[1].setFont(new Font("Helvetica", Font.PLAIN, 19));
        lbls[2].setFont(new Font("Helvetica", Font.PLAIN, 19));
        lbls[3].setFont(new Font("Helvetica", Font.PLAIN, 19));
        lbls[4].setFont(new Font("Helvetica", Font.PLAIN, 19));
        botones[0] = new JRadioButton("Funcional            ");
        botones[1] = new JRadioButton("Orientado a eventos          ");
        botones[2] = new JRadioButton("Lógico           ");
        botones[3] = new JRadioButton("Imperativo           ");
        botones[4] = new JRadioButton("Interpretado         ");
        botones[5] = new JRadioButton("Orientado a aspectos         ");
        botones[6] = new JRadioButton("Multihilos           ");
        botones[7] = new JRadioButton("Distribuido          ");
        botones[8] = new JRadioButton("Java EE          ");
        botones[9] = new JRadioButton("Java SE          ");
        botones[10] = new JRadioButton("Java ME         ");
        botones[11] = new JRadioButton("Java Card           ");
        botones[12] = new JRadioButton("7 bits          ");
        botones[13] = new JRadioButton("8 bits          ");
        botones[14] = new JRadioButton("16 bits         ");
        botones[15] = new JRadioButton("32 bits         ");
        botones[16] = new JRadioButton("actionPerformed         ");
        botones[17] = new JRadioButton("itemStateChanged            ");
        botones[18] = new JRadioButton("textValueChanged            ");
        botones[19] = new JRadioButton("valueChanged            ");
        respuestas = new JRadioButton[5];
        respuestas[0] = botones[3];
        respuestas[1] = botones[5];
        respuestas[2] = botones[10];
        respuestas[3] = botones[13];
        respuestas[4] = botones[16];
        btnGrp = new ButtonGroup[5];
        txtSalida = new JTextArea(19, 70);
        txtSalida.setEditable(false);
        txtSalida.setFont(new Font("Helvetica", Font.PLAIN, 20));
        for (int i = 0; i < 5; i++) {
            btnGrp[i] = new ButtonGroup();
        }

        mnu.setFont(new Font("Helvetica", Font.BOLD, 14));
        mnu1.setFont(new Font("Helvetica", Font.BOLD, 14));
        mnu2.setFont(new Font("Helvetica", Font.BOLD, 14));
        itm1.setFont(new Font("Helvetica", Font.BOLD, 14));
        itm2.setFont(new Font("Helvetica", Font.BOLD, 14));
        itm3.setFont(new Font("Helvetica", Font.BOLD, 14));
        itm4.setFont(new Font("Helvetica", Font.BOLD, 14));
        setJMenuBar(mnu);
        mnu.add(mnu1);
        mnu.add(mnu2);
        mnu1.add(itm1);
        mnu1.add(itm2);
        mnu1.add(itm3);
        mnu2.add(itm4);

        add(lbls[0]);
        for (int i = 0; i < 4; i++) {
            btnGrp[0].add(botones[i]);
            botones[i].setFont(new Font("Helvetica", Font.BOLD, 16));
            add(botones[i]);
        }

        add(lbls[1]);
        for (int i = 4; i < 8; i++) {
            btnGrp[1].add(botones[i]);
            botones[i].setFont(new Font("Helvetica", Font.BOLD, 16));
            add(botones[i]);
        }

        add(lbls[2]);
        for (int i = 8; i < 12; i++) {
            btnGrp[2].add(botones[i]);
            botones[i].setFont(new Font("Helvetica", Font.BOLD, 16));
            add(botones[i]);
        }

        add(lbls[3]);
        for (int i = 12; i < 16; i++) {
            btnGrp[3].add(botones[i]);
            botones[i].setFont(new Font("Helvetica", Font.BOLD, 16));
            add(botones[i]);
        }

        add(lbls[4]);
        for (int i = 16; i < 20; i++) {
            btnGrp[4].add(botones[i]);
            botones[i].setFont(new Font("Helvetica", Font.BOLD, 16));
            add(botones[i]);
        }
        add(txtSalida);

        setTitle("Prueba de Opcion Multiple");
        setResizable(false);
        setSize(1300, 900);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void limpiarSeleccion() {
        for (ButtonGroup buttonGroup : btnGrp) {
            buttonGroup.clearSelection();
        }
        txtSalida.setText("");
    }
    
    public void mostrarInfo(){
        
        JOptionPane.showMessageDialog(this, "Programa realizado por Pablo Velez y Rodrigo Ortiz\nFecha de creacion: 09/06/2023","Informacion",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void evaluar(){
        ArrayList<JRadioButton> seleccionados = new ArrayList<>();
        for (JRadioButton botone : botones) {
            if(botone.isSelected()){
                seleccionados.add(botone);
            }
        }
        
        int respuestasValidas = 0;
        for (JRadioButton seleccionado : seleccionados) {
            for (JRadioButton respuesta : respuestas) {
                if (seleccionado==respuesta){
                    respuestasValidas++;
                }
            }
        }
        
        
        int sinContestar = 5 - seleccionados.size();
        double pct = (respuestasValidas/5.0) * 100.0;
        
        StringBuilder sb = new StringBuilder();
        sb.append("Nota obtenida: ").append(respuestasValidas).append(" pts\tNota maxima: 5 pts");
        sb.append("\nHa dejado sin contestar ").append(sinContestar).append(" preguntas");
        sb.append("\nSu porcentaje de aciertos es de ").append(String.format("%.2f", pct)).append("%");
        
        for (int i = 0; i < 5; i++) {
            if((btnGrp[i].getSelection() == null)||(btnGrp[i].getSelection() != respuestas[i].getModel())){
                sb.append("\n\nLa pregunta ").append(i+1).append(" es incorrecta");
                sb.append("\nLa respuesta correcta es : ").append(respuestas[i].getText());
            }
                
        }
        
       txtSalida.setText(sb.toString());
    }

    private class ManejadorBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == itm1) {
                evaluar();
            } else if (e.getSource() == itm2) {
                limpiarSeleccion();
            } else if (e.getSource() == itm3) {
                System.exit(0);
            } else if (e.getSource() == itm4) {
                mostrarInfo();
            }
        }

    }

    public static void main(String[] args) {
        OpcMult v = new OpcMult();
    }

}
