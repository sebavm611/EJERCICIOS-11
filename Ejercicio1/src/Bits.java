
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;


/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
public class Bits extends JFrame {
    
    JMenuBar mnu;
    JMenuItem items[];
    JMenu mnu1,mnu2;
    JLabel lbl1,lbl2;
    JTextField txt1,txt2,txt3;
    
    public Bits(){
        setLayout(new FlowLayout());
        mnu = new JMenuBar();
        items = new JMenuItem [5];
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
        txt3 = new JTextField(40);
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
        txt3.setFont(new Font("Helvetica", Font.PLAIN, 25));
        JLabel espacio = new JLabel("                                       ");
        espacio.setFont(new Font("Helvetica", Font.PLAIN, 34));
        JLabel espacio1 = new JLabel("                                                                                                                                                                                      ");
        espacio1.setFont(new Font("Helvetica", Font.PLAIN, 14));
        
        
        setJMenuBar(mnu);
        add(espacio1);
        add(lbl1);
        add(txt1);
        add(lbl2);
        add(txt2);
        add(espacio);
        add(txt3);
        setSize(930,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        Bits b = new Bits();
    }
}
