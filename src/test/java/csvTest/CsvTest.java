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
			System.out.println(a);
		}
	}

}
