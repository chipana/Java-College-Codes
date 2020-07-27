//verificar se a frase eh palindrome
import javax.swing.JOptionPane;

public class ex8
{
  public static void main(String[] s)
  {
    String Frase;
    int j,i;
    boolean EhPalindrome = true;

    Frase = JOptionPane.showInputDialog("entre com a frase");
   
    i=0;
    j=Frase.length()-1;
    while( (EhPalindrome =  Frase.charAt(i++) == Frase.charAt(j--)) && i<j)
       ;               
/*    while( EhPalindrome && i<j)
      if (Frase.charAt(i) != Frase.charAt(j))
         EhPalindrome = false;
      else
      {
         i++;
         j--;
      }
*/
    
    JOptionPane.showMessageDialog(null, "a frase " + Frase +"\n"+ (EhPalindrome?"":"nao ") +"eh palindrome");
    System.exit(0);
  }
}