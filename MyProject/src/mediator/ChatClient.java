package mediator;

public class ChatClient {
	
	public static void main(String [] args) {
		ChatServer chatServer = new ChatServerImpl();
		User user1= new UserImpl(chatServer, "vib");
		User user2= new UserImpl(chatServer, "manj");
		User user3= new UserImpl(chatServer, "arya");
		User user4= new UserImpl(chatServer, "xyz");
		User user5= new UserImpl(chatServer, "abc");
		chatServer.addUser(user1);
		chatServer.addUser(user2);
		chatServer.addUser(user3);
		chatServer.addUser(user4);
		chatServer.addUser(user5);
		user1.sendMessage("Hi All");
	}

}
