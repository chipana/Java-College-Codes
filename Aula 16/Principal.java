
import javax.swing.*;
public class Principal
{

   public static void main(String []s)
   {
     boolean Acabou = false;
     Historico h = new Historico();
     while (!Acabou)
     {
       switch(FrmMenu.Executar())
       {
         case 1 : Disciplina d = new Disciplina();
                  if (FrmDisciplina.Executar(d))
                      h.inserir(d);
                  break;
         case 2 : String Nome = JOptionPane.showInputDialog("Entre com o nome da disciplina para remover");
                  h.remover(Nome);
                  break;
         case 3 : Nome = JOptionPane.showInputDialog("Entre com o nome da disciplina para alterar");
                  d = h.obterDisciplina(Nome);
                  if (d==null)
                     JOptionPane.showMessageDialog(null,"Disciplina nao encontrada");
                  else
                     FrmDisciplina.Executar(d);
                  break;
         case 4 : String R="";
                  for(int i=0;i<h.obterQtd();i++)
                  {
                      d = h.obterDisciplina(i);
                      R += d.getNome()+" " + d.getCreditos()+" "+d.media()+"\n";
                  }
                  JOptionPane.showMessageDialog(null,R);
                  break;
         case 5 : JOptionPane.showMessageDialog(null,"CR="+h.CR());
                  break;
         case 6 : Acabou = true;
                  break;
       }
     }
     System.exit(0);
   }
}