//programa da forca
import javax.swing.JOptionPane;

class Velha
{
  private char M[][];
  private boolean VezX;

  public Velha()
  {
    M = new char[3][3];
    VezX = true;
    Inicializar();
  }

  public void Inicializar()
  {
    char L='1';
    for(int i=0;i<3;i++)
      for(int j=0;j<3;j++,L++)
         M[i][j] = L;
  }

  public String Mostrar()
  {
    String Resp="";
    for(int i=0;i<3;i++)
    {
      for(int j=0;j<3;j++)
         Resp+=M[i][j]+" ";
      Resp+="\n";
    }
    return Resp;
  }

  public boolean TemGanhador()
  {
    return  (M[0][0] == M[0][1] && M[0][0] == M[0][2]) ||
            (M[1][0] == M[1][1] && M[1][0] == M[1][2]) ||
            (M[2][0] == M[2][1] && M[2][0] == M[2][2]) ||
            (M[0][0] == M[1][0] && M[0][0] == M[2][0]) ||
            (M[0][1] == M[1][1] && M[0][1] == M[2][1]) ||
            (M[0][2] == M[1][2] && M[0][2] == M[2][2]) ||
            (M[0][0] == M[1][1] && M[0][0] == M[2][2]) ||
            (M[0][2] == M[1][1] && M[0][2] == M[2][0]);
  }

  public boolean TemEspaco()
  {
    return  M[0][0] <= '9' || M[1][0] <= '9' || M[2][0] <= '9' ||
            M[0][1] <= '9' || M[1][1] <= '9' || M[2][1] <= '9' ||
            M[0][2] <= '9' || M[1][2] <= '9' || M[2][2] <= '9';
  }

  public boolean DeuVelha()
  {
    return !TemGanhador() && !TemEspaco();
  }

  private int Linha(int pos)
  {
    return (pos-1)/3;
  }
  private int Coluna(int pos)
  {
    return (pos-1)%3;
  }

  public boolean Jogar(int pos)
  {
    int L = Linha(pos);
    int C = Coluna(pos);
    if (pos<1 || pos>9 || M[L][C]>'9')
      return false;
    else
    {
      M[L][C] = VezX?'X':'O';
      if (!TemGanhador())
         VezX = !VezX;
      return true;
    }
  }
  public char Vez()
  {
    return VezX?'X':'O';
  }
}



public class ex11
{
  public static void main(String[] s)
  {
    Velha v = new Velha();

    while (!v.TemGanhador() && !v.DeuVelha())
    {
      int pos = Integer.parseInt(JOptionPane.showInputDialog(v.Mostrar()+"\nJogador "+v.Vez()+" Entre com a posicao:"));
      v.Jogar(pos);
    }

    if (v.TemGanhador())
        JOptionPane.showMessageDialog(null,"Parabens jogador "+v.Vez()+"! Vc Ganhou!");
    else
        JOptionPane.showMessageDialog(null,"Deu Velha :(");
    System.exit(0);
  }
}