//programa da forca
import javax.swing.JOptionPane;

class Forca
{
   private int _Erros;
   private String _FRASE,_Frase,_Visor,_Letras;

   public void ObterFraseSecreta()
   {
     _Frase = JOptionPane.showInputDialog("Entre com a frase secreta");
     Inicializar(_Frase);
   }

   public String ObterFrase()
   {
     return _Frase;
   }

   private void MontarVisor()
   {
        _Visor = "";
        for(int i=0;i<_FRASE.length();i++)
            if (!Character.isLetter(_FRASE.charAt(i)) || _Letras.indexOf(_FRASE.charAt(i))>-1)
                _Visor = _Visor+_Frase.charAt(i)+" ";
            else
               _Visor = _Visor+"_ ";
   }

   public boolean DescobriuFrase()
   {
        boolean Descobriu = true;

        for(int i=0;i<_FRASE.length() && Descobriu;i++)
            if (Character.isLetter(_FRASE.charAt(i)) && _Letras.indexOf(_FRASE.charAt(i))==-1)
                Descobriu = false;
        return Descobriu;
   }

   public void Inicializar(String Frase)
   {
     _Frase = Frase;
     _FRASE = _Frase.toUpperCase().trim();
     _Visor = "";
     _Letras="";
     _Erros = 0;
     MontarVisor();
   }

   public void ChutarLetra(char L)
   {
       L = Character.toUpperCase(L);
       if (_Letras.indexOf(L)>-1 || !Character.isLetter(L) || _FRASE.indexOf(L)==-1)
         _Erros++;
       if (_Letras.indexOf(L)==-1)
         _Letras += L+" ";
       MontarVisor();
   }

   public boolean Acabou()
   {
     return _Erros>=5 || DescobriuFrase();
   }

   public char PedirLetra()
   {
     return JOptionPane.showInputDialog(_Visor+"\nErros:"+_Erros+"\nLetras:"+_Letras).trim().charAt(0);
   }
}



public class ex10
{
  public static void main(String[] s)
  {
    Forca f = new Forca();
    f.ObterFraseSecreta();
    while (!f.Acabou())
       f.ChutarLetra(f.PedirLetra());
    if (f.DescobriuFrase())
       JOptionPane.showMessageDialog(null, "Parabens! a Frase era\n"+f.ObterFrase());
    else
       JOptionPane.showMessageDialog(null,"Tente da proxima vez!\nFrase era\n"+f.ObterFrase());
    System.exit(0);
  }
}