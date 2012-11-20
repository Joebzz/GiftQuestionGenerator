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
		JPanel jplInnerPanel1 = createTrueFalseInnerPanel();
		jtbExample.addTab("True/False Question", jplInnerPanel1);
		jtbExample.setSelectedIndex(0);
		JPanel jplInnerPanel2 = createInnerPanel("Tab 2 Contains Icon only");
		jtbExample.addTab("Two", jplInnerPanel2);
		JPanel jplInnerPanel3 = createInnerPanel("Tab 3 Contains Tooltip and Icon");
		jtbExample.addTab("Three", jplInnerPanel3);
		JPanel jplInnerPanel4 = createInnerPanel("Tab 4 Contains Text only");
		jtbExample.addTab("Four", jplInnerPanel4);
		// Add the tabbed pane to this panel.
		setLayout(new GridLayout(1, 1));
		add(jtbExample);
	}

	protected JPanel createTrueFalseInnerPanel() {
		JPanel jp = new JPanel(new MigLayout("", "[align right][]", "[][][][]"));

		JLabel jlQTitle = new JLabel("Question Title (Optional):");
		final JTextArea jtQuestionTitle = new JTextArea("Title", 1, 20);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap");

		JLabel jlQuestion = new JLabel("Question:");
		final JTextArea jtQuestion = new JTextArea("Question Text", 20, 20);
		jp.add(jlQuestion);
		jp.add(jtQuestion, "wrap");

		JLabel jlCorrectAnswer = new JLabel("Correct Answer");
		final ButtonGroup btnGrp = new ButtonGroup();
		final JRadioButton jcTrue = new JRadioButton("True");
		final JRadioButton jcFalse = new JRadioButton("False");
		btnGrp.add(jcTrue);
		btnGrp.add(jcFalse);
		jp.add(jlCorrectAnswer, "wrap");
		jp.add(jcTrue);
		jp.add(jcFalse, "wrap");

		JButton jbSaveQuestion = new JButton("Save Question");
		jp.add(jbSaveQuestion);
		jbSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String qAnswer;
				if(jcTrue.isSelected())
					qAnswer = "T";
				else
					qAnswer = "F";
				giftFile.createTrueFalseQuestion(jtQuestionTitle.getText(), jtQuestion.getText(), qAnswer);
			}
		});
		return jp;
	}

	protected JPanel createInnerPanel(String text) {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
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
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
