
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


/**
 *
 * @author adm
 */
public class OperacionVector extends JFrame{
    ButtonGroup btnOpc;
    JTextField txtVector1,txtVector2;
    JTextArea txtSalida;
    JLabel lblVector1,lblVector2;
    JRadioButton botones[];

    public OperacionVector() {
        setLayout(new FlowLayout());
        
        lblVector1 = new JLabel("Vector 1   ");
        lblVector2 = new JLabel("     Vector 2   ");
        btnOpc = new ButtonGroup();
        txtVector1 = new JTextField(10);
        txtVector2 = new JTextField(10);
        txtSalida = new JTextArea(20,15);
        btnOpc = new ButtonGroup();
        botones = new JRadioButton[4];
        botones[0] = new JRadioButton("Sumar");
        botones[1] = new JRadioButton("Restar");
        botones[2] = new JRadioButton("Producto escalar");
        botones[3] = new JRadioButton("Producto vectorial");
        for (int i = 0; i < 4; i++) {
            btnOpc.add(botones[i]);
        }
        lblVector1.setFont(new Font("Helvetica",Font.BOLD,14));
        lblVector2.setFont(new Font("Helvetica",Font.BOLD,14));
        
        txtSalida.setEditable(false);
        txtSalida.setFont(new Font("Helvetica",Font.BOLD,12));
        
        //txtVector1.addKeyListener(l);
        add(lblVector1);
        add(txtVector1);
        add(lblVector2);
        add(txtVector2);
        for (int i = 0; i < 4; i++) {
            add(botones[i]);
        }
        
        add(txtSalida);
        setSize(475,300);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    private class ManejadorEnter implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                //SUBIR DATOS
            }
        }
        
    }
    
    public static void main(String[] args) {
        OperacionVector ov = new OperacionVector();
    }
    
    
}
