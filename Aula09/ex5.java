//fatorial
import javax.swing.JOptionPane;

public class ex5
{
  public static void main(String[] s)
  {
    int x,i;
    long fat;
    x = Integer.parseInt(JOptionPane.showInputDialog("entre com o valor x"));
   
    fat = 1;
    for(i=1;i<=x;i++)
      fat = fat * i;
    
    JOptionPane.showMessageDialog(null, "Fat(" + x + ")=" + fat);
  }
}