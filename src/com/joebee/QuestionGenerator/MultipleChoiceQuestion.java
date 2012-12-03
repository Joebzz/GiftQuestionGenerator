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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class MultipleChoiceQuestion {
	protected int qCount = 0;
	private final JPanel jp;
	public MultipleChoiceQuestion(final GiftFile giftFile){
		jp = new JPanel(new MigLayout("", "[align right][]", ""));

		JLabel jlQTitle = new JLabel("Question Title (Optional):");
		final JTextArea jtQuestionTitle = new JTextArea("Title", 1, 20);
		jp.add(jlQTitle);
		jp.add(jtQuestionTitle, "wrap");

		JLabel jlQuestion = new JLabel("Question:");
		final JTextArea jtQuestion = new JTextArea("Question Text", 20, 20);
		jp.add(jlQuestion);
		jp.add(jtQuestion, "wrap");

		JButton jbAddAnswer = new JButton("Add Answer");
		jp.add(jbAddAnswer);
		
		final ArrayList<JTextField> jtAnswers = new ArrayList<JTextField>();
		jtAnswers.add(0, new JTextField());
		jp.add(jtAnswers.get(qCount), "grow");
		
		
		final ArrayList<JSpinner> jsAnswers = new ArrayList<JSpinner>();
		jsAnswers.add(0, new JSpinner(new SpinnerNumberModel(0, 0, 100, 1)));
		jp.add(jsAnswers.get(qCount), "wrap");
		qCount++;
		
		jtAnswers.add(1, new JTextField());
		jp.add(jtAnswers.get(qCount), "cell 1 3, grow");
		
		jsAnswers.add(1, new JSpinner(new SpinnerNumberModel(0, 0, 100, 1)));
		jp.add(jsAnswers.get(qCount), "wrap");
		
		jbAddAnswer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				qCount ++;
				
				jtAnswers.add(qCount, new JTextField());
				jp.add(jtAnswers.get(qCount), "cell 1 " + 3 + qCount +" , grow");
				
				jsAnswers.add(qCount, new JSpinner(new SpinnerNumberModel(0, 0, 100, 1)));
				jp.add(jsAnswers.get(qCount), "wrap");
				jp.updateUI();
			}
		});
		JButton jbSaveQuestion = new JButton("Save Question");
		jp.add(jbSaveQuestion,"cell 0 3");
		
		jbSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				giftFile.createMultipleChoiceQuestion(jtQuestionTitle.getText(), jtQuestion.getText(), jtAnswers, jsAnswers, qCount);
			}
		});
	}
	public JPanel getPanel(){
		return jp;
	}
}
