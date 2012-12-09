package com.joebee.QuestionGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * @author Joebee Dawson - This program is free software: you can redistribute it
 *         and/or modify it under the terms of the GNU General Public License as
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

public class EssayQuestion {
	protected int qCount = 0;
	private final JPanel jp;

	// private final int TEXT_FIELD_WIDTH = 5;
	public EssayQuestion(final GiftFile giftFile) {
		jp = new JPanel(new MigLayout("", "[right][][]", ""));

		JLabel jlQTitle = new JLabel("Question Title (Optional):");
		final JTextField jtQuestionTitle = new JTextField("Title", 40);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap, split 2, span 2");

		JLabel jlQuestion = new JLabel("Question:");
		final JTextArea jtQuestion = new JTextArea("Question Text", 5, 40);
		jtQuestion.setLineWrap(true);
		jp.add(jlQuestion);
		jp.add(jtQuestion, "wrap, split 2, span 2");

		final JTextArea jtAnswer = new JTextArea("Answer", 5, 40);
		jtAnswer.setLineWrap(true);
		jp.add(jlQuestion);
		jp.add(jtQuestion, "wrap, split 2, span 2");

		JButton jbSaveQuestion = new JButton("Save Question");
		jp.add(jbSaveQuestion, "cell 0 3, grow, wrap");

		jbSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				giftFile.createEssayQuestion(jtQuestionTitle.getText(),
						jtQuestion.getText(), qCount);
			}
		});

		JButton jbClear = new JButton("Clear");
		jbClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jtQuestionTitle.setText("");
				jtQuestion.setText("");
				jtAnswer.setText("");
				TabbedPane.logger
						.info("Removed All entries from Short Question, QCount : "
								+ qCount);
			}
		});
		jp.add(jbClear, "grow");
	}

	public JPanel getPanel() {
		return jp;
	}
}
