package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;  
/**
 * 获取经纬度
 *
 * @author jueyue 返回格式：Map<String,Object> map map.put("status",
 * reader.nextString());//状态 map.put("result", list);//查询结果
 * list<map<String,String>>
 * 密钥:C0a9eecc5b366bde41202sljdflsjfsldjf   需要自己去申请
 * Created by hellcat on 2016/7/27.
 */
public class BaiduMap {

    public static Map<String,Double> getLngAndLat(String address){
        Map<String,Double> map=new HashMap<String, Double>();
        String url = "http://api.map.baidu.com/geocoder/v2/?address="+address+"&output=json&ak=knZ7b01292zrupudYR1hxa7yd2SIUsb6";
        try {
            String json = loadJSON(url);
            JSONObject obj = JSONObject.fromObject(json);
            if(obj.get("status").toString().equals("0")){
                double lng=obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
                double lat=obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
                map.put("lng", getDecimal(lng));
                map.put("lat", getDecimal(lat));
                System.out.println("经度："+lng+"---纬度："+lat);
            }else{
                System.out.println("未找到相匹配的经纬度！");
            }
        }catch (Exception e){
            System.out.println("未找到相匹配的经纬度！");
        }
        return map;
    }

    public static Map<String,String> getProvinceAndCity(Double lng,Double lat){
        Map<String,String> map=new HashMap<String, String>();
        String latAndLng = ""+lat+","+lng;
        String url = "http://api.map.baidu.com/geocoder/v2/?ak=knZ7b01292zrupudYR1hxa7yd2SIUsb6&location="+latAndLng+"&output=json&pois=1";
        try {
            String json = loadJSON(url);
            JSONObject obj = JSONObject.fromObject(json);
            if(obj.get("status").toString().equals("0")){
            	String province = obj.getJSONObject("result").getJSONObject("addressComponent").getString("province");
            	String city = obj.getJSONObject("result").getJSONObject("addressComponent").getString("city");
            	String district = obj.getJSONObject("result").getJSONObject("addressComponent").getString("district");
            	String adcode = obj.getJSONObject("result").getJSONObject("addressComponent").getString("adcode");
            	String street = obj.getJSONObject("result").getJSONObject("addressComponent").getString("street");
            	map.put("lng", lng.toString());
            	map.put("lat", lng.toString());
            	map.put("province", province);
            	map.put("city", city);
            	map.put("district", district);
            	map.put("adcode", adcode);
            	map.put("street", street);
            	System.out.println(obj);
                System.out.println(province+city);
            }else{
                //LogUtil.debug("未找到相匹配的经纬度！");
                System.out.println("地址库里无此数据！");
                map.put("lng", lng.toString());
            	map.put("lat", lng.toString());
            	map.put("province", "错误");
            	map.put("city", "错误");
            	map.put("district", "错误");
            	map.put("adcode", "错误");
            	map.put("street", "错误");
            }
        }catch (Exception e){
            //LogUtil.error("未找到相匹配的经纬度，请检查地址");
            System.out.println("未找到相匹配的地址，请检查经纬度！");
        }
        return map;
    }
    
    
    
    public static double getDecimal(double num) {
        if (Double.isNaN(num)) {
            return 0;
        }
        BigDecimal bd = new BigDecimal(num);
        num = bd.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
        return num;
    }

    public static String loadJSON (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream(),"UTF-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }
}