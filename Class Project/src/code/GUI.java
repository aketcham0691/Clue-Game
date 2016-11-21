package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {

	BoardObject[][] board;
	JButton[][] buttons = new JButton[25][24];  
	Game game;
	JFrame window;
	JPanel panel;
	JPanel leftPan;
	JPanel rightPan;
	JLabel playerLab;
	ArrayList<Card> playerCards;
	JPanel rightTop;
	JPanel rightMid;
	JPanel rightBot;
	JLabel one = new JLabel(new ImageIcon(getClass().getResource("one.jpg")));
	JLabel two = new JLabel(new ImageIcon(getClass().getResource("two.jpg")));
	JLabel three = new JLabel(new ImageIcon(getClass().getResource("three.jpg")));
	JLabel four = new JLabel(new ImageIcon(getClass().getResource("four.jpg")));
	JLabel five = new JLabel(new ImageIcon(getClass().getResource("five.jpg")));
	JLabel six = new JLabel(new ImageIcon(getClass().getResource("six.jpg")));

	public GUI(Game game){
		this.game = game;
		window = new JFrame();
		window.setVisible(true);
		window.setSize(1300,1300); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		JButton button = new JButton();
		button.setText("Start Game!");
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				board = game.getBoard().getBoard(); 		

				panel.setLayout(new GridLayout(1, 2));
				
				leftPan = new JPanel();
				rightPan = new JPanel();
				
				panel.add(leftPan);
				panel.add(rightPan);
				
				leftPan.setLayout(new GridLayout(25, 24));
				for (int i = 0; i < 25; i++){
					for (int j = 0; j < 24; j++){
						JButton button = new JButton();
						buttons[i][j] = button; 
						leftPan.add(button);
						if (board[i][j] instanceof Wall){
							button.setBackground(Color.BLACK);
						}
						if (board[i][j] instanceof Player){
							Player play = (Player) board[i][j];
							button.setBackground(play.getColor());
						}
						if (board[i][j] instanceof Doorway){
							button.setBackground(Color.GRAY);
						}
					}
				}
				
				leftPan.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
				rightPan.setLayout(new GridLayout(3, 1));
				playerLab = new JLabel();
				rightPan.add(playerLab);
				rightMid = new JPanel();
				rightMid.setLayout(new GridLayout(1, 3));
				rightPan.add(rightMid);
				rightBot = new JPanel();
				rightPan.add(rightBot);
				setTurn(game.getPlayers().get(0), game);
				panel.remove(button);
			}
		});
		panel.add(button);
		window.setContentPane(panel);
	}
	
	public void setTurn(Player player, Game game){
		playerLab.setText(player.getName());
		window.setContentPane(panel);
		ArrayList<Card> playerCards = player.getPlayersCards();
		for (Card c : playerCards){
			ImageIcon image1 = c.getPicture();
			JLabel rightlabel = new JLabel(image1);
			rightMid.add(rightlabel);
		}
		JButton roll = new JButton("Roll");
		roll.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int dieRoll = player.roll();
				player.calculateMoves(player.getPriorMoves(), player.moveOptions(player.getX(), player.getY()), dieRoll);
				ArrayList<JButton> moveButtons = new ArrayList<JButton>();
				for (int[] move : player.getMoveChoices()){
					int x = move[0];
					int y = move[1];
					JButton button = buttons[x][y]; 
					button.setBackground(Color.CYAN);
					moveButtons.add(button);
				}
				for (JButton b : moveButtons){
					b.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e){
							buttons[player.getX()][player.getY()].setBackground(new JButton().getBackground());
							int xIndex = 0;
							int yIndex = 0;
							for (int i = 0; i < buttons.length; i++){
								for(int j = 0; j < buttons[0].length; j++){
									if (buttons[i][j] == b){
										xIndex = i;
										yIndex = j;
									}
								}
							}	
							player.move(xIndex, yIndex);
							for (JButton but : moveButtons){
								but.setBackground(new JButton().getBackground());
								for (ActionListener al : but.getActionListeners()){
									but.removeActionListener(al);
								}
							}
							b.setBackground(player.getColor());
							rightBot.removeAll();
							rightBot.repaint();
							if(!player.inRoom()){
								JButton suggest = new JButton("Suggest");
								JButton endTurn = new JButton("End Turn"); 
								suggest.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										rightBot.remove(suggest);
										rightBot.remove(endTurn);
										rightBot.revalidate();
										rightBot.repaint();
										rightBot.setLayout(new GridLayout(4, 1));
										JPanel players = new JPanel(); 
										players.setLayout(new GridLayout(1, 6));
										JPanel weapons = new JPanel(); 
										weapons.setLayout(new GridLayout(1, 6));
										JPanel rooms= new JPanel(); 
										rooms.setLayout(new GridLayout(1, 9));
										JButton guess = new JButton("Guess");
										for(Card c: game.getChoices()){  
											JButton card = new JButton(c.getPicture()); 
											if(c instanceof CharacterCard){
												card.addActionListener(new ActionListener(){
													@Override
													public void actionPerformed(ActionEvent e){
														player.setPlay(c);
														for (Component comp : players.getComponents()){
															if (card != comp){
																players.remove(comp);
															}
														}
														players.revalidate();
														players.repaint();
													}
												});
												players.add(card);
											}
											if(c instanceof Weapon){
												card.addActionListener(new ActionListener(){
													@Override
													public void actionPerformed(ActionEvent e){
														player.setWeap(c);
														for (Component comp : weapons.getComponents()){
															if (card != comp){
																weapons.remove(comp);
															}
														}
														weapons.revalidate();
														weapons.repaint();
													}
												});
												weapons.add(card);
											}
											if(c instanceof RoomCard){
												card.addActionListener(new ActionListener(){
													@Override
													public void actionPerformed(ActionEvent e){
														player.setRoom(c);
														for (Component comp : rooms.getComponents()){
															if (card != comp){
																rooms.remove(comp);
															}
														}
														rooms.revalidate();
														rooms.repaint();
													}
												});
												rooms.add(card); 
											}
										}
										guess.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
											Player disprover = player.suggest(); 
												rightBot.remove(guess);
												rightBot.repaint();
												for(Card c: disprover.getPlayersCards()){
													if(c.equals(player.getPlay())){
														
													}
												}
												
											}
										});
										rightBot.add(players);
										rightBot.add(weapons);
										rightBot.add(rooms);	
										rightBot.add(guess);
									}
								});
								rightBot.add(suggest);
								rightBot.add(endTurn);
								rightBot.revalidate();
								rightBot.repaint();
								
							}
						}
					});
				}
				rightBot.remove(roll);
				switch(dieRoll){
				case 1: rightBot.add(one);
				break; 
				case 2: rightBot.add(two); 
				break; 
				case 3: rightBot.add(three);
				break; 
				case 4: rightBot.add(four); 
				break;
				case 5: rightBot.add(five);
				break; 
				case 6: rightBot.add(six); 
				break;
				}
				rightBot.revalidate();
				rightBot.repaint(); 
			}
		});
		rightBot.add(roll);
	}
	}
