
public class Historico
{
   private SqliteBD BD;
   public Historico()
   {
      BD = new SqliteBD();
   }

   public void inserir(Disciplina d)
   {
      BD.inserir(d);
   }

   /*protected int obterIndice(String Nome)
   {
      int i = 0;
      boolean Achou = false;
      Disciplina []V = BD.obterDisciplinas().toArray();
      while (!Achou && i<Qtd)
         if (V[i].getNome().equals(Nome))
            Achou = true;
         else
            i++;
      return Achou?i:-1;
   }*/

   public void remover(String Nome)
   {
     BD.remover(Nome);
   }
   public void alterar(String Nome, Disciplina d)
   {
     BD.alterar(Nome,d);
   }
   public Disciplina obterDisciplina(String Nome)
   {
     return  BD.obterDisciplina(Nome);

   }
   public java.util.Collection<Disciplina> obterDisciplinas()
   {
     return BD.obterDisciplinas();
   }
   /*public Disciplina obterDisciplina(int pos)
   {
       return V[pos];
   } */
   public int obterQtd()
   {
      return BD.obterQtd();
   }
   public float CR()
   {
     float Soma=0;
     int Creditos=0;
     for(Disciplina d : BD.obterDisciplinas())
     {
       Soma = Soma + d.media()*d.getCreditos();
       Creditos = Creditos + d.getCreditos();
     }
     return Creditos>0?Soma / Creditos:0;
   }
}