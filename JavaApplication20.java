package javaapplication20;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class insert1 extends Frame implements ActionListener,ItemListener
{
String s1,s2;
List list1;
TextField t1,t2,t3,t4,t5,t6,t7,t8;
Label l1,l2,l3,l4,l5,l6,l7,l8,ll1,ll2,ll3;
Checkbox c1,c2,cc1,cc2,cc3,cc4,cc5,cc6,cc7,cc8;
CheckboxGroup cg1,cg2;
Button b1,b2 ,show,search;
Connection con=null;
PreparedStatement stat;
insert1()
{
t1=new TextField(20);//fn
t2=new TextField(20);//ln
t3=new TextField(6);//gender
cg1=new CheckboxGroup();
c1=new Checkbox("male");
c2=new Checkbox("female");
c1.setCheckboxGroup(cg1);
c2.setCheckboxGroup(cg1);
t4=new TextField(5);//age
t5=new TextField(200);//address
t6=new TextField(10);//mobile
t7=new TextField(20);//mail
t8=new TextField(4);//bloodgroup
list1=new List();
list1.add("A+");
list1.add("A-");
list1.add("B+");
list1.add("B-");
list1.add("O+");
list1.add("O-");
list1.add("AB+");
list1.add("AB-");
cg2=new CheckboxGroup();
cc1=new Checkbox("A+");
cc2=new Checkbox("A-");
cc3=new Checkbox("B+");
cc4=new Checkbox("B-");
cc5=new Checkbox("O+");
cc6=new Checkbox("O-");
cc7=new Checkbox("AB+");
cc8=new Checkbox("AB-");

cc1.setCheckboxGroup(cg2);
cc2.setCheckboxGroup(cg2);
cc3.setCheckboxGroup(cg2);
cc4.setCheckboxGroup(cg2);
cc5.setCheckboxGroup(cg2);
cc6.setCheckboxGroup(cg2);
cc7.setCheckboxGroup(cg2);
cc8.setCheckboxGroup(cg2);

ll1=new Label("INSERT INTO DATABASE");
l1=new Label("Enter first name:");
l2=new Label("Enter last name:");
l3=new Label("Enter gender:");
l4=new Label("Enter Age:");
l5=new Label("Enter Address:");
l6=new Label("Enter mobile no:");
l7=new Label("Enter email address:");
l8=new Label("Enter blood group:");
b1=new Button("save");
b2=new Button("Exit Application");
show=new Button("Show DB");
search=new Button("Search DB");

//setLayout(new FlowLayout());
setLayout(null);
add(ll1);
ll1.setBounds(700,30,300,25);
add(l1);
l1.setBounds(25, 50, 100, 50);//fn
add(t1);
t1.setBounds(125, 65, 100, 25);
add(l2);
l2.setBounds(225,50,100,50);//ln
add(t2);
t2.setBounds(325,65,100,25);
add(l3);
l3.setBounds(425,50,79,50);//gender

add(c1);
c1.setBounds(505, 62,50, 25);
add(c2);
c2.setBounds(555, 62,60, 25);
add(l4);
l4.setBounds(615, 50,60, 50);//age
add(t4);
t4.setBounds(680, 65, 22, 25);
add(l5);
l5.setBounds(703, 50, 85, 50);//address
add(t5);
t5.setBounds(790, 65, 200, 100);
add(l6);
l6.setBounds(990,50,90,50);//phone
add(t6);
t6.setBounds(1087,65,80,25);
add(l7);
l7.setBounds(1170,50,120,50);//email
add(t7);
t7.setBounds(1295, 65, 150, 25);
add(l8);
l8.setBounds(25,127,105,30);//bloodgrp
//add(list1);
//list1.setBounds(1550, 50, 50, 50);
add(cc1);
cc1.setBounds(130,120,33,50);
add(cc2);
cc2.setBounds(163,120,30,50);
add(cc3);
cc3.setBounds(197,120,33,50);
add(cc4);
cc4.setBounds(232,120,33,50);
add(cc5);
cc5.setBounds(265,120,35,50);
add(cc6);
cc6.setBounds(300,120,35,50);
add(cc7);
cc7.setBounds(333,120,40,50);
add(cc8);
cc8.setBounds(375,120,50,50);

add(b1);
b1.setBounds(25,180,50,30);
add(b2);
b2.setBounds(90, 180, 100, 30);
add(show);
show.setBounds(250,180,100,30);
add(search);
search.setBounds(400,180,100,30);

c1.addItemListener(this);
c2.addItemListener(this);
cc1.addItemListener(this);
cc2.addItemListener(this);
cc3.addItemListener(this);
cc4.addItemListener(this);
cc5.addItemListener(this);
cc6.addItemListener(this);
cc7.addItemListener(this);
cc8.addItemListener(this);


b1.addActionListener(this);
b2.addActionListener(this);
show.addActionListener(this);
search.addActionListener(this);

setSize(1600,400);
setVisible(true);
//pack();
}
public void actionPerformed(ActionEvent a)
{
if (a.getSource()==b1)
{
  String url = "jdbc:sqlserver://localhost:1433;databaseName=bloodbank;integratedSecurity=true"; 
  try 
  {
  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
         con = DriverManager.getConnection(url);
  stat = con.prepareStatement("insert into data values (?, ?, ?, ?, ?,?,?,?)");                
                String fn = t1.getText();
                String ln = t2.getText();
                String sex=s1;
                String agge=t4.getText();
                String addr=t5.getText();
                String phone=t6.getText();
                String email=t7.getText();
                String blood=s2;
                //System.out.println(fn);
                if(fn.equals(""))
                {
                ll2=new Label("ERROR,PLEASE ENTER FIRST NAME");
                add(ll2);
                ll2.setBounds(25,300,1550,50);
                ll2.setBackground(Color.red);
                }
                else  if(ln.equals(""))
                {
                ll2=new Label("ERROR,PLEASE ENTER LAST NAME");
                add(ll2);
                ll2.setBounds(25,300,1550,50);
                ll2.setBackground(Color.red);
                }
                 else  if(s1==null)
                {
                ll2=new Label("ERROR,PLEASE CHOOSE GENDER");
                add(ll2);
                ll2.setBounds(25,300,1550,50);
                ll2.setBackground(Color.red);
                }
                else  if(agge.equals(""))
                {
                ll2=new Label("ERROR,PLEASE ENTER AGE");
                add(ll2);
                ll2.setBounds(25,300,1550,50);
                ll2.setBackground(Color.red);
                }
                else  if(Integer.parseInt(agge)<18 || Integer.parseInt(agge)>99)
                {
                ll2=new Label("ERROR,PLEASE ENTER AGE IN RANGE 18 TO 99");
                add(ll2);
                ll2.setBounds(25,300,1550,50);
                ll2.setBackground(Color.red);
                }
                else  if(s2==null)
                {
                ll2=new Label("ERROR,PLEASE CHOOSE GENDER");
                add(ll2);
                ll2.setBounds(25,300,1550,50);
                ll2.setBackground(Color.red);
                }
                
                
                stat.setString(1,fn);
                stat.setString(2,ln);
                stat.setString(3, sex);
                stat.setInt(4,Integer.parseInt(agge));
                stat.setString(5,addr);
                stat.setString(6,phone);
                stat.setString(7,email);
                stat.setString(8,blood);
                
               //stat.setInt(1, Integer.parseInt(id));
  //stat.setString(1,id);
                //stat.setString(2, name1);
                //stat.setString(3, address1);
                stat.executeUpdate();  
  //executeupdate -used for doing dml (insert,delete,update)
                con.close();
      ll2=new Label("Entry Successful");
      add(ll2);
      ll2.setBounds(550,180,350,25);
      ll2.setBackground(Color.green);
      
  }
  catch(Exception m)
  {   
      String arr[] = m.getMessage().split(" ");    
      System.out.println(m.getMessage());
      if(m.getMessage().equals("For input string: \"\""))
      {
      ll2=new Label("ERROR,you must fill all values");
      add(ll2);
      ll2.setBounds(550,180,350,25);
      ll2.setBackground(Color.red);
      }
//      else if(m.getMessage().equals("Cannot insert the value NULL into column 'gender', table 'bloodbank.dbo.data'; column does not allow nulls. INSERT fails."))
//      {
//      ll2=new Label("ERROR,please choose your gender");
//      add(ll2);
//      ll2.setBounds(550,180,350,25);
//      ll2.setBackground(Color.red);
//      } 
//      else if(m.getMessage().equals("Cannot insert the value NULL into column 'bloodgroup', table 'bloodbank.dbo.data'; column does not allow nulls. INSERT fails."))
//      {
//      ll2=new Label("ERROR,please choose your blood group");
//      add(ll2);
//      ll2.setBounds(550,180,350,25);
//      ll2.setBackground(Color.red);
//      }
      else if(m.getMessage().equals("String or binary data would be truncated."))
      {
      ll2=new Label("ERROR,please enter mobile number of ten digits");
      add(ll2);
      ll2.setBounds(550,180,350,25);
      ll2.setBackground(Color.red);
      }
      else if(arr.length>5)
      {
          String kk=arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" "+arr[5];
          if(kk.equals("Violation of UNIQUE KEY constraint 'UQ__data__B43B145FA2B54A61'."))
          {
            ll2=new Label("ERROR,please enter unique number ");
            add(ll2);
            ll2.setBounds(25,300,1550,50);
            ll2.setBackground(Color.red);
           }
     }
            else if(arr.length>5)
      {
          String kk=arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" "+arr[5];
          if(kk.equals("Violation of UNIQUE KEY constraint 'UQ__data__AB6E616489B79791'."))
          {
            ll2=new Label("ERROR,please enter unique email");
            add(ll2);
            ll2.setBounds(25,300,1550,50);
            ll2.setBackground(Color.red);
           }
     }
      else
      {
      ll2=new Label("ERROR,ENTER APPROPRIATE INPUT......"+m.getMessage());
      add(ll2);
      ll2.setBounds(25,300,1550,50);
      ll2.setBackground(Color.red);
      }
}
}
else if(a.getSource()==b2)
System.exit(0);
else if(a.getSource()==show){
    showdb o=new showdb();
}
else if(a.getSource()==search)
{
    searchdb o1=new searchdb();
}
}

    //@Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(c1.getState()==true)
            s1=c1.getLabel();
        if(c2.getState()==true)
            s1=c2.getLabel();
        
        if(cc1.getState()==true)
            s2=cc1.getLabel();
        if(cc2.getState()==true)
            s2=cc2.getLabel();
        if(cc3.getState()==true)
            s2=cc3.getLabel();
        if(cc4.getState()==true)
            s2=cc4.getLabel();
        if(cc5.getState()==true)
            s2=cc5.getLabel();
        if(cc6.getState()==true)
            s2=cc6.getLabel();
        if(cc7.getState()==true)
            s2=cc7.getLabel();
        if(cc8.getState()==true)
            s2=cc8.getLabel();
        
    }

   
}

class showdb{ //extends Frame implements ActionListener{
    showdb(){
    String url = "jdbc:sqlserver://localhost:1433;databaseName=bloodbank;integratedSecurity=true";
    //user id=nikhil;password=nerul
    //user id=system;password=nerul

      // Declare the JDBC objects.  
    Connection con = null;  //USED FOR DOING CONNECTION 
    Statement stmt = null; //USED FOR RUNNING COMMAND 
    ResultSet rs = null;  //USED FOR STORING THE RECORDS WHICH COMES FROM TABLE

      try {  
         // Establish the connection.  
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
         con = DriverManager.getConnection(url);  

         // Create and execute an SQL statement that returns some data.  
         stmt = con.createStatement();  
         
         rs = stmt.executeQuery("select * from data");  

         // Iterate through the data in the result set and display it.  
         while (rs.next()) { 
           //String foo = String.format("%-20s %s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
           //System.out.println(foo);
           //System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7)+"\t\t"+rs.getString(8)+"\t\t"+rs.getString(9));  
           //System.out.format("%32s%10d%16s",rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
           String foo = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
           System.out.println(foo);
         }  
      }
      // Handle any errors that may have occurred.  
      catch (Exception e) {  
          System.out.println(e.getMessage());
      }  
        
    }    
}

class searchdb extends Frame implements ActionListener{
    Label ll1;
    List l1;
    Button b1,b2,b3,b4,b5,del,exit;
    TextField t1,t2,t3,t4,t5,t22;
    Connection con;
    PreparedStatement stat;
    ResultSet rs;
    String foo1;
    searchdb(){
    setLayout(null);
    l1=new List();
    b1=new Button("Search First Name Like:");
    b2=new Button("Search Last Name Like:");
    b3=new Button("Search By Gender-m/f:");
    b4=new Button("Search by Number:");
    b5=new Button("Search by Blood group:");
    t1=new TextField(20);
    t2=new TextField(20);
    t3=new TextField(20);
    t4=new TextField(20);
    t5=new TextField(20);
    
    
    t22=new TextField(20);
    del=new Button("Delete:Enter id");
    //ll1=new Label(" : Fields have been deleted");
    exit=new Button("Exit");
    
    add(b1);
    b1.setBounds(25, 65, 135, 25);//fn
    add(t1);
    t1.setBounds(165, 65, 100, 25);
    add(b2);
    b2.setBounds(275,65,135,25);
    add(t2);
    t2.setBounds(415, 65,100, 25);
    add(b3);
    b3.setBounds(520,65,130,25);
    add(t3);
    t3.setBounds(655,65,130,25);
    add(b4);
    b4.setBounds(790,65,130,25);
    add(t4);
    t4.setBounds(927,65,130,25);
    add(b5);
    b5.setBounds(1060,65,130,25);
    add(t5);
    t5.setBounds(1200,65,130,25);
    
    
    
    add(l1);
    l1.setBounds(50,200,1500,150);
    //l1.setBackground(Color.red);
    add(del);
    del.setBounds(25,500,100,50);
    add(t22);
    t22.setBounds(130,510,50,25);
    //add(ll1);
    //ll1.setBounds(190,510,165,25);
    //ll1.setBackground(Color.red);
    add(exit);
    exit.setBounds(25,600,80,50);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    del.addActionListener(this);
    exit.addActionListener(this);
    setSize(1600,700);
    setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    if(e.getSource()==b1)
    {    
    String url = "jdbc:sqlserver://localhost:1433;databaseName=bloodbank;integratedSecurity=true"; 
    try 
    {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    con = DriverManager.getConnection(url);
    stat = con.prepareStatement("select * from data where firstname LIKE ?");
            String fn = t1.getText();
            foo1=new String();
            stat.setString(1,"%"+fn+"%");
              rs = stat.executeQuery();
              //if(rs.isBeforeFirst())
              //{
                  
              //}
              //else
              
              String foo2="";
              while (rs.next())      
              {
              String foo="";
              
              foo = String.format("%-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //String foo = String.format("%20s %40s %60s %80s %100s %120s %140s %160s %180s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //String foo = String.format("%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //foo2+=foo+"\n";
              System.out.println(foo);
              l1.add(foo);
              //foo="";
              //l1.
              }
              //l1.add(foo2);
              //System.out.println(foo2);
            //stat.executeUpdate();  
            //executeupdate -used for doing dml (insert,delete,update)
                con.close();
  }
  catch(Exception m)
  {
      System.out.println(m.getMessage());    
  }
}
  else if(e.getSource()==b2)
    {    
    String url = "jdbc:sqlserver://localhost:1433;databaseName=bloodbank;integratedSecurity=true"; 
    try 
    {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    con = DriverManager.getConnection(url);
    stat = con.prepareStatement("select * from data where lastname LIKE ?");
            String ln = t2.getText();
            foo1=new String();
            stat.setString(1,"%"+ln+"%");
              rs = stat.executeQuery();
              //if(rs.isBeforeFirst())
              //{
                  
              //}
              //else
              
              String foo2="";
              while (rs.next())      
              {
              String foo="";
              
              foo = String.format("%-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //String foo = String.format("%20s %40s %60s %80s %100s %120s %140s %160s %180s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //String foo = String.format("%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //foo2+=foo+"\n";
              System.out.println(foo);
              l1.add(foo);
              //foo="";
              //l1.
              }
              //l1.add(foo2);
              //System.out.println(foo2);
            //stat.executeUpdate();  
            //executeupdate -used for doing dml (insert,delete,update)
                con.close();
  }
  catch(Exception m)
  {
      System.out.println(m.getMessage());    
  }
  }
  else if(e.getSource()==b3)
    {    
    String url = "jdbc:sqlserver://localhost:1433;databaseName=bloodbank;integratedSecurity=true"; 
    try 
    {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    con = DriverManager.getConnection(url);
    stat = con.prepareStatement("select * from data where gender = ?");
            String sex = t3.getText();
            foo1=new String();
            if(sex.equals("m"))
                sex="male";
            else
                sex="female";
            stat.setString(1,sex);
              rs = stat.executeQuery();
              //if(rs.isBeforeFirst())
              //{
                  
              //}
              //else
              
              String foo2="";
              while (rs.next())      
              {
              String foo="";
              
              foo = String.format("%-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //String foo = String.format("%20s %40s %60s %80s %100s %120s %140s %160s %180s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //String foo = String.format("%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //foo2+=foo+"\n";
              System.out.println(foo);
              l1.add(foo);
              //foo="";
              //l1.
              }
              //l1.add(foo2);
              //System.out.println(foo2);
            //stat.executeUpdate();  
            //executeupdate -used for doing dml (insert,delete,update)
                con.close();
  }
  catch(Exception m)
  {
      System.out.println(m.getMessage());    
  }
  }
  else if(e.getSource()==b4)
    {    
    String url = "jdbc:sqlserver://localhost:1433;databaseName=bloodbank;integratedSecurity=true"; 
    try 
    {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    con = DriverManager.getConnection(url);
    stat = con.prepareStatement("select * from data where phone = ?");
            String m = t4.getText();
            foo1=new String();
            stat.setString(1,m);
              rs = stat.executeQuery();
              //if(rs.isBeforeFirst())
              //{
                  
              //}
              //else
              
              String foo2="";
              while (rs.next())      
              {
              String foo="";
              
              foo = String.format("%-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //String foo = String.format("%20s %40s %60s %80s %100s %120s %140s %160s %180s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //String foo = String.format("%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //foo2+=foo+"\n";
              System.out.println(foo);
              l1.add(foo);
              //foo="";
              //l1.
              }
              //l1.add(foo2);
              //System.out.println(foo2);
            //stat.executeUpdate();  
            //executeupdate -used for doing dml (insert,delete,update)
                con.close();
  }
  catch(Exception m)
  {
      System.out.println(m.getMessage());    
  }
  }
    else if(e.getSource()==b5)
    {    
    String url = "jdbc:sqlserver://localhost:1433;databaseName=bloodbank;integratedSecurity=true"; 
    try 
    {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    con = DriverManager.getConnection(url);
    stat = con.prepareStatement("select * from data where bloodgroup = ?");
            String b = t5.getText();
            foo1=new String();
            stat.setString(1,b);
              rs = stat.executeQuery();
              //if(rs.isBeforeFirst())
              //{
                  
              //}
              //else
              
              String foo2="";
              while (rs.next())      
              {
              String foo="";
              
              foo = String.format("%-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //String foo = String.format("%20s %40s %60s %80s %100s %120s %140s %160s %180s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //String foo = String.format("%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s"+"%20s", rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
              //foo2+=foo+"\n";
              System.out.println(foo);
              l1.add(foo);
              //foo="";
              //l1.
              }
              //l1.add(foo2);
              //System.out.println(foo2);
            //stat.executeUpdate();  
            //executeupdate -used for doing dml (insert,delete,update)
                con.close();
  }
  catch(Exception m)
  {
      System.out.println(m.getMessage());    
  }
  }
    else if(e.getSource()==del)
    {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=bloodbank;integratedSecurity=true";
        int del;
    try 
    {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    con = DriverManager.getConnection(url);
    stat = con.prepareStatement("delete from data where id=?");
            String s = t22.getText();         
            stat.setString(1,s);
              //stat.executeQuery();
              del =stat.executeUpdate();
              String k=String.valueOf(del);
              ll1=new Label(k+" : Fields have been deleted");
              add(ll1);
              ll1.setBounds(190,510,165,25);
              ll1.setBackground(Color.red);
              
              //System.out.println(del);
              //if(rs.isBeforeFirst())
              //{
              //System.out.println("something");
              //}
                con.close();
  }
  catch(Exception m)
  {
      //System.out.println(del);
      System.out.println(m.getMessage());   

  }
    }
    else if(e.getSource()==exit)
    {
        System.exit(0);
    }
}
}

public class JavaApplication20 {
    public static void main(String[] args) {
        insert1 s=new insert1();
    }
    
}
