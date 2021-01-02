
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class ConvertBlobToPdf{

	public static File getPdfFromBlob(Blob blobFile, String filename) {
		
		File savedFile = null;
		String path = null;
		
		try {
			
			path = "src/tempFiles" + "/" +filename;
			
			savedFile = new File(path);
			if(!savedFile.exists()) {
				FileOutputStream output = new FileOutputStream(savedFile);
			
				InputStream input =  blobFile.getBinaryStream();
				byte[] buffer = new byte[1024];
			
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
				output.close();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			//e.printStackTrace();
			System.out.print(e.getMessage());
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return savedFile;
	}

}
