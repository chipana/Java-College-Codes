//ex2 - eq do 2 grau


import javax.swing.*;

public class ex2
{
    public static void main(String args[])
    {
       float A,B,C,Delta,R1,R2;
       A = Float.parseFloat(JOptionPane.showInputDialog("A="));
       B = Float.parseFloat(JOptionPane.showInputDialog("B="));
       C = Float.parseFloat(JOptionPane.showInputDialog("C="));
       
       Delta = (float)Math.pow(B,2)-4*A*C;

       if (A==0)    
         JOptionPane.showMessageDialog(null,"Não eh uma eq do 2 grau");
       else if (Delta < 0)
    	 JOptionPane.showMessageDialog(null,"Não possui raizes reais");
       else if (Delta==0)
       {
          R1 = -B/(2*A);
	  JOptionPane.showMessageDialog(null,"possui uma raiz real\n"+R1);
       }else
       {
          R1 = (-B-(float)Math.sqrt(Delta))/(2*A);
          R2 = (-B+(float)Math.sqrt(Delta))/(2*A);
	  JOptionPane.showMessageDialog(null,"possui duas raizes reais\n"+R1+" e "+R2);
       }
    }
}