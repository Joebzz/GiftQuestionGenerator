package com.joebee.QuestionGenerator;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParsePosition;

public class MainGui extends JFrame {

	private int questionNumber = 0;
	private JPanel contentPane;
	private JTextArea option1TextField;
	private JTextArea option2TextField;
	private JTextArea option3TextField;
	private JTextArea option4TextField;
	public JPanel questionInfoPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow]"));
		setContentPane(contentPane);
		
		JLabel lblQuestionNo = new JLabel("No.");
		contentPane.add(lblQuestionNo);
		
		JLabel lblQuestionName = new JLabel("Name");
		contentPane.add(lblQuestionName);
		
		JLabel lblQuestionOptions = new JLabel("Options");
		contentPane.add(lblQuestionOptions, "span 2, wrap");
		
		questionInfoPanel = new JPanel();
		questionInfoPanel.setLayout(new MigLayout("", "[][]"));
		contentPane.add(questionInfoPanel, "span 2 4,grow");
		
		JLabel lblOption = new JLabel("Option 1");
		contentPane.add(lblOption, "flowx");
		
		JLabel lblOption_1 = new JLabel("Option 2");
		contentPane.add(lblOption_1, "wrap");
		
		option1TextField = new JTextArea(2, 10);
		option1TextField.setLineWrap(true);
		contentPane.add(option1TextField);
		
		option2TextField = new JTextArea(2, 10);
		option2TextField.setLineWrap(true);
		contentPane.add(option2TextField, "wrap");
		
		JLabel lblOption_2 = new JLabel("Option 3");
		contentPane.add(lblOption_2, "");
		
		JLabel lblOption_3 = new JLabel("Option 4");
		contentPane.add(lblOption_3, "wrap");
		
		option3TextField = new JTextArea(2, 10);
		option3TextField.setLineWrap(true);
		contentPane.add(option3TextField);
		
		option4TextField = new JTextArea(2, 10);
		option4TextField.setLineWrap(true);
		contentPane.add(option4TextField, "wrap");
		
		JLabel optionsAmmount = new JLabel("No. Of Options");
		contentPane.add(optionsAmmount);
				
		String[] optionsString = {"0", "1", "2", "3", "4"};
		JComboBox comboBox = new JComboBox(optionsString);
		contentPane.add(comboBox, "wrap");
		
		JLabel questionNumberLabel = new JLabel(""+questionNumber);
		questionInfoPanel.add(questionNumberLabel);
		
		JButton button = new JButton("Add Question");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questionNumber++;
				System.out.println(questionNumber);
				//updateQuestionInfo(""+questionNumber);
			}
		});
		
		contentPane.add(button, "span");
		
		JButton submitButton = new JButton("Submit Questions");
		contentPane.add(submitButton, "wrap, cell 3 5, span" );
	}
	
	public void updateQuestionInfo(String questionNumber){
		System.out.println(""+questionNumber);
		JLabel questionNumberLabel = new JLabel(questionNumber);
		questionInfoPanel.add(questionNumberLabel);
	}

}
