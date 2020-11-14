import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
	static Scanner Input = new Scanner(System.in);
	// creates an arraylist to hold the users
	static ArrayList<User> userList = new ArrayList<User>();
	private String greeting = "Hello";
    private String userName;
    private int rollingID=0 ;
    static Interface Interface1 = new Interface();
	static Curler Curler1 = new Curler();
	private boolean exitFlag=true;
	
	
    public boolean getExitFlag() {return exitFlag;}
	public void setExitFlag(boolean exitFlag) {this.exitFlag = exitFlag;}
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	public String getGreeting() {return greeting;}
	public void setRollingID(int id) {this.rollingID = id;}
	public int getRollingID() {return rollingID;}

	public Interface() {}

	public static void closeInterface() {Input.close();}
	  // creates a userlist and default user
	public static void createUserList() {
		userList.add(new User());
        User defaultUser = userList.get(0);
        defaultUser.setUserName("Default");
        defaultUser.setWifiName("DefaultWifiName");
        defaultUser.setWifiPassword("DefaultWififPassword");
        defaultUser.setDesiredTemp(100);
        defaultUser.setSessionDuration(600);
        defaultUser.setID(Interface1.getRollingID());
        Interface1.setRollingID(Interface1.getRollingID()+1);
        
        
		}
	
	
	public static void login() {
	    int loginFlag = 0;
		System.out.println("Enter userName");
        Interface1.setUserName(Input.next());
		
		
		        
       for (User i : userList) {
        	if (i.getUserName().equals(Interface1.getUserName())) {
                System.out.println(Interface1.getGreeting() + " " + Interface1.getUserName());
                loginFlag=1;
                break;
        	}
        	
       }
        if (loginFlag==0) {
        	
            System.out.println("Enter wifiName");
            String wifiName = Input.next();
            
            System.out.println("Enter wifiPassword");
            String wifiPassword = Input.next();
           
            System.out.println("Enter desired temperature");
            float desiredTemp = Input.nextFloat();
            
            System.out.println("Enter duration of your curling session");
            float duration = Input.nextFloat(); // if a user doesnt input a value it will get the default options
            if (wifiName=="" || wifiPassword=="" || desiredTemp==0 || duration ==0  ) {
            	System.out.println("Since you have entered an empty value for one of the inputs, default values will be used.");
            	userList.add(new User(Interface1.getUserName(), Interface1.getRollingID()));
            	Interface1.setRollingID(Interface1.getRollingID()+1);
            
            }
            userList.add(new User());
            for (User i : userList) {
            	if (i.getUserName()==null) {
            		i.setWifiName(wifiName);
            		i.setWifiPassword(wifiPassword);
            		i.setUserName(Interface1.getUserName());
            		i.setDesiredTemp(desiredTemp);
            		i.setSessionDuration(duration);
	                System.out.println(Interface1.getGreeting() + " " + i.getUserName());
	                i.setID(Interface1.getRollingID());
	              	Interface1.setRollingID(Interface1.getRollingID()+1);
	                
            		}
            }
        }
	}
	public static void startCurlerFunctions() {
		User CurrentUser =null;
		 for (User i : userList) {
	        	if (i.getUserName().equals(Interface1.getUserName())) {
	        		CurrentUser = i;
	        		break;
	        	}
	       }
		
		Curler1.turnOn(CurrentUser.getUserName(), CurrentUser.getWifiName(), CurrentUser.getWifiPassword());
		Curler1.preheat(CurrentUser.getDesiredTemp(), CurrentUser.getUserName());
	}
	
	public static void exitPrompt() {
		System.out.println("Press 0 to exit, 1 to continue as another User:");
		if(Input.nextInt()==0) {Interface1.setExitFlag(false);}
	}
	public static void exitMessage() {
		System.out.println("You look pretty, Have a nice day!");
	}
	
}
