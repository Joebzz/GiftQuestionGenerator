package com.joebee.QuestionGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ShortQuestion {
	protected int qCount = 0;
	private final JPanel jp;

	// private final int TEXT_FIELD_WIDTH = 5;
	public ShortQuestion(final GiftFile giftFile) {
		jp = new JPanel(new MigLayout("", "[right][][]", ""));

		JLabel jlQTitle = new JLabel("Question Title (Optional):");
		final JTextField jtQuestionTitle = new JTextField("Title", 20);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap, split 2, span 2");

		JLabel jlQuestion = new JLabel("Question:");
		final JTextArea jtQuestion = new JTextArea("Question Text", 5, 20);
		jp.add(jlQuestion);
		jp.add(jtQuestion, "wrap, split 2, span 2");

		JButton jbAddAnswer = new JButton("Add Answer");
		jp.add(jbAddAnswer, "grow");

		// final ArrayList<JTextField> jtQuestions = new
		// ArrayList<JTextField>();
		final ArrayList<JTextField> jtAnswers = new ArrayList<JTextField>();

		jtAnswers.add(qCount, new JTextField());
		jp.add(jtAnswers.get(qCount), "cell 1 " + (2 + qCount)
				+ ", grow, split, span");
		jp.add(new JLabel("" + (qCount + 1)), "wrap");

		jbAddAnswer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				qCount++;

				jtAnswers.add(qCount, new JTextField());
				jp.add(jtAnswers.get(qCount), "cell 1 " + (qCount+2)
						+ " , grow, split, span");

				jp.add(new JLabel("" + (qCount + 1)), "wrap");
				jp.updateUI();
			}
		});
		JButton jbSaveQuestion = new JButton("Save Question");
		jp.add(jbSaveQuestion, "cell 0 3, grow");

		jbSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				giftFile.createShortQuestion(jtQuestionTitle.getText(),
						jtQuestion.getText(), jtAnswers, qCount);
			}
		});
	}

	public JPanel getPanel() {
		return jp;
	}
}
