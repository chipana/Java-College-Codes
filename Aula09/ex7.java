//verificar se x eh primo
import javax.swing.JOptionPane;

public class ex7
{
  public static void main(String[] s)
  {
    int x,i;
    boolean EhPrimo = true;

    x = Integer.parseInt(JOptionPane.showInputDialog("entre com o valor x"));
   
    i=2;
    while( EhPrimo && i<x)
      if (x % i == 0)
         EhPrimo = false;
      else
         i++;
    
    JOptionPane.showMessageDialog(null, "o numero " + x + (EhPrimo?" ":" nao ") +"eh primo");
    System.exit(0);
  }
}