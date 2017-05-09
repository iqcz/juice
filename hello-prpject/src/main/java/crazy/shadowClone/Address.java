package crazy.shadowClone;

public class Address {
	private String state;

	private String province;

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

	private String city;

	public Address() {
	}
	
	public Address(String state, String province, String city) {
		this.state = state;
		this.province = province;
		this.city = city;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("State: " + state + ", ")
				.append("Province: " + province + ", ")
				.append("City: " + city + ".");
		
		return builder.toString();
	}
}
