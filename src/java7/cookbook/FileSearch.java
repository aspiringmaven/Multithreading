package java7.cookbook;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable{

	private String initDir;
	private final String fileName;	
	
	public static void main(String[] args) {
		Thread thread = new Thread(new FileSearch("D:\\", "autoexec.bat"));
		
		thread.start();
		
		try {
			System.out.println("Thread Working");
			TimeUnit.SECONDS.sleep(10);
			System.out.println("intuppted");
			thread.interrupt();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public FileSearch(String initDir, String file) {
		super();
		this.initDir = initDir;
		this.fileName = file;
	}


	public String getInitDir() {
		return initDir;
	}

	public void setInitDir(String initDir) {
		this.initDir = initDir;
	}

	@Override
	public void run() {
		
		File initPath = new File(initDir);
		try {
			processDirectory(initPath);
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	
	public void processDirectory(File dir) throws InterruptedException{
		if(dir == null) {
			return ;
		} 
		
		if(dir.isDirectory()) {
			for(File rDir : dir.listFiles()) {
				if(rDir != null && rDir.isDirectory()) {
					processDirectory(rDir);
				} else {
					processFile(rDir);
				}
			}
			if(Thread.interrupted()) {
				throw new InterruptedException("from dir method");
			}
		}
	}
	
	public void processFile(File dirFile) throws InterruptedException {
		if(dirFile == null) return;
		File file = new File(fileName);
		
		if(file.getName().equals(dirFile.getName())) {
			System.out.println("File Found  : "+dirFile.getAbsolutePath());
		}
		if(Thread.interrupted()) {
			throw new InterruptedException("from file method");
		}
	}


	public String getFileName() {
		return fileName;
	}
}