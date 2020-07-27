
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

  public String getNome()          { return Nome;    }
  public int    getCreditos()      { return Creditos;}
  public float getPP()             { return PP;    }
  public float getPF()             { return PF;    }
  public void setNome(String vl)   { Nome = vl;    }
  public void setCreditos(int vl)  { Creditos=vl;  }
  public void setPP(float vl)      { PP = vl;      }
  public void setPF(float vl)      { PF = vl;      }
}