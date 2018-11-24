package service;

import java.beans.FeatureDescriptor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import dao.CombinationData;
import pojo.Dog;
import utils.IoUtil;

abstract class CounterService {

	public Dog Prediction(ArrayList<Dog> inlis) throws Exception, IOException {
		
		// 统计后的结果
		ArrayList<Dog> resdog = new ArrayList<Dog>();
		HashSet<String> set = new HashSet<>();
		Collections.reverse(inlis);
		int a = 0;
		for (int i = 0; i < inlis.size(); i++) {
			if (set.size() < 5) {
				String lottery = inlis.get(i).getLottery();
				set.add(lottery);
				a++;
			} else {
				String lottery = inlis.get(i).getLottery();
				if (set.contains(lottery)) {
					a++;
				} else {
					break;
				}
			}
		}
		String zheng = "";
		for (String str : set) {
			zheng = str + zheng;
		}
		Dog dog = new Dog();
		dog.setScore(a);
		dog.setLottery(inlis.get(0).getLottery());
		dog.setDate(inlis.get(0).getDate());
		dog.setZheng(zheng);
		return dog;

	}

	// 数据的输入
	abstract public ArrayList<Dog> inData(String file)throws Exception;

	public ArrayList<Dog> historyPrediction(String filepath) throws Exception {
		// 所有数据
		ArrayList<Dog> alllist = inData(filepath);
		// 要预测的数据
		ArrayList<Dog> inData = new ArrayList<Dog>();
		// 预测数据的结果
		ArrayList<Dog> resultout = new ArrayList<>();
		for (int i = 0; i < alllist.size() - 1; i++) {
			Collections.reverse(inData);
			inData.add(alllist.get(i));
			// 要求输入数据大于15个
			if (i > 15) {
				// 预测
				Dog result = Prediction(inData);
				String next = alllist.get(i + 1).getLottery();
				// 判断是否对错
				Boolean preresult = result.getFan().contains(next);
				result.setPreresult(preresult);
				resultout.add(result);
			}
		}
		return resultout;
	}

}
