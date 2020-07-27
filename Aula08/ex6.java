//mostrar todos os divisores
import javax.swing.JOptionPane;

public class ex6
{
  public static void main(String[] s)
  {
    int x,i;
    String Divisores="";
    x = Integer.parseInt(JOptionPane.showInputDialog("entre com o valor x"));
   
    for(i=1;i<=x;i++)
      if (x % i == 0)
         Divisores = Divisores + i + " ";
    
    JOptionPane.showMessageDialog(null, "os divisores de " + x + " sao:\n" + Divisores);
    System.exit(0);
  }
}