package COMMANDDESIGNPatternUNDOButton;

public class PointsToNote {
	
	public static void main(String[] args){
	 System.out.println("When we need to decouple Objects making");
	 System.out.println("requests from the objects that knows how to");
	 System.out.println("perform those requests,we use COMMAND PATTERN");
	 
	 System.out.println("----DEFINITION---");
	 System.out.println("Encapsulates the request as an object");
	 System.out.println("thereby letting you parametrize clients");
	 System.out.println("with different requests,queue or log requests");
	 System.out.println("and support undoable operations");
	 
	 System.out.println("1.The command pattern decouples an object making a request from the one that knows how to perform it");
	 System.out.println("2.command object is at the centre of this decoupling and encapsulates a receiver with an action(or set of actions)");
	 System.out.println("3.an invoker makes the request of the command object by calling its execute() method which invokes those actions on the receiver");
	 System.out.println("4.invokers can be parametrized with commands even dynamically at runtime");
	 System.out.println("5.Commands may support undo by implementing an undo() method that restores the object to its previous state before the execute method was last called");
	 System.out.println("6.Macro commands are a simple extension of command that allow multiple commands to be invoked,Likewise macro commands can easily support undo");
	 System.out.println("7.In practice, it is not uncommon for SMART Command objects to implemen the request themselves rather than delegating to a receiver");
	 System.out.println("8.Commands may also be used to implement logging and transactional systems");
	 
	}

}
