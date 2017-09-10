package addressTest;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import util.BaiduMap;

public class LngAndLatTest {

	@Test
	public void test1() {
		Map<String, Double> inf = BaiduMap.getLngAndLat("上海东方康达家苑二期");
		BaiduMap.getProvinceAndCity(inf.get("lng"), inf.get("lat"));
	}
	
	@Test
	public void test2() {
		Map<String, Double> inf = BaiduMap.getLngAndLat("合肥市安徽合肥市瑶海区临泉路美晨雅阁东苑7幢310");
		Map<String, String> detailedMap = BaiduMap.getProvinceAndCity(inf.get("lng"), inf.get("lat"));
		System.out.println(detailedMap);
	}

}
