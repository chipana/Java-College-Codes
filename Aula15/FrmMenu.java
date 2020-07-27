
import javax.swing.*;
public class FrmMenu extends JFrame
{
	private JPanel pnlBotoes;
	private JButton criarBtn(String Nome)
	{
		JButton btn = new JButton(Nome);
		btn.setPreferredSize(new Dimension(200,30));
        	pnlBotoes.add(btn);
		btn.addActionListener(this);
		return btn;
	}
}