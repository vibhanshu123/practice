package mediator;

public interface ChatServer {
	
	public  void sendMessage(String message, User user);
	
	void addUser(User user);
	

}
