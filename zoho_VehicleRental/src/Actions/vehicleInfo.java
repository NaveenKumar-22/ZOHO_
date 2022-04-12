package Actions;
public class vehicleInfo {
	
	private String renter;
	private static String date;
	private int km=1000;
	private String name;
	private int num;
	public String type;
	public boolean available=true;
	private int dripDist=0;
	
	vehicleInfo(String name,int num,String type){
		this.name=name;
		this.num=num;
		this.type=type;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	
	
	public void setNum(int num) {
		this.num=num;
	}
	
	public int getNum() {
		return num;
	}
	
	
	
	public void setRenter(String ren) {
		renter=ren;
	}
	public String getRenter() {
		return renter;
	}
	
	
	
	public void setKm(int km) {
		this.km=km;
	}
	public int getKm() {
		return km;
	}
	
	
	public void setDrip(int drip) {
		dripDist=drip;
	}
	public int getDrip() {
		return dripDist;
	}
	
	
	
	public void setDate(String date) {
		this.date=date;
	}
	public String getDate() {
		return date;
	}
	
}
