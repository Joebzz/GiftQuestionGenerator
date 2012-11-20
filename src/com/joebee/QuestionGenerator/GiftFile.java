package com.joebee.QuestionGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
public class GiftFile {
	String giftString;
	File giftFile;
	public GiftFile (File giftFileMain) {
		giftFile = giftFileMain;
	}
	public void createTrueFalseQuestion (String qTitle, String qText, String qAnswer){
		try {
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
