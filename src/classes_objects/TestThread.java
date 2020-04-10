package classes_objects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 
public class TestThread {
 
    /**
     * @param file 查找的目录
     * @param search 查找的字符串
     */
    public static void search(File file, String search) {
        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
//                String fileContent = readFileConent(file);
//                if(fileContent.contains(search)){
//                    System.out.printf("找到子目标字符串%s,在文件:%s%n",search,file);
//                }
//            	SearchFileThread sft=new SearchFileThread(file,search);
//            	sft.start();
//            	new SearchFileThread(file,search).start();
            	SearchFileThread sft=new SearchFileThread(file,search);
            	new Thread(sft).start();
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search);
            }
        }
    }
     
    public static String readFileConent(File file){
        try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
 
    }
    public static void main(String[] args) {
        Thread gameTime=new Thread() {
        	public void run() {
        		int k=0;
        		while(true) {
	        		try {
	        			sleep(1000);
	        		}
	        		catch(Exception e) {
	        			e.printStackTrace();
	        		}
	        		System.out.printf("LOL进行了 %d 秒%n",++k);
	        		if(k==15) {
	        			System.out.println("LOL进行了一分钟，结束游戏！");
	        			break;
	        		}
        		}
        	}
        };
        gameTime.start();
        Hero leesin=new Hero();
        leesin.setDaemon(true);
        new Thread(leesin).start();
//        leesin.setDaemon(true);
//        leesin.start();
//        leesin.setDaemon(true);
    }
}
