package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import pojo.Dog;

public class IoUtil {

	public static ArrayList<String> readFile(String path) throws IOException {
		ArrayList<String> inlist = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String s = null;
		while ((s = br.readLine()) != null) {

			inlist.add(s);
		}
		br.close();
		return inlist;
	}



	public static void writeResult(ArrayList<Dog> resultout, String proutdata) throws Exception {
		BufferedWriter prbw = new BufferedWriter(new FileWriter(proutdata));
		for (int i=0;i<resultout.size();i++) {
			prbw.write(resultout.get(i).toString());
			prbw.newLine();

   		System.out.println(resultout.get(i).toString());

		}
		prbw.flush();
		prbw.close();
		System.out.println("完成");
		System.out.println("=============================");
	}

}
