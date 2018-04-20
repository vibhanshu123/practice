package mediator;

public class UserImpl extends User{

	public UserImpl(ChatServer chatSerer, String name) {
		super(chatSerer, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendMessage(String msg) {
		chatSerer.sendMessage(msg, this);
		
	}

	@Override
	public void receiveMessage(String msg) {
		System.out.println(this.name +":->Received message ");
		
	}

}
