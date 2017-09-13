package service;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import util.BaiduMap;
import util.CsvHandler;

public class Demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String[]> list = CsvHandler.readCSV("C://Users//Administrator//Desktop//待处理//地址映射.csv");
		ArrayList<String[]> row = new ArrayList<String[]>();

		for (String[] a : list) {
			File file = new File("C:\\Users\\Administrator\\Desktop\\待处理\\替换完成的csv\\" + a[0] + ".csv");
			if (file.exists()) {
				System.out.println(file.getPath()+"-----------存在");
				continue;
			} else {
				row.clear();
				System.out.println(a[4]);
				Map<String, Double> inf = BaiduMap.getLngAndLat(a[2]);
				Map<String, String> detailedMap = BaiduMap.getProvinceAndCity(inf.get("lng"), inf.get("lat"));
				a[5] = detailedMap.get("province");
				a[6] = detailedMap.get("city");
				a[7] = inf.get("lng").toString();
				a[8] = inf.get("lat").toString();
				a[9] = a[5] + a[6] + a[2];
				row.add(a);
				CsvHandler.writeCsv(row, "C://Users//Administrator//Desktop//待处理//替换完成的csv//" + a[0] + ".csv");
			}

		}

		// CsvHandler.writeCsv(list,
		// "C://Users//Administrator//Desktop//待处理//替换完成的csv//重灾区1.csv");

	}

}
