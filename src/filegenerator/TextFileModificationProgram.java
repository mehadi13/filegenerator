package filegenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileModificationProgram {
	static void modifyFile(String filePath, String fileName, String extention, String oldString[], String newString[]) {
		File fileToBeModified = new File(filePath + "/" + fileName + extention);

		String content = "";

		BufferedReader reader = null;

		// FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));

			// Reading all the lines of input text file into oldContent

			String line = reader.readLine();

			while (line != null) {
				content = content + line + System.lineSeparator();

				line = reader.readLine();
			}

			// Replacing oldString with newString in the oldContent
			for (int i = 0; i < oldString.length; i++) {
				content = content.replaceAll(oldString[i], newString[i]);
			}

			// Rewriting the input text file with newContent

			// writer = new FileWriter(fileToBeModified);

			// writer.write(content);
			//makePackage(filePath, newString[1]);
			createFile(filePath, newString[1] + fileName, content);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources

				reader.close();

				// writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void makePackage(String path, String packageName) {
		File files = new File(path + "/" + packageNameToFolderName(packageName));
		if (!files.exists()) {
			if (files.mkdirs()) {
				System.out.println("Multiple directories are created!");
			} else {
				System.out.println("Failed to create multiple directories!");
			}
		}
	}

	public static String packageNameToFolderName(String packageName) {
		String[] folderList = packageName.split("\\.");
		String folderName = "";
		for (String string : folderList) {
			folderName = folderName + string + "/";
		}
		return folderName;
	}

	public static void createFile(String filePath, String fileName, String data) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filePath + "/" + fileName + ".java");
			out.write(data.getBytes());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// modifyFile("C:/StudentFile.txt", "85", "95");
		String old[] = { "<package>", "<ClassName>", "<ClassNameLowerCase>","<ClassNameLowerCasePrural>" };
		String newString[] = { "com.bjit.training", "Rating", "rating","ratings" };
		String files[] = { "Controller", "Repository", "Service" };
		String extention = ".java";
		for (int i = 0; i < files.length; i++)
			modifyFile("/home/mehadi/Desktop/generate/template", files[i], extention, old, newString);

		System.out.println("done");
	}
}
