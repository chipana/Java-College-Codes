

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FrmDisciplina extends JDialog implements ActionListener
{
  	private int Resp;
  	private Disciplina disc;
	public void actionPerformed(ActionEvent e)
	{
             try{
		JButton btn = (JButton)e.getSource();
		switch (btn.getText())
		{
			case "Ok"       :
                          AtualizarObjeto(disc);
                          Resp = 1; break;
			case "Cancelar" : Resp = 2; break;
			default         : Resp = 0; break;
		}
		setVisible(false);//hide();
             }catch(Exception ex)
             {
               JOptionPane.showMessageDialog(null,"Dados do aluno invalidos");
             }
	}

	private JPanel pnlBotoes,pnlDados;
	private JTextField tbxNome, tbxCreditos, tbxPP, tbxPF;
	private JButton criarBtn(String Nome)
	{
		JButton btn = new JButton(Nome);
		btn.setPreferredSize(new Dimension(100,30));
        	pnlBotoes.add(btn);
		btn.addActionListener(this);
		return btn;
	}
	private int Linha = 0;
        private JTextField criarCampo(String Nome, int Tamanho)
        {
		JTextField tbx = new JTextField(Tamanho);
		JLabel lbl = new JLabel(Nome);

                lbl.setBounds(20,20+25*Linha,70,20);
                tbx.setBounds(90, 20+25*Linha,Tamanho*5,20);

		pnlDados.add(lbl);
        	pnlDados.add(tbx);
        	Linha++;
		return tbx;

        }
	public FrmDisciplina()
	{
            setTitle("Gerenciador de Historico");
            setSize(330,200);
            setMinimumSize(new Dimension(330,200));
            setMaximumSize(new Dimension(330,200));
            setModal(true);
            setLocationRelativeTo(null);
            pnlBotoes = new JPanel();
            getContentPane().add(pnlBotoes, BorderLayout.SOUTH);
            pnlDados = new JPanel();
            pnlDados.setLayout(null);
            getContentPane().add(pnlDados, BorderLayout.CENTER);
            criarBtn("Ok");
            criarBtn("Cancelar");
            tbxNome = criarCampo("Nome:",40);
            tbxCreditos = criarCampo("Creditos:",20);
            tbxPP = criarCampo("PP:",10);
            tbxPF = criarCampo("PF:",10);
        }
        
        private void AtualizarTela(Disciplina a)
        {
          tbxNome.setText(a.getNome());
          tbxCreditos.setText(""+a.getCreditos());
          tbxPP.setText(""+a.getPP());
          tbxPF.setText(""+a.getPF());
        }

        private void AtualizarObjeto(Disciplina a)
        {
          a.setNome(tbxNome.getText());
          a.setCreditos(Integer.parseInt(tbxCreditos.getText()));
          a.setPP(Float.parseFloat(tbxPP.getText()));
          a.setPF(Float.parseFloat(tbxPF.getText()));
        }

        public static FrmDisciplina Instancia=null;
        public static boolean Executar(Disciplina a)
        {
           if (Instancia==null)
             Instancia = new FrmDisciplina();

           Instancia.Resp = 0;
           Instancia.disc = a;
           Instancia.AtualizarTela(a);
           Instancia.setVisible(true);
           return Instancia.Resp==1;
        }

        public static void main(String []s)
        {
            Disciplina a = new Disciplina();
            a.setNome("PRJ");
            a.setCreditos(6);
            a.setPP(10);
            a.setPF(3);
            FrmDisciplina.Executar(a);
            JOptionPane.showMessageDialog(null,
              "Nome:"+a.getNome()+"\nCreditos:"+a.getCreditos()+
              "\nPP:"+a.getPP()+"\nPF:"+a.getPF()+"\nMedia:"+a.media());
            System.exit(0);
        }
}