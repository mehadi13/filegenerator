package filegenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String readFileFromPath;
		String packageName;
		String createPackageIn;
		
		FileGenerator fileGenerator = new FileGenerator();
		fileGenerator.modifyFile("/home/mehadi/Desktop/service.java", "class Name", "MyClass");
		//fileGenerator.createFile("/home/mehadi/Desktop", "service", "Sample data");
		//fileGenerator.makePackage("/home/mehadi/Desktop", "Untitled.Directory2.Sub2.Sub-Sub2");
		//.readFileList("/home/mehadi/Desktop/gamelayout/node_modules/accepts");
	}
}

class FileGenerator{
	public ArrayList<String> readFileList(String filePath) {
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> fileNameList = new ArrayList<>();
		
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  String fileName[] = (listOfFiles[i].getName()).split("\\.");
		    	  fileNameList.add(fileName[0]);
		        System.out.println("File " + fileName[0]);
		      } /*else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }*/
		    }
		    return fileNameList;
	}
	
	public void makePackage(String path,String packageName) {
		File files = new File(path+"/"+packageNameToFolderName(packageName));
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
	}
	
	public String packageNameToFolderName(String packageName) {
		String[] folderList = packageName.split("\\.");
		String folderName = "";
		for (String string : folderList) {
			folderName = folderName+string+"/";
		}
		return folderName;
	}
	
	public void createFile(String filePath,String fileName,String data)
    {
        FileOutputStream out;
		try {
			out = new FileOutputStream(filePath+"/"+fileName+".java");
			out.write(data.getBytes());
	        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	
	public void modifyFile(String filePath, String oldString, String newString)
	{
		File fileToBeModified = new File(filePath);
		
		String oldContent = "";
		
		BufferedReader reader = null;
		
		FileWriter writer = null;
		
		try 
		{
			reader = new BufferedReader(new FileReader(fileToBeModified));
			
			//Reading all the lines of input text file into oldContent
			
			String line = reader.readLine();
			
			while (line != null) 
			{
				oldContent = oldContent + line + System.lineSeparator();
				
				line = reader.readLine();
			}
			
			//Replacing oldString with newString in the oldContent
			
			String newContent = oldContent.replaceAll(oldString, newString);
			
			//Rewriting the input text file with newContent
			
			writer = new FileWriter(fileToBeModified);
			
			writer.write(newContent);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				//Closing the resources
				
				reader.close();
				
				writer.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}
