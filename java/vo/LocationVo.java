package vo;

public class LocationVo {

	String region_1depth_name;
	String region_2depth_name;
	
	double latitude; //����(y)
	double longitude;//�浵(x)
	
	
	public String getRegion_1depth_name() {
		return region_1depth_name;
	}
	public void setRegion_1depth_name(String region_1depth_name) {
		this.region_1depth_name = region_1depth_name;
	}
	public String getRegion_2depth_name() {
		return region_2depth_name;
	}
	public void setRegion_2depth_name(String region_2depth_name) {
		this.region_2depth_name = region_2depth_name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	

}
