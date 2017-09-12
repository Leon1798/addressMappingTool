package util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CsvHandler {
	public static ArrayList<String[]> readCSV(String FilePath) {  
	    try {  
	        // 用来保存数据  
	        ArrayList<String[]> csvFileList = new ArrayList<String[]>();  
	        // 定义一个CSV路径  
	        String csvFilePath = FilePath;  
	        // 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);  
	        CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("GBK"));  
	        // 跳过表头 如果需要表头的话，这句可以忽略  
	        reader.readHeaders();  
	        // 逐行读入除表头的数据  
	        while (reader.readRecord()) {  
	            System.out.println(reader.getRawRecord());   
	            csvFileList.add(reader.getValues());   
	        }  
	        reader.close();  
	          
	        // 遍历读取的CSV文件  
	        for (int row = 0; row < csvFileList.size(); row++) {  
	            // 取得第row行第0列的数据  
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
     * 写入CSV文件
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
