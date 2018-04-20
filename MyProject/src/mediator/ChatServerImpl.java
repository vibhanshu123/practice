package mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatServerImpl implements ChatServer{

	private final List<User> userList ;
	
	public ChatServerImpl() {
		userList= new ArrayList<User>();
	}
	
	@Override
	public void sendMessage(String message, User user1) {
		for(User user:userList) {
			if(!user1.equals(user)) {
				user.receiveMessage(message);
			}
		}
		
	}

	@Override
	public void addUser(User user) {
		userList.add(user);
		
	}

}
