package com.joebee.QuestionGenerator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

/**
 * @author Snooop This program is free software: you can redistribute it and/or
 *         modify it under the terms of the GNU General Public License as
 *         published by the Free Software Foundation, either version 3 of the
 *         License, or (at your option) any later version.
 * 
 *         This program is distributed in the hope that it will be useful, but
 *         WITHOUT ANY WARRANTY; without even the implied warranty of
 *         MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *         General Public License for more details.
 * 
 *         You should have received a copy of the GNU General Public License
 *         along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

public class TabbedPane extends JPanel {
	String giftString;
	static String gFileString = "C:/giftFile.txt";
	static File gFile = new File(gFileString);
	static GiftFile giftFile;

	static String logfile = "Gift Project Logfile";
	static Logger logger = Logger.getLogger(logfile);

	public TabbedPane() {
		JTabbedPane jtbExample = new JTabbedPane();

		JPanel jplInnerTrueFalsePanel = createTrueFalseInnerPanel();
		jtbExample.addTab("True/False Question", jplInnerTrueFalsePanel);
		jtbExample.setSelectedIndex(0);

		JPanel jplInnerMultipleChoicePanel = createMutipleChoicePanel();
		jtbExample.addTab("Multiple Choice Question",
				jplInnerMultipleChoicePanel);

		JPanel jplInnerMatchingPanel = createMatchingPanel();
		jtbExample.addTab("Matching Question", jplInnerMatchingPanel);

		JPanel jplInnerShortPanel = createShortPanel();
		jtbExample.addTab("Short Question", jplInnerShortPanel);

		// Add the tabbed pane to this panel.
		setLayout(new GridLayout(1, 1));
		add(jtbExample);
	}

	private JPanel createShortPanel() {
		ShortQuestion sQuestion = new ShortQuestion(giftFile);
		return sQuestion.getPanel();
	}

	protected JPanel createTrueFalseInnerPanel() {
		TrueFalseQuestion tfQuestion = new TrueFalseQuestion(giftFile);
		return tfQuestion.getPanel();
	}

	protected JPanel createMutipleChoicePanel() {
		MultipleChoiceQuestion mcQuestion = new MultipleChoiceQuestion(giftFile);
		return mcQuestion.getPanel();
	}

	protected JPanel createMatchingPanel() {
		MatchingQuestion mQuestion = new MatchingQuestion(giftFile);
		return mQuestion.getPanel();
	}

	public static void main(String[] args) {
		FileHandler hand;
		try {
			hand = new FileHandler("gift_generator_log.log");
			hand.setFormatter(new SimpleFormatter());
			logger.addHandler(hand);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
			logger.severe("Exception : Logger cannot be created.");
		}
		logger.info("Logging Started");
		final JFrame frame = new JFrame("Gift Question Generator");
		giftFile = new GiftFile(gFile);
		// giftFile = new GiftFile(gFile);
		/*
		 * JMenuBar menuBar; JMenu menu; JMenuItem menuItem;
		 * 
		 * menuBar = new JMenuBar();
		 * 
		 * // Build the first menu. menu = new JMenu("File");
		 * 
		 * menuBar.add(menu); // a group of JMenuItems menuItem = new
		 * JMenuItem("New Gift File", KeyEvent.VK_T);
		 * menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
		 * ActionEvent.ALT_MASK));
		 * menuItem.getAccessibleContext().setAccessibleDescription(
		 * "Select A Gift File to save to"); menuItem.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent arg0) {
		 * JFileChooser jfc = new JFileChooser(gFile); int returnVal =
		 * jfc.showOpenDialog(frame); if (jfc.getSelectedFile() != null) { gFile
		 * = new File(jfc.getSelectedFile().getAbsoluteFile().toString());
		 * logger.info("You chose to open this file: " +
		 * jfc.getSelectedFile().getAbsoluteFile().toString()); giftFile = new
		 * GiftFile(gFile); } } }); menu.add(menuItem);
		 */

		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.getContentPane().add(new TabbedPane(), BorderLayout.CENTER);
		frame.setSize(500, 400);
		// frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}
}
