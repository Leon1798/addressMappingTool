package csvTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import util.CsvHandler;

public class CsvTest {

	@Test
	public void test1() {
		ArrayList<String[]> list = CsvHandler.readCSV("C://Users//Administrator//Desktop//地址映射简版.csv");
		for(String[] a:list){
			System.out.println(a[1]+"--------------"+a[2]+a[3]+a[4]);
		}
	}

	@Test
	public void test2() {
		ArrayList<String[]> list = CsvHandler.readCSV("C://Users//Administrator//Desktop//地址映射简版.csv");
		CsvHandler.writeCsv(list, "C://Users//Administrator//Desktop//复制好的文件哟.csv");
	}
}
