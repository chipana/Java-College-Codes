
import javax.swing.*;

public class Disciplina
{
  private String Nome;
  private int    Creditos;
  private float PP,PF;
  public float  media()
  {
    return (PP+PF)/2;
  }

  public void ler()
  {
    Nome = JOptionPane.showInputDialog("Nome");
    Creditos = Integer.parseInt(JOptionPane.showInputDialog("Creditos"));
    PP = Float.parseFloat(JOptionPane.showInputDialog("PP"));
    PF = Float.parseFloat(JOptionPane.showInputDialog("PF"));
  }

  public String getNome()          { return Nome;    }
  public int    getCreditos()      { return Creditos;}
  public float getPP()             { return PP;    }
  public float getPF()             { return PF;    }
}