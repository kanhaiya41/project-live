package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.List;
class jdbc {
    Connection con;
    public jdbc()
    {
        try 
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kanhaiya?useCursorFetch=true&defaultFetchSize=100", "root", "root");
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    void selectdata(JPanel panel,String tablename)
    {
        deletezeroquantity();
        DefaultTableModel model=new DefaultTableModel
        (
                  new Object[][]
                  {
//                        {"","","",""}
                  },
                        new String[]{"index","product name","quantity","Rate(single pro.)"}
        );
        JTable jt=new JTable(model);
        jt.setBounds(0,100,400,200);
        Border broder=BorderFactory.createLineBorder(Color.black);
        jt.setBorder(broder);
        
        jt.setEnabled(false);
        jt.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane=new JScrollPane(jt);
        jScrollPane.setBounds(0,50,400,200);
        
        panel.add(jScrollPane);
        
        
            try 
        {
            String q="select * from " + tablename;
            Statement s=con.createStatement();
            ResultSet set=s.executeQuery(q);
            ResultSetMetaData tstruc=set.getMetaData();
            int colum=tstruc.getColumnCount();
            model.setRowCount(0);
            while(set.next())
            {
                
                Object[] rowData = new Object[colum];
                for (int i = 1; i <= colum; i++) 
                {
                    rowData[i - 1] = set.getObject(i);
                    
                }    
                model.addRow(rowData);
            }
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
    }
     void requser(JPanel panel,String tablename)
    {
        DefaultTableModel model=new DefaultTableModel
        (
                  new Object[][]
                  {
//                        {"","","",""}
                  },
                        new String[]{"username","password","stock Id","Account"}
        );
        JTable jt=new JTable(model);
        jt.setBounds(0,100,400,200);
        Border broder=BorderFactory.createLineBorder(Color.black);
        jt.setBorder(broder);
        
        jt.setEnabled(false);
        jt.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane=new JScrollPane(jt);
        jScrollPane.setBounds(0,50,400,200);
        
        panel.add(jScrollPane);
        
        
            try 
        {
            String q="select * from " + tablename;
            Statement s=con.createStatement();
            ResultSet set=s.executeQuery(q);
            ResultSetMetaData tstruc=set.getMetaData();
            int colum=tstruc.getColumnCount();
            model.setRowCount(0);
            while(set.next())
            {
                
                Object[] rowData = new Object[colum];
                for (int i = 1; i <= colum; i++) 
                {
                    rowData[i - 1] = set.getObject(i);
                    
                }    
                model.addRow(rowData);
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
    }
    
    public void selectdatafromrequesttable(JPanel panel,String tablename)
    {
        
        
        DefaultTableModel model=new DefaultTableModel
        (
                  new Object[][]
                  {
                        //{}
                  },
                        new String[]{"Index","User Name","Product name","Quantity","Rate(single pro.)","type"}
        );
        JTable jt=new JTable(model);
        jt.setBounds(0,0,400,200);
        Border broder=BorderFactory.createLineBorder(Color.black);
        jt.setBorder(broder);
        jt.setEnabled(false);
        jt.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane=new JScrollPane(jt);
        jScrollPane.setBounds(0,0,450,200);
        panel.add(jScrollPane);
        //frame.add(jPanel);
        try 
        {
            
            
            String q="select * from " + tablename;
            Statement s=con.createStatement();
            ResultSet set=s.executeQuery(q);
            ResultSetMetaData tstruc=set.getMetaData();
            int colum=tstruc.getColumnCount();
            while(set.next())
            {
                
                Object[] rowData = new Object[colum];
                for (int i = 1; i <= colum; i++) 
                {
                    rowData[i - 1] = set.getObject(i);
                }    
                
                
                
                
                
                
                
                
                model.addRow(rowData);
                    
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void selectdatafromsubmittable(JPanel panel,String tablename)
    {
        
        
        DefaultTableModel model=new DefaultTableModel
        (
                  new Object[][]
                  {
                        //{}
                  },
                        new String[]{"Index","User Name","Product name","Quantity","Rate(single pro.)"}
        );
        JTable jt=new JTable(model);
        jt.setBounds(0,0,400,200);
        Border broder=BorderFactory.createLineBorder(Color.black);
        jt.setBorder(broder);
        jt.setEnabled(false);
        jt.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane=new JScrollPane(jt);
        jScrollPane.setBounds(0,0,450,200);
        panel.add(jScrollPane);
        //frame.add(jPanel);
        try 
        {
            
            
            String q="select * from " + tablename;
            Statement s=con.createStatement();
            ResultSet set=s.executeQuery(q);
            ResultSetMetaData tstruc=set.getMetaData();
            int colum=tstruc.getColumnCount();
            while(set.next())
            {
                
                Object[] rowData = new Object[colum];
                for (int i = 1; i <= colum; i++) 
                {
                    rowData[i - 1] = set.getObject(i);
                }    
                
                

                model.addRow(rowData);
                    
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
     public void selectdatafromissuedtable(JPanel panel,String tablename)
    {
        SwingUtilities.invokeLater(() -> 
        {
           DefaultTableModel model=new DefaultTableModel
        (
                  new Object[][]
                  {
                        //{}
                  },
                        new String[]{"Index","User Name","Product name","Quantity","Rate(single pro.)","Type"}
        );
        JTable jt=new JTable(model);
        jt.setBounds(0,0,400,200);
        Border broder=BorderFactory.createLineBorder(Color.black);
        jt.setBorder(broder);
        jt.setEnabled(false);
        jt.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane=new JScrollPane(jt);
        jScrollPane.setBounds(0,0,450,200);
        panel.add(jScrollPane);
        //frame.add(jPanel);
        try 
        {
            
            
            String q="select * from " + tablename+" where type=?";
            PreparedStatement s=con.prepareStatement(q);
            s.setString(1, "Returnable");
            ResultSet set=s.executeQuery();
            ResultSetMetaData tstruc=set.getMetaData();
            int colum=tstruc.getColumnCount();
            while(set.next())
            {
                
                Object[] rowData = new Object[colum];
                for (int i = 1; i <= colum; i++) 
                {
                    rowData[i - 1] = set.getObject(i);
                }    
                
                

                model.addRow(rowData);
                    
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        } 
        });

        
        
    }
     
        public void selectdatafromnonissuedtable(JPanel panel,String tablename)
    {
        SwingUtilities.invokeLater(() -> 
        {
           DefaultTableModel model=new DefaultTableModel
        (
                  new Object[][]
                  {
                        //{}
                  },
                        new String[]{"Index","User Name","Product name","Quantity","Rate(single pro.)","Type"}
        );
        JTable jt=new JTable(model);
        jt.setBounds(0,0,400,200);
        Border broder=BorderFactory.createLineBorder(Color.black);
        jt.setBorder(broder);
        jt.setEnabled(false);
        jt.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane=new JScrollPane(jt);
        jScrollPane.setBounds(0,50,450,200);
        panel.add(jScrollPane);
        //frame.add(jPanel);
        try 
        {
            
            
            String q="select * from " + tablename+" where type=?";
            PreparedStatement s=con.prepareStatement(q);
            s.setString(1, "non-Returnable");
            ResultSet set=s.executeQuery();
            ResultSetMetaData tstruc=set.getMetaData();
            int colum=tstruc.getColumnCount();
            while(set.next())
            {
                
                Object[] rowData = new Object[colum];
                for (int i = 1; i <= colum; i++) 
                {
                    rowData[i - 1] = set.getObject(i);
                }    
                
                

                model.addRow(rowData);
                    
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        } 
        });

        
        
    }
        
    public void deletesoldhistory()
    {
        try 
        {
            
            
            String q="delete from issueditems where type=?";
            PreparedStatement s=con.prepareStatement(q);
            s.setString(1, "non-Returnable");
            s.executeUpdate();
            
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }
    public void insertacc(String username,String pass,String cpass,String stockid,String acc,JLabel info){
        try {
            
            String sq="select * from account where Account=?";
            String admin="Admin";
            PreparedStatement sptmt=con.prepareStatement(sq);
            sptmt.setString(1, admin);
            ResultSet set= sptmt.executeQuery();
            String setstock="";
            while(set.next())
            {
            setstock=set.getString("StockID");
            }
            if(stockid.equals(setstock))
            {
                String q="insert into requsers(UserName,Password,StockID,Account)values(?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setString(1, username);
                pstmt.setString(2, pass);
                pstmt.setString(3, stockid);
                pstmt.setString(4, acc);
                if(pass.equals(cpass)){
                    pstmt.executeUpdate();
                    
                    info.setForeground(Color.GREEN);
                    info.setText("request sent to Admin");
                }
                else{
                    info.setForeground(Color.red);
                    info.setText("Plese Feel the Same Password");
                }
            }
            else
            {
                info.setForeground(Color.red);
                info.setText("Stock Id does not exist");
            }
             Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    info.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void appacc(String username,JLabel info){
        try {
            
            String sq="select * from requsers where username=?";
            PreparedStatement sptmt=con.prepareStatement(sq);
            sptmt.setString(1, username);
            ResultSet set= sptmt.executeQuery();
            String pass="",stockid="",acc="";
            String u="";
            while(set.next())
            {
                u=set.getString("username");
                pass=set.getString("password");
                stockid=set.getString("stockid");
                acc=set.getString("account");
            }
            if(u.isEmpty())
                {
                    info.setForeground(Color.red);
                    info.setText("Enter a valid Username");
                }
                else{
                    info.setForeground(Color.GREEN);
                info.setText("request Approved");
                }
                String q="insert into account(UserName,Password,StockID,Account)values(?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setString(1, username);
                pstmt.setString(2, pass);
                pstmt.setString(3, stockid);
                pstmt.setString(4, acc);
                pstmt.executeUpdate();
                
                
                
                        Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    info.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertadmin(String username,String pass,String cpass,String stockid,String acc,JLabel info){
        try {
            
            String sq="select * from account where Account=?";
            String admin="Admin";
            PreparedStatement sptmt=con.prepareStatement(sq);
            sptmt.setString(1, admin);
            ResultSet set= sptmt.executeQuery();
            
            if(!set.next())
            {
                String q="insert into account(UserName,Password,StockID,Account)values(?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setString(1, username);
                pstmt.setString(2, pass);
                pstmt.setString(3, stockid);
                pstmt.setString(4, acc);
                if(pass.equals(cpass)){
                    pstmt.executeUpdate();
                    System.out.println("3");
                    info.setForeground(Color.GREEN);
                    info.setText("successfully signed in go and log in");
                }
                else{
                    info.setForeground(Color.red);
                    info.setText("Plese Feel the Same Password");
                }
            }
            else
            {
                info.setForeground(Color.red);
                info.setText("Already have an Admin");
            }
            
             Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    info.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void findacc(String username,String pass,String stockid,String acctype,JLabel linfo,JFrame enterenceframe,JFrame Loginpanel)
    {
        try {
            Object[] rowData;
            int i;
            String q="select * from account where UserName=?";
            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setString(1, username);
            ResultSet set = preparedStatement.executeQuery();
            ResultSetMetaData tstruc = set.getMetaData();
            int colum = tstruc.getColumnCount();
            
            if (set.next()) {
                
                do {
                    rowData = new Object[colum];
                for (i = 1; i <= colum; i++) {
                    rowData[i - 1] = set.getObject(i);
                    
                    
                    
                }
                break;
                } while (set.next());
            } 
            
            else
            {
                linfo.setForeground(Color.red);
                linfo.setText("Username not Found");
                Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    linfo.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
                
            }
            
            if(!pass.equals(set.getString("Password")))
            {
                linfo.setForeground(Color.red);
                linfo.setText("You Entered an Incorrect Password");
                Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    linfo.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
            }
            
            else if(!stockid.equals(set.getString("StockID")))
            {
                linfo.setForeground(Color.red);
                linfo.setText("Wrong Stock ID");
                Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    linfo.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
            }
            
            else if(!acctype.equals(set.getString("Account")))
            {
                linfo.setForeground(Color.red);
                linfo.setText("You Are Not "+acctype);
                Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    linfo.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
            }
            
            else if(acctype.equals("Admin")){
                
                AdminPanel a=new AdminPanel();
                Loginpanel.dispose();
                                enterenceframe.dispose();
            }
            
            else{
                UserPanel u=new UserPanel(username);
                Loginpanel.dispose();
                                enterenceframe.dispose();
            }

             
            
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void insertnewstock(String item,String quantity,String rate,JLabel subimtlable)
    {
        try {
            int iquantity=Integer.parseInt(quantity);
            String q="insert into newstocktable(p_name,quantity,rate)values(?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1, item);
            pstmt.setInt(2, iquantity);
            pstmt.setString(3, rate);
            pstmt.executeUpdate();
            subimtlable.setForeground(Color.BLUE);
            subimtlable.setText("Added to New Stock");
                        Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    subimtlable.setText("");
                }
            });
            //time.setRepeats(false);
            time.start();
        } catch (Exception e) {
            
        }
    }
    
    public void selectuser(String username,JPanel panel,String tablename)
    {
       DefaultTableModel model=new DefaultTableModel
        (
                  new Object[][]
                  {
//                        {"","","",""}
                  },
                        new String[]{"index","User Name","product name","quantity","Rate(single pro.),type"}
        );
        JTable jt=new JTable(model);
        jt.setBounds(0,50,400,200);
        Border broder=BorderFactory.createLineBorder(Color.black);
        jt.setBorder(broder);
        
        jt.setEnabled(false);
        jt.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane=new JScrollPane(jt);
        jScrollPane.setBounds(0,50,400,200);
        panel.add(jScrollPane);
        //frame.add(jPanel);
        try 
        {
            
            
            String q="select * from " + tablename +" where username=?";
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1, username);
            ResultSet set=pstmt.executeQuery();
            ResultSetMetaData tstruc=set.getMetaData();
            int colum=tstruc.getColumnCount();
            
            while(set.next())
            {
                
                Object[] rowData = new Object[colum];
                for (int i = 1; i <= colum; i++) 
                {
                    rowData[i - 1] = set.getObject(i);
                }    
                model.addRow(rowData);
            }
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void insertrequest(String username, String item, String quantity, String rate, String type, JLabel info) {
    try {
        String sq = "select * from product where p_name=?";
        PreparedStatement spstmt = con.prepareStatement(sq);
        spstmt.setString(1, item);
        ResultSet set = spstmt.executeQuery();

        // Check if the result set has any rows
        if (set.next()) {
            int qu = Integer.parseInt(quantity);
            if (qu > set.getInt("quantity")) {
                info.setForeground(Color.red);
                info.setText("Quantity is too High");
                Timer time = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        info.setText("");
                    }
                });
                time.start();
            } else {
                String q = "insert into requesttable(username,p_name,quantity,rate,type)values(?,?,?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(q);
                pstmt.setString(1, username);
                pstmt.setString(2, item);
                pstmt.setInt(3, qu);
                pstmt.setString(4, rate);
                pstmt.setString(5, type);
                pstmt.executeUpdate();
                info.setForeground(Color.green);
                info.setText("Request Submitted");
                Timer time = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        info.setText("");
                    }
                });
                time.start();
            }
        } 

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    public void insertsubmitrequest(String username,String item,String quantity,String rate,JLabel info)
    {
        try {
            String sq = "select * from issueditems where username=? and p_name=?";
        PreparedStatement spstmt = con.prepareStatement(sq);
        spstmt.setString(1, username);
        spstmt.setString(2, item);
        ResultSet set = spstmt.executeQuery();

        // Check if the result set has any rows
        if (set.next()) {
            int qu = Integer.parseInt(quantity);
            if (qu > set.getInt("quantity")) {
                info.setForeground(Color.red);
                info.setText("Quantity is too High");
                Timer time = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        info.setText("");
                    }
                });
                time.start();
            }
            else{
            String q="insert into submitreq(username,p_name,quantity,rate)values(?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1, username);
            pstmt.setString(2, item);
            pstmt.setString(3, quantity);
            pstmt.setString(4, rate);
            pstmt.executeUpdate();
            info.setForeground(Color.green);
            info.setText("Request Submited");
            Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    info.setText("");
                }
            });
                        time.start();
                    }}
        } catch (Exception e) {
        }
    }
    
   public void insertinmainstock(JLabel info) 
    {
        try {
            int mquantity=0,nquantity=0;
            String pname="";
            String nsq = "select * from newstocktable";
            PreparedStatement pstmt = con.prepareStatement(nsq);
            ResultSet set = pstmt.executeQuery();
            
            
            String q="insert into product(p_name,quantity,rate)values(?,?,?)";
                PreparedStatement ipstmt=con.prepareStatement(q);
                System.out.println("no");
                set=pstmt.executeQuery(nsq);
                while(set.next()){
                    
                    ipstmt.setString(1,set.getString("p_name") );
                    ipstmt.setInt(2,set.getInt("quantity"));
                    ipstmt.setString(3, set.getString("rate"));
                    ipstmt.executeUpdate();
                }
                PreparedStatement dpstmt = con.prepareStatement("delete from newstocktable");
                dpstmt.executeUpdate();
            

                info.setForeground(Color.BLUE);
                info.setText("Added to Main Stock");

                Timer time = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        info.setText("");
                    }
                });

                time.start();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updatemainstock(String data,String quantity,String rate,JLabel info)
    {
                try {
                int oldquantity = 0;
                int textquantity=Integer.parseInt(quantity);
                 String sq="select * from product";
                 PreparedStatement spstmt=con.prepareStatement(sq);
                 ResultSet set =spstmt.executeQuery();
                 while(set.next())
                {
                    if(data.equals(set.getString("p_name")))
                    {
                        
                        oldquantity=set.getInt("quantity");
                        break;
                    }
                }
                String uq="update product set quantity=?, rate=? where p_name=?";
                PreparedStatement upstmt=con.prepareStatement(uq);
                int newquantity=textquantity+oldquantity;
                upstmt.setInt(1, newquantity);
                upstmt.setString(2, rate);
                upstmt.setString(3, data);
                upstmt.executeUpdate();
                info.setForeground(Color.BLUE);
                info.setText("Added to Main Stock");

                Timer time = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        info.setText("");
                    }
                });

                time.start();
        } catch (Exception e) {
        }
    }
    
    public void deletedatafromrequesttable(String username,String pname)
    {
        try {
            String q="delete from requesttable where username=? and p_name=?";
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1, username);
            pstmt.setString(2, pname);
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deletefromrequser(String username)
    {
        try {
            String q="delete from requsers where username=?";
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void reqtoissue(String username,String pname,JLabel info)
    {
        try {
            String sq="select * from requesttable where username=? and p_name=?";
            PreparedStatement pstmt=con.prepareStatement(sq);
            pstmt.setString(1, username);
            pstmt.setString(2, pname);
            ResultSet set=pstmt.executeQuery();
            String iq="insert into issueditems(username,p_name,quantity,rate,type)values(?,?,?,?,?)";
            PreparedStatement ipstmt=con.prepareStatement(iq);
            String us="",pn="";
            while(set.next())
            {
                us=set.getString("username");
                pn=set.getString("p_name");
                ipstmt.setString(1,(set.getString("username")));
                ipstmt.setString(2,(set.getString("p_name")));
                ipstmt.setString(3,(set.getString("quantity")));
                ipstmt.setString(4,(set.getString("rate")));
                ipstmt.setString(5,(set.getString("type")));
                ipstmt.executeUpdate();
            }
            if(us.isEmpty()||pn.isEmpty())
            {
                info.setForeground(Color.red);
                info.setText("Request not Found");
            }
            else{
                info.setForeground(Color.blue);
            info.setText("Request Accepted");
            }
            
            Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   info.setText("");
                }
            });
            time.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void acceptsubmitrequest(String username,String pname,JLabel subimtlable)
    {
        try {
            String sq="select * from submitreq where username=? and p_name=?";
            PreparedStatement spstmt=con.prepareStatement(sq);
            spstmt.setString(1, username);
            spstmt.setString(2, pname);
            ResultSet set=spstmt.executeQuery();
            String u="",p="";
            while(set.next())
            {
                u=set.getString("username");
                p=set.getString("p_name");
            }
            String ds="delete from submitreq where username=? and p_name=?";
            PreparedStatement pstmt=con.prepareStatement(ds);
            pstmt.setString(1, username);
            pstmt.setString(2, pname);
            pstmt.executeUpdate();
            String di="delete from issueditems where username=? and p_name=?";
            PreparedStatement ipstmt=con.prepareStatement(di);
            ipstmt.setString(1, username);
            ipstmt.setString(2, pname);
            ipstmt.executeUpdate();
            if(u.isEmpty()||p.isEmpty())
            {
                subimtlable.setForeground(Color.red);
                subimtlable.setText("Request not Found");
            }
            else{
                subimtlable.setForeground(Color.BLUE);
            subimtlable.setText("Request Accepted");
            }
            
                        Timer time=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    subimtlable.setText("");
                }
            });
                        
            time.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) 
    {    
        JFrame jdbcfram=new JFrame("Admin Panel");
        jdbcfram.setBounds(0,0,1600,800);
        //panel for carry main stock table
        JPanel panel=new JPanel();
        panel.setBounds(1100, 100, 400, 200);
        panel.setBackground(Color.red);
        jdbcfram.add(panel);
        jdbcfram.setLayout(null);
        jdbcfram.setVisible(true);
        jdbcfram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jdbc obj=new jdbc();
        //obj.selectdata(panel);
        
    }
    
    public void usernamesuggestion(JTextField iusernametext,JComboBox<String> unamesugg,List<String> options,String sugtablename,String pname)
    {
        try {
            String q="select * from "+sugtablename;
            PreparedStatement pstmt=con.prepareStatement(q);
            ResultSet set=pstmt.executeQuery();
            while(set.next())
            {
                options.add(set.getString(pname));
            }
            

        // Add DocumentListener to JTextField for dynamic updates
        iusernametext.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            private void updateSuggestions() {
                   SwingUtilities.invokeLater(() -> {
                    String prefix = iusernametext.getText().toLowerCase();
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

                    for (String option : options) {
                        if (option.toLowerCase().startsWith(prefix)) {
                            model.addElement(option);
                        }
                    }

                    unamesugg.setModel(model);
                });
            }
        });
        unamesugg.setVisible(true);
        unamesugg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String suggest=(String) unamesugg.getSelectedItem();
                iusernametext.setText(suggest);
                  
            }
        });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void itemnamesugg(JTextField iusernametext,JComboBox<String> unamesugg,List<String> options,String sugtablename,String pname,JTextField quantity,JTextField rate)
    {
        try {
            String q="select * from "+sugtablename;
            PreparedStatement pstmt=con.prepareStatement(q);
            ResultSet set=pstmt.executeQuery();
            while(set.next())
            {
                options.add(set.getString(pname));
            }
            

        // Add DocumentListener to JTextField for dynamic updates
        iusernametext.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            private void updateSuggestions() {
                   SwingUtilities.invokeLater(() -> {
                    String prefix = iusernametext.getText().toLowerCase();
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

                    for (String option : options) {
                        if (option.toLowerCase().startsWith(prefix)) {
                            model.addElement(option);
                        }
                    }

                    unamesugg.setModel(model);
                });
            }
        });
        unamesugg.setVisible(true);
        unamesugg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    String suggest=(String) unamesugg.getSelectedItem();
                String sq="select * from "+sugtablename+" where p_name=?";
                PreparedStatement spstmt=con.prepareStatement(sq);
                spstmt.setString(1, suggest);
                ResultSet sset=spstmt.executeQuery();
                String ratet="";
                int qq=0;
                while(sset.next())
                {
                    ratet=sset.getString("rate");
                    qq=sset.getInt("quantity");
                }
                
                String qqq=String.valueOf(qq);
                iusernametext.setText(suggest);
                quantity.setText(qqq);
                rate.setText(ratet);
                } catch (Exception exx) {
                }
                
                  
            }
        });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void issuereqsug(JTextField iusernametext,JComboBox<String> unamesugg,List<String> options,String sugtablename,String pname,JTextField rate)
    {
        try {
            String q="select * from "+sugtablename;
            PreparedStatement pstmt=con.prepareStatement(q);
            ResultSet set=pstmt.executeQuery();
            while(set.next())
            {
                options.add(set.getString(pname));
            }
            

        // Add DocumentListener to JTextField for dynamic updates
        iusernametext.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            private void updateSuggestions() {
                   SwingUtilities.invokeLater(() -> {
                    String prefix = iusernametext.getText().toLowerCase();
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

                    for (String option : options) {
                        if (option.toLowerCase().startsWith(prefix)) {
                            model.addElement(option);
                        }
                    }

                    unamesugg.setModel(model);
                });
            }
        });
        unamesugg.setVisible(true);
        unamesugg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    String suggest=(String) unamesugg.getSelectedItem();
                String sq="select * from "+sugtablename+" where username=?";
                PreparedStatement spstmt=con.prepareStatement(sq);
                spstmt.setString(1, suggest);
                ResultSet sset=spstmt.executeQuery();
                String ratet="";
                while(sset.next())
                {
                    ratet=sset.getString("p_name");
                }
                iusernametext.setText(suggest);
                rate.setText(ratet);
                } catch (Exception exx) {
                }
                
                  
            }
        });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public void userninsugg(JTextField iusernametext,JComboBox<String> unamesugg,List<String> options,String sugtablename,String pname)
    {
        try {
            String q="select * from "+sugtablename;
            PreparedStatement pstmt=con.prepareStatement(q);
            ResultSet set=pstmt.executeQuery();
            while(set.next())
            {
                options.add(set.getString(pname));
            }
            

        // Add DocumentListener to JTextField for dynamic updates
        iusernametext.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            private void updateSuggestions() {
                   SwingUtilities.invokeLater(() -> {
                    String prefix = iusernametext.getText().toLowerCase();
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

                    for (String option : options) {
                        if (option.toLowerCase().startsWith(prefix)) {
                            model.addElement(option);
                        }
                    }

                    unamesugg.setModel(model);
                });
            }
        });
        unamesugg.setVisible(true);
        unamesugg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                    String suggest=(String) unamesugg.getSelectedItem();
                
                
                
                
                iusernametext.setText(suggest);
                
                
                
                  
            }
        });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
   public void test(String data,String quantity)
   {
       try {
           int oldquantity = 0;
           int textquantity=Integer.parseInt(quantity);
            String sq="select * from test";
            PreparedStatement spstmt=con.prepareStatement(sq);
            ResultSet set =spstmt.executeQuery();
            boolean match=false;
            while(set.next())
            {
                if(data.equals(set.getString("data")))
                {
                    match=true;
                    oldquantity=set.getInt("quantity");
                    break;
                }
            }
            if(!match)
            {
                System.out.println("no");
                String q="insert into test(data,quantity)values(?,?)";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setString(1, data);
                pstmt.setInt(2,textquantity);
                pstmt.executeUpdate();
            }
            else
            {
                int newquantity=textquantity+oldquantity;
                System.out.println("mathc");
                String uq="update test set quantity=? where data=?";
                PreparedStatement upstmt=con.prepareStatement(uq);
                upstmt.setInt(1, newquantity);
                upstmt.setString(2, data);
                upstmt.executeUpdate();
            }
            
       } catch (Exception e) {
           e.printStackTrace();
       }
       
   }
   
   
   public void suggestions(JComboBox<String> itemname,List<String> op,String sugtablename,JTextField quantity,JLabel rate)
   {
       try {
           String q="select * from "+sugtablename;
            PreparedStatement pstmt=con.prepareStatement(q);
            ResultSet set=pstmt.executeQuery();
            String qu="",r="";
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while(set.next())
            {
                
                op.add(set.getString("p_name"));
                qu=set.getString("quantity");
                r=set.getString("rate");
            }
            for (String option : op) {
                        
                            model.addElement(option);
                        
                    }

                    itemname.setModel(model);
                    itemname.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e) 
               {
                   try {
                       String qs="select * from "+sugtablename+" where p_name=?";
                       String selection=(String) itemname.getSelectedItem();
            PreparedStatement spstmt=con.prepareStatement(qs);
            spstmt.setString(1, selection);
            ResultSet sset=spstmt.executeQuery();
            String qu="",r="";
            
            if(sset.next())
            {
                
                qu=sset.getString("quantity");
                r=sset.getString("rate");
                quantity.setText(qu);
                rate.setText(r);
            }
            quantity.setText(qu);
            rate.setText(r);
                   } catch (Exception ee) {
                   }
                   
               }
           });
                    
       } catch (Exception e) {
       }
   }
   
   public void minusstock(String un,String pname)
   {
       try {
           String mainq="";
           String pn="";
           
           String q="select * from product";
           PreparedStatement pstmt=con.prepareStatement(q);
           ResultSet set=pstmt.executeQuery();
           
           String qq="select * from requesttable where username=? and p_name=?";
           PreparedStatement qpstmt=con.prepareStatement(qq);
           qpstmt.setString(1, un);
           qpstmt.setString(2, pname);
           
           ResultSet qset=qpstmt.executeQuery();
           int reqq=0;
           while(qset.next())
           {
                reqq=qset.getInt("quantity");
           }
           
           while(set.next())
           {
               if(pname.equals(set.getString("p_name")))
               {
                   pn=set.getString("p_name");
                   mainq=set.getString("quantity");
                   break;
               }
           }
           
           int imainq=Integer.parseInt(mainq);
           int newq=imainq-reqq;
           String uq="update product set quantity=? where p_name=?";
           PreparedStatement upstmt=con.prepareStatement(uq);
           upstmt.setInt(1, newq);
           upstmt.setString(2, pname);
           upstmt.executeUpdate();
           
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   
   public void plusmainstock(String pname,String un)
   {
       try {
           String mainq="";
           String pn="";
           
           String q="select * from product";
           PreparedStatement pstmt=con.prepareStatement(q);
           ResultSet set=pstmt.executeQuery();
           String qq="select * from issueditems where username=? and p_name=?";
           PreparedStatement qpstmt=con.prepareStatement(qq);
           qpstmt.setString(1, un);
           qpstmt.setString(2, pname);
           
           ResultSet qset=qpstmt.executeQuery();
           int reqq=0;
           String qpname="";
           String qrate="";
           while(qset.next())
           {
               
                reqq=qset.getInt("quantity");
                qpname=qset.getString("p_name");
                qrate=qset.getString("rate");
           }
           
           while(set.next())
           {
               if(pname.equals(set.getString("p_name")))
               {
                   pn=set.getString("p_name");
                   mainq=set.getString("quantity");
                   break;
               }
           }
           if(pn.isEmpty())
           {
               String iq="insert into product(p_name,quantity,rate)values(?,?,?)";
               PreparedStatement ipstmt=con.prepareStatement(iq);
               ipstmt.setString(1, qpname);
               ipstmt.setInt(2, reqq);
               ipstmt.setString(3, qrate);
               ipstmt.executeUpdate();
           }
           else{
           int imainq=Integer.parseInt(mainq);
           int newq=imainq+reqq;
           String uq="update product set quantity=? where p_name=?";
           PreparedStatement upstmt=con.prepareStatement(uq);
           upstmt.setInt(1, newq);
           upstmt.setString(2, pname);
           upstmt.executeUpdate();
                   }
       } catch (Exception e) {
       }
   }
  
   
   public void suggestuseritems(String sugtablename,List<String> op,JComboBox<String> itemname,JLabel uname,JTextField quantity,JLabel rate)
   {
       try {
           String unames=uname.getText();
           String q="select * from "+sugtablename+" where username=?";
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1, unames);
            ResultSet set=pstmt.executeQuery();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while(set.next())
            {
                op.add(set.getString("p_name"));
            }
            for (String option : op) {
                        
                            model.addElement(option);
                        
                    }

                    itemname.setModel(model);
                    itemname.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e) 
               {
                   try {
                       String qs="select * from "+sugtablename+" where p_name=?";
                       String selection=(String) itemname.getSelectedItem();
            PreparedStatement spstmt=con.prepareStatement(qs);
            spstmt.setString(1, selection);
            ResultSet sset=spstmt.executeQuery();
            String qu="",r="";
            
            if(sset.next())
            {
                
                qu=sset.getString("quantity");
                r=sset.getString("rate");
                quantity.setText(qu);
                rate.setText(r);
            }
            quantity.setText(qu);
            rate.setText(r);
                   } catch (Exception ee) {
                   }
                   
               }
           });
       } catch (Exception e) {
       }
   }
   
   public void setCustomIcon(String imagePath,JFrame frame) {
        try {
            // Read the image file
            BufferedImage iconImage = ImageIO.read(new File(imagePath));

            // Set the image as the icon
            frame.setIconImage(iconImage);
        } catch (IOException e) {
            // Handle the exception if the image cannot be loaded
            e.printStackTrace();
        }
    }
   public void deletezeroquantity() {
    try {
        String q = "select * from product";
        PreparedStatement pstmt = con.prepareStatement(q);
        ResultSet set = pstmt.executeQuery();

        while (set.next()) {
            int quantity = set.getInt("quantity");
            String productName = set.getString("p_name");

            if (quantity <= 0) {
                String dq = "delete from product where p_name=?";
                PreparedStatement dpstmt = con.prepareStatement(dq);
                dpstmt.setString(1, productName);
                dpstmt.executeUpdate();
            }
        }
    } catch (Exception e) {
        e.printStackTrace(); // Print the exception for debugging purposes
    }
}

}


