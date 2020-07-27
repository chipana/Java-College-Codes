

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

public class FrmSplash extends JDialog
{
        private BufferedImage Fundo;
        private Font Fonte;
        private BufferedImage LerImagem(String Nome)
        {
           BufferedImage img = null;
           try {
               img = javax.imageio.ImageIO.read(new java.io.File(Nome));
           } catch (java.io.IOException e) {}
           return img;
        }

	public FrmSplash()
	{
            setTitle("Splash");
            Fundo = LerImagem("Splash.jpg");
            Fonte = new Font("Arial", Font.BOLD, 26);
            setUndecorated(true);
            setSize(450,270);
            //setModal(true);
            setLocationRelativeTo(null);
        }


        public void paint(Graphics G)
        {
           super.paint(G);
           G.drawImage(Fundo,0,0,getWidth(),getHeight(),null);

           G.setColor(Color.YELLOW);
           G.setFont(Fonte);
           G.drawString("FAETERJ Historico 0.98b",80,60);
           G.setColor(new Color(255,100,0,150));
           G.fillRect(50,230,350,10);
        }

        private void pintaBarra(Graphics G, float Progresso)
        {

           G.setColor(new Color(255,255,100,150));
           G.fillRect(50,230,(int)(350*Progresso/100f),10);

           G.setColor(Color.BLACK);
           G.drawRect(50,230,350,10);
        }

        private void mostrar()
        {
           setVisible(true);
           Graphics G = getGraphics();
           for(int i=0;i<100;i++)
           {
              pintaBarra(G,i);
              try{ Thread.sleep(20); }catch(Exception e) {}
           }
           Instancia.setVisible(false);
        }

        public static FrmSplash Instancia=null;
        public static void Executar()
        {
           if (Instancia==null)
             Instancia = new FrmSplash();
           Instancia.mostrar();
        }

        public static void main(String []s)
        {
            FrmSplash.Executar();
            System.exit(0);
        }
}