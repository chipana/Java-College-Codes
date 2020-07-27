//bin2dec
import javax.swing.JOptionPane;

public class ex9
{
  public static void main(String[] s)
  {
    String Bin;
    int i,N,Pot;

    for(Bin = JOptionPane.showInputDialog("entre com um numero binario"),
        N=0,
        Pot=1,
        i=Bin.length()-1;
        i>=0;
        N+=((Bin.charAt(i) == '1')?Pot:0),
        i--,
        Pot*=2);

/*    N = 0;
    Pot = 1;
    for(i=Bin.length()-1;i>=0;i--) 
    {
       if (Bin.charAt(i) == '1')
       	 N = N + Pot;
       Pot = Pot * 2;  
    }
*/
    JOptionPane.showMessageDialog(null, "o numero binario:" + Bin +"\nVale:"+N);
    System.exit(0);
  }
}