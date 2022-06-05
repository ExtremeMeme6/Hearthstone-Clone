package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameView extends JFrame{

	public JPanel fHero;
	public JPanel sHero;
	public JPanel rSide;
	public JPanel lSide;
	public JFrame field;
	public JPanel endTurn;
	public JPanel fCards;
	public JPanel sCards;
	public JPanel fField;
	public JPanel sField;
	public JPanel fHeroInfo;
	public JPanel sHeroInfo;
	public GameView() {
		field = new JFrame();
		field.setBounds(0, 0, 1900, 1000);
		field.setTitle("Hearthstone");
		field.setVisible(true);
		lSide = new JPanel();
		lSide.setLayout(new BorderLayout());
		lSide.setPreferredSize(new Dimension(1500,900));
		field.add(lSide, BorderLayout.WEST);
		lSide.setVisible(true);
		
		
		fHero = new JPanel();
		fHero.setLayout(new BorderLayout());
		fHero.setPreferredSize(new Dimension(1500, 450));
		lSide.add(fHero, BorderLayout.SOUTH);
		fHero.setVisible(true);
		
		fCards = new JPanel();
		fCards.setPreferredSize(new Dimension(1500, 150));
		fHero.add(fCards, BorderLayout.SOUTH);
		fCards.setVisible(true);
		fCards.setBackground(Color.GRAY);
		
		fField = new JPanel();
		fField.setPreferredSize(new Dimension(1500, 150));
		fHero.add(fField, BorderLayout.NORTH);
		fField.setVisible(true);
		fField.setBackground(Color.GRAY);
		
		fHeroInfo = new JPanel();
		fHeroInfo.setPreferredSize(new Dimension(1500, 150));
		fHero.add(fHeroInfo, BorderLayout.CENTER);
		fHeroInfo.setVisible(true);
		fHeroInfo.setBackground(Color.WHITE);
		
		
		sHero = new JPanel();
		sHero.setLayout(new BorderLayout());
		sHero.setPreferredSize(new Dimension(1500, 450));
		lSide.add(sHero, BorderLayout.NORTH);
		sHero.setVisible(true);
		
		
		sCards = new JPanel();
		sCards.setPreferredSize(new Dimension(1500, 150));
		sHero.add(sCards, BorderLayout.NORTH);
		sCards.setVisible(true);
		sCards.setBackground(Color.GRAY);
		
		sField = new JPanel();
		sField.setPreferredSize(new Dimension(1500, 150));
		sHero.add(sField, BorderLayout.SOUTH);
		sField.setVisible(true);
		sField.setBackground(Color.GRAY);
		
		sHeroInfo = new JPanel();
		sHeroInfo.setPreferredSize(new Dimension(1500, 150));
		sHero.add(sHeroInfo, BorderLayout.CENTER);
		sHeroInfo.setVisible(true);
		sHeroInfo.setBackground(Color.WHITE);
		
	
		
		rSide = new JPanel();
		rSide.setPreferredSize(new Dimension(400, 900));
		field.add(rSide, BorderLayout.EAST);
		rSide.setVisible(true);
		rSide.setBackground(Color.WHITE);
		rSide.setLayout(new BorderLayout());
		endTurn = new JPanel();
		endTurn.setPreferredSize(new Dimension(400,500));
		endTurn.setVisible(true);
		rSide.add(endTurn, BorderLayout.CENTER);
		
		
		
		
	}
	public static void main(String args[]) {
		new GameView();
		
	}

}
