package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public GUI(Game game){
		this.game = game;
		window = new JFrame();
		window.setVisible(true);
		window.setSize(1300,1300); 
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
				
				leftPan.setBackground(Color.RED);
				rightPan.setBackground(Color.BLUE);
				
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
				
				leftPan.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 30, Color.BLACK));
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
				
			}
		});
		rightBot.add(roll);
		
	}
	
	
}
