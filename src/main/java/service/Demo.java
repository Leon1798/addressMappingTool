package service;

import java.util.ArrayList;
import java.util.Map;

import util.BaiduMap;
import util.CsvHandler;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String[]> list = CsvHandler.readCSV("C://Users//Administrator//Desktop//待处理//csv文件//重灾区1.csv");
		for(String[] a:list){
			System.out.println(a[4]);
			Map<String, Double> inf = BaiduMap.getLngAndLat(a[4]);
			Map<String, String> detailedMap = BaiduMap.getProvinceAndCity(inf.get("lng"), inf.get("lat"));
			a[5] = detailedMap.get("province");
			a[6] = detailedMap.get("city");
			a[7] = inf.get("lng").toString();
			a[8] = inf.get("lat").toString();
			a[9] = a[5]+a[6]+a[2];
		}
		
		CsvHandler.writeCsv(list, "C://Users//Administrator//Desktop//待处理//替换完成的csv//重灾区1.csv");
		
	}

}
