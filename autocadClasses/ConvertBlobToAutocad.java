package autocadClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import pdfClasses.ConvertBlobToPdf;

public class ConvertBlobToAutocad {

	public static String getAutocadFromBlob(Blob blobFile, String filename) {
		
		String path = null;
		try {
			
			path = ConvertBlobToPdf.class.getClassLoader().getResource("tempFiles").getPath() + "/" +filename;
			
			File tempFile = new File(path);
			FileOutputStream output = new FileOutputStream(tempFile);
			
			InputStream input =  blobFile.getBinaryStream();
			byte[] buffer = new byte[1024];
			
			while(input.read(buffer) > 0) {
				output.write(buffer);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}
	
}
