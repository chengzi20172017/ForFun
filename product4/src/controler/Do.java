package controler;

import java.io.IOException;
import java.util.ArrayList;

import pojo.Dog;
import service.CounterService1;
import service.CounterService2;
import service.CounterService3;
import service.CounterService4;
import service.CounterService5;
import service.CounterServiceInterface;
import utils.IoUtil;

public class Do {

	public static void main(String[] args) throws Exception {
		String in ="indata.txt";
		String out1 ="outdata1.txt";
		String out2 ="outdata2.txt";
		String out3 ="outdata3.txt";
		String out4 ="outdata4.txt";
		String out5 ="outdata5.txt";
		CounterServiceInterface counterService1 = new CounterService1();
		CounterServiceInterface counterService2 = new CounterService2();
		CounterServiceInterface counterService3 = new CounterService3();
		CounterServiceInterface counterService4 = new CounterService4();
		CounterServiceInterface counterService5 = new CounterService5();
		predictionAll(counterService1,in,out1);
		predictionAll(counterService2,in,out2);
		predictionAll(counterService3,in,out3);
		predictionAll(counterService4,in,out4);
		predictionAll(counterService5,in,out5);
	}

	private static void predictionAll(CounterServiceInterface counterService,String in,String out) throws Exception, IOException {
		
		// 历史数据预测及结果查看
		ArrayList<Dog> historyPrediction = counterService.historyPrediction(in);
		// 下一期的预测
		ArrayList<Dog> inData = counterService.inData(in);
		Dog result = counterService.Prediction(inData);
		//把预测结果加上一起打印
		historyPrediction.add(result);
		// 打印每期预测结果
		IoUtil.writeResult(historyPrediction, out);
	}

}
