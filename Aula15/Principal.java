
import javax.swing.*;
public class Principal
{
   public static int menu()
   {
     int opc;
     do{
       opc = Integer.parseInt(JOptionPane.showInputDialog("1-Inserir\n2-Remover\n3-Alterar\n4-Listar\n5-CR\n6-Sair"));
     }while (opc<1 || opc > 6);
     return opc;
   }
   public static void main(String []s)
   {
     boolean Acabou = false;
     Historico h = new Historico();
     while (!Acabou)
     {
       switch(menu())
       {
         case 1 : Disciplina d = new Disciplina();
                  d.ler();
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
                     d.ler();
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
   }
}