
package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;

public class userin {
    public userin()
    {
                //Frame for take user account
                JFrame enterenceframe=new JFrame("Store Management System/User Options");
                enterenceframe.setBounds(620, 280, 300, 400);
                JLayeredPane layeredPane=new JLayeredPane();
                layeredPane.setBounds(0,0,300,400);
                layeredPane.setLayout(null);
                ImageIcon background=new ImageIcon("D:\\\\project\\\\project\\\\img\\\\backuser.jpg");
                JLabel backimage=new JLabel(background);
                backimage.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
                jdbc oj=new jdbc();
                String imagePath="D:\\project\\project\\img\\Store Icon.png";
                oj.setCustomIcon(imagePath, enterenceframe);
                //buttons for in
                JButton login,signin;
                //login button
                login=new JButton("Log In");
                login.setBounds(100, 100, 100, 50);
                login.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                         //loginpanel (frame for loging in)
                        JFrame Loginpanel=new JFrame("Store Management System/User Log In");
                        Loginpanel.setBounds(620, 280, 300, 400);
                        JLayeredPane layeredPane=new JLayeredPane();
                        layeredPane.setBounds(0,0,300,400);
                        layeredPane.setLayout(null);
                        ImageIcon background=new ImageIcon("D:\\project\\project\\img\\backuser.jpg");
                        JLabel backimage=new JLabel(background);
                        backimage.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
                        String imagePath="D:\\project\\project\\img\\Store Icon.png";
                        oj.setCustomIcon(imagePath, Loginpanel);
                        //Lables for Your information
                        JLabel username,password,stocklid,account;
                        username=new JLabel("UserName:");
                        username.setBounds(10, 10, 100, 20);
                        password=new JLabel("Password:");
                        password.setBounds(10, 40, 100, 20);
                        stocklid=new JLabel("StockID:");
                        stocklid.setBounds(10, 70, 100, 20);
                        account=new JLabel("Account:");
                        account.setBounds(10, 100, 100, 20);
                        //Textfields For Feel Information
                        JTextField usernametext,stockidtext;
                        JPasswordField passwordtext;
                        usernametext =new JTextField();
                        usernametext.setBounds(130, 10,100, 20);
                        passwordtext =new JPasswordField();
                        passwordtext.setBounds(130, 40,100, 20);
                        stockidtext =new JTextField();
                        stockidtext.setBounds(130, 70,100, 20);
                        JLabel laccounttext=new JLabel("   User");
                        Border border=BorderFactory.createLineBorder(Color.black);
                        laccounttext.setBorder(border);
                        laccounttext.setBackground(Color.white);
                        laccounttext.setOpaque(true);
                        laccounttext.setBounds(130, 100, 100, 20);
                        //buttons for operations
                        JButton submit,clear;
                        submit=new JButton("Log In");
                        submit.setBounds(20, 130, 100, 50);
                        //Lable for giving msj of wrong value warning
                        JLabel linfo=new JLabel("");
                        linfo.setBounds(50, 200, 300, 50);
                        //Submit(log in) button opration
                        submit.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) 
                            {
                                String usernam,pass,stockid,acctype;
                                usernam=usernametext.getText();
                                pass=passwordtext.getText();
                                stockid=stockidtext.getText();
                                acctype="User";
                                if(usernam.isEmpty())
                                {
                                    linfo.setText("Please Fill the User name");
                                }
                                else if(pass.isEmpty())
                                {
                                    linfo.setText("Enter the Password");
                                }
                                else if(stockid.isEmpty())
                                {
                                    linfo.setText("Stock Id is Required");
                                }
                                else{
                                    jdbc o=new jdbc();
                                o.findacc(usernam, pass, stockid, acctype,linfo,enterenceframe,Loginpanel);
                                
                                }
                                Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    linfo.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();

                            }
                        });
                        //Clear button and it's operation
                        clear=new JButton("Clear");
                        clear.setBounds(130, 130, 100, 50);
                        clear.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) 
                            {
                                usernametext.setText("");
                                passwordtext.setText("");        
                                stockidtext.setText("");
                            }
                        });
                        // Adding components in login frame(loginpanel)
                        layeredPane.add(submit,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(linfo,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(clear,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(username,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(password,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(stocklid,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(account,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(usernametext,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(passwordtext,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(stockidtext,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(laccounttext,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(backimage,JLayeredPane.DEFAULT_LAYER);
                Loginpanel.add(layeredPane);
                Loginpanel.setLayout(null);
                Loginpanel.setVisible(true);
                Loginpanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    }
                });
                //Lable for what operation you want to do
                JLabel or=new JLabel("--Or--");
                or.setBounds(133, 150, 100, 20);
                //signin button
                signin=new JButton("Sign In");
                signin.setBounds(100, 170, 100, 50);
                signin.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {   
                         //signinpanel (frame for sign in)
                JFrame Signpanel=new JFrame("Store Management System/User Sign In");
                Signpanel.setBounds(620, 280, 300, 400);
                JLayeredPane layeredPane=new JLayeredPane();
                        layeredPane.setBounds(0,0,300,400);
                        layeredPane.setLayout(null);
                        ImageIcon background=new ImageIcon("D:\\\\project\\\\project\\\\img\\\\backuser.jpg");
                        JLabel backimage=new JLabel(background);
                        backimage.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
                String imagePath="D:\\project\\project\\img\\Store Icon.png";
                oj.setCustomIcon(imagePath, Signpanel);
                //Lables for Your information
                JLabel susername,spassword,sstocklid,saccount,cpassword;
                susername=new JLabel("UserName:");
                susername.setBounds(10, 10, 100, 20);
                spassword=new JLabel("Password:");
                spassword.setBounds(10, 40, 100, 20);
                cpassword=new JLabel("Confirm Password:");
                cpassword.setBounds(10, 70, 120, 20);
                sstocklid=new JLabel("StockID:");
                sstocklid.setBounds(10, 100, 100, 20);
                saccount=new JLabel("Account:");
                saccount.setBounds(10, 130, 100, 20);
                //Textfields For Feel Information
                JTextField susernametext,sstockidtext;
                JPasswordField spasswordtext,cpasswordtext;
                susernametext =new JTextField();
                susernametext.setBounds(120, 10,100, 20);
                spasswordtext =new JPasswordField();
                spasswordtext.setBounds(120, 40,100, 20);
                cpasswordtext =new JPasswordField();
                cpasswordtext.setBounds(120, 70,100, 20);
                sstockidtext =new JTextField();
                sstockidtext.setBounds(120, 100,100, 20);
                JLabel laccounttext=new JLabel("   User");
                
                Border border=BorderFactory.createLineBorder(Color.black);
                laccounttext.setBorder(border);
                laccounttext.setBackground(Color.white);
                laccounttext.setOpaque(true);
                laccounttext.setBounds(120,130,100,20);
                //buttons for operation
                JButton ssubmit,sclear;
                ssubmit=new JButton("Sign In");
                ssubmit.setBounds(20, 160, 100, 50);
                JLabel info=new JLabel("");
                info.setBounds(40, 250, 300, 30);
                ssubmit.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String usernamevalue,passvalue,cpasvalue,stockidvalue,accvalue;
                        usernamevalue=susernametext.getText();
                        passvalue=spasswordtext.getText();
                        cpasvalue=cpasswordtext.getText();
                        stockidvalue=sstockidtext.getText();
                        accvalue="User";
                        if(usernamevalue.isEmpty())
                                {
                                    info.setText("Please Fill the User name");
                                }
                                else if(passvalue.isEmpty())
                                {
                                    info.setText("Enter the Password");
                                }
                                else if(cpasvalue.isEmpty())
                                {
                                    info.setText("Confirm Your Password");
                                }
                                else if(stockidvalue.isEmpty())
                                {
                                    info.setText("Stock Id is Required");
                                }
                                
                                else{
                                    jdbc obj=new jdbc();    
                        obj.insertacc(usernamevalue, passvalue, cpasvalue, stockidvalue, accvalue,info);
                                }
                        Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    info.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
                        susernametext.setText("");
                        spasswordtext.setText("");
                        cpasswordtext.setText("");
                        sstockidtext.setText("");
                        }
                });
                //Clear button to clean the fields
                sclear=new JButton("Clear");
                sclear.setBounds(130, 160, 100, 50);
                sclear.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        susernametext.setText("");
                        spasswordtext.setText("");
                        cpasswordtext.setText("");
                        sstockidtext.setText("");
                           
                    }
                });
                //Adding components to frame(sign in panel)
                layeredPane.add(ssubmit,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(sclear,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(susername,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(spassword,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(cpassword,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(sstocklid,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(info,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(saccount,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(susernametext,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(spasswordtext,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(cpasswordtext,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(sstockidtext,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(laccounttext,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(backimage,JLayeredPane.DEFAULT_LAYER);
                Signpanel.add(layeredPane);
                Signpanel.setLayout(null);
                Signpanel.setVisible(true);
                Signpanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    
                    }
                });
                //Adding components in frame
                layeredPane.add(login,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(or,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(signin,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(backimage,JLayeredPane.DEFAULT_LAYER);
                enterenceframe.add(layeredPane);
                enterenceframe.setLayout(null);
                enterenceframe.setVisible(true);
                
                
    }
    
}
