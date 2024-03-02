package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;


public class UserPanel {

    public UserPanel(String username) {
        //Main Userframe for UserPanel
        JFrame Userframe=new JFrame("Store Management System/User Panel");
        Userframe.setBounds(0,0,1600,800);
        JLayeredPane layeredPane=new JLayeredPane();
        layeredPane.setBounds(0,0,1600,800);
        layeredPane.setLayout(null);
        ImageIcon panelback=new ImageIcon("D:\\project\\project\\img\\Panelback.jpg");
        JLabel backpanel=new JLabel(panelback);
        backpanel.setBounds(0,0,1600,800);
        //Lablel and Panel for Main stock table
        JLabel mainstocklable=new JLabel("Main Stock Table:-");
        JPanel mainstocktablepanel=new JPanel();
        mainstocklable.setBounds(10, 0, 400, 50);
        mainstocklable.setFont(new Font(mainstocklable.getName(),Font.PLAIN,20));
        mainstocktablepanel.setBounds(1100, 100, 400, 300);
        mainstocktablepanel.setBackground(Color.MAGENTA);
        mainstocktablepanel.setLayout(null);
        //calling data fuction from jdbc
        jdbc oj=new jdbc();
        String tablename="product";
        oj.selectdata(mainstocktablepanel,tablename);
        String imagePath="D:\\project\\project\\img\\Store Icon.png";
        oj.setCustomIcon(imagePath, Userframe);
        //refresh button for main stock
        JButton mainrefresh=new JButton("Refresh");
        mainrefresh.setBounds(150, 255, 100, 40);
        mainrefresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                jdbc oj=new jdbc();
                String tablename="product";
                oj.selectdata(mainstocktablepanel,tablename);
            }
        });
        //Sidebar Panel for Userpanel
        JPanel Sidebar=new JPanel();
        Sidebar.setBounds(0, 0, 300, 800);
        Sidebar.setBackground(Color.ORANGE);
        Sidebar.setLayout(null);
        //buttons,panels and lables with sidebar
        JButton myitems,Requestforissue,submitbutton,yourreq,exitbutton;
        JPanel myitemspanel,Requestforissuepanel,submitpanel,issuereqpanel,submitreqpanel;
        JPanel myitemspanel1=new JPanel();
        
        
        myitemspanel = new JPanel();
        Requestforissuepanel = new JPanel();
        submitpanel = new JPanel();
        issuereqpanel = new JPanel();
        submitreqpanel = new JPanel();
        // My Items Button
        myitems=new JButton("My Items");
        myitems.setBounds(100, 100, 100, 30);
        myitems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel myItemslable;
                myItemslable=new JLabel("Your Items:-");
                myItemslable.setBounds(5, 0, 400, 50);
                myItemslable.setFont(new Font(myItemslable.getName(),Font.PLAIN,20));
                myitemspanel.setBounds(400, 100, 400, 400);
                myitemspanel.setBackground(Color.CYAN);
                myitemspanel.setLayout(null);
                String tablename="issueditems";
                jdbc j=new jdbc();
                j.selectuser(username, myitemspanel, tablename);
                //Refresh button for Your items
                JButton mrefresh=new JButton("Refresh");
                mrefresh.setBounds(150, 260, 100, 50);
                
                mrefresh.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        String tablename="issueditems";
                        jdbc j=new jdbc();
                        j.selectuser(username, myitemspanel, tablename);
                    }
                });
                //Adding components in myitemspanel
                myitemspanel.add(myItemslable);
                myitemspanel.add(mrefresh);
                //Add components of myitemsbutton to userframe
                
                layeredPane.add(myitemspanel,JLayeredPane.PALETTE_LAYER);
                mainstocktablepanel.setVisible(true);
                mainstocklable.setVisible(true);
                //Remove other components
                layeredPane.remove(submitpanel);
                layeredPane.remove(Requestforissuepanel);
                layeredPane.remove(myitemspanel1);
                layeredPane.remove(issuereqpanel);
                layeredPane.remove(submitreqpanel);
                layeredPane.repaint();
            }
        });
        //Button for request to a new item
        Requestforissue=new JButton("Request to Issue");
        Requestforissue.setBounds(100, 250, 100, 30);
        Requestforissue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //requestpanel
                Requestforissuepanel.setBounds(400, 100, 400, 400);
                Requestforissuepanel.setBackground(Color.lightGray);
                Requestforissuepanel.setLayout(null);
                //Lables for give info
                JLabel reqforissue,rusername,item,quantity,rate,type,info;
                reqforissue=new JLabel("Request For Issue Items:-");
                reqforissue.setBounds(10, 10, 400, 50);
                reqforissue.setFont(new Font(reqforissue.getName(),Font.PLAIN,30));
                rusername=new JLabel("User Name:");
                rusername.setBounds(10, 70, 150, 20);
                rusername.setFont(new Font(rusername.getName(),Font.PLAIN,20));
                item=new JLabel("Item:");
                item.setBounds(10, 100, 150, 20);
                item.setFont(new Font(item.getName(),Font.PLAIN,20));
                quantity=new JLabel("Quantity:");
                quantity.setBounds(10, 130, 150, 20);
                quantity.setFont(new Font(quantity.getName(),Font.PLAIN,20));
                rate=new JLabel("Rate:");
                rate.setBounds(10, 160, 150, 20);
                rate.setFont(new Font(rate.getName(),Font.PLAIN,20));
                type=new JLabel("Type:");
                type.setBounds(10, 190, 150, 20);
                type.setFont(new Font(type.getName(),Font.PLAIN,20));
                info=new JLabel("");
                info.setBounds(100, 280, 400, 20);
                info.setFont(new Font(info.getName(),Font.PLAIN,20));
                //Text field for feel info
                JTextField quantitytext;
                JLabel ratetext;
                JLabel rtusernametext=new JLabel(username);
                rtusernametext.setBounds(150, 70, 200, 25);
                rtusernametext.setFont(new Font(rtusernametext.getName(),Font.PLAIN,20));
                Border border=BorderFactory.createLineBorder(Color.black);
                rtusernametext.setBorder(border);
                rtusernametext.setBackground(Color.white);
                rtusernametext.setOpaque(true);
                List<String> op = new ArrayList<>();
                JComboBox<String> itemtext=new JComboBox<>(op.toArray(new String[0]));
                itemtext.setBounds(150, 100, 200, 25);
                itemtext.setFont(new Font(itemtext.getName(),Font.PLAIN,20));
                
                
                quantitytext=new JTextField();
                quantitytext.setBounds(150, 130, 200, 25);
                quantitytext.setFont(new Font(quantitytext.getName(),Font.PLAIN,20));
                
                ratetext=new JLabel();
                ratetext.setBounds(150, 160, 200, 25);
                ratetext.setFont(new Font(ratetext.getName(),Font.PLAIN,20));
                ratetext.setBorder(border);
                ratetext.setBackground(Color.white);
                ratetext.setOpaque(true);
                String stablename="product";
                jdbc jc=new jdbc();
                jc.suggestions(itemtext, op, stablename,quantitytext,ratetext);
                String[] options={"Returnable","non-Returnable"};
                JComboBox<String> typelist=new JComboBox<>(options);
                typelist.setBounds(150, 190, 100, 25);
                //Buttons for operations
                JButton requestbutton,clearbutton;
                requestbutton=new JButton("Request");
                requestbutton.setBounds(50, 230, 100, 30);
                requestbutton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        String usernames,items,quantitys,rates,type;
                        usernames=rtusernametext.getText();
                        items=(String) itemtext.getSelectedItem();
                        quantitys=quantitytext.getText();
                        rates=ratetext.getText();
                        type=(String)typelist.getSelectedItem();
                        if(quantitys.isEmpty())
                        {
                            info.setText("Eter Quantity");
                              Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    info.setText("");
                }
            });
                        
            time.start();
                        }
                        else if(rates.isEmpty())
                        {
                            info.setText("Enter Rate");
                            
                              Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    info.setText("");
                }
            });
                        
            time.start();
                        }
                        else{
                            jdbc d=new jdbc();
                        d.insertrequest(usernames, items, quantitys, rates,type, info);
                        }
                        
                    }
                });
                clearbutton=new JButton("Clear");
                clearbutton.setBounds(200, 230, 100, 30);
                clearbutton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
//                        rtusernametext.setText("");
                        //itemtext.setText("");
                        quantitytext.setText("");
                        ratetext.setText("");
                    }
                });
                //Components in Panel
                Requestforissuepanel.add(reqforissue);
                Requestforissuepanel.add(rusername);
                Requestforissuepanel.add(item);
                Requestforissuepanel.add(quantity);
                Requestforissuepanel.add(rate);
                Requestforissuepanel.add(type);
                Requestforissuepanel.add(info);
                Requestforissuepanel.add(ratetext);
                Requestforissuepanel.add(rtusernametext);
                Requestforissuepanel.add(itemtext);
                Requestforissuepanel.add(quantitytext);
                Requestforissuepanel.add(ratetext);              
                Requestforissuepanel.add(typelist);
                Requestforissuepanel.add(requestbutton);
                Requestforissuepanel.add(clearbutton);
                //Add components in userframe
                layeredPane.add(Requestforissuepanel,JLayeredPane.PALETTE_LAYER);
                mainstocktablepanel.setVisible(true);
                mainstocklable.setVisible(true);
                //Remove other components
                layeredPane.remove(myitemspanel1);
                layeredPane.remove(submitpanel);
                layeredPane.remove(issuereqpanel);
                layeredPane.remove(submitreqpanel);
//                Userframe.remove(myItemslable);
                layeredPane.remove(myitemspanel);
                layeredPane.repaint();
            }
        });
        //Button for submit your items to store
        submitbutton=new JButton("Submit");
        submitbutton.setBounds(100, 400, 100, 30);
        submitbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //submit panel for details for submit item
                submitpanel.setBounds(400, 100, 400, 400);
                submitpanel.setBackground(Color.pink);
                submitpanel.setLayout(null);
                //Lables for give info
                JLabel sreqforissue,susername,sitem,squantity,srate,sinfo;
                sreqforissue=new JLabel("Request For Submit Items:-");
                sreqforissue.setBounds(10, 10, 400, 50);
                sreqforissue.setFont(new Font(sreqforissue.getName(),Font.PLAIN,30));
                susername=new JLabel("User Name:");
                susername.setBounds(10, 70, 150, 20);
                susername.setFont(new Font(susername.getName(),Font.PLAIN,20));
                sitem=new JLabel("Item:");
                sitem.setBounds(10, 100, 150, 20);
                sitem.setFont(new Font(sitem.getName(),Font.PLAIN,20));
                squantity=new JLabel("Quantity:");
                squantity.setBounds(10, 130, 150, 20);
                squantity.setFont(new Font(squantity.getName(),Font.PLAIN,20));
                srate=new JLabel("Rate:");
                srate.setBounds(10, 160, 150, 20);
                srate.setFont(new Font(srate.getName(),Font.PLAIN,20));
                sinfo=new JLabel("");
                sinfo.setBounds(100, 280, 400, 20);
                sinfo.setFont(new Font(sinfo.getName(),Font.PLAIN,20));
                //Text field for feel info
                JTextField squantitytext;
                JLabel sratetext;
                JLabel susernametext=new JLabel(username);
                susernametext.setBounds(150, 70, 200, 25);
                Border border=BorderFactory.createLineBorder(Color.black);
                susernametext.setBorder(border);
                susernametext.setBackground(Color.white);
                susernametext.setOpaque(true);
                susernametext.setFont(new Font(susernametext.getName(),Font.PLAIN,20));
                List<String> op = new ArrayList<>();
                JComboBox<String> sitemtext=new JComboBox<>(op.toArray(new String[0]));
                sitemtext.setFont(new Font(sitemtext.getName(),Font.PLAIN,20));
                String stablename="issueditems";
                
                sitemtext.setBounds(150, 100, 200, 25);
                sitemtext.setFont(new Font(sitemtext.getName(),Font.PLAIN,20));
                squantitytext=new JTextField();
                squantitytext.setBounds(150, 130, 200, 25);
                squantitytext.setFont(new Font(squantitytext.getName(),Font.PLAIN,20));
                sratetext=new JLabel();
                sratetext.setBounds(150, 160, 200, 25);
                sratetext.setFont(new Font(sratetext.getName(),Font.PLAIN,20));
                sratetext.setBorder(border);
                sratetext.setBackground(Color.white);
                sratetext.setOpaque(true);
                jdbc jc=new jdbc();
                jc.suggestuseritems(stablename, op, sitemtext, susernametext,squantitytext,sratetext);
                //Button for submit your items to store
                JButton ssubmitbutton,sclearbutton;
                ssubmitbutton=new JButton("Request");
                ssubmitbutton.setBounds(50, 230, 100, 30);
                ssubmitbutton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        String usernames,items,quantitys,rates;
                        usernames=susernametext.getText();
                        items=(String) sitemtext.getSelectedItem();
                        quantitys=squantitytext.getText();
                        rates=sratetext.getText();
                        if(quantitys.isEmpty())
                        {
                            sinfo.setText("Enter Quantity");
                            Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sinfo.setText("");
                }
            });
                        
            time.start();
                        }
                        else{
                            jdbc d=new jdbc();
                        d.insertsubmitrequest(usernames, items, quantitys, rates, sinfo);
                        }
                        
                    }
                });
                sclearbutton=new JButton("Clear");
                sclearbutton.setBounds(200, 230, 100, 30);
                sclearbutton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
//                        susernametext.setText("");
//                        sitemtext.setText("");
                        squantitytext.setText("");
                        sratetext.setText("");
                    }
                });
                //Components in Panel
                submitpanel.add(sreqforissue);
                submitpanel.add(susername);
                submitpanel.add(sitem);
                submitpanel.add(squantity);
                submitpanel.add(srate);
                submitpanel.add(sinfo);
                submitpanel.add(sratetext);
                submitpanel.add(susernametext);
                submitpanel.add(sitemtext);
                submitpanel.add(squantitytext);
                submitpanel.add(sratetext);              
                submitpanel.add(ssubmitbutton);
                submitpanel.add(sclearbutton);
                //your item carried panel
                myitemspanel1.setBounds(1110, 100, 400, 300);
                myitemspanel1.setBackground(Color.magenta);
                myitemspanel1.setLayout(null);
                JLabel mylabel=new JLabel("Your Items:-");
                mylabel.setBounds(10, 0, 400, 40);
                mylabel.setFont(new Font(mylabel.getName(),Font.PLAIN,30));
                String tablename="issueditems";
                jdbc j=new jdbc();
                j.selectuser(username, myitemspanel1, tablename);
                //Refresh button for Your items
                JButton mrefresh=new JButton("Refresh");
                mrefresh.setBounds(150, 255, 100, 40);
                
                mrefresh.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        String tablename="issueditems";
                        jdbc j=new jdbc();
                        j.selectuser(username, myitemspanel, tablename);
                    }
                });
                
                //Add components in myitemspanel1
                myitemspanel1.add(mylabel);
                myitemspanel1.add(mrefresh);
                //Add component in userframe
                layeredPane.add(submitpanel,JLayeredPane.PALETTE_LAYER);
                
                layeredPane.add(myitemspanel1,JLayeredPane.PALETTE_LAYER);
                //Remove component form userframe
                mainstocktablepanel.setVisible(false);
                mainstocklable.setVisible(false);
                layeredPane.remove(Requestforissuepanel);              
//                Userframe.remove(myItemslable);
                layeredPane.remove(myitemspanel);
                layeredPane.remove(issuereqpanel);
                layeredPane.remove(submitreqpanel);
                layeredPane.repaint();
            }
        });
        //your request button
        yourreq=new JButton("Your Request");
        yourreq.setBounds(100, 550, 100, 30);
        yourreq.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //item request panel
                issuereqpanel.setBounds(400, 100, 400, 400);
                issuereqpanel.setBackground(Color.pink);
                issuereqpanel.setLayout(null);
                jdbc jb=new jdbc();
                String rtablename="requesttable";
                jb.selectuser(username, issuereqpanel, rtablename);
                JLabel iylabel=new JLabel("You Requested for items:-");
                iylabel.setBounds(10, 0, 400, 40);
                iylabel.setFont(new Font(iylabel.getName(),Font.PLAIN,30));
                JButton irefresh=new JButton("Refresh");
                irefresh.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String rtablename="requesttable";
                jb.selectuser(username, issuereqpanel, rtablename);
                    }
                });
                irefresh.setBounds(150,260,80,30);
                //add component in issuerequestpanel
                issuereqpanel.add(iylabel);
                issuereqpanel.add(irefresh);
                //submit request panel
                submitreqpanel.setBounds(1100, 100, 400, 300);
                submitreqpanel.setBackground(Color.MAGENTA);
                submitreqpanel.setLayout(null);
                JLabel ilabel=new JLabel("Submission Requests:-");
                ilabel.setBounds(10, 0, 400, 40);
                ilabel.setFont(new Font(iylabel.getName(),Font.PLAIN,30));
                String stablename="submitreq";
                jb.selectuser(username, submitreqpanel, stablename);
                JButton srefresh=new JButton("Refresh");
                srefresh.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String stablename="submitreq";
                jb.selectuser(username, submitreqpanel, stablename);
                    }
                });
                srefresh.setBounds(150,260,80,30);
                submitreqpanel.add(ilabel);
                submitreqpanel.add(srefresh);
                //add panel in frame
                layeredPane.add(issuereqpanel,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(submitreqpanel,JLayeredPane.PALETTE_LAYER);
                //remove components from panel
                mainstocktablepanel.setVisible(false);
                mainstocklable.setVisible(false);
                layeredPane.remove(Requestforissuepanel);              
                layeredPane.remove(myitemspanel);
                layeredPane.remove(submitpanel);
                layeredPane.remove(myitemspanel1);
                
                
                layeredPane.repaint();
            }
        });
        //exit button
        exitbutton=new JButton("Exit");
        exitbutton.setBounds(100, 700, 100, 30);
        exitbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
                int r=JOptionPane.showConfirmDialog(null, "Exit ?",null,JOptionPane.YES_NO_OPTION);
                if(r==JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
        });
        //Add buttons in sidebar
        Sidebar.add(myitems);
        Sidebar.add(Requestforissue);
        Sidebar.add(submitbutton);
        Sidebar.add(yourreq);
        Sidebar.add(exitbutton);
        //Add components in frame
        

        
        mainstocktablepanel.add(mainstocklable);
        mainstocktablepanel.add(mainrefresh);
        layeredPane.add(mainstocktablepanel,JLayeredPane.PALETTE_LAYER);
        layeredPane.add(Sidebar,JLayeredPane.PALETTE_LAYER);
        layeredPane.add(backpanel,JLayeredPane.DEFAULT_LAYER);
        Userframe.add(layeredPane);
        Userframe.setLayout(null);
        Userframe.setVisible(true);
        Userframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        UserPanel u=new UserPanel("user");
    }
}
