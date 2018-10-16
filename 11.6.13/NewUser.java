import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NewUser extends JFrame implements ActionListener
{
   JPasswordField p;
   JPanel p1,p2,p3,p4,mp;
   JLabel lb1,lb2,lb3;
   JButton b1,b2;
   JTextField t1,t2;

  NewUser()
   {
     setLayout(new FlowLayout());

     p=new JPasswordField(30);

     lb1=new JLabel("Name        : ");
     lb2=new JLabel("Password : ");
     lb3=new JLabel("Address    : ");

     t1=new JTextField(30);
     t2=new JTextField(30);

     b1=new JButton("Create");
     b2=new JButton("Back");


     p1=new JPanel();
     p2=new JPanel();
     p3=new JPanel();
     p4=new JPanel();
     mp=new JPanel(new GridLayout(4,1));

     p1.add(lb1);
     p1.add(t1);
     p2.add(lb2);
     p2.add(p);
     p3.add(lb3);
     p3.add(t2);
     p4.add(b1);
     p4.add(b2);

     mp.add(p1);
     mp.add(p2);
     mp.add(p3);
     mp.add(p4);

     add(mp);

     setVisible(true);
     setTitle("New User");
     setBounds(400,400,450,200);

     b2.addActionListener(this);

  }

   public void actionPerformed(ActionEvent ae)
    {
  	     if(ae.getSource()==b2)
	     {
			 this.setVisible(false);
             new Login();
		}
}

  /*public  static void main (String arg[])
  {
	   new NewUser();
 }*/
 }


