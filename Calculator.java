import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Calculator implements ActionListener,WindowListener
{
int k;
String op1,op2,op;
JFrame f;
JLabel l;
JButton b[]=new JButton[16];
String caption[]={"7","8","9","+","4","5","6","-","1","2","3","*","BS","0","=","/"};
String digits="0123456789";
String operators="+-*/";
JPanel p;
Calculator()
{
f=new JFrame("Calculator");
f.addWindowListener(this);
l=new JLabel("0");
l.setFont(new Font("Arial",1,40));
p=new JPanel();
p.setLayout(new GridLayout(4,4));
for(int i=0;i<16;i++)
{
b[i]=new JButton(caption[i]);
b[i].addActionListener(this);
b[i].setFont(new Font("Arial",1,24));
p.add(b[i]);
}
f.add(l,BorderLayout.NORTH);
f.add(p);
f.setVisible(true);
f.setSize(400,400);
}
public static void main(String ar[])
{
Calculator c=new Calculator();
}
public void actionPerformed(ActionEvent e)
{
JButton bt=(JButton)e.getSource();
String text=bt.getText();

if(digits.contains(text))
{
if(k==0)
{
l.setText(text);
k=1;
}
else
{
l.setText(l.getText()+text);
}
}

else if(operators.contains(text))
{
op1=l.getText();
op=text;
k=0;
}
else if(text.equals("="))
{
op2=l.getText();
calc();
}

}

void calc()
{
float a,b,c;
a=Float.parseFloat(op1);
b=Float.parseFloat(op2);
if(op.equals("+"))
c=a+b;
else if(op.equals("-"))
c=a-b;
else if(op.equals("*"))
c=a*b;
else
c=a/b;
l.setText(""+c);
}

public void windowClosing(WindowEvent e)
{
f.dispose();
}
public void windowClosed(WindowEvent e)
{
}
public void windowOpened(WindowEvent e)
{
}
public void windowIconified(WindowEvent e)
{
}
public void windowDeiconified(WindowEvent e)
{
}
public void windowActivated(WindowEvent e)
{
}
public void windowDeactivated(WindowEvent e)
{
}

}