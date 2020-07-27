

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FrmMenu extends JDialog implements ActionListener
{
  	private int Resp;
	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton)e.getSource();
		switch (btn.getText())
		{
			case "Inserir" : Resp = 1; break;
			case "Remover" : Resp = 2; break;
			case "Alterar" : Resp = 3; break;
			case "Listar"  : Resp = 4; break;
			case "CR"      : Resp = 5; break;
			case "Sair"    : Resp = 6; break;
			default        : Resp = 0; break;
		}
		setVisible(false);//hide();
	}

	private JPanel pnlBotoes;
	private JButton criarBtn(String Nome)
	{
		JButton btn = new JButton(Nome);
		btn.setPreferredSize(new Dimension(200,30));
        	pnlBotoes.add(btn);
		btn.addActionListener(this);
		return btn;
	}
	public FrmMenu()
	{
            setTitle("Gerenciador de Historico");
            setSize(300,270);
            setModal(true);
            setLocationRelativeTo(null);
            pnlBotoes = new JPanel();
            getContentPane().add(pnlBotoes, BorderLayout.CENTER);
            criarBtn("Inserir");
            criarBtn("Remover");
            criarBtn("Alterar");
            criarBtn("Listar");
            criarBtn("CR");
            criarBtn("Sair");
        }
        
        public static FrmMenu Instancia=null;
        public static int Executar()
        {
           if (Instancia==null)
             Instancia = new FrmMenu();
             
           Instancia.Resp = 0;
           Instancia.setVisible(true);
           return Instancia.Resp;
        }

        public static void main(String []s)
        {
            int opc;
            while ( (opc = FrmMenu.Executar())!=6)
               JOptionPane.showMessageDialog(null," Resp="+opc);
            System.exit(0);
        }
}