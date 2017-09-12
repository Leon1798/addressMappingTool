package addressTest;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import util.BaiduMap;

public class LngAndLatTest {

	@Test
	public void test1() {
		Map<String, Double> inf = BaiduMap.getLngAndLat("11");
		BaiduMap.getProvinceAndCity(inf.get("lng"), inf.get("lat"));
	}
	
	@Test
	public void test2() {
		Map<String, Double> inf = BaiduMap.getLngAndLat("合肥六安市舒城县城关镇广厦路凤池苑牡丹园2幢108室");
		Map<String, String> detailedMap = BaiduMap.getProvinceAndCity(inf.get("lng"), inf.get("lat"));
		System.out.println(detailedMap);
	}
	@Test
	public void test3() {
		
		Map<String, String> detailedMap = BaiduMap.getProvinceAndCity(0.0, 0.0);
		System.out.println(detailedMap);
	}
}
