//verificar se a frase eh palindrome
import javax.swing.JOptionPane;

public class ex12
{
  public static void main(String[] s)
  {
    String Frase,Corrigida;
    int i;
    char Letra;
    boolean EhInicioPalavra = true;

    Frase = JOptionPane.showInputDialog("entre com a frase");
   
    Corrigida = "";
    for(i=0;i<Frase.length();i++) 
    {
       Letra = Frase.charAt(i);
       if ( Character.isLetter(Letra) )
       {
           Corrigida = Corrigida + (EhInicioPalavra?Character.toUpperCase(Letra):Character.toLowerCase(Letra));
           EhInicioPalavra=false;
       }
       else
       {
           Corrigida += Letra;
           EhInicioPalavra=true;     
       } 
    }
    JOptionPane.showMessageDialog(null, "a frase era:" + Frase +"\nCorrigida:"+Corrigida);
    System.exit(0);
  }
}