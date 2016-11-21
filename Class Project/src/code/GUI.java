package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
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
				buttons[1][1].setText("S");
				buttons[1][1].setForeground(Color.white);
				buttons[1][1].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][2].setText("T");
				buttons[1][2].setForeground(Color.white);
				buttons[1][2].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][3].setText("U");
				buttons[1][3].setForeground(Color.white);
				buttons[1][3].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][4].setText("D");
				buttons[1][4].setForeground(Color.white);
				buttons[1][4].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][5].setText("Y");
				buttons[1][5].setForeground(Color.white);
				buttons[1][5].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][10].setText("H");
				buttons[1][10].setForeground(Color.white);
				buttons[1][10].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][11].setText("A");
				buttons[1][11].setForeground(Color.white);
				buttons[1][11].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][12].setText("L");
				buttons[1][12].setForeground(Color.white);
				buttons[1][12].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][13].setText("L");
				buttons[1][13].setForeground(Color.white);
				buttons[1][13].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][18].setText("L");
				buttons[1][18].setForeground(Color.white);
				buttons[1][18].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][19].setText("O");
				buttons[1][19].setForeground(Color.white);
				buttons[1][19].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][20].setText("U");
				buttons[1][20].setForeground(Color.white);
				buttons[1][20].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][21].setText("N");
				buttons[1][21].setForeground(Color.white);
				buttons[1][21].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][22].setText("G");
				buttons[1][22].setForeground(Color.white);
				buttons[1][22].setMargin(new Insets(0, 0, 0, 0));
				buttons[1][23].setText("E");
				buttons[1][23].setForeground(Color.white);
				buttons[1][23].setMargin(new Insets(0, 0, 0, 0));
				buttons[7][0].setText("L");
				buttons[7][0].setForeground(Color.white);
				buttons[7][0].setMargin(new Insets(0, 0, 0, 0));
				buttons[7][1].setText("I");
				buttons[7][1].setForeground(Color.white);
				buttons[7][1].setMargin(new Insets(0, 0, 0, 0));
				buttons[7][2].setText("B");
				buttons[7][2].setForeground(Color.white);
				buttons[7][2].setMargin(new Insets(0, 0, 0, 0));
				buttons[7][3].setText("R");
				buttons[7][3].setForeground(Color.white);
				buttons[7][3].setMargin(new Insets(0, 0, 0, 0));
				buttons[7][4].setText("A");
				buttons[7][4].setForeground(Color.white);
				buttons[7][4].setMargin(new Insets(0, 0, 0, 0));
				buttons[7][5].setText("R");
				buttons[7][5].setForeground(Color.white);
				buttons[7][5].setMargin(new Insets(0, 0, 0, 0));
				buttons[7][6].setText("Y");
				buttons[7][6].setForeground(Color.white);
				buttons[7][6].setMargin(new Insets(0, 0, 0, 0));
				buttons[11][17].setText("D");
				buttons[11][17].setForeground(Color.white);
				buttons[11][17].setMargin(new Insets(0, 0, 0, 0));
				buttons[11][18].setText("I");
				buttons[11][18].setForeground(Color.white);
				buttons[11][18].setMargin(new Insets(0, 0, 0, 0));
				buttons[11][19].setText("N");
				buttons[11][19].setForeground(Color.white);
				buttons[11][19].setMargin(new Insets(0, 0, 0, 0));
				buttons[11][20].setText("I");
				buttons[11][20].setForeground(Color.white);
				buttons[11][20].setMargin(new Insets(0, 0, 0, 0));
				buttons[11][21].setText("N");
				buttons[11][21].setForeground(Color.white);
				buttons[11][21].setMargin(new Insets(0, 0, 0, 0));
				buttons[11][22].setText("G");
				buttons[11][22].setForeground(Color.white);
				buttons[11][22].setMargin(new Insets(0, 0, 0, 0));
				buttons[13][1].setForeground(Color.white);
				buttons[13][1].setMargin(new Insets(0, 0, 0, 0));
				buttons[13][1].setText("B");
				buttons[13][2].setForeground(Color.white);
				buttons[13][2].setMargin(new Insets(0, 0, 0, 0));
				buttons[13][2].setText("I");
				buttons[13][3].setForeground(Color.white);
				buttons[13][3].setMargin(new Insets(0, 0, 0, 0));
				buttons[13][3].setText("L");
				buttons[13][4].setForeground(Color.white);
				buttons[13][4].setMargin(new Insets(0, 0, 0, 0));
				buttons[13][4].setText("L");
				buttons[13][5].setForeground(Color.white);
				buttons[13][5].setMargin(new Insets(0, 0, 0, 0));
				buttons[13][5].setText("-");
				buttons[14][1].setForeground(Color.white);
				buttons[14][1].setMargin(new Insets(0, 0, 0, 0));
				buttons[14][1].setText("I");
				buttons[14][2].setForeground(Color.white);
				buttons[14][2].setMargin(new Insets(0, 0, 0, 0));
				buttons[14][2].setText("A");
				buttons[14][3].setForeground(Color.white);
				buttons[14][3].setMargin(new Insets(0, 0, 0, 0));
				buttons[14][3].setText("R");
				buttons[14][4].setForeground(Color.white);
				buttons[14][4].setMargin(new Insets(0, 0, 0, 0));
				buttons[14][4].setText("D");
				buttons[21][0].setForeground(Color.white);
				buttons[21][0].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][0].setText("C");
				buttons[21][1].setForeground(Color.white);
				buttons[21][1].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][1].setText("O");
				buttons[21][2].setForeground(Color.white);
				buttons[21][2].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][2].setText("N");
				buttons[21][3].setForeground(Color.white);
				buttons[21][3].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][3].setText("S");
				buttons[21][4].setForeground(Color.white);
				buttons[21][4].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][4].setText("E");
				buttons[21][5].setForeground(Color.white);
				buttons[21][5].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][5].setText("R");
				buttons[22][0].setForeground(Color.white);
				buttons[22][0].setMargin(new Insets(0, 0, 0, 0));
				buttons[22][0].setText("V");
				buttons[22][1].setForeground(Color.white);
				buttons[22][1].setMargin(new Insets(0, 0, 0, 0));
				buttons[22][1].setText("A");
				buttons[22][2].setForeground(Color.white);
				buttons[22][2].setMargin(new Insets(0, 0, 0, 0));
				buttons[22][2].setText("T");
				buttons[22][3].setForeground(Color.white);
				buttons[22][3].setMargin(new Insets(0, 0, 0, 0));
				buttons[22][3].setText("O");
				buttons[22][4].setForeground(Color.white);
				buttons[22][4].setMargin(new Insets(0, 0, 0, 0));
				buttons[22][4].setText("R");
				buttons[22][5].setForeground(Color.white);
				buttons[22][5].setMargin(new Insets(0, 0, 0, 0));
				buttons[22][5].setText("Y");
				buttons[21][8].setForeground(Color.white);
				buttons[21][8].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][8].setText("B");
				buttons[21][9].setForeground(Color.white);
				buttons[21][9].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][9].setText("A");
				buttons[21][10].setForeground(Color.white);
				buttons[21][10].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][10].setText("L");
				buttons[21][11].setForeground(Color.white);
				buttons[21][11].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][11].setText("L");
				buttons[21][12].setForeground(Color.white);
				buttons[21][12].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][12].setText("R");
				buttons[21][13].setForeground(Color.white);
				buttons[21][13].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][13].setText("O");
				buttons[21][14].setForeground(Color.white);
				buttons[21][14].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][14].setText("O");
				buttons[21][15].setForeground(Color.white);
				buttons[21][15].setMargin(new Insets(0, 0, 0, 0));
				buttons[21][15].setText("M");
				buttons[23][17].setForeground(Color.white);
				buttons[23][17].setMargin(new Insets(0, 0, 0, 0));
				buttons[23][17].setText("K");
				buttons[23][18].setForeground(Color.white);
				buttons[23][18].setMargin(new Insets(0, 0, 0, 0));
				buttons[23][18].setText("I");
				buttons[23][19].setForeground(Color.white);
				buttons[23][19].setMargin(new Insets(0, 0, 0, 0));
				buttons[23][19].setText("T");
				buttons[23][20].setForeground(Color.white);
				buttons[23][20].setMargin(new Insets(0, 0, 0, 0));
				buttons[23][20].setText("C");
				buttons[23][21].setForeground(Color.white);
				buttons[23][21].setMargin(new Insets(0, 0, 0, 0));
				buttons[23][21].setText("H");
				buttons[23][22].setForeground(Color.white);
				buttons[23][22].setMargin(new Insets(0, 0, 0, 0));
				buttons[23][22].setText("E");
				buttons[23][23].setForeground(Color.white);
				buttons[23][23].setMargin(new Insets(0, 0, 0, 0));
				buttons[23][23].setText("N");
				leftPan.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
				rightPan.setLayout(new GridLayout(3, 1));
				playerLab = new JLabel();
				playerLab.setFont(new Font("Arial", Font.PLAIN, 40));
				rightTop = new JPanel();
				rightTop.setLayout(new GridBagLayout());
				rightTop.add(playerLab);
				rightPan.add(rightTop);
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
		JButton noMove = new JButton("Choose not to move this turn");
		JButton roll = new JButton("Roll");
		JButton usePassage = new JButton("Use Passageway");
		usePassage.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				player.usePassageway();
				rightBot.remove(roll);
				rightBot.remove(noMove);
				rightBot.remove(usePassage);
				if(player.inRoom()){
					JButton suggest = new JButton("Suggest");
					JButton endTurn = new JButton("End Turn"); 
					endTurn.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e){
							playerLab.removeAll();
							rightBot.removeAll();
							rightMid.removeAll();
							Player play;
							int idx = game.getPlayers().indexOf(player);
							
							if (idx == game.getPlayers().size() - 1){
								play = game.getPlayers().get(0);
							}
							else{
								play = game.getPlayers().get(idx + 1);
							}
							
							game.setTurn(play);
							playerLab.revalidate();
							playerLab.repaint();
							rightMid.revalidate();
							rightMid.repaint();
							rightBot.revalidate();
							rightBot.repaint();
							player.clearChoices();
							for (Room r : game.getRooms()){
								System.out.println("\n" + r + ": ");
								r.printMembers();
							}
						}
					});
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
							JLabel room = new JLabel();
							for (Room r : game.getRooms()){
								if (r.getMembers().contains(player)){
									room.setIcon(r.getCard().getPicture());
									player.setRoom(r.getCard());
								}
							}
							rooms.add(room);
							JButton guess = new JButton("Guess");
							for(Card c: game.getChoices()){  
								JButton card = new JButton(new ImageIcon(((c.getPicture().getImage()
							            .getScaledInstance(80, 80,
							                    java.awt.Image.SCALE_SMOOTH)))));
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
								
							}
							guess.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									if (player.suggest() == null){
										rightPan.removeAll();
										JLabel win = new JLabel("Congratulations! You guess the cards in the envelope!");
										rightPan.add(win);
										rightPan.revalidate();
										rightPan.repaint();
									}
									else{
									Player disprover = player.suggest();
									
									rightBot.remove(guess);
									rightBot.repaint();
									for(Card c: disprover.getPlayersCards()){
										if(c.toString() == player.getPlay().toString()){
											rightBot.removeAll();
											rightBot.setLayout(new GridLayout(1, 3));
											rightBot.add(new JLabel("Disprover: " + disprover.getName()));
											rightBot.add(new JLabel(c.getPicture()));
											JButton endTurn = new JButton("End Turn");
											endTurn.addActionListener(new ActionListener(){
												@Override
												public void actionPerformed(ActionEvent e){
													playerLab.removeAll();
													rightBot.removeAll();
													rightMid.removeAll();
													Player play;
													int idx = game.getPlayers().indexOf(player);
													
													if (idx == game.getPlayers().size() - 1){
														play = game.getPlayers().get(0);
													}
													else{
														play = game.getPlayers().get(idx + 1);
													}
													
													game.setTurn(play);
													playerLab.revalidate();
													playerLab.repaint();
													rightMid.revalidate();
													rightMid.repaint();
													rightBot.revalidate();
													rightBot.repaint();
													player.clearChoices();
													for (Room r : game.getRooms()){
														System.out.println("\n" + r + ": ");
														r.printMembers();
													}
												}
											});
											rightBot.add(endTurn);
											rightBot.revalidate();
											rightBot.repaint();
										}
										else if(c.toString() == player.getWeapon().toString()){
											rightBot.removeAll();
											rightBot.setLayout(new GridLayout(1, 3));
											rightBot.add(new JLabel("Disprover: " + disprover.getName()));
											rightBot.add(new JLabel(c.getPicture()));
											JButton endTurn = new JButton("End Turn");
											endTurn.addActionListener(new ActionListener(){
												@Override
												public void actionPerformed(ActionEvent e){
													playerLab.removeAll();
													rightBot.removeAll();
													rightMid.removeAll();
													Player play;
													int idx = game.getPlayers().indexOf(player);
													
													if (idx == game.getPlayers().size() - 1){
														play = game.getPlayers().get(0);
													}
													else{
														play = game.getPlayers().get(idx + 1);
													}
													
													game.setTurn(play);
													playerLab.revalidate();
													playerLab.repaint();
													rightMid.revalidate();
													rightMid.repaint();
													rightBot.revalidate();
													rightBot.repaint();
													player.clearChoices();
													for (Room r : game.getRooms()){
														System.out.println("\n" + r + ": ");
														r.printMembers();
													}
												}
											});
											rightBot.add(endTurn);
											rightBot.revalidate();
											rightBot.repaint();
										}
										else if(c.toString() == player.getRoom().toString()){
											rightBot.removeAll();
											rightBot.setLayout(new GridLayout(1, 3));
											rightBot.add(new JLabel("Disprover: " + disprover.getName()));
											rightBot.add(new JLabel(c.getPicture()));
											JButton endTurn = new JButton("End Turn");
											endTurn.addActionListener(new ActionListener(){
												@Override
												public void actionPerformed(ActionEvent e){
													playerLab.removeAll();
													rightBot.removeAll();
													rightMid.removeAll();
													Player play;
													int idx = game.getPlayers().indexOf(player);
													
													if (idx == game.getPlayers().size() - 1){
														play = game.getPlayers().get(0);
													}
													else{
														play = game.getPlayers().get(idx + 1);
													}
													
													game.setTurn(play);
													playerLab.revalidate();
													playerLab.repaint();
													rightMid.revalidate();
													rightMid.repaint();
													rightBot.revalidate();
													rightBot.repaint();
													player.clearChoices();
													for (Room r : game.getRooms()){
														System.out.println("\n" + r + ": ");
														r.printMembers();
													}
												}
											});
											rightBot.add(endTurn);
											rightBot.revalidate();
											rightBot.repaint();
										}
									}}
									
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
		roll.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				rightBot.remove(noMove);
				int dieRoll = player.roll();
				ArrayList<Room> rooms = game.getRooms();
				if (rooms.get(0).getMembers().contains(player)){
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(3, 6), dieRoll, 3, 6);
					
					int[] door = new int[] {3, 6};
					player.listRemove(player.getMoveChoices(), door);
					
				}
				else if (rooms.get(1).getMembers().contains(player)){
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(18, 19), dieRoll, 0 ,0);
					
					int[] door = new int[] {18, 19};
					player.listRemove(player.getMoveChoices(), door);
					
				}
				else if (rooms.get(2).getMembers().contains(player)){
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(5, 17), dieRoll, 5 ,17);
					
					int[] door = new int[] {5, 17};
					player.listRemove(player.getMoveChoices(), door);
					
				}
				else if (rooms.get(3).getMembers().contains(player)){
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(19, 8), dieRoll, 0, 0);
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(17, 9), dieRoll, 0, 0);
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(17, 14), dieRoll, 0,0 );
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(19, 15), dieRoll , 0, 0);
					
					int[] door1 = new int[] {19, 8};
					int[] door2 = new int[] {17, 9};
					int[] door3 = new int[] {17, 14};
					int[] door4 = new int[] {19, 15};
					player.listRemove(player.getMoveChoices(), door1);
					player.listRemove(player.getMoveChoices(), door2);
					player.listRemove(player.getMoveChoices(), door3);
					player.listRemove(player.getMoveChoices(), door4);
					
				}
				else if (rooms.get(4).getMembers().contains(player)){
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(8, 6), dieRoll, 0, 0);
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(10, 3), dieRoll,0 ,0);
					
					int[] door1 = new int[] {8, 6};
					int[] door2 = new int[] {10, 3};
					player.listRemove(player.getMoveChoices(), door1);
					player.listRemove(player.getMoveChoices(), door2);
					
				}
				else if (rooms.get(5).getMembers().contains(player)){
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(19, 4), dieRoll,19,4);
					
					int[] door1 = new int[] {19, 4};
					player.listRemove(player.getMoveChoices(), door1);
					
				}
				else if (rooms.get(6).getMembers().contains(player)){
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(9, 17), dieRoll,0,0);
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(12, 16), dieRoll,0,0);
					
					int[] door1 = new int[] {9, 17};
					int[] door2 = new int[] {12, 16};
					player.listRemove(player.getMoveChoices(), door1);
					player.listRemove(player.getMoveChoices(), door2);
					
				}
				else if (rooms.get(7).getMembers().contains(player)){
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(12, 1), dieRoll,0,0);
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(15, 5), dieRoll,0,0);
					
					int[] door1 = new int[] {12, 1};
					int[] door2 = new int[] {15, 5};
					player.listRemove(player.getMoveChoices(), door1);
					player.listRemove(player.getMoveChoices(), door2);
					
				}
				else if (rooms.get(8).getMembers().contains(player)){
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(4, 9), dieRoll,0,0);
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(6, 11), dieRoll,0,0);
					player.calculateMoves(player.getPriorMoves(), player.moveOptions(6, 12), dieRoll,0,0);
					
					int[] door1 = new int[] {4, 9};
					int[] door2 = new int[] {6, 11};
					int[] door3 = new int[] {6, 12};
					player.listRemove(player.getMoveChoices(), door1);
					player.listRemove(player.getMoveChoices(), door2);
					player.listRemove(player.getMoveChoices(), door3);
					
				}
				else{
				player.calculateMoves(player.getPriorMoves(), player.moveOptions(player.getX(), player.getY()), dieRoll,player.getX(),player.getY());
				
				}
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
							if (player.getX() == 0 && player.getY() == 0){
								buttons[player.getX()][player.getY()].setBackground(Color.BLACK);
							}
							else{
							buttons[player.getX()][player.getY()].setBackground(new JButton().getBackground());
							}
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
							for (int i = 0; i < 25; i++){
								for (int j = 0; j < 24; j++){
									if (board[i][j] instanceof Doorway){
										buttons[i][j].setBackground(Color.GRAY);
									}
								}
							}
							rightBot.removeAll();
							rightBot.repaint();
							if(player.inRoom()){
								JButton suggest = new JButton("Suggest");
								JButton endTurn = new JButton("End Turn"); 
								endTurn.addActionListener(new ActionListener(){
									@Override
									public void actionPerformed(ActionEvent e){
										playerLab.removeAll();
										rightBot.removeAll();
										rightMid.removeAll();
										Player play;
										int idx = game.getPlayers().indexOf(player);
										
										if (idx == game.getPlayers().size() - 1){
											play = game.getPlayers().get(0);
										}
										else{
											play = game.getPlayers().get(idx + 1);
										}
										
										game.setTurn(play);
										playerLab.revalidate();
										playerLab.repaint();
										rightMid.revalidate();
										rightMid.repaint();
										rightBot.revalidate();
										rightBot.repaint();
										player.clearChoices();
										for (Room r : game.getRooms()){
											System.out.println("\n" + r + ": ");
											r.printMembers();
										}
									}
								});
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
										JLabel room = new JLabel();
										for (Room r : game.getRooms()){
											if (r.getMembers().contains(player)){
												room.setIcon(r.getCard().getPicture());
												player.setRoom(r.getCard());
											}
										}
										rooms.add(room);
										JButton guess = new JButton("Guess");
										for(Card c: game.getChoices()){  
											JButton card = new JButton(new ImageIcon(((c.getPicture().getImage()
										            .getScaledInstance(80, 80,
										                    java.awt.Image.SCALE_SMOOTH)))));
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
											
										}
										guess.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												if (player.suggest() == null){
													rightPan.removeAll();
													JLabel win = new JLabel("Congratulations! You guessed the cards in the envelope!");
													rightPan.add(win);
													rightPan.revalidate();
													rightPan.repaint();
												}
												else{
												Player disprover = player.suggest();
												
												rightBot.remove(guess);
												rightBot.repaint();
												
												for(Card c: disprover.getPlayersCards()){
													if(c.toString() == player.getPlay().toString()){
														rightBot.removeAll();
														rightBot.setLayout(new GridLayout(1, 3));
														rightBot.add(new JLabel("Disprover: " + disprover.getName()));
														rightBot.add(new JLabel(c.getPicture()));
														JButton endTurn = new JButton("End Turn");
														endTurn.addActionListener(new ActionListener(){
															@Override
															public void actionPerformed(ActionEvent e){
																playerLab.removeAll();
																rightBot.removeAll();
																rightMid.removeAll();
																Player play;
																int idx = game.getPlayers().indexOf(player);
																
																if (idx == game.getPlayers().size() - 1){
																	play = game.getPlayers().get(0);
																}
																else{
																	play = game.getPlayers().get(idx + 1);
																}
																
																game.setTurn(play);
																playerLab.revalidate();
																playerLab.repaint();
																rightMid.revalidate();
																rightMid.repaint();
																rightBot.revalidate();
																rightBot.repaint();
																player.clearChoices();
																for (Room r : game.getRooms()){
																	System.out.println("\n" + r + ": ");
																	r.printMembers();
																}
															}
														});
														rightBot.add(endTurn);
														rightBot.revalidate();
														rightBot.repaint();
													}
													else if(c.toString() == player.getWeapon().toString()){
														rightBot.removeAll();
														rightBot.setLayout(new GridLayout(1, 3));
														rightBot.add(new JLabel("Disprover: " + disprover.getName()));
														rightBot.add(new JLabel(c.getPicture()));
														JButton endTurn = new JButton("End Turn");
														endTurn.addActionListener(new ActionListener(){
															@Override
															public void actionPerformed(ActionEvent e){
																playerLab.removeAll();
																rightBot.removeAll();
																rightMid.removeAll();
																Player play;
																int idx = game.getPlayers().indexOf(player);
																
																if (idx == game.getPlayers().size() - 1){
																	play = game.getPlayers().get(0);
																}
																else{
																	play = game.getPlayers().get(idx + 1);
																}
																
																game.setTurn(play);
																playerLab.revalidate();
																playerLab.repaint();
																rightMid.revalidate();
																rightMid.repaint();
																rightBot.revalidate();
																rightBot.repaint();
																player.clearChoices();
																for (Room r : game.getRooms()){
																	System.out.println("\n" + r + ": ");
																	r.printMembers();
																}
															}
														});
														rightBot.add(endTurn);
														rightBot.revalidate();
														rightBot.repaint();
													}
													else if(c.toString() == player.getRoom().toString()){
														rightBot.removeAll();
														rightBot.setLayout(new GridLayout(1, 3));
														rightBot.add(new JLabel("Disprover: " + disprover.getName()));
														rightBot.add(new JLabel(c.getPicture()));
														JButton endTurn = new JButton("End Turn");
														endTurn.addActionListener(new ActionListener(){
															@Override
															public void actionPerformed(ActionEvent e){
																playerLab.removeAll();
																rightBot.removeAll();
																rightMid.removeAll();
																Player play;
																int idx = game.getPlayers().indexOf(player);
																
																if (idx == game.getPlayers().size() - 1){
																	play = game.getPlayers().get(0);
																}
																else{
																	play = game.getPlayers().get(idx + 1);
																}
																
																game.setTurn(play);
																playerLab.revalidate();
																playerLab.repaint();
																rightMid.revalidate();
																rightMid.repaint();
																rightBot.revalidate();
																rightBot.repaint();
																player.clearChoices();
																for (Room r : game.getRooms()){
																	System.out.print("\n" + r + ": ");
																	r.printMembers();
																}
															}
														});
														rightBot.add(endTurn);
														rightBot.revalidate();
														rightBot.repaint();
													}
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
							else {
								JButton endTurn = new JButton("End Turn"); 
								endTurn.addActionListener(new ActionListener(){
									@Override
									public void actionPerformed(ActionEvent e){
										playerLab.removeAll();
										rightBot.removeAll();
										rightMid.removeAll();
										Player play;
										int idx = game.getPlayers().indexOf(player);
										
										if (idx == game.getPlayers().size() - 1){
											play = game.getPlayers().get(0);
										}
										else{
											play = game.getPlayers().get(idx + 1);
										}
										
										game.setTurn(play);
										playerLab.revalidate();
										playerLab.repaint();
										rightMid.revalidate();
										rightMid.repaint();
										rightBot.revalidate();
										rightBot.repaint();
										player.clearChoices();
										for (Room r : game.getRooms()){
											System.out.println("\n" + r + ": ");
											r.printMembers();
										}
									}
								});
								
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
		
		noMove.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				rightBot.remove(roll);
				rightBot.remove(noMove);
				if(player.inRoom()){
					JButton suggest = new JButton("Suggest");
					JButton endTurn = new JButton("End Turn"); 
					endTurn.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e){
							playerLab.removeAll();
							rightBot.removeAll();
							rightMid.removeAll();
							Player play;
							int idx = game.getPlayers().indexOf(player);
							
							if (idx == game.getPlayers().size() - 1){
								play = game.getPlayers().get(0);
							}
							else{
								play = game.getPlayers().get(idx + 1);
							}
							
							game.setTurn(play);
							playerLab.revalidate();
							playerLab.repaint();
							rightMid.revalidate();
							rightMid.repaint();
							rightBot.revalidate();
							rightBot.repaint();
							player.clearChoices();
							for (Room r : game.getRooms()){
								System.out.println("\n" + r + ": ");
								r.printMembers();
							}
						}
					});
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
							JLabel room = new JLabel();
							for (Room r : game.getRooms()){
								if (r.getMembers().contains(player)){
									room.setIcon(r.getCard().getPicture());
									player.setRoom(r.getCard());
								}
							}
							rooms.add(room);
							JButton guess = new JButton("Guess");
							for(Card c: game.getChoices()){  
								JButton card = new JButton(new ImageIcon(((c.getPicture().getImage()
							            .getScaledInstance(80, 80,
							                    java.awt.Image.SCALE_SMOOTH)))));
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
							}
							guess.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									if (player.suggest() == null){
										rightPan.removeAll();
										JLabel win = new JLabel("Congratulations! You guess the cards in the envelope!");
										rightPan.add(win);
										rightPan.revalidate();
										rightPan.repaint();
									}
									else{
									Player disprover = player.suggest();
									
									rightBot.remove(guess);
									rightBot.repaint();
									for(Card c: disprover.getPlayersCards()){
										if(c.toString() == player.getPlay().toString()){
											rightBot.removeAll();
											rightBot.setLayout(new GridLayout(1, 3));
											rightBot.add(new JLabel("Disprover: " + disprover.getName()));
											rightBot.add(new JLabel(c.getPicture()));
											JButton endTurn = new JButton("End Turn");
											endTurn.addActionListener(new ActionListener(){
												@Override
												public void actionPerformed(ActionEvent e){
													playerLab.removeAll();
													rightBot.removeAll();
													rightMid.removeAll();
													Player play;
													int idx = game.getPlayers().indexOf(player);
													
													if (idx == game.getPlayers().size() - 1){
														play = game.getPlayers().get(0);
													}
													else{
														play = game.getPlayers().get(idx + 1);
													}
													
													game.setTurn(play);
													playerLab.revalidate();
													playerLab.repaint();
													rightMid.revalidate();
													rightMid.repaint();
													rightBot.revalidate();
													rightBot.repaint();
													player.clearChoices();
													for (Room r : game.getRooms()){
														System.out.println("\n" + r + ": ");
														r.printMembers();
													}
												}
											});
											rightBot.add(endTurn);
											rightBot.revalidate();
											rightBot.repaint();
										}
										else if(c.toString() == player.getWeapon().toString()){
											rightBot.removeAll();
											rightBot.setLayout(new GridLayout(1, 3));
											rightBot.add(new JLabel("Disprover: " + disprover.getName()));
											rightBot.add(new JLabel(c.getPicture()));
											JButton endTurn = new JButton("End Turn");
											endTurn.addActionListener(new ActionListener(){
												@Override
												public void actionPerformed(ActionEvent e){
													playerLab.removeAll();
													rightBot.removeAll();
													rightMid.removeAll();
													Player play;
													int idx = game.getPlayers().indexOf(player);
													
													if (idx == game.getPlayers().size() - 1){
														play = game.getPlayers().get(0);
													}
													else{
														play = game.getPlayers().get(idx + 1);
													}
													
													game.setTurn(play);
													playerLab.revalidate();
													playerLab.repaint();
													rightMid.revalidate();
													rightMid.repaint();
													rightBot.revalidate();
													rightBot.repaint();
													player.clearChoices();
													for (Room r : game.getRooms()){
														System.out.println("\n" + r + ": ");
														r.printMembers();
													}
												}
											});
											rightBot.add(endTurn);
											rightBot.revalidate();
											rightBot.repaint();
										}
										else if(c.toString() == player.getRoom().toString()){
											rightBot.removeAll();
											rightBot.setLayout(new GridLayout(1, 3));
											rightBot.add(new JLabel("Disprover: " + disprover.getName()));
											rightBot.add(new JLabel(c.getPicture()));
											JButton endTurn = new JButton("End Turn");
											endTurn.addActionListener(new ActionListener(){
												@Override
												public void actionPerformed(ActionEvent e){
													playerLab.removeAll();
													rightBot.removeAll();
													rightMid.removeAll();
													Player play;
													int idx = game.getPlayers().indexOf(player);
													
													if (idx == game.getPlayers().size() - 1){
														play = game.getPlayers().get(0);
													}
													else{
														play = game.getPlayers().get(idx + 1);
													}
													
													game.setTurn(play);
													playerLab.revalidate();
													playerLab.repaint();
													rightMid.revalidate();
													rightMid.repaint();
													rightBot.revalidate();
													rightBot.repaint();
													player.clearChoices();
													for (Room r : game.getRooms()){
														System.out.println("\n" + r + ": ");
														r.printMembers();
													}
												}
											});
											rightBot.add(endTurn);
											rightBot.revalidate();
											rightBot.repaint();
										}
									}}
									
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
				else{
					playerLab.removeAll();
					rightBot.removeAll();
					rightMid.removeAll();
					Player play;
					int idx = game.getPlayers().indexOf(player);
					
					if (idx == game.getPlayers().size() - 1){
						play = game.getPlayers().get(0);
					}
					else{
						play = game.getPlayers().get(idx + 1);
					}
					
					game.setTurn(play);
					playerLab.revalidate();
					playerLab.repaint();
					rightMid.revalidate();
					rightMid.repaint();
					rightBot.revalidate();
					rightBot.repaint();
					player.clearChoices();
				}
				
			}
		});
		rightBot.add(noMove);
		rightBot.add(roll);
		if (game.getRooms().get(0).getMembers().contains(player) || game.getRooms().get(2).getMembers().contains(player) || game.getRooms().get(5).getMembers().contains(player) || game.getRooms().get(1).getMembers().contains(player)){
			rightBot.add(usePassage);
		}
	}
	}
