package control;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.*;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.FieldSpell;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import view.GameView;
import view.StartView;


public class Control implements ActionListener, GameListener {
	private Hero p1;
	private Hero p2;
	private Game game;
	private StartView view = new StartView();
	private JButton hunterp1 = new JButton();
	private JButton magep1 = new JButton();
	private JButton paladinp1 = new JButton();
	private JButton warlockp1 = new JButton();
	private JButton priestp1 = new JButton();
	private JButton hunterp2 = new JButton();
	private JButton magep2 = new JButton();
	private JButton paladinp2 = new JButton();
	private JButton warlockp2 = new JButton();
	private JButton priestp2 = new JButton();
	private JButton confirm = new JButton();
	private GameView view2;
	private JButton endTurn;
	private JTextArea fdeck;
	private JTextArea sdeck;
	private JTextArea fHeroInfo;
	private JTextArea sHeroInfo; 
	private JButton fPlayer;
	private JButton fHeroPower;
	private JButton sPlayer;
	private JButton sHeroPower;
	private ArrayList<JButton> fHand = new ArrayList<JButton>(10);
	private ArrayList<JButton> sHand = new ArrayList<JButton>(10);
	private ArrayList<JButton> fField = new ArrayList<JButton>(7);
	private ArrayList<JButton> sField = new ArrayList<JButton>(7);
	JButton selectedToAttack;
	JButton spell;
	JButton HeroPower;
	public Control() throws IOException, CloneNotSupportedException, FullHandException {
		view.confirm.add(confirm, BorderLayout.CENTER);
		confirm.setText("Confirm");
		confirm.addActionListener(this);
		view.fHero.add(hunterp1);
		hunterp1.setText("Hero: Hunter \n Name: Rexxar");
		hunterp1.addActionListener(this);
		view.fHero.add(magep1);
		magep1.setText("Hero: Mage \n Name: Jaina Proudmoore");
		magep1.addActionListener(this);
		view.fHero.add(paladinp1);
		paladinp1.setText("Hero: Paladin \n Name: Uther Lightbringer");
		paladinp1.addActionListener(this);
		view.fHero.add(priestp1);
		priestp1.setText("Hero: Priest \n Name: Anduin Wrynn");
		priestp1.addActionListener(this);
		view.fHero.add(warlockp1);
		warlockp1.setText("Hero: Warlock \n Name: Gul'dan");
		warlockp1.addActionListener(this);
		view.sHero.add(hunterp2);
		hunterp2.setText("Hero: Hunter \n Name: Rexxar");
		hunterp2.addActionListener(this);
		view.sHero.add(magep2);
		magep2.setText("Hero: Mage \n Name: Jaina Proudmoore");
		magep2.addActionListener(this);
		view.sHero.add(paladinp2);
		paladinp2.setText("Hero: Paladin \n Name: Uther Lightbringer");
		paladinp2.addActionListener(this);
		view.sHero.add(priestp2);
		priestp2.setText("Hero: Priest \n Name: Anduin Wrynn");
		priestp2.addActionListener(this);
		view.sHero.add(warlockp2);
		warlockp2.setText("Hero: Warlock \n Name: Gul'dan");
		warlockp2.addActionListener(this);
		
		
	}

	@Override
	public void onGameOver() {
		view2.field.dispose();
		if(p1.getCurrentHP() == 0)
			JOptionPane.showMessageDialog(null, "Player two is the winner");
		if(p2.getCurrentHP() == 0)
			JOptionPane.showMessageDialog(null, "Player One is the winner");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == hunterp1) {
			try {
				p1 = new Hunter();
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == magep1) {
			try {
				p1 = new Mage();
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == paladinp1) {
			try {
				p1 = new Paladin();
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == priestp1) {
			try {
				p1 = new Priest();
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == warlockp1) {
			try {
				p1 = new Warlock();
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == hunterp2) {
			try {
				p2 = new Hunter();
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == magep2) {
			try {
				p2 = new Mage();
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == paladinp2) {
			try {
				p2 = new Paladin();
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == priestp2) {
			try {
				p2 = new Priest();
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == warlockp2) {
			try {
				p2 = new Warlock();
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(p1 != null && p2 != null && e.getSource() == confirm) {
			try {
				game = new Game(p1,p2);
			} catch (FullHandException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			game.setListener(this);
			try {
				game.getCurrentHero().drawCard();
			} catch (FullHandException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			view.field.dispose();
			 view2 = new GameView();
			 endTurn = new JButton();
			 endTurn.addActionListener(this);
			view2.endTurn.add(endTurn);
			endTurn.setVisible(true);
			endTurn.setText("End Turn");
			endTurn.setPreferredSize(new Dimension(100,20));
			fdeck = new JTextArea();
			fdeck.setText("      Deck: "+(p1.getDeck().size()));
			view2.rSide.add(fdeck, BorderLayout.SOUTH);
			fdeck.setVisible(true);
			fdeck.setEditable(false);
			fdeck.setPreferredSize(new Dimension(400, 350));
			sdeck = new JTextArea();
			sdeck.setText("      Deck: "+(p2.getDeck().size()));
			view2.rSide.add(sdeck, BorderLayout.NORTH);
			sdeck.setVisible(true);
			sdeck.setEditable(false);
			sdeck.setPreferredSize(new Dimension(400, 350));
			cardView(p1, view2.fCards, fHand);
			cardView(p2, view2.sCards, sHand);
			
			 fHeroInfo = new JTextArea();
			fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
			p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
			view2.fHeroInfo.add(fHeroInfo, BorderLayout.CENTER);
			fHeroInfo.setVisible(true);
			fHeroInfo.setEditable(false);
			sHeroInfo = new JTextArea();
			sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
			view2.sHeroInfo.add(sHeroInfo, BorderLayout.CENTER);
			sHeroInfo.setVisible(true);
			sHeroInfo.setEditable(false);
			fPlayer = new JButton();
			fPlayer.setText(p1.getName());
			fPlayer.setVisible(true);
			fPlayer.addActionListener(this);
			view2.fHeroInfo.add(fPlayer, BorderLayout.CENTER);
			
			 fHeroPower = new JButton();
			fHeroPower.setText("Hero Power");
			fHeroPower.setVisible(true);
			fHeroPower.addActionListener(this);
			view2.fHeroInfo.add(fHeroPower, BorderLayout.CENTER);
			
			sPlayer = new JButton();
			sPlayer.setText(p2.getName());
			sPlayer.setVisible(true);
			sPlayer.addActionListener(this);
			view2.sHeroInfo.add(sPlayer, BorderLayout.CENTER);
			
			 sHeroPower = new JButton();
			sHeroPower.setText("Hero Power");
			sHeroPower.setVisible(true);
			sHeroPower.addActionListener(this);
			view2.sHeroInfo.add(sHeroPower, BorderLayout.CENTER);
			

			
			
		}
	
		if(e.getSource() == endTurn) {

			try {
				game.endTurn();
			} catch (FullHandException | CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				
			}
			if(game.getCurrentHero() == p1) {
				fHeroInfo.setText("Name: "  + game.getCurrentHero().getName() + "\n" + "Total Mana Crystals: " + game.getCurrentHero().getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						game.getCurrentHero().getCurrentManaCrystals() + "\n" + "Current HP: " + game.getCurrentHero().getCurrentHP());
				fHand.clear();
				view2.fCards.removeAll();
				cardView(p1,view2.fCards, fHand);
				view2.fCards.revalidate();
				view2.fCards.repaint();
				sHand.clear();
				view2.sCards.removeAll();
				cardView(p2,view2.sCards, sHand);
				view2.sCards.revalidate();
				view2.sCards.repaint();
				fdeck.setText("      Deck: "+(p1.getDeck().size()));
			}
			if(game.getCurrentHero() == p2) {
				sHeroInfo.setText("Name: "  + game.getCurrentHero().getName() + "\n" + "Total Mana Crystals: " + game.getCurrentHero().getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						game.getCurrentHero().getCurrentManaCrystals() + "\n" + "Current HP: " + game.getCurrentHero().getCurrentHP());
				fHand.clear();
				view2.fCards.removeAll();
				cardView(p1,view2.fCards, fHand);
				view2.fCards.revalidate();
				view2.fCards.repaint();
				sHand.clear();
				view2.sCards.removeAll();
				cardView(p2,view2.sCards, sHand);
				view2.sCards.revalidate();
				view2.sCards.repaint();
				sdeck.setText("      Deck: "+(p2.getDeck().size()));
			}
			
		}
		if(game != null && game.getCurrentHero() == p1 && fHand.contains(e.getSource())) {
			int i = fHand.indexOf(e.getSource());
			if(p1.getHand().get(i) instanceof Minion) {
			Minion m = (Minion) p1.getHand().get(i);
			try {
				p1.playMinion(m);
			} catch (NotYourTurnException | NotEnoughManaException | FullFieldException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				
			}
			if(p1.getField().contains(m)) {
				fField.add(fHand.get(i));
				view2.fField.add(fField.get(fField.indexOf(e.getSource())));
				view2.fField.revalidate();
				view2.fField.repaint();
			view2.fCards.remove(fHand.get(i));
			fHand.remove(i);
			view2.fCards.revalidate();
			view2.fCards.repaint();
			fHeroInfo.setText("Name: "  + game.getCurrentHero().getName() + "\n" + "Total Mana Crystals: " + game.getCurrentHero().getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					game.getCurrentHero().getCurrentManaCrystals() + "\n" + "Current HP: " + game.getCurrentHero().getCurrentHP());
			}
			
		}
	    }
		
			if(game != null && game.getCurrentHero() == p2 && sHand.contains(e.getSource())) {
				int i = sHand.indexOf(e.getSource());
				if(p2.getHand().get(i) instanceof Minion) {
				Minion m = (Minion) p2.getHand().get(i);
				try {
					p2.playMinion(m);
				} catch (NotYourTurnException | NotEnoughManaException | FullFieldException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
				if(p2.getField().contains(m)) {
					sField.add(sHand.get(i));
					view2.sField.add(sField.get(sField.indexOf(e.getSource())));
					view2.sField.revalidate();
					view2.sField.repaint();
				view2.sCards.remove(sHand.get(i));
				sHand.remove(i);
				view2.sCards.revalidate();
				view2.sCards.repaint();
				sHeroInfo.setText("Name: "  + game.getCurrentHero().getName() + "\n" + "Total Mana Crystals: " + game.getCurrentHero().getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						game.getCurrentHero().getCurrentManaCrystals() + "\n" + "Current HP: " + game.getCurrentHero().getCurrentHP());
				}
				
			}
		    }
			
		if(game != null && game.getCurrentHero() == p1) {
			if(sField.contains(e.getSource()) && fField.contains(selectedToAttack)) {
				int i = sField.indexOf(e.getSource());
				int j = fField.indexOf(selectedToAttack);
				try {
					p1.attackWithMinion(p1.getField().get(j), p2.getField().get(i));
				} catch (CannotAttackException | NotYourTurnException | TauntBypassException | InvalidTargetException
						| NotSummonedException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
					fField.clear();
					view2.fField.removeAll();
					FieldView(p1,view2.fField,fField);
					view2.fField.revalidate();
					view2.fField.repaint();
					
					sField.clear();
					view2.sField.removeAll();
					FieldView(p2,view2.sField,sField);
					view2.sField.revalidate();
					view2.sField.repaint();
				
					
			
				
				
			}
			else {
			if(!sField.contains(e.getSource())) {
				if(fField.contains(e.getSource())) {
					selectedToAttack = fField.get(fField.indexOf(e.getSource()));
				}
			}
			}
		}
		if(game != null && game.getCurrentHero() == p2) {
			if(fField.contains(e.getSource()) && sField.contains(selectedToAttack)) {
				int i = fField.indexOf(e.getSource());
				int j = sField.indexOf(selectedToAttack);
				Minion m = p2.getField().get(j);
				Minion mm = p1.getField().get(i);
				try {
					p2.attackWithMinion(p2.getField().get(j), p1.getField().get(i));
				} catch (CannotAttackException | NotYourTurnException | TauntBypassException | InvalidTargetException
						| NotSummonedException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				if(p2.getField().contains(m)) {
					view2.sField.remove(selectedToAttack);
					sField.get(j).setText("Name: " + m.getName()+ " " + "Mana cost: " + m.getManaCost()+ " " 
			+ "Rarity: " + m.getRarity() + " " + "HP: " + m.getMaxHP()+ " "+"Current HP: " + m.getCurrentHP() + "Attack: " + m.getAttack());
					view2.sField.add(sField.get(j));
					view2.sField.revalidate();
					view2.sField.repaint();
				}
				

				if(!p2.getField().contains(m)) {
					view2.sField.remove(selectedToAttack);
					sField.remove(j);
				view2.sField.revalidate();
				view2.sField.repaint();
				}
				if(p1.getField().contains(mm)) {
					view2.fField.remove(fField.get(i));
					fField.get(i).setText("Name: " + mm.getName()+ " " + "Mana cost: " + mm.getManaCost()+ " " 
			+ "Rarity: " + mm.getRarity() + " " + "HP: " + mm.getMaxHP()+ " "+"Current HP: "+mm.getCurrentHP() + "Attack: " + mm.getAttack());
					view2.fField.add(fField.get(i));
					view2.fField.revalidate();
					view2.fField.repaint();
				}
				if(!p1.getField().contains(mm)) {
					view2.fField.remove(fField.get(i));
					view2.fField.revalidate();
					view2.fField.repaint();
				}
				
				
			}
			else {
			if(!fField.contains(e.getSource())) {
				if(sField.contains(e.getSource())) {
					selectedToAttack = sField.get(sField.indexOf(e.getSource()));
				}
			}
			}
		}
		if(game != null && game.getCurrentHero() == p1) {
			if(e.getSource().equals(sPlayer) && fField.contains(selectedToAttack)) {
				int i = fField.indexOf(selectedToAttack);
				try {
					p1.attackWithMinion(p1.getField().get(i), p2);
				} catch (CannotAttackException | NotYourTurnException | TauntBypassException | NotSummonedException
						| InvalidTargetException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
			}
			else {
				if(!e.getSource().equals(sPlayer)) {
					if(fField.contains(e.getSource())) {
						selectedToAttack = fField.get(fField.indexOf(e.getSource()));
					}
				}
			}
		}
		if(game != null && game.getCurrentHero() == p2) {
			if(e.getSource().equals(fPlayer) && sField.contains(selectedToAttack)) {
				int i = sField.indexOf(selectedToAttack);
				try {
					p2.attackWithMinion(p2.getField().get(i), p1);
				} catch (CannotAttackException | NotYourTurnException | TauntBypassException | NotSummonedException
						| InvalidTargetException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
			}
			else {
				if(!e.getSource().equals(fPlayer)) {
					if(sField.contains(e.getSource())) {
						selectedToAttack = sField.get(sField.indexOf(e.getSource()));
					}
				}
			}
		}
		if(e.getSource().equals(fHeroPower)) {
			if(p1 instanceof Hunter) {
				try {
					((Hunter) p1).useHeroPower();
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
						| FullHandException | FullFieldException | CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
				fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
			}
			if(p1 instanceof Paladin) {
				try {
					((Paladin) p1).useHeroPower();
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
						| FullHandException | FullFieldException | CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
				JButton jb = new JButton();
				jb.setText("Name: Silver Hand Recruit Mana cost: 1 Rarity: BASIC HP: 1 Current HP: 1 Attack: 1");
				jb.addActionListener(this);
				fField.add(jb);
				view2.fField.add(jb);
				view2.fField.revalidate();
				view2.fField.repaint();
			}
			if(p1 instanceof Warlock) {
				try {
					((Warlock) p1).useHeroPower();
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
						| FullHandException | FullFieldException | CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
				fHand.clear();
				view2.fCards.removeAll();
				cardView(p1,view2.fCards, fHand);
				view2.fCards.revalidate();
				view2.fCards.repaint();
				fdeck.setText("      Deck: "+(p1.getDeck().size()));
			}
			
			
		}
		if((e.getSource().equals(sPlayer) || e.getSource().equals(fPlayer)) && fHeroPower.equals(HeroPower)) {
			if(p1 instanceof Mage) {
				if(e.getSource().equals(sPlayer));{
			try {
				((Mage) p1).useHeroPower(p2);
			} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException | FullHandException
					| FullFieldException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
			sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
				}
				if(e.getSource().equals(fPlayer)) {
					JOptionPane.showMessageDialog(null, "I can't attack myself");
				}
			}
			if(p1 instanceof Priest) {
				if(e.getSource().equals(fPlayer)) {
				try {
					((Priest) p1).useHeroPower(p1);
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
						| FullHandException | FullFieldException | CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
			}
				if(e.getSource().equals(sPlayer)) {
					try {
						((Priest) p1).useHeroPower(p2);
					} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
							| FullHandException | FullFieldException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
					sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
				}
			}

		}
		else {
			if(!e.getSource().equals(fPlayer) || !e.getSource().equals(sPlayer)) {
				if(e.getSource().equals(fHeroPower)) {
					HeroPower = fHeroPower;
				}
			}
		}
		if(HeroPower != null && selectedToAttack != null && fHeroPower.equals(HeroPower) && (fField.contains(selectedToAttack)|| sField.contains(selectedToAttack))) {
			if(fField.contains(selectedToAttack)) {
				int i = fField.indexOf(selectedToAttack);
				if(p1 instanceof Mage) {
					JOptionPane.showMessageDialog(null, "I can't attack a friendly minion");
				
				}
				if(p1 instanceof Priest) {
					try {
						((Priest) p1).useHeroPower(p1.getField().get(i));
					} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
							| FullHandException | FullFieldException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					HeroPower = null;
					selectedToAttack = null;
					fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
					sField.clear();
					view2.fField.removeAll();
					FieldView(p1, view2.fField, fField);
					view2.fField.revalidate();
					view2.fField.repaint();
				}
			}
			if(sField.contains(selectedToAttack)) {
				int i = sField.indexOf(selectedToAttack);
				Minion m = p2.getField().get(i);
				if(p1 instanceof Mage) {
					try {
						((Mage) p1).useHeroPower(m);
					} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
							| FullHandException | FullFieldException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					HeroPower = null;
					selectedToAttack = null;
					fHeroInfo.setText("Name:"
							+ " "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
					if(p2.getField().contains(m)) {
						sField.clear();
						view2.sField.removeAll();
						FieldView(p2, view2.sField, sField);
						view2.sField.revalidate();
						view2.sField.repaint();
					}
					if(!p2.getField().contains(m)) {
						sField.remove(i);
						view2.sField.removeAll();
						FieldView(p2, view2.sField, sField);
						view2.sField.revalidate();
						view2.sField.repaint();
					}
				}
				if(p1 instanceof Priest) {
					try {
						((Priest) p1).useHeroPower(m);
					} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
							| FullHandException | FullFieldException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					HeroPower = null;
					selectedToAttack = null;
					fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
					sField.clear();
					view2.sField.removeAll();
					FieldView(p2, view2.sField, sField);
					view2.sField.revalidate();
					view2.sField.repaint();
				}
			}
			
		}
		else {
			if(HeroPower != null && !fHeroPower.equals(HeroPower)) {
				if(e.getSource().equals(fHeroPower))
				HeroPower = fHeroPower;
			}
			if(sField.equals(e.getSource())) {
				selectedToAttack = (JButton) e.getSource();
			}
			if(fField.equals(e.getSource())) {
				selectedToAttack = (JButton) e.getSource();
			}
		}
		if(e.getSource().equals(sHeroPower)) {
			if(p2 instanceof Hunter) {
				try {
					((Hunter) p2).useHeroPower();
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
						| FullHandException | FullFieldException | CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
				fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
			}
			if(p2 instanceof Paladin) {
				try {
					((Paladin) p2).useHeroPower();
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
						| FullHandException | FullFieldException | CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
				JButton jb = new JButton();
				jb.setText("Name: Silver Hand Recruit Mana cost: 1 Rarity: BASIC HP: 1 Current HP: 1 Attack: 1");
				jb.addActionListener(this);
				sField.add(jb);
				view2.sField.add(jb);
				view2.sField.revalidate();
				view2.sField.repaint();
			}
			if(p2 instanceof Warlock) {
				try {
					((Warlock) p2).useHeroPower();
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
						| FullHandException | FullFieldException | CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
				sHand.clear();
				view2.sCards.removeAll();
				cardView(p2,view2.sCards, sHand);
				view2.sCards.revalidate();
				view2.sCards.repaint();
				sdeck.setText("      Deck: "+(p2.getDeck().size()));
			}
			
			
		}
		if((e.getSource().equals(sPlayer) || e.getSource().equals(fPlayer)) && sHeroPower.equals(HeroPower)) {
			if(p2 instanceof Mage) {
				if(e.getSource().equals(fPlayer));{
			try {
				((Mage) p2).useHeroPower(p1);
			} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException | FullHandException
					| FullFieldException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
			sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
				}
				if(e.getSource().equals(sPlayer)) {
					JOptionPane.showMessageDialog(null, "I can't attack myself");
				}
			}
			if(p2 instanceof Priest) {
				if(e.getSource().equals(sPlayer)) {
				try {
					((Priest) p2).useHeroPower(p2);
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
						| FullHandException | FullFieldException | CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
						p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
			}
				if(e.getSource().equals(fPlayer)) {
					try {
						((Priest) p2).useHeroPower(p1);
					} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
							| FullHandException | FullFieldException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
					sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
				}
			}

		}
		else {
			if(!e.getSource().equals(fPlayer) || !e.getSource().equals(sPlayer)) {
				if(e.getSource().equals(sHeroPower)) {
					HeroPower = sHeroPower;
				}
			}
		}
		if(HeroPower != null && selectedToAttack != null && sHeroPower.equals(HeroPower) && (fField.contains(selectedToAttack)|| sField.contains(selectedToAttack))) {
			if(sField.contains(selectedToAttack)) {
				int i = sField.indexOf(selectedToAttack);
				if(p2 instanceof Mage) {
					JOptionPane.showMessageDialog(null, "I can't attack a friendly minion");
				
				}
				if(p2 instanceof Priest) {
					try {
						((Priest) p2).useHeroPower(p2.getField().get(i));
					} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
							| FullHandException | FullFieldException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					HeroPower = null;
					selectedToAttack = null;
					sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
					sField.clear();
					view2.sField.removeAll();
					FieldView(p2, view2.sField, sField);
					view2.sField.revalidate();
					view2.sField.repaint();
				}
			}
			if(fField.contains(selectedToAttack)) {
				int i = fField.indexOf(selectedToAttack);
				Minion m = p1.getField().get(i);
				if(p2 instanceof Mage) {
					try {
						((Mage) p2).useHeroPower(m);
					} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
							| FullHandException | FullFieldException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					HeroPower = null;
					selectedToAttack = null;
					sHeroInfo.setText("Name:"
							+ " "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
					if(p1.getField().contains(m)) {
						fField.clear();
						view2.fField.removeAll();
						FieldView(p1, view2.fField, fField);
						view2.fField.revalidate();
						view2.fField.repaint();
					}
					if(!p1.getField().contains(m)) {
						fField.remove(i);
						view2.fField.removeAll();
						FieldView(p1, view2.fField, fField);
						view2.fField.revalidate();
						view2.fField.repaint();
					}
				}
				if(p2 instanceof Priest) {
					try {
						((Priest) p2).useHeroPower(m);
					} catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException
							| FullHandException | FullFieldException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					HeroPower = null;
					selectedToAttack = null;
					sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
					fField.clear();
					view2.fField.removeAll();
					FieldView(p1, view2.fField, fField);
					view2.fField.revalidate();
					view2.fField.repaint();
				}
			}
			
		}
		else {
			if(HeroPower != null && !sHeroPower.equals(HeroPower)) {
				if(e.getSource().equals(sHeroPower))
				HeroPower = sHeroPower;
			}
			if(sField.equals(e.getSource())) {
				selectedToAttack = (JButton) e.getSource();
			}
			if(fField.equals(e.getSource())) {
				selectedToAttack = (JButton) e.getSource();
			}
		}
		if(game != null && game.getCurrentHero() == p1 && fHand.contains(e.getSource())) {
			int i = fHand.indexOf(e.getSource());
			Card s = (Card) p1.getHand().get(i);
				if(s instanceof AOESpell) {
					if(s.getName().equals("Curse of Weakness")) {
						try {
							p1.castSpell((AOESpell) s, p2.getField());
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
								p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
						fHand.clear();
						view2.fCards.removeAll();
						cardView(p1,view2.fCards, fHand);
						view2.fCards.revalidate();
						view2.fCards.repaint();
						
						sField.clear();
						view2.sField.removeAll();
						FieldView(p2, view2.sField, sField);
						view2.sField.revalidate();
						view2.sField.repaint();
					}
					if(s.getName().equals( "Flamestrike")) {
						try {
							p1.castSpell((AOESpell) s, p2.getField());
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
								p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
						fHand.clear();
						view2.fCards.removeAll();
						cardView(p1,view2.fCards, fHand);
						view2.fCards.revalidate();
						view2.fCards.repaint();
						
						sField.clear();
						view2.sField.removeAll();
						FieldView(p2, view2.sField, sField);
						view2.sField.revalidate();
						view2.sField.repaint();
					}
					if(s.getName().equals("Holy Nova")) {
						try {
							p1.castSpell((AOESpell) s, p2.getField());
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
								p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
						sField.clear();
						view2.sField.removeAll();
						FieldView(p2, view2.sField, sField);
						view2.sField.revalidate();
						view2.sField.repaint();
						
						fHand.clear();
						view2.fCards.removeAll();
						cardView(p1,view2.fCards, fHand);
						view2.fCards.revalidate();
						view2.fCards.repaint();
						
						fField.clear();
						view2.fField.removeAll();
						FieldView(p1, view2.fField, fField);
						view2.fField.revalidate();
						view2.fField.repaint();
					}
					if(s.getName().equals("MultiShot")) {
						try {
							p1.castSpell((AOESpell) s , p2.getField());
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
								p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
						fHand.clear();
						view2.fCards.removeAll();
						cardView(p1,view2.fCards, fHand);
						view2.fCards.revalidate();
						view2.fCards.repaint();
						
						sField.clear();
						view2.sField.removeAll();
						FieldView(p2, view2.sField, sField);
						view2.sField.revalidate();
						view2.sField.repaint();
					}
					if(s.getName().equals("Twisting Nether")) {
						try {
							p1.castSpell((AOESpell) s, p2.getField());
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
								p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
						sField.clear();
						view2.sField.removeAll();
						FieldView(p2, view2.sField, sField);
						view2.sField.revalidate();
						view2.sField.repaint();
						
						fHand.clear();
						view2.fCards.removeAll();
						cardView(p1,view2.fCards, fHand);
						view2.fCards.revalidate();
						view2.fCards.repaint();
						
						fField.clear();
						view2.fField.removeAll();
						FieldView(p1, view2.fField, fField);
						view2.fField.revalidate();
						view2.fField.repaint();
					}
				}
				if(s.getName().equals("Level Up!")) {
					try {
						p1.castSpell((FieldSpell)s);
					} catch (NotYourTurnException | NotEnoughManaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
							p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
					fHand.clear();
					view2.fCards.removeAll();
					cardView(p1,view2.fCards, fHand);
					view2.fCards.revalidate();
					view2.fCards.repaint();
					
					fField.clear();
					view2.fField.removeAll();
					FieldView(p1, view2.fField, fField);
					view2.fField.revalidate();
					view2.fField.repaint();
				}
			
			
		}
			if(game != null && spell != null && game.getCurrentHero() == p1 && fHand.contains(spell) && sPlayer.equals(e.getSource())) {
				int i = fHand.indexOf(spell);
				Card s = (Card) p1.getHand().get(i);
				if(s instanceof HeroTargetSpell) {
					if(s.getName().equals("Kill Command")) {
						try {
							p1.castSpell((HeroTargetSpell)s, p2);
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
				p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
						sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
								p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
						fHand.clear();
						view2.fCards.removeAll();
						cardView(p1,view2.fCards, fHand);
						view2.fCards.revalidate();
						view2.fCards.repaint();
						
					}
					if(s.getName().equals("Pyroblast")) {
						try {
							p1.castSpell((HeroTargetSpell)s, p2);
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
				p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
						sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
								p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
						fHand.clear();
						view2.fCards.removeAll();
						cardView(p1,view2.fCards, fHand);
						view2.fCards.revalidate();
						view2.fCards.repaint();
					}
				}
			}
			else {
				if(sPlayer != null && !sPlayer.equals(e.getSource())) {
					if(fHand.contains(e.getSource())) {
						spell =(JButton) e.getSource();
						
					}
				}
			}
				
				
			
		
		  
		 
		  if(game != null && spell != null &&(fField.contains(e.getSource()) || sField.contains(e.getSource())) && fHand.contains(spell)) {
			  int i = fHand.indexOf(spell);
			  Card s = (Card) p1.getHand().get(i);
			  if(fField.contains(e.getSource())) {
				  Minion m = p1.getField().get(fField.indexOf(e.getSource()));
				  if(s.getName().equals("Siphon Soul")) {
						try {
							p1.castSpell((LeechingSpell) s, m);
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
				p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
						fField.clear();
						view2.fField.removeAll();
						FieldView(p1, view2.fField, fField);
						view2.fField.revalidate();
						view2.fField.repaint();
						
						fHand.clear();
						view2.fCards.removeAll();
						FieldView(p1, view2.fCards, fHand);
						view2.fCards.revalidate();
						view2.fCards.repaint();
						
					}
				  if(s instanceof MinionTargetSpell) {
						if(s.getName().equals("Divine Spirit")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
											fField.clear();
											view2.fField.removeAll();
											FieldView(p1, view2.fField, fField);
											view2.fField.revalidate();
											view2.fField.repaint();
											
											fHand.clear();
											view2.fCards.removeAll();
											FieldView(p1, view2.fCards, fHand);
											view2.fCards.revalidate();
											view2.fCards.repaint();
						}
						if(s.getName().equals("Kill Command")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
											fField.clear();
											view2.fField.removeAll();
											FieldView(p1, view2.fField, fField);
											view2.fField.revalidate();
											view2.fField.repaint();
											
											fHand.clear();
											view2.fCards.removeAll();
											FieldView(p1, view2.fCards, fHand);
											view2.fCards.revalidate();
											view2.fCards.repaint();
						}
						if(s.getName().equals("Polymorph")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
											fField.clear();
											view2.fField.removeAll();
											FieldView(p1, view2.fField, fField);
											view2.fField.revalidate();
											view2.fField.repaint();
											
											fHand.clear();
											view2.fCards.removeAll();
											FieldView(p1, view2.fCards, fHand);
											view2.fCards.revalidate();
											view2.fCards.repaint();
						}
						if(s.getName().equals("Pyroblast")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
											fField.clear();
											view2.fField.removeAll();
											FieldView(p1, view2.fField, fField);
											view2.fField.revalidate();
											view2.fField.repaint();
											
											fHand.clear();
											view2.fCards.removeAll();
											FieldView(p1, view2.fCards, fHand);
											view2.fCards.revalidate();
											view2.fCards.repaint();
						}
						if(s.getName().equals("Seal of Champions")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
											fField.clear();
											view2.fField.removeAll();
											FieldView(p1, view2.fField, fField);
											view2.fField.revalidate();
											view2.fField.repaint();
											
											fHand.clear();
											view2.fCards.removeAll();
											FieldView(p1, view2.fCards, fHand);
											view2.fCards.revalidate();
											view2.fCards.repaint();
						}
						if(s.getName().equals("Shadow Word: Death")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
											fField.clear();
											view2.fField.removeAll();
											FieldView(p1, view2.fField, fField);
											view2.fField.revalidate();
											view2.fField.repaint();
											
											fHand.clear();
											view2.fCards.removeAll();
											FieldView(p1, view2.fCards, fHand);
											view2.fCards.revalidate();
											view2.fCards.repaint();
						}
						
						
					}
				}
			  if(sField.contains(e.getSource())) {
				  Minion m = p2.getField().get(sField.indexOf(e.getSource()));
				  if(s.getName().equals("Siphon Soul")) {
						try {
							p1.castSpell((LeechingSpell) s, m);
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
				p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
						sField.clear();
						view2.sField.removeAll();
						FieldView(p2, view2.sField, sField);
						view2.sField.revalidate();
						view2.sField.repaint();
						
						fHand.clear();
						view2.fCards.removeAll();
						FieldView(p1, view2.fCards, fHand);
						view2.fCards.revalidate();
						view2.fCards.repaint();
						
					}
				  if(s instanceof MinionTargetSpell) {
						if(s.getName().equals("Divine Spirit")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							fHand.clear();
							view2.fCards.removeAll();
							FieldView(p1, view2.fCards, fHand);
							view2.fCards.revalidate();
							view2.fCards.repaint();
						}
						if(s.getName().equals("Kill Command")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							fHand.clear();
							view2.fCards.removeAll();
							FieldView(p1, view2.fCards, fHand);
							view2.fCards.revalidate();
							view2.fCards.repaint();
						}
						if(s.getName().equals("Polymorph")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							fHand.clear();
							view2.fCards.removeAll();
							FieldView(p1, view2.fCards, fHand);
							view2.fCards.revalidate();
							view2.fCards.repaint();
						}
						if(s.getName().equals("Pyroblast")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							fHand.clear();
							view2.fCards.removeAll();
							FieldView(p1, view2.fCards, fHand);
							view2.fCards.revalidate();
							view2.fCards.repaint();
						}
						if(s.getName().equals("Seal of Champions")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							fHand.clear();
							view2.fCards.removeAll();
							FieldView(p1, view2.fCards, fHand);
							view2.fCards.revalidate();
							view2.fCards.repaint();
						}
						if(s.getName().equals("Shadow Word: Death")) {
							try {
								p1.castSpell((MinionTargetSpell)s, m);
							} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							fHand.clear();
							view2.fCards.removeAll();
							FieldView(p1, view2.fCards, fHand);
							view2.fCards.revalidate();
							view2.fCards.repaint();
						}
						
						
					}
				}
			  
				
				}
				  
			  
		  
		  else {
			  if(fField != null && !fField.contains(e.getSource()) && sField != null && !sField.contains(e.getSource())) {
				  if(fHand.contains(e.getSource())) {
					  spell = (JButton) e.getSource();
				  }
			  }
		  }
		  
		  if(game != null && game.getCurrentHero() == p2 && sHand.contains(e.getSource())) {
				int i = sHand.indexOf(e.getSource());
				Card s = (Card) p2.getHand().get(i);
					if(s instanceof AOESpell) {
						if(s.getName().equals("Curse of Weakness")) {
							try {
								p2.castSpell((AOESpell) s, p1.getField());
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sHand.clear();
							view2.sCards.removeAll();
							cardView(p2,view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
						}
						if(s.getName().equals( "Flamestrike")) {
							try {
								p2.castSpell((AOESpell) s, p1.getField());
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sHand.clear();
							view2.sCards.removeAll();
							cardView(p2,view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
						}
						if(s.getName().equals("Holy Nova")) {
							try {
								p2.castSpell((AOESpell) s, p1.getField());
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							cardView(p2,view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
						}
						if(s.getName().equals("MultiShot")) {
							try {
								p2.castSpell((AOESpell) s , p1.getField());
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sHand.clear();
							view2.sCards.removeAll();
							cardView(p2,view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
						}
						if(s.getName().equals("Twisting Nether")) {
							try {
								p2.castSpell((AOESpell) s, p1.getField());
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							cardView(p2,view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
						}
					}
					if(s.getName().equals("Level Up!")) {
						try {
							p2.castSpell((FieldSpell)s);
						} catch (NotYourTurnException | NotEnoughManaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
						sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							cardView(p2,view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
					}
				
				
			}
				if(game != null && spell != null && game.getCurrentHero() == p2 && sHand.contains(spell) && fPlayer.equals(e.getSource())) {
					int i = sHand.indexOf(spell);
					Card s = (Card) p2.getHand().get(i);
					if(s instanceof HeroTargetSpell) {
						if(s.getName().equals("Kill Command")) {
							try {
								p2.castSpell((HeroTargetSpell)s, p1);
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
							sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sHand.clear();
							view2.sCards.removeAll();
							cardView(p2,view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							
						}
						if(s.getName().equals("Pyroblast")) {
							try {
								p2.castSpell((HeroTargetSpell)s, p1);
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							fHeroInfo.setText("Name: "  + p1.getName() + "\n" + "Total Mana Crystals: " + p1.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p1.getCurrentManaCrystals() + "\n" + "Current HP: " + p1.getCurrentHP());
							sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
									p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sHand.clear();
							view2.sCards.removeAll();
							cardView(p2,view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
						}
					}
				}
				else {
					if(fPlayer != null && !fPlayer.equals(e.getSource())) {
						if(sHand.contains(e.getSource())) {
							spell =(JButton) e.getSource();
							
						}
					}
				}
					
					
				
			
			  
			 
			  if(game != null && spell != null &&(fField.contains(e.getSource()) || sField.contains(e.getSource())) && sHand.contains(spell)) {
				  int i = sHand.indexOf(spell);
				  Card s = (Card) p2.getHand().get(i);
				  if(fField.contains(e.getSource())) {
					  Minion m = p2.getField().get(fField.indexOf(e.getSource()));
					  if(s.getName().equals("Siphon Soul")) {
							try {
								p2.castSpell((LeechingSpell) s, m);
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							
						}
					  if(s instanceof MinionTargetSpell) {
							if(s.getName().equals("Divine Spirit")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							if(s.getName().equals("Kill Command")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							if(s.getName().equals("Polymorph")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							if(s.getName().equals("Pyroblast")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							if(s.getName().equals("Seal of Champions")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							if(s.getName().equals("Shadow Word: Death")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							fField.clear();
							view2.fField.removeAll();
							FieldView(p1, view2.fField, fField);
							view2.fField.revalidate();
							view2.fField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							
							
						}
					}
				  if(sField.contains(e.getSource())) {
					  Minion m = p2.getField().get(sField.indexOf(e.getSource()));
					  if(s.getName().equals("Siphon Soul")) {
							try {
								p2.castSpell((LeechingSpell) s, m);
							} catch (NotYourTurnException | NotEnoughManaException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
							sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							
						}
					  if(s instanceof MinionTargetSpell) {
							if(s.getName().equals("Divine Spirit")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							if(s.getName().equals("Kill Command")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							if(s.getName().equals("Polymorph")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							if(s.getName().equals("Pyroblast")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							if(s.getName().equals("Seal of Champions")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							if(s.getName().equals("Shadow Word: Death")) {
								try {
									p2.castSpell((MinionTargetSpell)s, m);
								} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								sHeroInfo.setText("Name: "  + p2.getName() + "\n" + "Total Mana Crystals: " + p2.getTotalManaCrystals() + " \n" + "Current Mana Crystals: " +
					p2.getCurrentManaCrystals() + "\n" + "Current HP: " + p2.getCurrentHP());
							sField.clear();
							view2.sField.removeAll();
							FieldView(p2, view2.sField, sField);
							view2.sField.revalidate();
							view2.sField.repaint();
							
							sHand.clear();
							view2.sCards.removeAll();
							FieldView(p2, view2.sCards, sHand);
							view2.sCards.revalidate();
							view2.sCards.repaint();
							}
							
							
						}
					}
				  
					
					}
					  
				  
			  
			  else {
				  if(sField != null && !sField.contains(e.getSource())&& fField != null && !fField.contains(e.getSource())) {
					  if(sHand.contains(e.getSource())) {
						  spell = (JButton) e.getSource();
					  }
				  }
			  }
			  
		
			
	}
	public void cardView(Hero p, JPanel j,ArrayList<JButton>jb) {
		for(int i=0; i < p.getHand().size(); i++) {
			
			if(game.getOpponent() == p) {
				jb.add(new JButton());
				jb.get(i).setText(" ");
				j.add(jb.get(i));
			}
			else {
			Minion check;
			jb.add(new JButton());
			if(p.getHand().get(i) instanceof Minion ) {
			check = (Minion) p.getHand().get(i);
			if(check.isDivine()) {
				if(!check.isSleeping() && check.isTaunt()) {
					jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
							+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "DIVINE"+ " " + "TAUNT"+ " " + "CHARGE");
							jb.get(i).addActionListener(this);
							j.add(jb.get(i));
							}
				if(!check.isSleeping()) {
					jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
							+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "DIVINE" + " "+ "CHARGE");
							jb.get(i).addActionListener(this);
							j.add(jb.get(i));
							}
				}
			if(check.isTaunt()) {
				jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
						+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "DIVINE" + " "+ "TAUNT");
						jb.get(i).addActionListener(this);
						j.add(jb.get(i));
						}
			else {
			jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
			+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "DIVINE");
			jb.get(i).addActionListener(this);
			j.add(jb.get(i));
			}
			if(check.isTaunt()) {
				if(!check.isSleeping()) {
					jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
							+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "TAUNT" +" " +"CHARGE");
							jb.get(i).addActionListener(this);
							j.add(jb.get(i));
							}
				else {
				jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
				+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "TAUNT");
				jb.get(i).addActionListener(this);
				j.add(jb.get(i));
				}
			}
			if(!check.isSleeping()) {
				jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
				+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "CHARGE");
				jb.get(i).addActionListener(this);
				j.add(jb.get(i));
				}
			else {
				jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
						+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " " +"Current HP: "+ check.getCurrentHP()+ "Attack: " + check.getAttack());
				jb.get(i).addActionListener(this);
				j.add(jb.get(i));
			}
			}
			else {
				jb.get(i).setText("Name: " + p.getHand().get(i).getName()+ " " + "Mana cost: " + p.getHand().get(i).getManaCost()+ " " 
						+ "Rarity: " +p.getHand().get(i).getRarity());
						jb.get(i).addActionListener(this);
						j.add(jb.get(i));
			}
		}
		}
		}

	public void FieldView(Hero p, JPanel j, ArrayList<JButton> jb) {
		Minion check;
		for(int i = 0; i < p.getField().size(); i++) {
			    jb.add(new JButton());
				check = (Minion) p.getField().get(i);
				if(check.isDivine()) {
					if(!check.isSleeping() && check.isTaunt()) {
						jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
								+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "DIVINE"+ " " + "TAUNT"+ " " + "CHARGE");
								jb.get(i).addActionListener(this);
								j.add(jb.get(i));
								}
					if(!check.isSleeping()) {
						jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
								+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "DIVINE" + " "+ "CHARGE");
								jb.get(i).addActionListener(this);
								j.add(jb.get(i));
								}
					}
				if(check.isTaunt()) {
					jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
							+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "DIVINE" + " "+ "TAUNT");
							jb.get(i).addActionListener(this);
							j.add(jb.get(i));
							}
				else {
				jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
				+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "DIVINE");
				jb.get(i).addActionListener(this);
				j.add(jb.get(i));
				}
				if(check.isTaunt()) {
					if(!check.isSleeping()) {
						jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
								+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "TAUNT" +" " +"CHARGE");
								jb.get(i).addActionListener(this);
								j.add(jb.get(i));
								}
					else {
					jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
					+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "TAUNT");
					jb.get(i).addActionListener(this);
					j.add(jb.get(i));
					}
				}
				if(!check.isSleeping()) {
					jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
					+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " "+"Current HP: "+ check.getCurrentHP() + "Attack: " + check.getAttack() + " " + "CHARGE");
					jb.get(i).addActionListener(this);
					j.add(jb.get(i));
					}
				else {
					jb.get(i).setText("Name: " + check.getName()+ " " + "Mana cost: " + check.getManaCost()+ " " 
							+ "Rarity: " + check.getRarity() + " " + "HP: " + check.getMaxHP()+ " " +"Current HP: "+ check.getCurrentHP()+ "Attack: " + check.getAttack());
					jb.get(i).addActionListener(this);
					j.add(jb.get(i));
				}
		}
	}
	public static void main(String args[]) {
		try {
			new Control();
		} catch (IOException | CloneNotSupportedException | FullHandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}