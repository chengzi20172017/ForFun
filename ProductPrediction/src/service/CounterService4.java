package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import pojo.Dog;

public class CounterService4 extends CounterService implements CounterServiceInterface{

	@Override
	public ArrayList<Dog> inData(String file) throws Exception {
		ArrayList<Dog> inlist = new ArrayList<Dog>();
		BufferedReader br;
		br = new BufferedReader(new FileReader(file));
		String s = null;
		while ((s = br.readLine()) != null) {
			if (!s.equals("")) {
				Dog dog = new Dog();
				String[] split = s.split("\\D");
				dog.setDate(split[1]);
				dog.setLottery(split[2].substring(1,2));
				inlist.add(dog);
			}
		}
		br.close();
		return inlist;
	}

}
