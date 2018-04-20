package mediator;

public abstract class User {
	
	protected ChatServer chatSerer ;
	protected String name;
	
	
	public User(ChatServer chatSerer, String name) {
		super();
		this.chatSerer = chatSerer;
		this.name = name;
	}
	
	
	public abstract void sendMessage(String message);
	
	public abstract void receiveMessage(String message);
	

}
