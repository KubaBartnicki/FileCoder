package engine;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Coder {
	private Codec codec;
	private double progress = 0;
	double max;
	public Coder(Codec codec) {
		this.codec = codec;
	}
	
	public void setProgress(int in) {

		progress = 1-(in/max);
	}
	
	public double getProgress() {
		return progress;
	}
	
	public void codeFile(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		FileOutputStream fos = new FileOutputStream(path + ".asd");
		max = fis.available() +0.1;
		while(fis.available()>0) {
			fos.write(codec.encode(fis.read()));
			setProgress(fis.available());
			System.out.println(progress	);
		}
		progress = 1.0;
	}
	
	public void decodeFile(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		FileOutputStream fos = new FileOutputStream(path + ".decoded");
		max = fis.available() +0.1;
		while(fis.available()>0) {
			fos.write(codec.decode(fis.read()));	
			setProgress(fis.available());
		}
		progress = 1.0;
	}
	
}
