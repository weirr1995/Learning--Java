package classes_objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestFile {
	static File file=null;
	static boolean flag=false;
	public static void FileList(File f) {
		if(flag)return;
		if(f.isDirectory()) {
			File f0[]=f.listFiles();
			for(File x:f0)FileList(x);
		}
		if(f.isFile()) {
			if(f.length()>100*1000&&f.length()<Integer.MAX_VALUE) {
				file=f;
				flag=true;return;
			}
		}
	}
	public static void main(String[] args) {
		File f=new File("C:\\游戏");
		FileList(f);
		System.out.printf("找到了该文件，其绝对路径为：%s%n",file.getAbsolutePath());
//		File f0=new File(file.getAbsolutePath()+"-0");
//		File f1=new File(file.getAbsolutePath()+"-1");
//		File f2=new File(file.getAbsolutePath()+"-2");
//		File f3=new File(file.getAbsolutePath()+"-3");
		int n=(int)file.length()/4;
		int m=(int)file.length()%4;
		FileInputStream fis=null;
		try {
			byte a[]=new byte[(int)file.length()];
//			FileInputStream fis=new FileInputStream(file);
			fis=new FileInputStream(file);
			fis.read(a);
			fis.close();
			for(int i=0;i<4;++i) {
				String child=file.getName()+"-"+i;
			//	File fx=new File(file.getAbsolutePath()+"-"+i);
				File fx=new File(file.getParent(),child);
				FileOutputStream fos=new FileOutputStream(fx);
				byte b[]=new byte[n+m];
				if(i!=3) {
				System.arraycopy(a, i*n, b, 0, n);
				}
				else {
				System.arraycopy(a, i*n, b, 0, n+m);
				}
				fos.write(b);
				fos.close();
			}
			byte src[]=new byte[(int)file.length()];
			File newf=new File(file.getParent()+"/副本"+file.getName());
			FileOutputStream fos2=new FileOutputStream(newf);	
			for(int i=0;i<4;++i) {
				String name=file.getAbsolutePath()+"-"+i;
				File fx=new File(name);
				byte b[]=new byte[n+m];
				FileInputStream fis2=new FileInputStream(fx);
				fis2.read(b);
				fis2.close();
				fos2.write(b);
			//	fos2.flush();
//				if(i!=3) {
//					System.arraycopy(b, 0, src, i*n, n);
//				}
//				else {
//					System.arraycopy(b, 0, src, i*n, n+m);
//				}
			}
			fos2.close();
//			File newf=new File(file.getParent()+"/副本"+file.getName());
//			FileOutputStream fos2=new FileOutputStream(newf);
//			fos2.write(src);
//			fos2.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fis!=null) {
				try {
					fis.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}