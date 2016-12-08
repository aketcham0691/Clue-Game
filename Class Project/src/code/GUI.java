package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import layout.TableLayout;

public class GUI {

	BoardObject[][] board;
	JButton[][] buttons = new JButton[25][24]; 
	ArrayList<JButton> lounge = new ArrayList<JButton>();
	ArrayList<JButton> hall = new ArrayList<JButton>();
	ArrayList<JButton> ballroom = new ArrayList<JButton>();
	ArrayList<JButton> kitchen = new ArrayList<JButton>();
	ArrayList<JButton> conservatory = new ArrayList<JButton>();
	ArrayList<JButton> billiard = new ArrayList<JButton>();
	ArrayList<JButton> study = new ArrayList<JButton>();
	ArrayList<JButton> library = new ArrayList<JButton>();
	ArrayList<JButton> dining = new ArrayList<JButton>();
	Game game;
	JFrame window;
	JPanel panel;
	JPanel leftPan;
	JPanel rightPan;
	JPanel farRightPan = new JPanel();
	BackgroundPanel bg2;
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
	Room guessRoom;
	JFrame evidence = new JFrame("Suggestions");
	JPanel scarSuggestions = new JPanel();
	JPanel colSuggestions = new JPanel();
	JPanel whiteSuggestions = new JPanel();
	JPanel greenSuggestions = new JPanel();
	JPanel peaSuggestions = new JPanel();
	JPanel plumSuggestions = new JPanel();	
	ArrayList<BackgroundPanel> suggestionCards = new ArrayList<BackgroundPanel>();
	ImageIcon parchment = new ImageIcon(getClass().getResource("parchment.jpg"));
	Image parchmentimg = parchment.getImage();
	ImageIcon parchment1 = new ImageIcon(getClass().getResource("parchment1.jpg"));
	Image parchmentimg1 = parchment1.getImage();
	ImageIcon black = new ImageIcon(getClass().getResource("black.jpg"));
	ImageIcon white = new ImageIcon(getClass().getResource("white.jpg"));
	JTextArea textArea = new JTextArea(2, 20);
	
	
	public GUI(Game game) {
		this.game = game;
		window = new JFrame("Clue");
		window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		window.setVisible(true);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon boardImg = new ImageIcon(getClass().getResource("board.jpg"));
		Image img = boardImg.getImage();
		BackgroundPanel bg = new BackgroundPanel(img);
		ImageIcon clue = new ImageIcon(getClass().getResource("clue.jpg"));
		Image img1 = clue.getImage();
		BackgroundPanel bg1 = new BackgroundPanel(img1);
		bg1.setLayout(null);
		JButton button = new JButton();
		ImageIcon mansion = new ImageIcon(getClass().getResource("mansion.jpg"));
		Image mansionimg = mansion.getImage();
		
		bg2 = new BackgroundPanel(mansionimg);
		button.setText("Start Game!");
		panel = new JPanel();
		double[][] size = {{.46, .46, .08},{TableLayout.FILL}};
		panel.setLayout (new TableLayout(size));
		farRightPan.setLayout(new GridLayout(1,1));		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				board = game.getBoard().getBoard(); 		
				window.setContentPane(panel);				
				rightPan = new JPanel();				
				panel.add(bg, "0, 0");
				panel.add(bg2, "1, 0");
				panel.add(farRightPan, "2, 0");				
				bg.setLayout(new GridLayout(25, 24));
				for (int i = 0; i < 25; i++){
					for (int j = 0; j < 24; j++){
						JButton button = new JButton();
						button.setBorder(new LineBorder(Color.black));
						buttons[i][j] = button; 
						bg.add(button);
						if (board[i][j] instanceof Hallway){
							if (i%2 == 0 && j%2 == 0){
								button.setIcon(black);
							}
							if (i%2 == 0 && j%2 == 1){
								button.setIcon(white);
							}
							if (i%2 == 1 && j%2 == 0){
								button.setIcon(white);
							}
							if (i%2 == 1 && j%2 == 1){
								button.setIcon(black);
							}
							
						}
						if (board[i][j] instanceof Wall){
							button.setBackground(Color.BLACK);
							button.setBorder(null);
						}
						if (board[i][j] instanceof Player){
							Player play = (Player) board[i][j];
							button.setIcon(play.getIcon());
							button.setOpaque(true);
						}
						if (board[i][j] instanceof Doorway){
							button.setBackground(Color.GRAY);
							button.setBorder(null);
						}
						
					}
				}
				lounge.add(buttons[1][18]);
				lounge.add(buttons[1][19]);
				lounge.add(buttons[1][20]);
				lounge.add(buttons[1][21]);
				lounge.add(buttons[2][21]);
				lounge.add(buttons[3][21]);
				hall.add(buttons[1][10]);
				hall.add(buttons[1][11]);
				hall.add(buttons[1][12]);
				hall.add(buttons[1][13]);
				hall.add(buttons[4][11]);
				hall.add(buttons[4][12]);
				study.add(buttons[0][1]);
				study.add(buttons[0][2]);
				study.add(buttons[0][3]);
				study.add(buttons[0][4]);
				study.add(buttons[1][0]);
				study.add(buttons[2][0]);
				library.add(buttons[7][1]);
				library.add(buttons[8][1]);
				library.add(buttons[9][1]);
				library.add(buttons[7][4]);
				library.add(buttons[8][4]);
				library.add(buttons[9][4]);
				billiard.add(buttons[13][1]);
				billiard.add(buttons[14][1]);
				billiard.add(buttons[15][1]);
				billiard.add(buttons[13][2]);
				billiard.add(buttons[14][2]);
				billiard.add(buttons[15][2]);
				conservatory.add(buttons[20][1]);
				conservatory.add(buttons[20][2]);
				conservatory.add(buttons[20][3]);
				conservatory.add(buttons[23][1]);
				conservatory.add(buttons[23][2]);
				conservatory.add(buttons[23][3]);
				ballroom.add(buttons[20][9]);
				ballroom.add(buttons[20][10]);
				ballroom.add(buttons[20][11]);
				ballroom.add(buttons[20][12]);
				ballroom.add(buttons[20][13]);
				ballroom.add(buttons[20][14]);
				kitchen.add(buttons[21][19]);
				kitchen.add(buttons[21][20]);
				kitchen.add(buttons[21][21]);
				kitchen.add(buttons[22][19]);
				kitchen.add(buttons[22][20]);
				kitchen.add(buttons[22][21]);
				dining.add(buttons[10][18]);
				dining.add(buttons[11][18]);
				dining.add(buttons[12][18]);
				dining.add(buttons[10][21]);
				dining.add(buttons[11][21]);
				dining.add(buttons[12][21]);
				bg2.setLayout(new GridLayout(3, 1));
				playerLab = new JLabel();
				playerLab.setFont(new Font("Arial", Font.PLAIN, 40));
				playerLab.setForeground(Color.white);
				rightTop = new JPanel();
				rightTop.setLayout(new GridBagLayout());
				bg2.add(rightTop);
				rightMid = new JPanel();
				rightMid.setLayout(new BoxLayout(rightMid, BoxLayout.LINE_AXIS));
				bg2.add(rightMid);
				rightBot = new JPanel();
				rightBot.setLayout(new BoxLayout(rightBot, BoxLayout.LINE_AXIS));
				bg2.add(rightBot);
				setTurn(game.getPlayers().get(0), game);
				panel.remove(button);
			}
		});
		bg1.setLayout(new GridBagLayout());
		bg1.add(button);
		window.setContentPane(bg1);
		window.revalidate();
		window.repaint();
		for (int i = 0; i < 6; i++){
			BackgroundPanel evidence = new BackgroundPanel(parchmentimg1);
			JLabel characters = new JLabel("People");
			characters.setAlignmentX(Component.CENTER_ALIGNMENT);
			characters.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 24));
			characters.setOpaque(true);
			JPanel chars = new JPanel();
			chars.setLayout(new GridLayout(6,1));
			for (int j = 0; j< 6; j++){
				JPanel charSug = new JPanel();
				double[][] layout = {{.8,.2},{TableLayout.FILL}};
				charSug.setLayout(new TableLayout(layout));
				charSug.setBackground(null);
				charSug.setOpaque(false);
				JLabel scarName = new JLabel();
				switch(j){
				case 0: scarName.setText("Miss Scarlet"); break;
				case 1: scarName.setText("Col. Mustard"); break;
				case 2: scarName.setText("Mrs. White"); break;
				case 3: scarName.setText("Mr. Green"); break;
				case 4: scarName.setText("Mrs. Peacock"); break;
				case 5: scarName.setText("Prof. Plum"); break;
				}
			
				scarName.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 16));
				scarName.setBackground(null);
				scarName.setOpaque(false);
				scarName.setBorder(BorderFactory.createLineBorder(Color.black));
				charSug.add(scarName, "0, 0");
				JButton mark = new JButton();
				mark.setBackground(Color.white);
				mark.setSize(new Dimension(20,50));
				mark.setBorder(BorderFactory.createLineBorder(Color.black));
				mark.setFocusPainted(false);
				mark.setText(null);
				mark.setOpaque(false);
				mark.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						if (mark.getText() == null){
							mark.setText("X");
							
						}
						else mark.setText(null);
					}
				});
				charSug.add(mark, "1, 0");
				chars.add(charSug);
			}
			JLabel weapons = new JLabel("Weapons");
			weapons.setAlignmentX(Component.CENTER_ALIGNMENT);
			weapons.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 24));
			weapons.setOpaque(true);
			JPanel weaps = new JPanel();
			weaps.setLayout(new GridLayout(6,1));
			for (int l = 0; l< 6; l++){
				JPanel weapSug = new JPanel();
				double[][] layout = {{.8,.2},{TableLayout.FILL}};
				weapSug.setLayout(new TableLayout(layout));
				weapSug.setBackground(null);
				weapSug.setOpaque(false);
				JLabel scarName = new JLabel();
				switch(l){
				case 0: scarName.setText("Revolver"); break;
				case 1: scarName.setText("Lead Pipe"); break;
				case 2: scarName.setText("Candlestick"); break;
				case 3: scarName.setText("Rope"); break;
				case 4: scarName.setText("Knife"); break;
				case 5: scarName.setText("Wrench"); break;
				}
				
				scarName.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 16));
				scarName.setBackground(null);
				scarName.setOpaque(false);
				scarName.setBorder(BorderFactory.createLineBorder(Color.black));
				weapSug.add(scarName, "0, 0");
				JButton mark = new JButton();
				mark.setBackground(Color.white);
				mark.setBorder(BorderFactory.createLineBorder(Color.black));
				mark.setSize(new Dimension(100,100));
				mark.setFocusPainted(false);
				mark.setText(null);
				mark.setOpaque(false);
				mark.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						if (mark.getText() == null){
							mark.setText("X");
							
						}
						else mark.setText(null);
					}
				});
				weapSug.add(mark, "1, 0");
				weaps.add(weapSug);
			}
			JLabel rooms = new JLabel("Rooms");
			rooms.setAlignmentX(Component.CENTER_ALIGNMENT);
			rooms.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 24));
			rooms.setOpaque(true);
			JPanel roomss = new JPanel();
			roomss.setLayout(new GridLayout(9,1));
			for (int k = 0; k < 9; k++){
				JPanel roomSug = new JPanel();
				double[][] layout = {{.8,.2},{TableLayout.FILL}};
				roomSug.setLayout(new TableLayout(layout));
				roomSug.setBackground(null);
				roomSug.setOpaque(false);
				JLabel scarName = new JLabel();
				switch(k){
				case 0: scarName.setText("Lounge"); break;
				case 1: scarName.setText("Conservatory"); break;
				case 2: scarName.setText("Ballroom"); break;
				case 3: scarName.setText("Dining Room"); break;
				case 4: scarName.setText("Billiard Room"); break;
				case 5: scarName.setText("Hall"); break;
				case 6: scarName.setText("Kitchen"); break;
				case 7: scarName.setText("Library"); break;
				case 8: scarName.setText("Study"); break;
				}
				
				scarName.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 16));
				scarName.setBackground(null);
				scarName.setOpaque(false);
				scarName.setBorder(BorderFactory.createLineBorder(Color.black));
				roomSug.add(scarName, "0, 0");
				JButton mark = new JButton();
				mark.setBackground(Color.white);
				mark.setBorder(BorderFactory.createLineBorder(Color.black));
				mark.setFocusPainted(false);
				mark.setText(null);
				mark.setOpaque(false);
				mark.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						if (mark.getText() == null){
							mark.setText("X");
							
						}
						else mark.setText(null);
					}
				});
				roomSug.add(mark, "1, 0");
				roomss.add(roomSug);
			}
			evidence.setLayout(new BoxLayout(evidence, BoxLayout.PAGE_AXIS)); 
			evidence.add(characters);
			evidence.add(chars);
			evidence.add(weapons);
			evidence.add(weaps);
			evidence.add(rooms);
			evidence.add(roomss);
			suggestionCards.add(evidence);
		}
	}
	
	public void setTurn(Player player, Game game){
		rightTop.removeAll();
		rightTop.setLayout(new GridBagLayout());
		BackgroundPanel namebg = new BackgroundPanel(parchmentimg);
		JTextArea nameText = new JTextArea(1,1);
		nameText.setText("\n"+ "    " + player.getName() + "    \n");
		nameText.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 44));
		namebg.add(nameText);
		rightTop.add(namebg);
	    rightTop.revalidate();
	    rightTop.repaint();
		farRightPan.removeAll();
		farRightPan.add(suggestionCards.get(game.getPlayers().indexOf(player)));
		//evidence.setContentPane(suggestionCards.get(game.getPlayers().indexOf(player)));
		//evidence.setVisible(true);
		//evidence.setSize(380, 1000);
		//playerLab.setText(player.getName());
		//playerLab.setForeground(Color.white);
		window.setContentPane(panel);
		ArrayList<Card> playerCards = player.getPlayersCards();
		rightMid.setLayout(new BoxLayout(rightMid, BoxLayout.LINE_AXIS));
		rightMid.add(Box.createHorizontalGlue());
		JButton showCards = new JButton("Show Cards");
		showCards.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				rightMid.removeAll();
				rightMid.add(Box.createHorizontalGlue());
				for (Card c : playerCards){
					ImageIcon image1 = c.getPicture();
					JLabel rightlabel = new JLabel(image1);
					rightMid.add(rightlabel);
					rightMid.add(Box.createHorizontalGlue());
				}
				rightMid.revalidate();
				rightMid.repaint();
			}
		});
		rightMid.add(showCards);
		rightMid.add(Box.createHorizontalGlue());
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
			}
		});
		JButton accusation = new JButton("Make Accusation");
		accusation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rightBot.removeAll();
				rightBot.revalidate();
				rightBot.repaint();
				rightBot.setLayout(new GridLayout(2, 2));
				JPanel players = new JPanel(); 
				players.setLayout(new GridLayout(1, 6));
				JPanel weapons = new JPanel(); 
				weapons.setLayout(new GridLayout(1, 6));
				JPanel rooms= new JPanel(); 
				rooms.setLayout(new GridLayout(1, 9));
				JButton accuse = new JButton("Accuse");
				for(Card c: game.getChoices()){  
					JButton card = new JButton(new ImageIcon(((c.getPicture().getImage()
				            .getScaledInstance(80, 150,
				                    java.awt.Image.SCALE_SMOOTH)))));
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
								card.removeActionListener(this);
								rooms.revalidate();
								rooms.repaint();
							}
						});
						rooms.add(card);
					}
					if(c instanceof CharacterCard){
						card.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e){
								card.removeActionListener(this);
								player.setPlay(c);
								for (Component comp : players.getComponents()){
									if (card != comp){
										players.remove(comp);
									}
								}
								card.removeActionListener(this);
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
								card.removeActionListener(this);
								weapons.revalidate();
								weapons.repaint();
							}
						});
						weapons.add(card);
					}
					
					
				}
				accuse.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Player disprover = player.suggest();
						if (disprover == null){
							rightMid.removeAll();
							rightMid.setLayout(new GridBagLayout());
							rightBot.removeAll();
							BackgroundPanel winbg = new BackgroundPanel(parchmentimg);
							JTextArea textArea = new JTextArea(2, 20);
							textArea.setSize(new Dimension(800, 400));
						    textArea.setText("\n               Congratulations! You solved the mystery! \n");
						    textArea.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 28));
						    textArea.setWrapStyleWord(true);
						    textArea.setLineWrap(true);
						    textArea.setOpaque(false);
						    textArea.setEditable(false);
						    textArea.setFocusable(false);
						    textArea.setBackground(UIManager.getColor("Label.background"));
						    textArea.setBorder(UIManager.getBorder("Label.border"));
						    winbg.add(textArea);
						    JButton close = new JButton("Close Game");
						    close.addActionListener(new ActionListener(){
						    	@Override
						    	public void actionPerformed(ActionEvent e){
						    		System.exit(0);
						    	}
						    });
							rightMid.add(winbg);
							rightBot.setLayout(new BoxLayout(rightBot, BoxLayout.LINE_AXIS));
							rightBot.add(Box.createHorizontalGlue());
							rightBot.add(close);
							rightBot.add(Box.createHorizontalGlue());
							rightMid.revalidate();
							rightMid.repaint();
							rightBot.revalidate();
							rightBot.repaint();
						}
						else{
							rightMid.removeAll();
							rightMid.setLayout(new GridBagLayout());
							
							BackgroundPanel losebg = new BackgroundPanel(parchmentimg);
							JTextArea textArea = new JTextArea(2, 20);
							textArea.setSize(new Dimension(800, 400));
						    textArea.setText("\n          Sorry, your accusation was incorrect. \n\n          You have been removed from the game.\n");
						    textArea.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 28));
						    textArea.setWrapStyleWord(true);
						    textArea.setLineWrap(true);
						    textArea.setOpaque(false);
						    textArea.setEditable(false);
						    textArea.setFocusable(false);
						    textArea.setBackground(UIManager.getColor("Label.background"));
						    textArea.setBorder(UIManager.getBorder("Label.border"));
						    losebg.add(textArea);
							rightMid.add(losebg);
							player.removeFromGame();
							rightBot.removeAll();
							rightBot.setLayout(new BoxLayout(rightBot, BoxLayout.LINE_AXIS));
							rightBot.add(Box.createHorizontalGlue());
							rightBot.add(endTurn);
							rightBot.add(Box.createHorizontalGlue());
							rightMid.revalidate();
							rightMid.repaint();
							rightBot.revalidate();
							rightBot.repaint();
						}
						
					}
				});
				rightBot.add(players);
				rightBot.add(weapons);
				rightBot.add(rooms);	
				rightBot.add(accuse);
			}
			
		});
		JButton suggest = new JButton("Suggest");
		
		suggest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rightBot.removeAll();
				rightBot.revalidate();
				rightBot.repaint();
				rightBot.setLayout(new GridLayout(2, 2));
				JPanel players = new JPanel(); 
				players.setLayout(new GridLayout(1, 6));
				JPanel weapons = new JPanel(); 
				weapons.setLayout(new GridLayout(1, 6));
				JPanel rooms= new JPanel(); 
				rooms.setLayout(new GridLayout(1, 1));
				JButton room = new JButton();
				for (Room r : game.getRooms()){
					if (r.getMembers().contains(player)){
						guessRoom = r;
						room.setIcon(new ImageIcon(((r.getCard().getPicture().getImage()
					            .getScaledInstance(80, 150,
					                    java.awt.Image.SCALE_SMOOTH)))));
						player.setRoom(r.getCard());
						break;
					}
					
				}

				rooms.add(room);
				JButton guess = new JButton("Guess");
				for(Card c: game.getChoices()){  
					JButton card = new JButton(new ImageIcon(((c.getPicture().getImage()
				            .getScaledInstance(80, 150,
				                    java.awt.Image.SCALE_SMOOTH)))));
					if(c instanceof CharacterCard){
						card.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e){
								card.removeActionListener(this);
								player.setPlay(c);
								for (Component comp : players.getComponents()){
									if (card != comp){
										players.remove(comp);
									}
								}
								for (Player p : game.getPlayers()){
									if (p.getCard().toString() == c.toString()){
										int pX = p.getX();
										int pY = p.getY();
										if (pX != 0 && pY != 0){
											if (pX%2 == 0 && pY%2 == 0){
												buttons[pX][pY].setIcon(black);
											}
											if (pX%2 == 0 && pY%2 == 1){
												buttons[pX][pY].setIcon(white);
											}
											if (pX%2 == 1 && pY%2 == 0){
												buttons[pX][pY].setIcon(white);
											}
											if (pX%2 == 1 && pY%2 == 1){
												buttons[pX][pY].setIcon(black);
											}
											
											buttons[pX][pY].setBackground(new JButton().getBackground());
										}
										if (p.inRoom()){
											for (int i = 0; i < buttons.length; i++){
												for(int j = 0; j < buttons[0].length; j++){
													if (buttons[i][j].getIcon()!= null && buttons[i][j].getIcon().equals(p.getIcon())){
														buttons[i][j].setBackground(Color.white);
														buttons[i][j].setIcon(null);
														buttons[i][j].setOpaque(false);
													}
												}
											}
										}
										if (guessRoom.equals(game.getRooms().get(0))){
											for(int k = 0; k < 6; k++){
												if (study.get(k).getIcon() == null){
												study.get(k).setIcon(p.getIcon());

												break;
												}
											}
										}
										if (guessRoom.equals(game.getRooms().get(1))){
											for(int k = 0; k < 6; k++){
												if (kitchen.get(k).getIcon() == null){
												kitchen.get(k).setIcon(p.getIcon());

												break;
												}
											}
										}
										if (guessRoom.equals(game.getRooms().get(2))){
											for(int k = 0; k < 6; k++){
												if (lounge.get(k).getIcon() == null){
												lounge.get(k).setIcon(p.getIcon());

												break;
												}
											}
										}
										if (guessRoom.equals(game.getRooms().get(3))){
											for(int k = 0; k < 6; k++){
												if (ballroom.get(k).getIcon() == null){
												ballroom.get(k).setIcon(p.getIcon());

												break;
												}
											}
										}
										if (guessRoom.equals(game.getRooms().get(4))){
											for(int k = 0; k < 6; k++){
												if (library.get(k).getIcon() == null){
												library.get(k).setIcon(p.getIcon());

												break;
												}
											}
										}
										if (guessRoom.equals(game.getRooms().get(5))){
											for(int k = 0; k < 6; k++){
												if (conservatory.get(k).getIcon() == null){
												conservatory.get(k).setIcon(p.getIcon());

												break;
												}
											}
										}
										if (guessRoom.equals(game.getRooms().get(6))){
											for(int k = 0; k < 6; k++){
												if (dining.get(k).getIcon() == null){
												dining.get(k).setIcon(p.getIcon());

												break;
												}
											}
										}
										if (guessRoom.equals(game.getRooms().get(7))){
											for(int k = 0; k < 6; k++){
												if (billiard.get(k).getIcon() == null){
												billiard.get(k).setIcon(p.getIcon());

												break;
												}
											}
										}
										if (guessRoom.equals(game.getRooms().get(8))){
											for(int k = 0; k < 6; k++){
												if (hall.get(k).getIcon() == null){
												hall.get(k).setIcon(p.getIcon());

												break;
												}
											}
										}
										break;
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
								card.removeActionListener(this);
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
						Player disprover = player.suggest();
						if (disprover == null){
							bg2.removeAll();
							JLabel win = new JLabel("Congratulations! You guessed the cards in the envelope!");
							bg2.add(win);
							bg2.revalidate();
							bg2.repaint();
						}
						else{
						rightBot.removeAll();
						rightBot.repaint();
						for(Card c: disprover.getPlayersCards()){
							if(c.toString() == player.getPlay().toString()){
								rightBot.removeAll();
								rightBot.setLayout(new BoxLayout(rightBot, BoxLayout.LINE_AXIS));
								rightBot.add(Box.createHorizontalGlue());
								JLabel disp = new JLabel();
								disp.setFont(new Font("Arial", Font.PLAIN, 28));
								disp.setText("Disprover:   ");
								disp.setForeground(Color.white);
								rightBot.add(disp);
								rightBot.add(new JLabel(disprover.getCard().getPicture()));
								rightBot.add(Box.createHorizontalGlue());
								JLabel dispCard = new JLabel();
								dispCard.setFont(new Font("Arial", Font.PLAIN, 28));
								dispCard.setText("Disprover's Card:   ");
								dispCard.setForeground(Color.white);
								JPanel botRight = new JPanel();
								botRight.setLayout(new BoxLayout(botRight, BoxLayout.PAGE_AXIS));
								botRight.setBackground(null);
								botRight.setOpaque(false);
								rightBot.add(dispCard);
								rightBot.add(new JLabel(c.getPicture()));
								rightBot.add(Box.createHorizontalGlue());
								botRight.add(Box.createVerticalGlue());
								botRight.add(accusation);
								botRight.add(Box.createVerticalGlue());
								botRight.add(endTurn);
								botRight.add(Box.createVerticalGlue());
								rightBot.add(botRight);
								rightBot.add(Box.createHorizontalGlue());	
								rightBot.revalidate();
								rightBot.repaint();
							}
							else if(c.toString() == player.getWeapon().toString()){
								rightBot.removeAll();
								rightBot.setLayout(new BoxLayout(rightBot, BoxLayout.LINE_AXIS));
								rightBot.add(Box.createHorizontalGlue());
								JLabel disp = new JLabel();
								disp.setFont(new Font("Arial", Font.PLAIN, 28));
								disp.setText("Disprover:   ");
								disp.setForeground(Color.white);
								rightBot.add(disp);
								rightBot.add(new JLabel(disprover.getCard().getPicture()));
								rightBot.add(Box.createHorizontalGlue());
								JLabel dispCard = new JLabel();
								dispCard.setFont(new Font("Arial", Font.PLAIN, 28));
								dispCard.setText("Disprover's Card:   ");
								dispCard.setForeground(Color.white);
								JPanel botRight = new JPanel();
								botRight.setLayout(new BoxLayout(botRight, BoxLayout.PAGE_AXIS));
								botRight.setBackground(null);
								botRight.setOpaque(false);
								rightBot.add(dispCard);
								rightBot.add(new JLabel(c.getPicture()));
								rightBot.add(Box.createHorizontalGlue());
								botRight.add(Box.createVerticalGlue());
								botRight.add(accusation);
								botRight.add(Box.createVerticalGlue());
								botRight.add(endTurn);
								botRight.add(Box.createVerticalGlue());
								rightBot.add(botRight);
								rightBot.add(Box.createHorizontalGlue());	
								rightBot.revalidate();
								rightBot.repaint();
							}
							else if(c.toString() == player.getRoom().toString()){
								rightBot.removeAll();
								rightBot.setLayout(new BoxLayout(rightBot, BoxLayout.LINE_AXIS));
								rightBot.add(Box.createHorizontalGlue());
								JLabel disp = new JLabel();
								disp.setFont(new Font("Arial", Font.PLAIN, 28));
								disp.setText("Disprover:   ");
								disp.setForeground(Color.white);
								rightBot.add(disp);
								rightBot.add(new JLabel(disprover.getCard().getPicture()));
								rightBot.add(Box.createHorizontalGlue());
								JLabel dispCard = new JLabel();
								dispCard.setFont(new Font("Arial", Font.PLAIN, 28));
								dispCard.setText("Disprover's Card:   ");
								dispCard.setForeground(Color.white);
								JPanel botRight = new JPanel();
								botRight.setLayout(new BoxLayout(botRight, BoxLayout.PAGE_AXIS));
								botRight.setBackground(null);
								botRight.setOpaque(false);
								rightBot.add(dispCard);
								rightBot.add(new JLabel(c.getPicture()));
								rightBot.add(Box.createHorizontalGlue());
								botRight.add(Box.createVerticalGlue());
								botRight.add(accusation);
								botRight.add(Box.createVerticalGlue());
								botRight.add(endTurn);
								botRight.add(Box.createVerticalGlue());
								rightBot.add(botRight);
								rightBot.add(Box.createHorizontalGlue());	
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
		
		JButton noMove = new JButton("Choose not to move this turn");
		JButton roll = new JButton("Roll");
		JButton usePassage = new JButton("Use Passageway");
		usePassage.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				player.usePassageway();
				if (player.getRoomIn().equals(game.getRooms().get(1))){
					for (JButton b : study){
						if (b.getIcon() != null && b.getIcon().equals(player.getIcon())){
							b.setBackground(Color.white);
							b.setIcon(null);
							b.setOpaque(false);
							break;
						}
					}
					for(int k = 0; k < 6; k++){
						if (kitchen.get(k).getIcon() == null){
						kitchen.get(k).setIcon(player.getIcon());
						break;
						}
					}
				}
				if (player.getRoomIn().equals(game.getRooms().get(0))){
					for (JButton b : kitchen){
						if (b.getIcon() != null && b.getIcon().equals(player.getIcon())){
							b.setBackground(Color.white);
							b.setIcon(null);
							b.setOpaque(false);
							break;
						}
					}
					for(int k = 0; k < 6; k++){
						if (study.get(k).getIcon() == null){
						study.get(k).setIcon(player.getIcon());
						break;
						}
					}
				}
				if (player.getRoomIn().equals(game.getRooms().get(5))){
					for (JButton b : lounge){
						if (b.getIcon() != null && b.getIcon().equals(player.getIcon())){
							b.setBackground(Color.white);
							b.setIcon(null);
							b.setOpaque(false);
							break;
						}
					}
					for(int k = 0; k < 6; k++){
						if (conservatory.get(k).getIcon() == null){
						conservatory.get(k).setIcon(player.getIcon());
						break;
						}
					}
				}
				if (player.getRoomIn().equals(game.getRooms().get(2))){
					for (JButton b : conservatory){
						if (b.getIcon() != null && b.getIcon().equals(player.getIcon())){
							b.setBackground(Color.white);
							b.setIcon(null);
							b.setOpaque(false);
							break;
						}
					}
					for(int k = 0; k < 6; k++){
						if (lounge.get(k).getIcon() == null){
						lounge.get(k).setIcon(player.getIcon());
						break;
						}
					}
				}
				rightBot.removeAll();
				if(player.inRoom()){
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(accusation);
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(suggest);
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(endTurn);
					rightBot.add(Box.createHorizontalGlue());
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
					button.setIcon(null);
					button.setBackground(Color.CYAN);
					button.setOpaque(true);
					moveButtons.add(button);
				}
				for (JButton b : moveButtons){
					b.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e){
							for (int i = 0; i < 25; i++){
								for (int j = 0; j < 24; j++){
									JButton button = buttons[i][j];
									if (board[i][j] instanceof Hallway){
										if (i%2 == 0 && j%2 == 0){
											button.setIcon(black);
										}
										if (i%2 == 0 && j%2 == 1){
											button.setIcon(white);
										}
										if (i%2 == 1 && j%2 == 0){
											button.setIcon(white);
										}
										if (i%2 == 1 && j%2 == 1){
											button.setIcon(black);
										}
										
									}
								}
							}
							if (player.getX() == 0 && player.getY() == 0){
								buttons[player.getX()][player.getY()].setIcon(null);
								buttons[player.getX()][player.getY()].setBackground(Color.BLACK);
							}
							else{
								if (player.getX()%2 == 0 && player.getY()%2 == 0){
									buttons[player.getX()][player.getY()].setIcon(black);
								}
								if (player.getX()%2 == 0 && player.getY()%2 == 1){
									buttons[player.getX()][player.getY()].setIcon(white);
								}
								if (player.getX()%2 == 1 && player.getY()%2 == 0){
									buttons[player.getX()][player.getY()].setIcon(white);
								}
								if (player.getX()%2 == 1 && player.getY()%2 == 1){
									buttons[player.getX()][player.getY()].setIcon(black);
								}
							buttons[player.getX()][player.getY()].setBackground(new JButton().getBackground());
							}
							if (player.inRoom()){
								for (int i = 0; i < buttons.length; i++){
									for(int j = 0; j < buttons[0].length; j++){
										if (buttons[i][j].getIcon()!= null && buttons[i][j].getIcon().equals(player.getIcon())){
											buttons[i][j].setBackground(Color.white);
											buttons[i][j].setIcon(null);
											buttons[i][j].setOpaque(false);
										}
									}
								}
							}
							int xIndex = 0;
							int yIndex = 0;
							for (int i = 0; i < buttons.length; i++){
								for(int j = 0; j < buttons[0].length; j++){
									if (buttons[i][j] == b){
										xIndex = i;
										yIndex = j;
										if(i == 5 && j == 17){
											for(int k = 0; k < 6; k++){
												if (lounge.get(k).getIcon() == null){
												lounge.get(k).setIcon(player.getIcon());
												break;
												}
											}		
										}
										if((i == 6 && j == 11)||(i == 6 && j == 12)||(i == 4 && j == 9)){
											for(int k = 0; k < 6; k++){
												if (hall.get(k).getIcon() == null){
												hall.get(k).setIcon(player.getIcon());
												break;
												}
											}		
										}
										if(i == 3 && j == 6){
											for(int k = 0; k < 6; k++){
												if (study.get(k).getIcon() == null){
												study.get(k).setIcon(player.getIcon());
												break;
												}
											}		
										}
										if((i == 8 && j == 6)||(i == 10 && j == 3)){
											for(int k = 0; k < 6; k++){
												if (library.get(k).getIcon() == null){
												library.get(k).setIcon(player.getIcon());
												break;
												}
											}		
										}
										if((i == 12 && j == 1)||(i == 15 && j == 5)){
											for(int k = 0; k < 6; k++){
												if (billiard.get(k).getIcon() == null){
												billiard.get(k).setIcon(player.getIcon());
												break;
												}
											}		
										}
										if(i == 19 && j == 4){
											for(int k = 0; k < 6; k++){
												if (conservatory.get(k).getIcon() == null){
												conservatory.get(k).setIcon(player.getIcon());
												break;
												}
											}		
										}
										if((i == 19 && j == 8)||(i == 19 && j == 15)||(i == 17 && j == 9)||(i == 17 && j == 14)){
											for(int k = 0; k < 6; k++){
												if (ballroom.get(k).getIcon() == null){
												ballroom.get(k).setIcon(player.getIcon());
												break;
												}
											}		
										}
										if(i == 18 && j == 19){
											for(int k = 0; k < 6; k++){
												if (kitchen.get(k).getIcon() == null){
												kitchen.get(k).setIcon(player.getIcon());
												break;
												}
											}		
										}
										if((i == 9 && j == 17)||(i == 12 && j == 16)){
											for(int k = 0; k < 6; k++){
												if (dining.get(k).getIcon() == null){
												dining.get(k).setIcon(player.getIcon());
												break;
												}
											}		
										}
									}
								}
							}
							
							player.move(xIndex, yIndex);
							for (JButton but : moveButtons){
								but.setBackground(new JButton().getBackground());
								but.removeAll();
								for (ActionListener al : but.getActionListeners()){
									but.removeActionListener(al);
								}
							}				
							b.setIcon(player.getIcon());
							for (int i = 0; i < 25; i++){
								for (int j = 0; j < 24; j++){
									if (board[i][j] instanceof Doorway){
										buttons[i][j].setIcon(null);
										buttons[i][j].setOpaque(false);
										buttons[i][j].setContentAreaFilled(false);
										buttons[i][j].setBorderPainted(false);
									}
								}
							}
							rightBot.removeAll();
							rightBot.repaint();
							if(player.inRoom()){
								rightBot.add(Box.createHorizontalGlue());
								rightBot.add(accusation);
								rightBot.add(Box.createHorizontalGlue());
								rightBot.add(suggest);
								rightBot.add(Box.createHorizontalGlue());
								rightBot.add(endTurn);
								rightBot.add(Box.createHorizontalGlue());
								rightBot.revalidate();
								rightBot.repaint();
								
							}
							else {
								
								rightBot.add(Box.createHorizontalGlue());
								rightBot.add(endTurn);
								rightBot.add(Box.createHorizontalGlue());
								rightBot.revalidate();
								rightBot.repaint();
							}
						}
					});
				}
				rightBot.removeAll();
				switch(dieRoll){
				case 1: 
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(one);
					rightBot.add(Box.createHorizontalGlue());
				break; 
				case 2: 
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(two); 
					rightBot.add(Box.createHorizontalGlue());
				break; 
				case 3: 
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(three);
					rightBot.add(Box.createHorizontalGlue());
				break; 
				case 4: 
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(four); 
					rightBot.add(Box.createHorizontalGlue());
				break;
				case 5: 
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(five);
					rightBot.add(Box.createHorizontalGlue());
				break; 
				case 6: 
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(six);
					rightBot.add(Box.createHorizontalGlue());
				break;
				}
				rightBot.revalidate();
				rightBot.repaint(); 
			}
		});
		
		noMove.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				rightBot.removeAll();
				if(player.inRoom()){
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(accusation);
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(suggest);
					rightBot.add(Box.createHorizontalGlue());
					rightBot.add(endTurn);
					rightBot.add(Box.createHorizontalGlue());
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
		if (!player.isInGame()){
			rightBot.add(Box.createHorizontalGlue());
			rightBot.add(endTurn);
			rightBot.add(Box.createHorizontalGlue());
		}
		else{
		rightBot.add(Box.createHorizontalGlue());
		rightBot.add(noMove);
		rightBot.add(Box.createHorizontalGlue());
		if (game.getRooms().get(0).getMembers().contains(player) || game.getRooms().get(2).getMembers().contains(player) || game.getRooms().get(5).getMembers().contains(player) || game.getRooms().get(1).getMembers().contains(player)){
			rightBot.add(usePassage);
			rightBot.add(Box.createHorizontalGlue());
		}
		if (game.getRooms().get(0).getMembers().contains(player) && board[4][6] instanceof Player){
			
		}
		else if (game.getRooms().get(1).getMembers().contains(player) && board[17][19] instanceof Player){
			
		}
		else if (game.getRooms().get(2).getMembers().contains(player) && board[6][17] instanceof Player){
			
		}
		else if (game.getRooms().get(3).getMembers().contains(player) && board[19][7] instanceof Player && board[19][16] instanceof Player && board[16][9] instanceof Player && board[16][14] instanceof Player){
			
		}
		else if (game.getRooms().get(4).getMembers().contains(player) && board[8][7] instanceof Player && board[11][3] instanceof Player){
			
		}
		else if (game.getRooms().get(5).getMembers().contains(player) && board[19][5] instanceof Player){
			
		}
		else if (game.getRooms().get(6).getMembers().contains(player) && board[8][17] instanceof Player && board[12][15] instanceof Player){
			
		}
		else if (game.getRooms().get(7).getMembers().contains(player) && board[11][1] instanceof Player && board[15][6] instanceof Player){
			
		}
		else if (game.getRooms().get(8).getMembers().contains(player) && board[4][8] instanceof Player && board[7][11] instanceof Player && board[7][12] instanceof Player){
			
		}
		else{
		rightBot.add(roll);
		rightBot.add(Box.createHorizontalGlue());
		rightBot.add(accusation);
		rightBot.add(Box.createHorizontalGlue());
		}
		bg2.revalidate();
		bg2.repaint();
		}
	}
	}
