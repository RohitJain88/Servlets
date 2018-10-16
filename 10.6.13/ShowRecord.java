import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ShowRecord extends JFrame implements ActionListener
{

   JPanel p1,p2,p3,p4,mp;
   JLabel lb1,lb2,lb3;
   JButton b1,b2,b3,b4;
   JTextField t1,t2,t3;
   JOptionPane op;
   Connection con;
   PreparedStatement pst;
   ResultSet r;

  ShowRecord()
   {
     setLayout(new FlowLayout());



     lb1=new JLabel("Roll No.       : ");
     lb2=new JLabel("Name           : ");
      lb3=new JLabel("Address      : ");

     t1=new JTextField(30);
     t2=new JTextField(30);
    t3=new JTextField(30);

     b1=new JButton("Previous");
     b2=new JButton("Show");
     b3=new JButton("Next");
     b4=new JButton("Home");

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
     p4.add(b1);
     p4.add(b2);
     p4.add(b3);
     p4.add(b4);

     mp.add(p1);
     mp.add(p2);
     mp.add(p3);
     p1.setVisible(false);
     p2.setVisible(false);
p3.setVisible(false);
 mp.add(p4);
     add(mp);

     setVisible(true);
     setTitle("Show Record");
     setBounds(400,400,450,180);

         b1.addActionListener(this);
	      b2.addActionListener(this);
	      b3.addActionListener(this);
	      b4.addActionListener(this);

	       try{
		  		con=MyConnection.createConnection();
		  		JOptionPane.showMessageDialog(this,"Database connected");
		  		pst=con.prepareStatement("Select * from student");
		  		r=pst.executeQuery();

		  	 }catch(Exception  e)
		  	  {
		  		  JOptionPane.showMessageDialog(this,"Error in Connection");
		  	  }


	   }

	   public void actionPerformed(ActionEvent ae)
	   {
				try{
		   if(ae.getSource()==b2)
		   {






					  if(r.next())
					  {
					  t1.setText(""+r.getInt(1));
					   t2.setText(""+r.getString(2));
					    t3.setText(""+r.getString(3));
					     p1.setVisible(true);
					       p2.setVisible(true);
							     p3.setVisible(true);
				  		}


			  }


	 	     if(ae.getSource()==b4)
	 	     {
	 		    this.setVisible(false);
	 		    new HomePage();
	           }

	           if(ae.getSource()==b1)
			   	 {
			   	 		 if(r.previous())
			   	 		 {
							 t1.setText(""+r.getInt(1));
							 t2.setText(""+r.getString(2));
					    t3.setText(""+r.getString(3));
						 }
			   	 }
			   	           if(ae.getSource()==b3)
						   	  {
			   	 		 if(r.next())
			   	 		 {
							 t1.setText(""+r.getInt(1));
							 					   t2.setText(""+r.getString(2));
					    t3.setText(""+r.getString(3));
						 }

						   	  }



	            }

			   			catch(Exception e)
			   			{
			   				op.showMessageDialog(this,"Error in Display");

						}


     }



public  static void main (String arg[])
  {
	   new ShowRecord();
 }
 }


