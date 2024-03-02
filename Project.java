package project;

import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
public class Project {
    public Project() {
        //our main frame
        JFrame Mainframe=new JFrame("Store Management Software");
        Mainframe.setBounds(0,0,1600,800);
        JLayeredPane layeredPane=new JLayeredPane();
        layeredPane.setBounds(0,0,1600,800);
        layeredPane.setLayout(null);
        ImageIcon background=new ImageIcon("D:\\project\\project\\img\\background.jpg");
        JLabel backimage=new JLabel(background);
        backimage.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
        jdbc c=new jdbc();
        String imagePath="D:\\project\\project\\img\\Store Icon.png";
        c.setCustomIcon(imagePath, Mainframe);
        // Lable for ask admin or user
        JLabel wholable=new JLabel("Who Are You");
        wholable.setBounds(620,320, 300, 50);
        Font labelFont = wholable.getFont();
        wholable.setFont(new Font(labelFont.getName(), Font.BOLD, 40));
        wholable.setForeground(Color.MAGENTA);
        //buttons for admin panel
        JButton Adminbutton=new JButton("Admin");
        Adminbutton.setBounds(800, 400, 100, 50);
        
        Adminbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InAccount obj1=new InAccount();
            }
        });
        //buttons for user panel
        
        JButton Userbutton=new JButton("User");
        Userbutton.setBounds(600, 400, 100, 50);
        Userbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userin ui=new userin();
            }
        });
        
        layeredPane.add(wholable,JLayeredPane.PALETTE_LAYER);
        layeredPane.add(Adminbutton,JLayeredPane.PALETTE_LAYER);
        layeredPane.add(Userbutton,JLayeredPane.PALETTE_LAYER);
        layeredPane.add(backimage,JLayeredPane.DEFAULT_LAYER);
        Mainframe.add(layeredPane);
        Mainframe.setLayout(null);
        Mainframe.setVisible(true);
        Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    public static void main(String[] args) {
        Project obj=new Project();
        
    }
}
