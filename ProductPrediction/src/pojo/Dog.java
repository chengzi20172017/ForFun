package pojo;

import java.util.ArrayList;

public class Dog implements Comparable<Dog> {
	// 日期
	private String date = "";
	// 开奖结果
	private String lottery = "";
	// 正
	private String zheng = "";
	// 反
	private String fan = "";
	// 分数
	private int score = 0;
	// 预测结果
	private String preresult="还没预测";
	// 属于那些252种情况
	ArrayList<String> belogto = new ArrayList<String>();
	//持续次数
	private String ci ="0";

	public Dog() {
		super();
	}

	public String getLottery() {
		return lottery;
	}

	public void setLottery(String lottery) {
		this.lottery = lottery;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getZheng() {
		return zheng;
	}

	public void setZheng(String zheng) {
		this.zheng = zheng;
		setFan(zheng);
	}

	public String getFan() {
		return fan;
	}
    
	
	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	private void setFan(String zheng) {
		String[] arr = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		ArrayList<String> strArray = new ArrayList<String>();
		strArray.add("0");
		strArray.add("1");
		strArray.add("2");
		strArray.add("3");
		strArray.add("4");
		strArray.add("5");
		strArray.add("6");
		strArray.add("7");
		strArray.add("8");
		strArray.add("9");
		strArray.remove(zheng.charAt(0) + "");
		strArray.remove(zheng.charAt(1) + "");
		strArray.remove(zheng.charAt(2) + "");
		strArray.remove(zheng.charAt(3) + "");
		strArray.remove(zheng.charAt(4) + "");
		for (String str : strArray) {
			fan = fan + str;
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPreresult() {
		return preresult;
	}

	public void setPreresult(Boolean preresult) {
		String str="";
		if(preresult){
			str="正确";
		}else if(!preresult){
			str="错误";
		}else{
			str="还没预测";
		}
		this.preresult = str;
	}

	public ArrayList<String> getBelogto() {
		return belogto;
	}

	public void setBelogto(ArrayList<String> belogto) {
		this.belogto = belogto;
	}

	@Override
	public int compareTo(Dog o) {
		int i = this.getScore() - o.getScore();
		return -i;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{日期:"+date+"}"+
		       "{开奖结果:"+lottery+"}"+
//		       "{持续次数:"+ci+"}"+
		       "{正:"+zheng+"}"+
		       "{反:"+fan+"}"+
		       "{分数:"+score+"}"+
		       "{预测结果:"+preresult+"}"+
//		       "{属于那些252种情况:"+belogto.toString()+"}"+
				"";
	}
}
