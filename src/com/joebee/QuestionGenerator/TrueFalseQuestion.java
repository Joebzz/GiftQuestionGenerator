package com.joebee.QuestionGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

public class TrueFalseQuestion {
	private JPanel jp;
	public TrueFalseQuestion(final GiftFile giftFile){
		jp = new JPanel(new MigLayout("", "[align right][]", "[][][][]"));

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
	}
	public JPanel getPanel(){
		return jp;
	}
}
