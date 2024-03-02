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


class AdminPanel {
    
    public AdminPanel() {
        JFrame Adminframe=new JFrame("Store Management System/Admin Panel");
        Adminframe.setBounds(0,0,1600,800);
        JLayeredPane layeredPane=new JLayeredPane();
        layeredPane.setBounds(0,0,1600,800);
        layeredPane.setLayout(null);
        ImageIcon panelback=new ImageIcon("D:\\project\\project\\img\\Panelback.jpg");
        JLabel backpanel=new JLabel(panelback);
        backpanel.setBounds(0,0,1600,800);
        //panel for carry main stock table
        JLabel hed=new JLabel("Requests form Users:-");
        JLabel msjh=new JLabel("Requests For Submit From User:-");
        JPanel mainstocktablepanel=new JPanel();
        
        //Panels for Sidebar button operations
        JPanel newstockpanel,issuepanel,submitpanel,submitpanel1,issueditemstablepanel,issueditemstablepanel1,requserpanel,accounttablepanel,soldoutitemspanel;
        newstockpanel=new JPanel();
        issuepanel=new JPanel();
        submitpanel=new JPanel();
        submitpanel1=new JPanel();
        requserpanel=new JPanel();
        accounttablepanel=new JPanel();
        soldoutitemspanel=new JPanel();
        JPanel requesttablepanel=new JPanel();
        issueditemstablepanel=new JPanel();
        issueditemstablepanel1=new JPanel();
        //Lable for main stock table
        JLabel mainstocklable=new JLabel("Main Stock Table:-");
        mainstocklable.setBounds(1110, 150, 400, 50);
        mainstocklable.setFont(new Font(mainstocklable.getName(),Font.PLAIN,20));
        //panel for main stock table
        mainstocktablepanel.setBounds(1100, 150, 400, 320);
        mainstocktablepanel.setBackground(Color.magenta);
        mainstocktablepanel.setLayout(null);
        jdbc oj=new jdbc();
        String mtablename="product";
        oj.selectdata(mainstocktablepanel,mtablename);
        String imagePath="D:\\project\\project\\img\\Store Icon.png";
        oj.setCustomIcon(imagePath, Adminframe);
        //Refresh button for main stock table
        JButton mainrefresh=new JButton("Refresh");
        mainrefresh.setBounds(1250, 410, 100, 50);
        mainrefresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                oj.selectdata(mainstocktablepanel, mtablename);
            }
        });
        mainrefresh.setVisible(true);
        //Sidebar for Admin Panel
        JPanel Sidebar=new JPanel();
        Sidebar.setBounds(0, 0, 300, 800);
        Sidebar.setBackground(Color.orange);
        Sidebar.setLayout(null);
        //buttons in sidebar
        JButton newstockbutton,issuebutton,submitbutton,approvels,soldout,exitbutton;
        
        
        //New stock button
        newstockbutton=new JButton("New Stock");
        newstockbutton.setBounds(100, 80, 100, 30);
        newstockbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //panel for new stock table and operations
               
               newstockpanel.setBounds(400, 100, 650, 420);
               newstockpanel.setBackground(Color.cyan);
               //Refreshing data
               jdbc j=new jdbc();
               String netablename="newstocktable";
               j.selectdata(newstockpanel, netablename);
               String mtablename="product";
               j.selectdata(newstockpanel, mtablename);
               String rtablename="requesttable";
               j.selectdatafromrequesttable(requesttablepanel, rtablename);
               String stablename="submitreq";
               j.selectdatafromsubmittable(submitpanel1, stablename);
               String itablename="issueditems";
               j.selectdatafromissuedtable(issueditemstablepanel1, itablename);
               String retablename="requsers";
               j.requser(requserpanel, retablename);
               String atablename="account";
               j.requser(accounttablepanel, atablename);
               j.selectdatafromnonissuedtable(soldoutitemspanel, itablename);
               //lable for new stock table
               JLabel newstocktablelable=new JLabel("New Stcok Table:-");
               newstocktablelable.setBounds(10, 10, 300, 40);
               newstocktablelable.setFont(new Font(newstocktablelable.getName(),Font.PLAIN,20));
               //lable for info of add new stock
               JLabel msj=new JLabel("Add New Stock:-");
               msj.setBounds(10, 210, 300, 40);              
               Font msjlablefont=msj.getFont();
               msj.setFont(new Font(msjlablefont.getName(),Font.PLAIN,20));
               //Lables for product info
               JLabel  itemlabel,quantitylable,ratelable;
               itemlabel=new JLabel("Item:");
               itemlabel.setFont(new Font(itemlabel.getName(),Font.PLAIN,15));
               quantitylable=new JLabel("Quantity:");
               quantitylable.setFont(new Font(itemlabel.getName(),Font.PLAIN,15));
               ratelable=new JLabel("Rate:");
               ratelable.setFont(new Font(itemlabel.getName(),Font.PLAIN,15));
               itemlabel.setBounds(10, 250, 100, 20);
               quantitylable.setBounds(10, 310, 100, 20);
               ratelable.setBounds(10, 350, 100, 20);
               //TextFields For Product Information
               JTextField itemtext,quantitytext,ratetext;
               itemtext=new JTextField();
               itemtext.setFont(new Font(itemtext.getName(),Font.PLAIN,15));
               quantitytext=new JTextField();
               quantitytext.setFont(new Font(quantitytext.getName(),Font.PLAIN,15));
               ratetext=new JTextField();
               ratetext.setFont(new Font(ratetext.getName(),Font.PLAIN,15));
               itemtext.setBounds(100, 250, 150, 30);
               String ntablename="product";
               String pname="p_name";
               List<String> options = new ArrayList<>();
               JComboBox<String> nnamesugg=new JComboBox<>(options.toArray(new String[0]));
               nnamesugg.setBounds(100,280,150,20);
               j.itemnamesugg(itemtext, nnamesugg, options, ntablename,pname,quantitytext,ratetext);
               quantitytext.setBounds(100, 310, 150, 30);
               ratetext.setBounds(100, 350, 150, 30);
               //Lable for data submition info in tables
               JLabel submitlable=new JLabel("");
               submitlable.setBounds(400, 270, 200, 50);
               submitlable.setFont(new Font(submitlable.getName(),Font.PLAIN,18));
               //Buttons for operation
               JButton add,clear,refresh,addtomainstock;
               //Add button
               add=new JButton("Add");
               add.setBounds(10, 390, 100, 30);
               add.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) 
                   {
                       String item,quantity,rate;
                       item=itemtext.getText();
                       quantity=quantitytext.getText();
                       rate=ratetext.getText();
                       jdbc jd=new jdbc();
                       if(!item.isEmpty()&&!quantity.isEmpty()&&!rate.isEmpty()&&nnamesugg.getSelectedItem()==null)
                       {
                           System.out.println("typed");
                            jd.insertnewstock(item, quantity, rate,submitlable);
                            itemtext.setText("");
                            quantitytext.setText("");
                            ratetext.setText("");
                       }
                       else if(nnamesugg.getSelectedItem()!=null&&!item.isEmpty()&&!quantity.isEmpty()&&!rate.isEmpty()){
                           System.out.println("selected");
                           jd.updatemainstock(item, quantity,rate,submitlable);
                       }
                       else{
                           if(item.isEmpty())
                           {
                                submitlable.setText("Enter Item");
                           }
                           else if(quantity.isEmpty())
                           {
                               submitlable.setText("Enter Quantity");
                           }
                           else if(rate.isEmpty())
                           {
                               submitlable.setText("Enter rate");
                           }
                            Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    submitlable.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
                       }
                   }
               });
               clear=new JButton("Clear");
               clear.setBounds(150, 390, 100, 30);
               clear.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) { 
                       itemtext.setText("");
                       quantitytext.setText("");
                       ratetext.setText("");
                   }
               });
               JLabel addtomainstocklabel=new JLabel("Add new stock to Main Stock \n table");
               addtomainstocklabel.setBounds(400, 70, 250, 100);
               addtomainstocklabel.setFont(new Font(addtomainstocklabel.getName(),Font.PLAIN,18));
               addtomainstock=new JButton("==>");
               addtomainstock.setBounds(470, 150, 100, 50);
               addtomainstock.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) 
                   {
                       jdbc c=new jdbc();
                       c.insertinmainstock(submitlable);
                   }
               });
               addtomainstock.setFont(new Font(addtomainstock.getName(),Font.PLAIN,30));
               refresh=new JButton("Refresh");
               refresh.setBounds(270, 250, 80, 50);
               refresh.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) 
                   {
                       j.selectdata(newstockpanel, netablename);
                   }
               });
               
               newstockpanel.setLayout(null);
               newstockpanel.setVisible(true);
               //Add Components in newstockpanel
               newstockpanel.add(newstocktablelable);
               newstockpanel.add(addtomainstock);
               newstockpanel.add(refresh);
               newstockpanel.add(submitlable);
               newstockpanel.add(clear);
               newstockpanel.add(add);
               newstockpanel.add(itemtext);
               newstockpanel.add(nnamesugg);
               newstockpanel.add(quantitytext);
               newstockpanel.add(ratetext);
               newstockpanel.add(msj);
               newstockpanel.add(itemlabel);
               newstockpanel.add(quantitylable);
               newstockpanel.add(ratelable);
               //Panels in Adminframe
               mainstocktablepanel.setVisible(true);
               mainstocklable.setVisible(true);
               mainrefresh.setVisible(true);
               newstockpanel.add(addtomainstocklabel);
               layeredPane.add(newstockpanel,JLayeredPane.PALETTE_LAYER);
               //Removing other panels components
               layeredPane.remove(issuepanel);
               layeredPane.remove(submitpanel);
               layeredPane.remove(requesttablepanel);
               layeredPane.remove(issueditemstablepanel1);
               layeredPane.remove(hed);
               layeredPane.remove(issueditemstablepanel);
//               Adminframe.remove(issuehed);
               layeredPane.remove(submitpanel1);
               layeredPane.remove(msjh);
               layeredPane.remove(requserpanel);
               layeredPane.remove(accounttablepanel);
               layeredPane.remove(soldoutitemspanel);
               layeredPane.repaint();
            }
        });
        // Issue Button
        issuebutton=new JButton("Issue");
        issuebutton.setBounds(100, 210, 100, 30);
        issuebutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
               //main issue panel
               issuepanel.setBounds(400, 100, 450, 420);
               issuepanel.setBackground(Color.lightGray);
               issuepanel.setVisible(true);
               issuepanel.setLayout(null);
               //panel for carry requests table
               requesttablepanel.setBounds(0, 50, 450, 200);
               //lable for show request table name
               hed.setBounds(10, 20, 400, 20);
               hed.setFont(new Font(hed.getName(),Font.PLAIN,20));
               
               String netablename="newstocktable";
               oj.selectdata(newstockpanel, netablename);
               String mtablename="product";
               oj.selectdata(newstockpanel, mtablename);
               String rtablename="requesttable";
               oj.selectdatafromrequesttable(requesttablepanel, rtablename);
               String stablename="submitreq";
               oj.selectdatafromsubmittable(submitpanel1, stablename);
               String itablename="issueditems";
               oj.selectdatafromissuedtable(issueditemstablepanel1, itablename);
               String retablename="requsers";
               oj.requser(requserpanel, retablename);
               String atablename="account";
               oj.requser(accounttablepanel, atablename);
               oj.selectdatafromnonissuedtable(soldoutitemspanel, itablename);
               //lables for provide info
               JLabel operationlable,iusername,ipname;
               operationlable=new JLabel("Do Operations With Requests....");
               operationlable.setBounds(10, 250, 400, 30);
               operationlable.setFont(new Font(operationlable.getName(),Font.PLAIN,20));
               iusername=new JLabel("User Name:");
               iusername.setBounds(10, 280, 150, 30);
               iusername.setFont(new Font(iusername.getName(),Font.PLAIN,15));
               ipname=new JLabel("Product Name:");
               ipname.setBounds(10, 340, 150, 30);
               ipname.setFont(new Font(ipname.getName(),Font.PLAIN,15));
               //Textfields for Take info
               JTextField iusernametext,ipnametext;
               List<String> options = new ArrayList<>();
               JComboBox<String> unamesugg=new JComboBox<>(options.toArray(new String[0]));
               unamesugg.setBounds(160,310,150,20);
               
               iusernametext=new JTextField();
               iusernametext.setBounds(160, 280, 150, 30);
               iusernametext.setFont(new Font(iusernametext.getName(),Font.PLAIN,15));
               String sugtablename="requesttable";
               String uname="username";
               
               
               ipnametext=new JTextField();
               ipnametext.setBounds(160, 340, 150, 30);
               ipnametext.setFont(new Font(ipnametext.getName(),Font.PLAIN,15));
               oj.issuereqsug(iusernametext, unamesugg,options,sugtablename,uname,ipnametext);
               //Buttons for operations
               JButton iAccept,idelete,iclear,irefresh;
               iAccept=new JButton("Accept");
               iAccept.setBounds(10, 380, 80, 30);
               JLabel issuesubmitlable=new JLabel("");
               issuesubmitlable.setBounds(320, 300, 200, 30);
               iAccept.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e)
                   {
                       String us,pn;
                       us=iusernametext.getText();
                       pn=ipnametext.getText();
                       if(us.isEmpty())
                       {
                           issuesubmitlable.setText("Enter Username");
                           Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    issuesubmitlable.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
                       }
                       else if(pn.isEmpty())
                       {
                           issuesubmitlable.setText("Enter the Item");
                           Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    issuesubmitlable.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
                       }
                       else{
                           jdbc jd=new jdbc();
                       jd.minusstock(us,pn);
                       jd.reqtoissue(us, pn,issuesubmitlable);
                       jd.deletedatafromrequesttable(us, pn);
                       iusernametext.setText("");
                       ipnametext.setText("");
                       
                       }
                       
                   }
               });
               idelete=new JButton("Delete");
               idelete.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) 
                   {
                       String us,pn;
                       us=iusernametext.getText();
                       pn=ipnametext.getText();
                       jdbc jd=new jdbc();
                       jd.deletedatafromrequesttable(us, pn);
                       iusernametext.setText("");
                       ipnametext.setText("");
                   }
               });
               idelete.setBounds(120, 380, 80, 30);
               iclear=new JButton("Clear");
               iclear.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) { 
                       iusernametext.setText("");
                       ipnametext.setText("");
                       
                   }
               });
               iclear.setBounds(230, 380, 80, 30);
               irefresh=new JButton("Refresh");
               irefresh.setBounds(350, 255, 80, 30);
               irefresh.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) 
                   {
                       String tablename="requesttable";
                       oj.selectdatafromrequesttable(requesttablepanel,tablename);
                   }
               });
               //Adding components in issuepanel
               issuepanel.add(hed);
               issuepanel.add(requesttablepanel);
               issuepanel.add(operationlable);
               issuepanel.add(iusername);
               issuepanel.add(ipname);
               issuepanel.add(iusernametext);
               issuepanel.add(unamesugg);
               issuepanel.add(ipnametext);
               issuepanel.add(iAccept);
               issuepanel.add(idelete);
               issuepanel.add(iclear);
               issuepanel.add(irefresh);
               issuepanel.add(issuesubmitlable);
               //Adding components in Adminframe
               mainstocktablepanel.setVisible(true);
               mainstocklable.setVisible(true);
               mainrefresh.setVisible(true);
               
               
               layeredPane.add(issuepanel,JLayeredPane.PALETTE_LAYER);
               //Removing other panels components
               layeredPane.remove(newstockpanel);
               layeredPane.remove(issueditemstablepanel1);
               layeredPane.remove(issueditemstablepanel);
//               Adminframe.remove(issuehed);
               layeredPane.remove(submitpanel);
               layeredPane.remove(submitpanel1);
               layeredPane.remove(msjh);
               layeredPane.remove(requserpanel);
               layeredPane.remove(accounttablepanel);
               layeredPane.remove(soldoutitemspanel);
               layeredPane.repaint();
            }
        });
        //submit button
        submitbutton=new JButton("Submit");
        submitbutton.setBounds(100, 340, 100, 30);
        submitbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Panel for carry submit table and opration
                submitpanel.setBounds(400, 100, 450, 420);
                submitpanel.setBackground(Color.PINK);
                Border broder=BorderFactory.createLineBorder(Color.black);
                submitpanel.setBorder(broder);
                submitpanel.setVisible(true);
                submitpanel.setLayout(null);
                
                msjh.setBounds(400,110, 400, 30);
                msjh.setFont(new Font(msjh.getName(),Font.PLAIN,20));
                submitpanel1.setBounds(400, 150, 450, 200);
                submitpanel1.setBorder(broder);
                //calling for data
                String netablename="newstocktable";
               oj.selectdata(newstockpanel, netablename);
               String mtablename="product";
               oj.selectdata(newstockpanel, mtablename);
               String rtablename="requesttable";
               oj.selectdatafromrequesttable(requesttablepanel, rtablename);
               String stablename="submitreq";
               oj.selectdatafromsubmittable(submitpanel1, stablename);
               String itablename="issueditems";
               oj.selectdatafromissuedtable(issueditemstablepanel1, itablename);
               String retablename="requsers";
               oj.requser(requserpanel, retablename);
               String atablename="account";
               oj.requser(accounttablepanel, atablename);
               oj.selectdatafromnonissuedtable(soldoutitemspanel, itablename);
                //Panel for carry issued items table
                issueditemstablepanel.setBounds(1050, 100, 450, 300);
                issueditemstablepanel.setBackground(Color.magenta);
                issueditemstablepanel.setBorder(broder);
                issueditemstablepanel.setLayout(null);
                JLabel issuehed =new JLabel("Issued Items:-");
                issuehed.setBounds(10, 10, 400, 20);
                issuehed.setFont(new Font(issuehed.getName(),Font.PLAIN,20));
                //calling for data
                issueditemstablepanel1.setBounds(0, 50, 450, 200);
                String tablename="issueditems";
                oj.selectdatafromissuedtable(issueditemstablepanel1, tablename);
                //refresh button for issued items table
                JButton irefresh=new JButton("Refresh");
                irefresh.setBounds(175, 255, 100, 40);
                irefresh.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        String stablename="issueditems";
                        oj.selectdatafromissuedtable(issueditemstablepanel1, stablename);
                    }
                });
                //lables for provide info
               JLabel soperationlable,susername,spname;
               soperationlable=new JLabel("Do Operations With Requests....");
               soperationlable.setBounds(10, 250, 400, 30);
               soperationlable.setFont(new Font(soperationlable.getName(),Font.PLAIN,20));
               susername=new JLabel("User Name:");
               susername.setBounds(10, 280, 150, 30);
               susername.setFont(new Font(susername.getName(),Font.PLAIN,15));
               spname=new JLabel("Product Name:");
               spname.setBounds(10, 340, 150, 30);
               spname.setFont(new Font(spname.getName(),Font.PLAIN,15));
               //Textfields for Take info
               JTextField susernametext,spnametext;
               List<String> options = new ArrayList<>();
               JComboBox<String> sunamesugg=new JComboBox<>(options.toArray(new String[0]));
               sunamesugg.setBounds(160,310,150,20);
               susernametext=new JTextField();
               susernametext.setBounds(160, 280, 150, 30);
               susernametext.setFont(new Font(susernametext.getName(),Font.PLAIN,15));
               String suggtablename="submitreq";
               String suname="username";
               spnametext=new JTextField();
               spnametext.setBounds(160, 340, 150, 30);
               spnametext.setFont(new Font(spnametext.getName(),Font.PLAIN,15));
               oj.issuereqsug(susernametext, sunamesugg, options, suggtablename,suname,spnametext);
               //Buttons for operations
               JButton sAccept,sclear,srefresh;
               sAccept=new JButton("Accept");
               sAccept.setBounds(10, 380, 80, 30);
               JLabel issuesubmitlable=new JLabel("");
               issuesubmitlable.setBounds(320, 300, 200, 30);
               sAccept.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        String use,pna;
                        use=susernametext.getText();
                        pna=spnametext.getText();
                        if(use.isEmpty())
                        {
                            issuesubmitlable.setText("Enter Username");
                            Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   issuesubmitlable.setText("");
                }
            });
            time.start();
                        }
                        else if(pna.isEmpty())
                        {
                            issuesubmitlable.setText("Enter Item");
                            Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   issuesubmitlable.setText("");
                }
            });
            time.start();
                        }
                        else
                        {
                            jdbc jdbc=new jdbc();
                        jdbc.plusmainstock(pna, use);
                        jdbc.acceptsubmitrequest(use, pna,issuesubmitlable);
                        jdbc.plusmainstock(pna, use);
                        susernametext.setText("");
                        spnametext.setText("");
                        }
                        
                    }
                });
               
               
               sclear=new JButton("Clear");
               sclear.setBounds(230, 380, 80, 30);
               sclear.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) { 
                       susernametext.setText("");
                       spnametext.setText("");
                       
                   }
               });
               
               srefresh=new JButton("Refresh");
               srefresh.setBounds(350, 255, 80, 30);
               srefresh.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) 
                   {
                       String tablename="submitreq";
                       oj.selectdatafromsubmittable(submitpanel1,tablename);
                   }
               });
                //main stock invisible
                mainstocktablepanel.setVisible(false);
                mainstocklable.setVisible(false);
                mainrefresh.setVisible(false);
                //Adding components in submitpanel
               submitpanel.add(issuesubmitlable);
               submitpanel.add(soperationlable);
               submitpanel.add(susername);
               submitpanel.add(spname);
               submitpanel.add(susernametext);
               submitpanel.add(sunamesugg);
               submitpanel.add(spnametext);
               submitpanel.add(sAccept);
               
               submitpanel.add(sclear);
               submitpanel.add(srefresh);
               //adding component in issueditemtablepanel
               issueditemstablepanel.add(issueditemstablepanel1);
                issueditemstablepanel.add(issuehed);
                issueditemstablepanel.add(irefresh);
                //add components in frame
                layeredPane.add(msjh,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(issueditemstablepanel,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(submitpanel1,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(submitpanel,JLayeredPane.PALETTE_LAYER);
                //Removing other panels components
                layeredPane.remove(newstockpanel);
                layeredPane.remove(issuepanel);
                layeredPane.remove(requesttablepanel);               
                layeredPane.remove(hed);
                layeredPane.remove(requserpanel);
                layeredPane.remove(accounttablepanel);
                layeredPane.remove(soldoutitemspanel);
                layeredPane.repaint();
                }
        });
        //approvels button
        approvels=new JButton("Approvel");
        approvels.setBounds(100,470,100,30);
        approvels.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                requserpanel.setBounds(400, 100, 450, 420);
                requserpanel.setBackground(Color.PINK);
                Border broder=BorderFactory.createLineBorder(Color.black);
                requserpanel.setBorder(broder);
                requserpanel.setVisible(true);
                requserpanel.setLayout(null);
                //call for data
                String netablename="newstocktable";
               oj.selectdata(newstockpanel, netablename);
               String mtablename="product";
               oj.selectdata(newstockpanel, mtablename);
               String rtablename="requesttable";
               oj.selectdatafromrequesttable(requesttablepanel, rtablename);
               String stablename="submitreq";
               oj.selectdatafromsubmittable(submitpanel1, stablename);
               String itablename="issueditems";
               oj.selectdatafromissuedtable(issueditemstablepanel1, itablename);
               String retablename="requsers";
               oj.requser(requserpanel, retablename);
               String atablename="account";
               oj.requser(accounttablepanel, atablename);
               oj.selectdatafromnonissuedtable(soldoutitemspanel, itablename);
                JLabel assuehed =new JLabel("User Requests:-");
                assuehed.setBounds(10, 10, 400, 20);
                assuehed.setFont(new Font(assuehed.getName(),Font.PLAIN,20));
                //labels 
                JLabel aoperationlable,ausername;
               aoperationlable=new JLabel("Do Operations With Requests....");
               aoperationlable.setBounds(10, 250, 400, 30);
               aoperationlable.setFont(new Font(aoperationlable.getName(),Font.PLAIN,20));
               ausername=new JLabel("User Name:");
               ausername.setBounds(10, 280, 150, 30);
               ausername.setFont(new Font(ausername.getName(),Font.PLAIN,15));
               
               //Textfields for Take info
               JTextField ausernametext;
               List<String> aptions = new ArrayList<>();
               JComboBox<String> aunamesugg=new JComboBox<>(aptions.toArray(new String[0]));
               aunamesugg.setBounds(160,310,150,20);
               ausernametext=new JTextField();
               ausernametext.setBounds(160, 280, 150, 30);
               ausernametext.setFont(new Font(ausernametext.getName(),Font.PLAIN,15));
               String auggtablename="requsers";
               String auname="username";
               oj.userninsugg(ausernametext, aunamesugg, aptions, auggtablename,auname);
               JButton aAccept,aclear,arefresh;
               aAccept=new JButton("Approve");
               aAccept.setBounds(10, 350, 100, 30);
               JLabel infol=new JLabel("");
               infol.setBounds(320, 300, 200, 30);
               aAccept.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        String uuuuu=ausernametext.getText();
                        if(uuuuu.isEmpty())
                        {
                            infol.setText("Enter Username");
                             Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    infol.setText("");
                }
            });
                        
            time.start();
                        }
                        else{
                            jdbc bc=new jdbc();
                        bc.appacc(uuuuu,infol);
                        bc.deletefromrequser(uuuuu);
                        }
                        
                    }
                });
               aclear=new JButton("Clear");
               aclear.setBounds(230, 350, 80, 30);
               aclear.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        ausernametext.setText("");
                    }
                });
               arefresh=new JButton("Refresh");
                arefresh.setBounds(350, 255, 80, 30);
                arefresh.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        jdbc cd=new jdbc();
                        String utablename="requsers";
                        cd.requser(requserpanel, utablename);
                    }
                });
                //acount table
                JLabel acssuehed =new JLabel("User Accounts:-");
                acssuehed.setBounds(10, 10, 400, 20);
                acssuehed.setFont(new Font(acssuehed.getName(),Font.PLAIN,20));
                accounttablepanel.setBounds(1100, 150, 400, 300);
                accounttablepanel.setBackground(Color.magenta);
                accounttablepanel.setLayout(null);
                String tablename="account";
                oj.requser(accounttablepanel, tablename);
                JButton acrefresh=new JButton("Refresh");
                acrefresh.setBounds(150, 255, 80, 30);
                acrefresh.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        jdbc cd=new jdbc();
                        String utablename="account";
                        cd.requser(accounttablepanel, utablename);
                    }
                });
                //add compnents in panel
                requserpanel.add(infol);
                requserpanel.add(assuehed);
                requserpanel.add(aAccept);
                requserpanel.add(aclear);
                requserpanel.add(arefresh);
                requserpanel.add(aoperationlable);
                requserpanel.add(ausername);
                requserpanel.add(aunamesugg);
                requserpanel.add(ausernametext);
                accounttablepanel.add(acrefresh);
                accounttablepanel.add(acssuehed);
                //add panel in frame
                layeredPane.add(requserpanel,JLayeredPane.PALETTE_LAYER);
                layeredPane.add(accounttablepanel,JLayeredPane.PALETTE_LAYER);
                //main stock invisible
                mainstocktablepanel.setVisible(false);
                mainstocklable.setVisible(false);
                mainrefresh.setVisible(false);
                //Removing other panels components
                layeredPane.remove(newstockpanel);
                layeredPane.remove(issuepanel);
                layeredPane.remove(requesttablepanel);               
                layeredPane.remove(hed);
                layeredPane.remove(submitpanel);
               layeredPane.remove(submitpanel1);
               layeredPane.remove(issueditemstablepanel);
               layeredPane.remove(msjh);
               layeredPane.remove(soldoutitemspanel);
                layeredPane.repaint();
                
            }
        });
        //sold out button
        soldout=new JButton("Sold Out");
        soldout.setBounds(100, 600, 100, 30);
        soldout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                soldoutitemspanel.setBounds(400, 150, 450, 300);
               soldoutitemspanel.setBackground(Color.cyan);
               soldoutitemspanel.setLayout(null);
               String netablename="newstocktable";
               oj.selectdata(newstockpanel, netablename);
               String mtablename="product";
               oj.selectdata(newstockpanel, mtablename);
               String rtablename="requesttable";
               oj.selectdatafromrequesttable(requesttablepanel, rtablename);
               String stablename="submitreq";
               oj.selectdatafromsubmittable(submitpanel1, stablename);
               String itablename="issueditems";
               oj.selectdatafromissuedtable(issueditemstablepanel1, itablename);
               String retablename="requsers";
               oj.requser(requserpanel, retablename);
               String atablename="account";
               oj.requser(accounttablepanel, atablename);
               oj.selectdatafromnonissuedtable(soldoutitemspanel, itablename);
                JLabel sol=new JLabel("Recently Sold Out Items:-");
                sol.setBounds(10, 0, 300, 50);
                sol.setFont(new Font(sol.getName(),Font.PLAIN,20));
                
                JButton refresh,delete;
                refresh=new JButton("Refresh");
                delete=new JButton("Delete History");
                refresh.setBounds(100, 260, 100, 30);
                delete.setBounds(250, 260, 150, 30);
                refresh.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        oj.selectdatafromnonissuedtable(soldoutitemspanel, stablename);
                    }
                });
                delete.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        oj.deletesoldhistory();
                    }
                });
                soldoutitemspanel.add(sol);
                soldoutitemspanel.add(refresh);
                soldoutitemspanel.add(delete);
               //Panels in Adminframe
               mainstocktablepanel.setVisible(true);
               mainstocklable.setVisible(true);
               mainrefresh.setVisible(true);
               layeredPane.add(soldoutitemspanel,JLayeredPane.PALETTE_LAYER);
               layeredPane.remove(newstockpanel);
               //Removing other panels components
               layeredPane.remove(issuepanel);
               layeredPane.remove(submitpanel);
               layeredPane.remove(requesttablepanel);
               layeredPane.remove(issueditemstablepanel1);
               layeredPane.remove(hed);
               layeredPane.remove(issueditemstablepanel);
//               Adminframe.remove(issuehed);
               layeredPane.remove(submitpanel1);
               layeredPane.remove(msjh);
               layeredPane.remove(requserpanel);
               layeredPane.remove(accounttablepanel);
               layeredPane.repaint();
               
            }
        });
        //exit button
        exitbutton=new JButton("Exit");
        exitbutton.setBounds(100, 730, 100, 30);
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
        //Add buttons in Sidebar
        Sidebar.add(newstockbutton);
        Sidebar.add(issuebutton);
        Sidebar.add(submitbutton);
        Sidebar.add(approvels);
        Sidebar.add(soldout);
        Sidebar.add(exitbutton);
        //Add components in frame
        layeredPane.add(Sidebar,JLayeredPane.PALETTE_LAYER);
        layeredPane.add(mainstocklable,JLayeredPane.PALETTE_LAYER);
        layeredPane.add(mainrefresh,JLayeredPane.PALETTE_LAYER);
        layeredPane.add(mainstocktablepanel,JLayeredPane.PALETTE_LAYER);
        layeredPane.add(backpanel,JLayeredPane.DEFAULT_LAYER);
        Adminframe.add(layeredPane);
        Adminframe.setLayout(null);
        Adminframe.setVisible(true);
        Adminframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        AdminPanel a=new AdminPanel();
    }
}
