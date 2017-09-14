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
		Map<String, Double> inf = BaiduMap.getLngAndLat("广州花都区狮岭镇联合村新屋经济社东边三路8号");
		Map<String, String> detailedMap = BaiduMap.getProvinceAndCity(inf.get("lng"), inf.get("lat"));
		System.out.println(detailedMap);
	}
	@Test
	public void test3() {
		
		Map<String, String> detailedMap = BaiduMap.getProvinceAndCity(0.0, 0.0);
		System.out.println(detailedMap);
	}
}
