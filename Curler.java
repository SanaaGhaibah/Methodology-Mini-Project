import java.util.Date;

public class Curler{
	

	private boolean isOn = false;
	private float currTemp = 0;
	private String ipAddress = "";
	private Date currDate = null;
	private Date eventDate = null;
	private String songName = "";
	private float desiredTemp = 0;
	private float time= 5; // default time in seconds. (if user does not set a duration)

	
	public float getDesiredTemp() {return desiredTemp;}
	public void setDesiredTemp(float desiredTemp) {this.desiredTemp = desiredTemp;}
	public float getCurrTemp() {return currTemp;}
	public void setCurrTemp(float currTemp) {this.currTemp = currTemp;}
	public boolean getIsOn() {return isOn;}
	public void setIsOn(boolean isOn) {this.isOn = isOn;}
	public String getIpAddress () {return ipAddress;}
	public void setIpAddress(String ipAddress) {this.ipAddress = ipAddress;}
	public float getTime() {return time;}
	public void setTime(float time) {this.time = time;}
	public String getSongName() {return songName;}
	public void setSongName(String songName) {this.songName = songName;}
	public Date getCurrDate() {return currDate;}
	public void setCurrDate(Date currDate) {this.currDate = currDate;}
	public Date getEventDate() {return eventDate;}
	public void setEventDate(Date eventDate) {this.eventDate = eventDate;}
	
	public Curler() {}
	
	/*
	 * connects to given wifi
	 * checks the calendar, if event is today it plays song 
	 */
	public void wifiConnect(String wifiName, String wifiPassword) {
		System.out.println("Connected to the internet");
		checkCalendar(getIpAddress());
		/*
		 * IP address is set by user to prevent checking calendars of unwanted phones (other than user's phone)
		 */
		System.out.println("Ip address has been set");
		if(getCurrDate() == getEventDate()) {
			playSong(getSongName());
		}
	}

	
	/*
	 * when curler is set to preheat, it is turned on
	 * after green light is turned on, keeps on checking temperature to maintain the desired one
	 */
	public void preheat(float desiredTemp, String userName) {
		setDesiredTemp(desiredTemp);
		turnOnGreenLight();
		tempControl(desiredTemp,userName);
	}
	
	/*
	 * connects curler to wifi
	 */
	public void turnOn(String userName, String wifiName, String wifiPassword) {
		wifiConnect(wifiName, wifiPassword);
		turnOnHeat();
		System.out.println("Hello "+ userName +" your curler is now on");
		setIsOn(true);
		System.out.println();

	}
		
	/*
	 * maintains desired temperature as long as it is on
	 */
	public void tempControl(float desiredTemp, String userName) {
		while(getIsOn()==true && getTime() > 0) {
			if(getCurrTemp() > desiredTemp) {
				System.out.println("Current Temp = " + getCurrTemp() +" Desired Temp = " + desiredTemp);
				turnOffHeat();
				setTime(getTime()-1) ;
				System.out.println("Time remaining = " + getTime() + "seconds");
				System.out.println();

			}else {
				System.out.println("Current Temp = " + getCurrTemp() +" Desired Temp = " + desiredTemp);
				turnOnHeat();
				setTime(getTime()-1);
				System.out.println("Time remaining = " + getTime() + "seconds");
				System.out.println();

			}
		}
		turnOff(userName);
	}
	
	public void turnOnGreenLight() {
		System.out.println("Green light has been turned on");
	}
	
	public void turnOnHeat() {
		setCurrTemp(getCurrTemp()+10);
		System.out.println("Heat has been turnt on");
	}
	
	public void turnOffHeat() {
		setCurrTemp(getCurrTemp()-10);
		System.out.println("Heat has been turnt off");
	}
	
	/*
	 * turns off curler by turning off heat
	 */
	public void turnOff(String userName) {
		turnOffHeat();
		System.out.println("Curler has been turnt off");
		System.out.println("Good Bye " + userName );
		setIsOn(false);
	}
	

	
	/*
	 * Set a song to play when event is today 
	 */
	public void setSong(String song) {
		System.out.println("Your song is playing");
		setSongName(song);
	}
	
	/*
	 * surfs the internet for given song name to play
	 */
	public void playSong(String songName) {
	}
	/*
	 * checks if there are any upcoming events in which user might want to use the hair curler
	 */
	public void checkCalendar(String ipAddress) {
		setEventDate( new Date());	
		System.out.println("Checking your phone calendar for any upcoming events");
	}
	
	
	
}