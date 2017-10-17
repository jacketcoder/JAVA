package digitalEnvelop;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

import interfaceUsed.handleData;

public class dataFromURL implements handleData{
	String  urlString;
	String fileName,data;
	byte []dataInByte;
	public dataFromURL(String url,String fileName) {
		this.urlString=url;
		this.fileName=fileName;
	}
	void downloadData() {
		try {
			URL url=new URL(urlString);
			BufferedInputStream bis=new BufferedInputStream(url.openStream());
			FileOutputStream fos=new FileOutputStream(fileName);
			byte[] buffer=new byte[1024];
			int count=0;
			while((count=bis.read(buffer,0,1024))!=-1) {
				fos.write(buffer,0,count);
			}
			fos.close();
			bis.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getData() {
		File file=new File(fileName);
		//System.out.println(file.getName());
		try {
			 data=new String(Files.readAllBytes(file.toPath()));
			//System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	@Override
	public void fetchData() {
		downloadData();
		// TODO Auto-generated method stub
		
	}

}
