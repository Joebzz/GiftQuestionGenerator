package com.joebee.QuestionGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

public class TrueFalseQuestion {
	
	private JPanel jp;
	public TrueFalseQuestion(final GiftFile giftFile){
		jp = new JPanel(new MigLayout("", "[align right][]", "[][][][]"));

		JLabel jlQTitle = new JLabel("Question Title (Optional):");
		final JTextField jtQuestionTitle = new JTextField("Title", 20);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap");

		JLabel jlQuestion = new JLabel("Question:");
		final JTextArea jtQuestion = new JTextArea("Question Text", 5, 20);
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
				TabbedPane.logger.info("TrueFalse Gift file is : " + giftFile.toString());
				giftFile.createTrueFalseQuestion(jtQuestionTitle.getText(), jtQuestion.getText(), qAnswer);
			}
		});
	}
	public JPanel getPanel(){
		return jp;
	}
}
