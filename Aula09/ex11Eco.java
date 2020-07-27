//programa da velha economizando memoria
import javax.swing.JOptionPane;
import java.util.Random;

class Velha
{
  private int M;
  private Random GerAle;

  public Velha()
  {
    M = 0;
    Inicializar();
    GerAle = new Random();
  }

  public void Inicializar()
  {
    M=0;
    SetVezX(true);
  }

  private char Get(int L, int C)
  {
    switch ((M >> (L*6+C*2)) & 3)
    {
      case 0  : return  (char)('0'+(L*3+C+1));
      case 1  : return 'X';
      case 2  : return 'O';
      default : return 'E';
    }
  }
  private int Get(int Pos)
  {
    return Get(Linha(Pos), Coluna(Pos));
  }
  private void Set(int L, int C, char Letra)
  {
    int Mascara = ~(3 << L*6 + C*2);
    int Valor = 0;
    switch(Letra)
    {
      case 'X' : Valor = 1; break;
      case 'O' : Valor = 2; break;
      default  : Valor = 0; break;
    }
    M = (M & Mascara) | (Valor << (L*6+C*2));
  }

  private void SetVezX(boolean VezX)
  {
        M = (M & (~(1<<19))) | ((VezX?1:0)<<19);
  }

  private boolean GetVezX()
  {
      return ((M >> 19) & 1) == 1;
  }

  public String Mostrar()
  {
    String Resp="";
    char L='1';
    for(int i=0;i<3;i++)
    {
      for(int j=0;j<3;j++)
         Resp+=Get(i,j)+" ";
      Resp+="\n";
    }
    return Resp;
  }

  public boolean TemGanhador()
  {
    return  (Get(0,0) == Get(0,1) && Get(0,0) == Get(0,2)) ||
            (Get(1,0) == Get(1,1) && Get(1,0) == Get(1,2)) ||
            (Get(2,0) == Get(2,1) && Get(2,0) == Get(2,2)) ||
            (Get(0,0) == Get(1,0) && Get(0,0) == Get(2,0)) ||
            (Get(0,1) == Get(1,1) && Get(0,1) == Get(2,1)) ||
            (Get(0,2) == Get(1,2) && Get(0,2) == Get(2,2)) ||
            (Get(0,0) == Get(1,1) && Get(0,0) == Get(2,2)) ||
            (Get(0,2) == Get(1,1) && Get(0,2) == Get(2,0));
  }

  public boolean TemEspaco()
  {
    return  Get(0,0)<= '9' || Get(1,0)<= '9' || Get(2,0)<= '9' ||
            Get(0,1)<= '9' || Get(1,1)<= '9' || Get(2,1)<= '9' ||
            Get(0,2)<= '9' || Get(1,2)<= '9' || Get(2,2)<= '9';
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
    return pos>=1 && pos<=9 && Get(L,C)<='9';
  }

  private void Marcar(int pos)
  {
    int L = Linha(pos);
    int C = Coluna(pos);
    Set(L,C,Vez());
  }

  private void Limpar(int pos)
  {
    int L = Linha(pos);
    int C = Coluna(pos);
    Set(L,C,' ');
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
         SetVezX(!GetVezX());
      return true;
    }
  }
  public char Vez()
  {
    return GetVezX()?'X':'O';
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
    SetVezX(!GetVezX());
    int pos = Ganhar();
    SetVezX(!GetVezX());
    return pos;
  }

  private int Aleatorio()
  {
      int V[]= new int[9];
      int qtd,i;
      qtd = 0;
      for(i=1;i<=9;i++)
        if (Livre(i))
          V[qtd++]= i;

      if (qtd==0)
        return -1;
      else
        return V[GerAle.nextInt(qtd)];
  }

}



public class ex11Eco
{
  public static void main(String[]s)
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