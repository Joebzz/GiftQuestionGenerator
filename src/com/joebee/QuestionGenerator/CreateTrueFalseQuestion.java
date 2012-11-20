package com.joebee.QuestionGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTrueFalseQuestion {
	String giftString;
	File giftFile;
	public CreateTrueFalseQuestion (File giftFileMain, String qTitle, String qText, String qAnswer) {
		try {
			giftFile = giftFileMain;
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(giftFile, true));
			giftString = String.format("::%s:: %s {%s}%n", qTitle, qText, qAnswer);
			bufWrite.write(giftString);
			bufWrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
