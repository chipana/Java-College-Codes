//programa da forca
import javax.swing.JOptionPane;
import java.util.Random;

class Velha
{
  private char M[][];
  private boolean VezX;
  private Random GerAle;

  public Velha()
  {
    M = new char[3][3];
    VezX = true;
    Inicializar();
    GerAle = new Random();
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
  public boolean Livre(int pos)
  {
    int L = Linha(pos);
    int C = Coluna(pos);
    return pos>=1 && pos<=9 && M[L][C]<='9';
  }

  private void Marcar(int pos)
  {
    int L = Linha(pos);
    int C = Coluna(pos);
    M[L][C] = VezX?'X':'O';
  }

  private void Limpar(int pos)
  {
    int L = Linha(pos);
    int C = Coluna(pos);
    M[L][C] = (char)('0'+pos);
  }

  public boolean Jogar(int pos)
  {
    int L = Linha(pos);
    int C = Coluna(pos);
    if (!Livre(pos))
      return false;
    else
    {
      Marcar(pos);
      if (!TemGanhador())
         VezX = !VezX;
      return true;
    }
  }
  public char Vez()
  {
    return VezX?'X':'O';
  }

  public int Sugerir()
  {
    int pos;
    if (Livre(5))
       return 5;
    else if ( (pos = Ganhar())!=-1)
       return pos;
    else if ( (pos = Perder())!=-1)
       return pos;
    else
       return Aleatorio();
  }

  private int Ganhar()
  {
    int pos = -1;
    boolean Achou = false;
    char L = Vez();
    for(int i=1;i<=9 && !Achou;i++)
       if (Livre(i))
       {
          Marcar(i);
          if (TemGanhador())
          {
              Achou = true;
              pos = i;
          }
          Limpar(i);
       }

    return pos;
  }

  private int Perder()
  {
    VezX = !VezX;
    int pos = Ganhar();
    VezX = !VezX;
    return pos;
  }

  private int Aleatorio()
  {
      int V[] = new int[9];
      int qtd,i;
      qtd = 0;
      for(i=1;i<=9;i++)
        if (Livre(i))
          V[qtd++] = i;

      if (qtd==0)
        return -1;
      else
        return V[GerAle.nextInt(qtd)];
  }

}



public class ex11Hard
{
  public static void main(String[] s)
  {
    Velha v = new Velha();

    while (!v.TemGanhador() && !v.DeuVelha())
      if (v.Vez()=='O')
        v.Jogar(v.Sugerir());
      else
        v.Jogar(Integer.parseInt(JOptionPane.showInputDialog(v.Mostrar()+"\nJogador "+v.Vez()+" Entre com a posicao:")));

    if (v.TemGanhador())
        JOptionPane.showMessageDialog(null,"Parabens jogador "+v.Vez()+"! Vc Ganhou!");
    else
        JOptionPane.showMessageDialog(null,"Deu Velha :(");
    System.exit(0);
  }
}