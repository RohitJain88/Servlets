import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
   JPasswordField p;
   JPanel p1,p2,p3,mp;
   JLabel lb1,lb2;
   JButton b1,b2,b3;
   JTextField t;
   JOptionPane op;
Connection con;
PreparedStatement  pst;
ResultSet  rs;
   Login()
   {
	  setLayout(new FlowLayout());

     p=new JPasswordField(25);

     lb1=new JLabel("User ID :      ");
     lb2=new JLabel(" Password : ");

     t=new JTextField(25);
     b1=new JButton("Login");
     b2=new JButton("New User");
     b3=new JButton("Exit");

     p1=new JPanel();
     p2=new JPanel();
     p3=new JPanel();
     mp=new JPanel(new GridLayout(3,1));

     p1.add(lb1);
     p1.add(t);
     p2.add(lb2);
     p2.add(p);
     p3.add(b1);
     p3.add(b2);
     p3.add(b3);


     mp.add(p1);
     mp.add(p2);
     mp.add(p3);

     add(mp);
     op=new JOptionPane();

     setVisible(true);
     setTitle("Login");
     setBounds(400,400,400,180);

     b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);
     try{
		con=MyConnection.createConnection();
		JOptionPane.showMessageDialog(this,"Database connected");
		pst=con.prepareStatement("Select  username,password from userdetails where username=? and password=?");

	 }catch(Exception  e)
	  {
		  JOptionPane.showMessageDialog(this,"Error in Connection");
	  }

  }

  public void actionPerformed(ActionEvent ae)
       	{

			if(ae.getSource()==b1)
			 {
				 try{
				 pst.setString(1,t.getText());
				 pst.setString(2,new String(p.getPassword()));
				 rs=pst.executeQuery();

				 if(rs.next())
				  {
					 this.setVisible(false);
					 new HomePage();
			     }
			     else
			     {
					  op.showMessageDialog(this,"Either username or password is not correct");

				  }
			  }catch(Exception e)
			   {
				    op.showMessageDialog(this,"Error in loggin");
			   }
		   }


			 /*if(ae.getSource()==b1)
			 {
			         	 this.setVisible(false);
						 new HomePage();
	    	  }*/


             if(ae.getSource()==b2)
		     {
			 			this.setVisible(false);
			 			new NewUser();
		     }


             if(ae.getSource()==b3)
             {
				  System.exit(0);
		     }

	}

  public  static void main (String arg[])
  {
	   new Login();
 }
 }


