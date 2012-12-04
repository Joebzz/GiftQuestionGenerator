package com.joebee.QuestionGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

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

public class MatchingQuestion {
	protected int qCount = 0;
	private final JPanel jp;
	//private final int TEXT_FIELD_WIDTH = 5;
	public MatchingQuestion(final GiftFile giftFile){
		jp = new JPanel(new MigLayout("", "[right][][]", ""));

		JLabel jlQTitle = new JLabel("Question Title (Optional):");
		final JTextField jtQuestionTitle = new JTextField("Title", 20);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap, split 2, span 2");

		JLabel jlQuestion = new JLabel("Question:");
		final JTextArea jtQuestion = new JTextArea("Question Text", 5, 20);
		jp.add(jlQuestion);
		jp.add(jtQuestion, "wrap, split 2, span 2");

		JButton jbAddAnswer = new JButton("Add Pair");
		jp.add(jbAddAnswer, "grow");
		
		final ArrayList<JTextField> jtQuestions = new ArrayList<JTextField>();
		final ArrayList<JTextField> jtAnswers = new ArrayList<JTextField>();
		
		jtQuestions.add(qCount, new JTextField());
		jp.add(jtQuestions.get(qCount), "cell 1 "+(2+qCount)+" , grow, split, span");
		
		jtAnswers.add(qCount, new JTextField());
		jp.add(jtAnswers.get(qCount), "cell 2 " +(2+qCount)+", grow, split, span, wrap");
		
		qCount++;
		
		jtQuestions.add(qCount, new JTextField());
		jp.add(jtQuestions.get(qCount), "cell 1 "+(2+qCount)+" , grow, split, span");
		
		jtAnswers.add(qCount, new JTextField());
		jp.add(jtAnswers.get(qCount), "cell 2 " +(2+qCount)+", grow, split, span, wrap");
	
		jbAddAnswer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				qCount ++;
				
				jtAnswers.add(qCount, new JTextField());
				jp.add(jtAnswers.get(qCount), "cell 1 " +2+qCount+" , grow, split, span");
				
				jtQuestions.add(qCount, new JTextField());
				jp.add(jtQuestions.get(qCount), "cell 2 " +2+qCount+", grow, split, span, wrap");
				jp.updateUI();
			}
		});
		JButton jbSaveQuestion = new JButton("Save Question");
		jp.add(jbSaveQuestion,"cell 0 3, grow");
		
		jbSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				giftFile.createMatchingQuestion(jtQuestionTitle.getText(), jtQuestion.getText(), jtQuestions, jtAnswers, qCount);
			}
		});
	}
	public JPanel getPanel(){
		return jp;
	}
}
