import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class DeleteRecord extends JFrame implements ActionListener
{

   JPanel p1,p2,p3,mp;
   JLabel lb1,lb2;
   JButton b1,b2;
   JTextField t1,t2;
   Connection con;
PreparedStatement  pst;

  DeleteRecord()
   {
     setLayout(new FlowLayout());



     lb1=new JLabel("Roll No.       : ");
     lb2=new JLabel("Name           : ");

     t1=new JTextField(30);
     t2=new JTextField(30);

     b1=new JButton("Delete");
     b2=new JButton("Home");


     p1=new JPanel();
     p2=new JPanel();
     p3=new JPanel();
     mp=new JPanel(new GridLayout(4,1));

     p1.add(lb1);
     p1.add(t1);
     p2.add(lb2);
     p2.add(t2);
     p3.add(b1);
     p3.add(b2);

     mp.add(p1);
     mp.add(p2);
     mp.add(p3);

     add(mp);

     setVisible(true);
     setTitle("Delete Record");
     setBounds(400,400,450,180);

     b1.addActionListener(this);
     b2.addActionListener(this);
     try{
	 		con=MyConnection.createConnection();
	 		JOptionPane.showMessageDialog(this,"Database connected");
	 		pst=con.prepareStatement("delete from student where rollno=?");

	 	 }catch(Exception  e)
	 	  {
	 		  JOptionPane.showMessageDialog(this,"Error in Deletion");
	 	  }


  }

     public void actionPerformed(ActionEvent ae)
       {
		   if(ae.getSource()==b1)
		        	     {
							 try{
		        		   // pst.setInt(1,Integer.parseInt(t1.getText()));
		        		    pst.setInt(1,Integer.parseInt(t1.getText()));

            int    r=	pst.executeUpdate();
			 if(r>=1)
			 {
				JOptionPane.showMessageDialog(this,"Record is Deleted");
			}
			else
				{
			JOptionPane.showMessageDialog(this,"Record is not Deleted");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Error in Deletion");

		}
	}
     	     if(ae.getSource()==b2)
     	     {
     		    this.setVisible(false);
     		    new HomePage();
            }

     }

  /*public  static void main (String arg[])
  {
	   new DeleteRecord();
 }*/
 }


