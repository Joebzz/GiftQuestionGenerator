package com.joebee.QuestionGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * @author Joebee Dawson - This program is free software: you can redistribute
 *         it and/or modify it under the terms of the GNU General Public License
 *         as published by the Free Software Foundation, either version 3 of the
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
public class GiftFile {
	File giftFile;

	public GiftFile(File giftFileMain) {
		giftFile = giftFileMain;
	}

	public void createTrueFalseQuestion(String qTitle, String qText,
			String qAnswer) {
		TabbedPane.logger.info("Creating True/False Question : ");
		String giftString;
		try {
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(
					giftFile, true));
			giftString = String
					.format("::%s:: %s {%s}", qTitle, qText, qAnswer);
			bufWrite.write(giftString);
			TabbedPane.logger.info("True/False Gift String : " + giftString);
			bufWrite.newLine();
			bufWrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createMultipleChoiceQuestion(String qTitle, String qText,
			ArrayList<JTextField> jtAnswers, ArrayList<JSpinner> jsAnswers,
			int numAnswers) {
		try {
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(
					giftFile, true));
			StringBuilder giftString = new StringBuilder();
			giftString.append("::" + qTitle + "::" + qText + " {");
			for (int i = 0; i <= numAnswers; i++) {
				giftString.append("~%" + jsAnswers.get(i).getValue().toString()
						+ "%" + jtAnswers.get(i).getText());
			}
			giftString.append("}");
			bufWrite.write(giftString.toString());
			TabbedPane.logger
					.info("MCQ Gift String : " + giftString.toString());
			bufWrite.newLine();
			bufWrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createMatchingQuestion(String qTitle, String qText,
			ArrayList<JTextField> jtQuestions, ArrayList<JTextField> jtAnswers,
			int qCount) {
		try {
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(
					giftFile, true));
			StringBuilder giftString = new StringBuilder();
			giftString.append("::" + qTitle + "::" + qText + " {");
			for (int i = 0; i <= qCount; i++) {
				giftString.append(" =" + jtQuestions.get(i).getText() + " -> "
						+ jtAnswers.get(i).getText());
			}
			giftString.append("}");
			bufWrite.write(giftString.toString());
			TabbedPane.logger.info("Matching Gift String : "
					+ giftString.toString());
			bufWrite.newLine();
			bufWrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void createShortQuestion(String qTitle, String qText,
			ArrayList<JTextField> jtAnswers, int qCount) {
		try {
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(
					giftFile, true));
			StringBuilder giftString = new StringBuilder();
			giftString.append("::" + qTitle + "::" + qText + " {");
			for (int i = 0; i <= qCount; i++) {
				giftString.append(" =" + jtAnswers.get(i).getText());
			}
			giftString.append("}");
			bufWrite.write(giftString.toString());
			TabbedPane.logger.info("Short Gift String : "
					+ giftString.toString());
			bufWrite.newLine();
			bufWrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void createEssayQuestion(String qTitle, String qText, int qCount) {
		try {
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(
					giftFile, true));
			StringBuilder giftString = new StringBuilder();
			giftString.append("::" + qTitle + "::" + qText + " {}");
			bufWrite.write(giftString.toString());
			TabbedPane.logger.info("Essay Gift String : "
					+ giftString.toString());
			bufWrite.newLine();
			bufWrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
