package fileNameTest;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import util.FileUtil;

public class FileNameTest {
	@Test
	public void test1() {
		String[] fileName = FileUtil.getFileName("C:\\Users\\Administrator\\Desktop\\待处理\\替换完成的csv\\重灾区");
		for (String name : fileName) {
			System.out.println(name);
		}
		System.out.println("--------------------------------");
		ArrayList<String> listFileName = new ArrayList<String>();
		FileUtil.getAllFileName("C:\\Users\\Administrator\\Desktop\\待处理\\替换完成的csv\\重灾区", listFileName);
		for (String name : listFileName) {
			System.out.println(name);
		}
	}
	
	@Test
	public void test2(){
		File file =new File("C:\\Users\\Administrator\\Desktop\\待处理\\替换完成的csv\\重灾区\\31095.csv");
		System.out.println(file.getName()+"---------"+file.getPath());
		if(!file.exists()){
			System.out.println(file.getName()+"存在");
		}
	}
}
