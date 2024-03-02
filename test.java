
package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("text frame");
        frame.setLayout(null);
        frame.setBounds(0, 0, 1000, 700);
        JLabel lable=new JLabel("data");
        JTextField text=new JTextField();
        JLabel lable1=new JLabel("quantity");
        JTextField text1=new JTextField();
        JButton button =new JButton("submit");
        lable.setBounds(10, 10, 100, 50);
        text.setBounds(110, 10, 100, 50);
        lable1.setBounds(10, 60, 100, 50);
        text1.setBounds(110, 60, 100, 50);
        button.setBounds(60, 110, 100, 50);
        
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    jdbc j=new jdbc();
                    String value=text.getText();
                    String value1=text1.getText();
                    j.test(value,value1);
                    
                    
                } catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
            }
        });
        frame.add(text);
        frame.add(lable);
        frame.add(text1);
        frame.add(lable1);
        frame.add(button);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
