package edu.taihu.logistics.tool;

public class MathTool {
	public static final double EARTH_RADIUS = 6378.137;
	public static double distance(String startCoo,String endCoo) {
		String[] starts=startCoo.split(",");
		String[] ends=endCoo.split(",");
		Double lng1=Double.parseDouble(starts[0]);
		Double lat1=Double.parseDouble(starts[1]);
		Double lng2=Double.parseDouble(ends[0]);
		Double lat2=Double.parseDouble(ends[1]);
		double distance = GetDistance(lat1, lng1, lat2, lng2);
		return distance;
	}
	private static double rad(double d)
	{
	   return d * Math.PI / 180.0;
	}
	public static double GetDistance(double lat1, double lng1, double lat2, double lng2)
	{
	   double radLat1 = rad(lat1);
	   double radLat2 = rad(lat2);
	   double a = radLat1 - radLat2;
	   double b = rad(lng1) - rad(lng2);
	   double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
	    Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
	   s = s * EARTH_RADIUS;
	   s = Math.round(s * 10000) / 10000;
	   return s;
	}
	public static void main(String[] args) {
		//测试：北京到上海的距离
		double distance=distance("116.413384,39.910925", "121.480539,31.235929");
		System.out.println("北京到上海的距离为："+distance);
	}
}
