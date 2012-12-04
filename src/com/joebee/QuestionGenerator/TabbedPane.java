package com.joebee.QuestionGenerator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

/**
 * @author Snooop
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class TabbedPane extends JPanel {
	String giftString;
	static File gFile =  new File("C:/JEW/Dropbox/Software Engineering/QuestionsGenerator/giftFile.txt");
	static GiftFile giftFile;
	
	public TabbedPane() {
		JTabbedPane jtbExample = new JTabbedPane();
		JPanel jplInnerTrueFalsePanel = createTrueFalseInnerPanel();
		jtbExample.addTab("True/False Question", jplInnerTrueFalsePanel);
		jtbExample.setSelectedIndex(0);
		JPanel jplInnerMultipleChoicePanel = createMutipleChoicePanel();
		jtbExample.addTab("Multiple Choice Question", jplInnerMultipleChoicePanel);
		
		JPanel jplInnerMatchingPanel = createMatchingPanel();
		jtbExample.addTab("Matching Question", jplInnerMatchingPanel);
		
		// Add the tabbed pane to this panel.
		setLayout(new GridLayout(1, 1));
		add(jtbExample);
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
		JFrame frame = new JFrame("Gift Question Generator");
		giftFile = new GiftFile(gFile);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(new TabbedPane(), BorderLayout.CENTER);
		frame.setSize(500, 400);
		frame.setVisible(true);
	}
}
