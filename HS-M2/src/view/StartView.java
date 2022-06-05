package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartView extends JFrame {
	public JPanel fHero;
	public JPanel sHero;
	public JPanel confirm;
	public JFrame field;
	

	public StartView() {
		field = new JFrame();
		field.setBounds(0, 0, 1000, 600);
		field.setTitle("Hearthstone");
		field.setVisible(true);
		fHero = new JPanel();
		fHero.setPreferredSize(new Dimension(getWidth(), 200));
		field.add(fHero, BorderLayout.SOUTH);
		fHero.setVisible(true);
		sHero = new JPanel();
		sHero.setPreferredSize(new Dimension(getWidth(), 200));
		field.add(sHero, BorderLayout.NORTH);
		sHero.setVisible(true);
		confirm = new JPanel();
		confirm.setPreferredSize(new Dimension(10,10));
		field.add(confirm, BorderLayout.CENTER);
	}

}
