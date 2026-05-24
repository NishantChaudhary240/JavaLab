package javalab;
import javax.swing.*;
import java.awt.event.*;
public class SimpleInterest_Swing_3 extends JFrame{
    SimpleInterest_Swing_3(){
        JLabel l1 = new JLabel("Principal Amount");
        l1.setBounds(10, 20, 200, 20);
        add(l1);
        
        JTextField t1 = new JTextField();
        t1.setBounds(150, 20, 100, 20);
        add(t1);
        
        JLabel l2 = new JLabel("Time");
        l2.setBounds(10, 50, 200, 20);
        add(l2);
        
        JTextField t2 = new JTextField();
        t2.setBounds(150, 50, 100, 20);
        add(t2);
        
        JLabel l3 = new JLabel("Interest Rate");
        l3.setBounds(10, 80, 200, 20);
        add(l3);
        
        JTextField t3 = new JTextField();
        t3.setBounds(150, 80, 100, 20);
        add(t3);
        
        JTextField res = new JTextField("Simple Interest = ");
        res.setBounds(10, 110, 300, 20);
        add(res);
        
        JButton btn = new JButton("Calculate");
        btn.setBounds(10, 130, 200, 20);
        add(btn);
        
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double P = Double.parseDouble(t1.getText());
                int T = Integer.parseInt(t2.getText());
                double R = Double.parseDouble(t3.getText());
                
                double SI = (P*T*R)/100;
                
                res.setText("Simple Interest = " + SI);
            }
        });
        setSize(500, 500);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new SimpleInterest_Swing_3();
    }
}
