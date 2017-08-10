package crazy.clone.deepClone;

public class Address implements Cloneable {
	
	private String state;
	private String province;
	private String city;

	public Address() {}
	
	public Address(String state, String province, String city) {
		this.state = state;
		this.province = province;
		this.city = city;
	}
	
/** getter and setter method start **/	
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
/** getter and setter method end **/	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("State: " + state + ", ")
				.append("Province: " + province + ", ")
				.append("City: " + city + ".");
		
		return builder.toString();
	}
	
	/**
	 * 深克隆的话，其作为另一个对象的引用对象，要重写clone方法。
	 */
	@Override
	protected Object clone() {
		Object obj = null;
		
		try {
			obj =  super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
}
