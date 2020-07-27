import javax.swing.JOptionPane;

public class ex3
{
  public static void main(String[] s)
  {
    float x1 = Float.parseFloat(JOptionPane.showInputDialog("X1="));
    float y1 = Float.parseFloat(JOptionPane.showInputDialog("Y1="));
    float x2 = Float.parseFloat(JOptionPane.showInputDialog("X2="));
    float y2 = Float.parseFloat(JOptionPane.showInputDialog("Y2="));
    
    float media = (float)Math.sqrt(Math.pow(x1 - x2, 2.0f) + Math.pow(y1 - y2, 2.0f));
    
    JOptionPane.showMessageDialog(null, "Distancia = " + media);
  }
}