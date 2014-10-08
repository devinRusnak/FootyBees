/**
 * GUI.java
 * 
 * 	This file is part of FootyBees.
 *
 *  FootyBees is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  FootyBees is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FootyBees.  If not, see <http://www.gnu.org/licenses/>.
 *  
 *  Copyright 2014 Devin Rusnak
 *  @author Devin Rusank
 *
 */
package footybees;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

public class GUI extends JFrame{

	// class instance variables
	private static final long serialVersionUID = 1L;
	private static JLabel time;
	private static GUI instance = null;	
	private static JFrame frame = null;
	private static JLabel status = null;
	private static JTextArea consoleView = null;
	private static double scale = 0.5;

	private GUI() {
		
		// class instance variables
		DrawingPanel field;
		JPanel stats, scoreBoard;
		JScrollPane console;
		JLabel score1, score2;		
		JMenuBar menuBar;
		JMenu file, game, developer;
		JMenuItem exit, newGame, start;
		JRadioButtonMenuItem d2, d3, debug;
		ButtonGroup radio_group;

		try {	// trying to use the default system look for windows etc
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}		


		// initialize the JFrame
		frame = new JFrame("Soccer Sim AIs v0.1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize( new Dimension(750,550) );
		//frame.setBackground(Color.lightGray);
		frame.getContentPane().setBackground(Color.lightGray);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		// initialize the menu bar	- TODO
		// 		holds the buttons of the tool bar
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, frame.getWidth(), 25);			// set size
		menuBar.setVisible(true);
		file = new JMenu("File");								// add a menu to bar
		file.setMnemonic(KeyEvent.VK_F);
		exit = new JMenuItem("Exit");							// add exit to the menu
		exit.setMnemonic(KeyEvent.VK_E);
		exit.setToolTipText("Exit application");
		exit.addActionListener(new ActionListener() {			// set exit's action listener
			public void actionPerformed(ActionEvent event) {
				System.out.println("exiting...");
				System.exit(0);
			}
		});		
		newGame = new JMenuItem("New Game");					// add new game to the menu
		newGame.setMnemonic(KeyEvent.VK_N);
		newGame.setToolTipText("Start a new game");
		newGame.addActionListener(new ActionListener() {		// set new game's action listener
			public void actionPerformed(ActionEvent event) {
				System.out.println("starting a new game...");
			}
		});
		file.add(newGame);
		file.addSeparator();
		file.add(exit);
		menuBar.add(file);	
		
		game = new JMenu("Game");
		game.setMnemonic(KeyEvent.VK_G);
		start = new JMenuItem("Start");
		start.setMnemonic(KeyEvent.VK_S);
		start.addActionListener(new ActionListener() {			// set exit's action listener
			public void actionPerformed(ActionEvent event) {
				System.out.println("*whistle*!!!");
				Referee.toggleTime();
			}
		});		
		game.add(start);
		game.addSeparator();
		d2 = new JRadioButtonMenuItem("2-D");
		d2.setSelected(true);
		d2.setMnemonic(KeyEvent.VK_2);
		d2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Simplistic Mode");
				Driver.simple = true;
			}
		});
		game.add(d2);
		d3 = new JRadioButtonMenuItem("3-D");
		d3.setSelected(false);
		d3.setMnemonic(KeyEvent.VK_3);
		d3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Realistic Mode");
				Driver.simple = false;
			}
		});
		game.add(d3);
		radio_group = new ButtonGroup();
		radio_group.add(d2);
		radio_group.add(d3);
		menuBar.add(game);
		
		developer = new JMenu("Dev");
		developer.setMnemonic(KeyEvent.VK_D);
		debug = new JRadioButtonMenuItem("Debug");
		debug.setMnemonic(KeyEvent.VK_D);
		debug.addActionListener(new ActionListener() {			// set exit's action listener
			public void actionPerformed(ActionEvent event) {
				if(Driver.debug)
					Driver.debug = false;
				else
					Driver.debug = true;
			}
		});	
		developer.add(debug);
		menuBar.add(developer);
		
		frame.setJMenuBar(menuBar);								// add menu bar to frame

		
		// initialize JLabel status bar
		status = new JLabel();
		status.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED));
		status.setText("Turn: White");
		//frame.add(status);

		// initialize JPanel field
		field = new DrawingPanel();
		field.setSize(new Dimension(375,500));
		field.setPreferredSize(new Dimension(375,500));
		frame.getContentPane().add(field);
		
		// initialize JPanel stats frame
		stats = new JPanel();
		scoreBoard = new JPanel();
		scoreBoard.setSize(250, 75);
		scoreBoard.setPreferredSize(new Dimension(250,75));
		scoreBoard.setLayout(new BoxLayout(scoreBoard, BoxLayout.X_AXIS));
		
		score1 = new JLabel("0");
		score2 = new JLabel("0");
		time = new JLabel("00:00");
		consoleView = new JTextArea("Hello!");
		consoleView.setPreferredSize(new Dimension(150,200));
		consoleView.setEditable(false);
		
		console = new JScrollPane(consoleView);
		console.setSize(150, 200);
		console.setPreferredSize(new Dimension(150,200) );
		
		stats.setSize(375,550);
		stats.setPreferredSize(new Dimension(375,550));
		stats.setBackground(Color.LIGHT_GRAY);
		stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
		
		scoreBoard.add(score1);
		scoreBoard.add(Box.createRigidArea(new Dimension(20,0)));
		scoreBoard.add(time);
		scoreBoard.add(Box.createRigidArea(new Dimension(20,0)));
		scoreBoard.add(score2);
		
		stats.add(scoreBoard, CENTER_ALIGNMENT);
		stats.add(Box.createRigidArea(new Dimension(0,10)));
		stats.add(console);
		stats.add(Box.createRigidArea(new Dimension(0,40)));
		
		frame.getContentPane().add(Box.createRigidArea(new Dimension(50,0)));
		frame.getContentPane().add(stats);		
		frame.pack();
		frame.setVisible(true);	
	}
	
	/**
	 * 
	 * @return
	 */
	public static GUI getGUI() {
		if(instance == null)
			instance = new GUI();
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public static JFrame getFrame() {
		return frame;
	}
	
	/**
	 * 
	 * @param t
	 */
	public void setClock(String t) {
		time.setText(t);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getClock() {
		return time.getText();
	}
	
	public static void setText(String s) {
		consoleView.setText(s);
	}
	
	public static String getText() {
		return consoleView.getText();
	}
}
