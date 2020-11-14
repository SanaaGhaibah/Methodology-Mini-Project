import java.io.IOException;



public class Main {
	// runs all the functions
	public static void main (String[] args) throws IOException {
		
        Interface.createUserList();
		while(Interface.Interface1.getExitFlag()){
	        Interface.login();
	        Interface.startCurlerFunctions();
	        Interface.exitPrompt();
		}
		Interface.exitMessage();
	}
}
