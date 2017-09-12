package util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

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
	
	 /**
     * д��CSV�ļ�
     */
    public static void writeCsv(ArrayList<String[]> contentList,String filePath){
        try {
            
            String csvFilePath = filePath;
             CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("GBK"));
             //String[] contents = {"aaaaa","bbbbb","cccccc","ddddddddd"};
             for(String[] content: contentList){
            	 wr.writeRecord(content);
             }
             
             wr.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
    }
}
