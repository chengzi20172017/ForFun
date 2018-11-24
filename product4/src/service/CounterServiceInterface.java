package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import pojo.Dog;

public interface CounterServiceInterface {
	
	
	public Dog Prediction(ArrayList<Dog> inlis) throws Exception;

	
	 public ArrayList<Dog> inData(String file)throws Exception;

	public ArrayList<Dog> historyPrediction(String filepath) throws Exception;



}
