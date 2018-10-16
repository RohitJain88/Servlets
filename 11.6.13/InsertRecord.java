import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class InsertRecord extends JFrame implements ActionListener
{

   JPanel p1,p2,p3,p4,mp;
   JLabel lb1,lb2,lb3;
   JButton btnInsert,btnHome;
   JTextField t1,t2,t3;
Connection con;
PreparedStatement  pst;
  InsertRecord()
   {
     setLayout(new FlowLayout());



     lb1=new JLabel("Roll No.       : ");
     lb2=new JLabel("Name           : ");
     lb3=new JLabel("Address       : ");

     t1=new JTextField(30);
     t2=new JTextField(30);
     t3=new JTextField(30);

     btnInsert=new JButton("Insert");
     btnHome=new JButton("Home");


     p1=new JPanel();
     p2=new JPanel();
     p3=new JPanel();
     p4=new JPanel();
     mp=new JPanel(new GridLayout(4,1));

     p1.add(lb1);
     p1.add(t1);
     p2.add(lb2);
     p2.add(t2);
     p3.add(lb3);
     p3.add(t3);
     p4.add(btnInsert);
     p4.add(btnHome);

     mp.add(p1);
     mp.add(p2);
     mp.add(p3);
     mp.add(p4);

     add(mp);

     setVisible(true);
     setTitle("Insert Record");
     setBounds(400,400,450,200);

     btnInsert.addActionListener(this);
     btnHome.addActionListener(this);
      try{
	 		con=MyConnection.createConnection();
	 		JOptionPane.showMessageDialog(this,"Database connected");
	 		pst=con.prepareStatement("insert into student values(?,?,?)");

	 	 }catch(Exception  e)
	 	  {
	 		  JOptionPane.showMessageDialog(this,"Error in Connection");
	  }

  }

     public void actionPerformed(ActionEvent ae)
       {
		    if(ae.getSource()==btnInsert)
		        	     {
		        		    try{
								pst.setInt(1,Integer.parseInt(t1.getText()));
								pst.setString(2,t2.getText());
								pst.setString(3,t3.getText());
        int    r=	pst.executeUpdate();
        if(r>=1)
        {
			 JOptionPane.showMessageDialog(this,"Record is Inserted");
			 t1.setText("");
			  t2.setText("");
			   t3.setText("");

		}
		else
		{
			 JOptionPane.showMessageDialog(this,"Record is not inserted");
		}
								 }catch(Exception  e)
									 	  {
									 		  JOptionPane.showMessageDialog(this,"Error in Insertion");
	  }
            }
     	     if(ae.getSource()==btnHome)
     	     {
     		    this.setVisible(false);
     		    new HomePage();
            }
     }

  public  static void main (String arg[])
  {
	   new InsertRecord();
 }
 }


