package MEMENTO;
public class FileWriterClient {

	public static void main(String[] args) {
		
		FileWriterCaretaker caretaker = new FileWriterCaretaker();
		
		FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
		fileWriter.write("First Set of Data\n");
		System.out.println(fileWriter+"\n\n");
		
		// lets save the file
		caretaker.save(fileWriter);
		//now write something else
		fileWriter.write("Second Set of Data\n");
		
		//checking file contents
		System.out.println(fileWriter+"\n\n");

		//lets undo to last save
		caretaker.undo(fileWriter);
		
		//checking file content again
		System.out.println(fileWriter+"\n\n");
		
		fileWriter.write("3RD Set of Data\n");
		caretaker.save(fileWriter);
		fileWriter.write("4TH Set of Data\n");
		caretaker.save(fileWriter);
		System.out.println(fileWriter+"\n\n");
		caretaker.undo(fileWriter);
		caretaker.undo(fileWriter);
		caretaker.undo(fileWriter);
		System.out.println(fileWriter+"CCCCC\n\n");
		
		
		
	}

}