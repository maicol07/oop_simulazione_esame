package ex2016.a01.t2.e2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
	private String fileName;
	private List<Integer> list = new ArrayList<>();
	private int incCurrent = 1;
	private Random random = new Random();
	
	public Controller(String fileName) {
		this.fileName = fileName;
	}
	
	public void handleIncInc() {
		list.add(incCurrent += 2);
	}
	
	public void handleRandom() {
		list.add(-random.nextInt(101));
	}
	
	public void handleUno() {
		list.add(1);
	}

	public void handleOk() {
		var file = new File(fileName);
    	if (file.exists()) {
        	file.delete();
    	}
    	
    	try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	
    	this.list.forEach(num -> {
    		System.out.println(num);
    		try {
				Files.writeString(file.toPath(), num + "\n", StandardOpenOption.APPEND);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	});
    	list.clear();
    	incCurrent = 1;
	}
}
