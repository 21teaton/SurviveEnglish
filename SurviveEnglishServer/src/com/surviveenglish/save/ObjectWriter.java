package com.surviveenglish.save;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriter {
	
	public static void writeObjectToFile(String path, Object object) {
		
		try {
			
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(object);
			objectOut.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}