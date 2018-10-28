package Input;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import FileProcessor.FileProcessor;

public class Starter{
	
	private final ExecutorService service = Executors.newSingleThreadExecutor();
	
	private FileProcessor processor = null;
	
    public Starter(FileProcessor processor) {
		this.processor = processor;
	}


    public List<String> getListOfAllFiles(String timeInSeconds){
       List<String> fileNamesSearched= null;
        try{
        	Callable<List<String>> getListOfAllFiles  = new Callable<List<String>>(){ 
            	public List<String> call() throws Exception{
                       return processor.processFile();                          
                      }
                    };
            Future<List<String>> f = service.submit(getListOfAllFiles);
            fileNamesSearched=f.get(Integer.parseInt(timeInSeconds), TimeUnit.SECONDS);
        }catch (final TimeoutException e){
            System.err.println("Could not complete operation");
            return null;
        }
        catch (final Exception e){
            throw new RuntimeException(e);
        }finally{
            service.shutdown();
        }
        return fileNamesSearched;
      }
}