import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HomePage extends JFrame implements ActionListener
{

   JPanel p1,p2,p3,p4,p5,mp;
   JButton b1,b2,b3,b4,b5;

   HomePage()
   {
	  setLayout(new FlowLayout());


     b1=new JButton("Insert Record");
     b2=new JButton("Delete Record");
     b3=new JButton("Show Record");
     b4=new JButton("Search Record");
     b5=new JButton("Back");

     p1=new JPanel();
     p2=new JPanel();
     p3=new JPanel();
     p4=new JPanel();
     p5=new JPanel();
     mp=new JPanel(new GridLayout(5,1));

     p1.add(b1);
     p2.add(b2);
     p3.add(b3);
     p4.add(b4);
     p5.add(b5);

     mp.add(p1);
     mp.add(p2);
     mp.add(p3);
     mp.add(p4);
     mp.add(p5);

     add(mp);

     setVisible(true);
     setTitle("Login");
    // setBounds(100,100,200,200);
    setBounds(400,400,450,250);

     b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);
     b4.addActionListener(this);
     b5.addActionListener(this);

  }

  public void actionPerformed(ActionEvent ae)
  {
	     if(ae.getSource()==b1)
	     {
		    this.setVisible(false);
		    new InsertRecord();
          }

          if(ae.getSource()==b2)
	  	   {
	  		    this.setVisible(false);
	  		    new DeleteRecord();
          }

          if(ae.getSource()==b3)
	  	   {
	  		    this.setVisible(false);
	  		    new ShowRecord();
          }

          if(ae.getSource()==b4)
	  	   {
	  		    this.setVisible(false);
	  		    new SearchRecord();
          }

          if(ae.getSource()==b5)
		   {
		  	    this.setVisible(false);
		  	    new Login();
          }


 }

  /*public  static void main (String arg[])
  {
	   new HomePage();
 }*/
 }


