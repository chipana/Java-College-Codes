//ex4 - leia aluno, nome,disc,creditos, nota1, nota2.
// media = (nota1 + 2*nota2)/3

import javax.swing.*;

public class ex4
{
    public static void main(String args[])
    {
       String Aluno,Disciplina;
       int Creditos;
       float Nota1,Nota2,Media;
       Aluno = JOptionPane.showInputDialog("Nome do Aluno=");
       Disciplina = JOptionPane.showInputDialog("Nome da Disciplina=");
       Creditos = Integer.parseInt(JOptionPane.showInputDialog("Creditos="));
       Nota1 = Float.parseFloat(JOptionPane.showInputDialog("Nota1="));
       Nota2 = Float.parseFloat(JOptionPane.showInputDialog("Nota2="));
       
       Media = (Nota1 + 2*Nota2)/3;
       JOptionPane.showMessageDialog(null,"Nome:"+Aluno+
                "\nDisciplina:"+Disciplina+
 		"\nCreditos:"+Creditos+
                "\nNota1:"+Nota1+
                "\nNota2:"+Nota2+
                "\nMedia:"+Media);
    }
}