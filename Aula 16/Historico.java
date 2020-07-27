public class Historico
{
   private Disciplina []V;
   private int Qtd;
   public Historico()
   {
      V = new Disciplina[100];
      Qtd = 0;
   }
   
   public void inserir(Disciplina d)
   {
      V[Qtd] = d;
      Qtd++;
   }
   
   protected int obterIndice(String Nome)
   {
      int i = 0;
      boolean Achou = false;
      while (!Achou && i<Qtd)
         if (V[i].getNome().equals(Nome))
            Achou = true;
         else
            i++;
      /*if (Achou)
         return i;
      else
         return -1;*/
      return Achou?i:-1;
   }

   public void remover(String Nome)
   {
      int pos = obterIndice(Nome);
      if (pos>=0)
      {
          V[pos] = V[Qtd-1];
          Qtd--;
      }
   }
   public Disciplina obterDisciplina(String Nome)
   {
      int pos = obterIndice(Nome);
      if (pos>=0)
         return V[pos];
      else
          return null;
   }
   public Disciplina obterDisciplina(int pos)
   {
       return V[pos];
   }
   public int obterQtd()
   {
      return Qtd;
   }
   public float CR()
   {
     float Soma=0;
     int Creditos=0;
     for(int i=0;i<Qtd;i++)
     {
       Soma = Soma + V[i].media()*V[i].getCreditos();
       Creditos = Creditos + V[i].getCreditos();
     }
     return Creditos>0?Soma / Creditos:0;
   }
}