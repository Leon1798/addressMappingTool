package util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;

public class CsvHandler {
	public static ArrayList<String[]> readCSV(String FilePath) {  
	    try {  
	        // ������������  
	        ArrayList<String[]> csvFileList = new ArrayList<String[]>();  
	        // ����һ��CSV·��  
	        String csvFilePath = FilePath;  
	        // ����CSV������ ����:CsvReader(�ļ�·�����ָ����������ʽ);  
	        CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("GBK"));  
	        // ������ͷ �����Ҫ��ͷ�Ļ��������Ժ���  
	        reader.readHeaders();  
	        // ���ж������ͷ������  
	        while (reader.readRecord()) {  
	            System.out.println(reader.getRawRecord());   
	            csvFileList.add(reader.getValues());   
	        }  
	        reader.close();  
	          
	        // ������ȡ��CSV�ļ�  
	        for (int row = 0; row < csvFileList.size(); row++) {  
	            // ȡ�õ�row�е�0�е�����  
	            String cell = csvFileList.get(row)[0];  
	            System.out.println("------------>"+cell);  
	        }  
	        return csvFileList;
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }
		return null;  
	}  
}
