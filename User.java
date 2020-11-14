class User implements java.io.Serializable {
	private static final long serialVersionUID = -6160264268204039045L;
	private String userName = null;
	private String wifiName = "";
	private String wifiPassword = "";
	private float desiredTemp = 0;
	private float sessionDuration = 0;
	private int ID;
	
	public User(){}
	public User(String name, int ID) {
		// 	ID constructor
		this.userName = name;
		this.ID = ID;
	}
	// Getters and Setters for all attributes 
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	public String getWifiName() {return wifiName;}
	public void setWifiName(String wifiName) {this.wifiName = wifiName;}
	public float getDesiredTemp() {return desiredTemp;}
	public void setDesiredTemp(float desiredTemp) {this.desiredTemp = desiredTemp;}
	public String getWifiPassword() {return wifiPassword;}
	public void setWifiPassword(String wifiPassword) {this.wifiPassword = wifiPassword;}
	public float getSessionDuration() {return sessionDuration;}
	public void setSessionDuration(float sessionDuration) {this.sessionDuration = sessionDuration;}
	public int getID() {return ID;}
	public void setID(int ID) {this.ID=ID;}
}
	

