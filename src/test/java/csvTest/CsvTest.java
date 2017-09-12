package csvTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import util.CsvHandler;

public class CsvTest {

	@Test
	public void test1() {
		ArrayList<String[]> list = CsvHandler.readCSV("C://Users//Administrator//Desktop//��ַӳ����.csv");
		for(String[] a:list){
			System.out.println(a[1]+"--------------"+a[2]+a[3]+a[4]);
		}
	}

	@Test
	public void test2() {
		ArrayList<String[]> list = CsvHandler.readCSV("C://Users//Administrator//Desktop//��ַӳ����.csv");
		CsvHandler.writeCsv(list, "C://Users//Administrator//Desktop//���ƺõ��ļ�Ӵ.csv");
	}
}
