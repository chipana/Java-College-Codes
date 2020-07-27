import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.io.*;

public class SqliteBD
{
   private static String _STR_CONEXAO_ = "jdbc:sqlite:Historico.db";
   public SqliteBD()
   {
     try{
  	Class.forName("org.sqlite.JDBC");// passo 1 - carregar o driver do banco
	File f = new File("Historico.db");
        if (!f.exists()) //se o banco nao existe entao cria
          criarBanco("Historico.db");
     }catch(Exception e)
     {
         e.printStackTrace();
         System.exit(0);
     }
   }

   private static void criarBanco(String nome) throws Exception
   {
	Connection conn = DriverManager.getConnection(_STR_CONEXAO_);
	if (conn != null) {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("create table Disciplina( "+
                          "Nome varchar(30) not null primary key,"+
                          "Creditos int not null, "+
                          "PP float not null, "+
                          "PF float not null, "+
                          "Foto blob)");
                stmt.close();
		conn.close();
        }
   }


   public int obterQtd()
   {
     int qtd=0;
     try{
	Connection conn = DriverManager.getConnection(_STR_CONEXAO_);
	if (conn != null) {
		PreparedStatement stmt = conn.prepareStatement("select count(*) from Disciplina");
		ResultSet r = stmt.executeQuery();
		if (r.next())
		   qtd = r.getInt(1);
                stmt.close();
		conn.close();
        }
	return qtd;
     }catch(Exception e)
     {
         e.printStackTrace();
         System.exit(0);
	 return 0;
     }
   }
   public void removerTodos()
   {
     try{
	Connection conn = DriverManager.getConnection(_STR_CONEXAO_);
	if (conn != null) {
		PreparedStatement stmt = conn.prepareStatement("delete from Disciplina");
		stmt.executeUpdate();
                stmt.close();
		conn.close();
        }
     }catch(Exception e)
     {
         e.printStackTrace();
         System.exit(0);
     }
   }
   public void inserir(Disciplina D)
   {
     try{
	Connection conn = DriverManager.getConnection(_STR_CONEXAO_);
	if (conn != null) {
		PreparedStatement stmt = conn.prepareStatement("insert into Disciplina(Nome,Creditos,PP,PF,Foto) values(?,?,?,?,?)");
		stmt.setString(1,D.getNome());
		stmt.setInt(2,D.getCreditos());
		stmt.setFloat(3,D.getPP());
		stmt.setFloat(4,D.getPF());
		stmt.setBytes(5,ImageToBytes(D.getFoto()));
		stmt.executeUpdate();
                stmt.close();
		conn.close();
        }
     }catch(Exception e)
     {
         e.printStackTrace();
         System.exit(0);
     }
   }
   public void alterar(String nome, Disciplina D)
   {
     try{
	Connection conn = DriverManager.getConnection(_STR_CONEXAO_);
	if (conn != null) {
		PreparedStatement stmt = conn.prepareStatement("update Disciplina set Nome=?, Creditos=? , PP=?, PF=?, Foto=? where Nome=?");
		stmt.setString(1,D.getNome());
		stmt.setInt(2,D.getCreditos());
		stmt.setFloat(3,D.getPP());
		stmt.setFloat(4,D.getPF());
		stmt.setBytes(5,ImageToBytes(D.getFoto()));
		stmt.setString(6,nome);
		stmt.executeUpdate();
                stmt.close();
		conn.close();
        }
     }catch(Exception e)
     {
         e.printStackTrace();
         System.exit(0);
     }
   }
   public void remover(String Nome)
   {
     try{
	Connection conn = DriverManager.getConnection(_STR_CONEXAO_);
	if (conn != null) {
		PreparedStatement stmt = conn.prepareStatement("delete from Disciplina where Nome=?");
		stmt.setString(1,Nome);
		stmt.executeUpdate();
                stmt.close();
		conn.close();
        }
     }catch(Exception e)
     {
         e.printStackTrace();
         System.exit(0);
     }
   }

   public Disciplina obterDisciplina(String Nome)
   {
     Disciplina d=null;
     try{
	Connection conn = DriverManager.getConnection(_STR_CONEXAO_);
	if (conn != null) {
		PreparedStatement stmt = conn.prepareStatement("select nome,creditos, pp, pf ,foto from Disciplina where nome=?");
		stmt.setString(1,Nome);
		ResultSet r = stmt.executeQuery();
		if (r.next())
		{
		   d = new Disciplina();
		   d.setNome(r.getString(1));
		   d.setCreditos(r.getInt(2));
		   d.setPP(r.getFloat(3));
		   d.setPF(r.getFloat(4));
                   d.setFoto(BytesToImage(r.getBytes(5)));
		}
                stmt.close();
		conn.close();
        }
	return d;
     }catch(Exception e)
     {
         e.printStackTrace();
         System.exit(0);
	 return null;
     }
   }



   public Collection<Disciplina> obterDisciplinas()
   {
     LinkedList<Disciplina> L= new LinkedList<Disciplina>();
     try{
	Connection conn = DriverManager.getConnection(_STR_CONEXAO_);
	if (conn != null) {
		PreparedStatement stmt = conn.prepareStatement("select nome,creditos, pp, pf from disciplina order by nome");
		ResultSet r = stmt.executeQuery();
		while (r.next())
		{
		   Disciplina d = new Disciplina();
		   d.setNome(r.getString(1));
		   d.setCreditos(r.getInt(2));
		   d.setPP(r.getFloat(3));
		   d.setPF(r.getFloat(4));
                   L.add(d);
		}
                stmt.close();
		conn.close();
        }
	return L;
     }catch(Exception e)
     {
         e.printStackTrace();
         System.exit(0);
	 return null;
     }
   }

   private static byte[] ImageToBytes(java.awt.Image img)
   {
      try{
	if (img==null)
           return null;
  	java.io.ByteArrayOutputStream memoria = new java.io.ByteArrayOutputStream();
        javax.imageio.ImageIO.write((java.awt.image.BufferedImage)img, "PNG", memoria);
	byte []v = memoria.toByteArray();
	return v;
     }catch(Exception e)
     {
       return null;
     }
   }
   private static java.awt.Image BytesToImage(byte []b)
   {
      try{
        if (b==null)
          return null;
  	java.io.ByteArrayInputStream memoria = new java.io.ByteArrayInputStream(b);
        java.awt.Image img = javax.imageio.ImageIO.read(memoria);
	return img; 
      }
      catch(Exception e)
      {
        return null;
      } 
   }
}