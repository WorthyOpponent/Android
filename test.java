package test;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.security.PublicKey;
import java.security.interfaces.DSAPublicKey;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws FileNotFoundException {
		String fileUri = "C:\\Users\\DELL\\Desktop\\input4164.txt";
		String str="";
		ArrayList<String> li = new ArrayList<String>();
		try (Scanner sc = new Scanner(new FileReader(fileUri))) {
		      sc.useDelimiter("\\s+");  //分隔符
		      while (sc.hasNext()) {   //按分隔符读取字符串
		    	 String temp = sc.next();
		    	 li.add(temp);
		      }
		      
		   }
		if(li.size()==1) {
			System.out.println("只有一个单词");
		}else {
			int start = 0;
			int flag = 0;
			ArrayList<String> li2 = new ArrayList<String>();
			int maxlen = 0;
			int len = 1;
			for(int i=0;i<li.size()-1;i++)
			{
				String str1 = li.get(i).toString();
				String str2 = li.get(i+1).toString();
				flag = Compare(str1, str2);
				if(flag == 0 && !str.equals("")) {
					start = 0;
					li2.add(str);
					str="";
					if(maxlen<len) {
						maxlen = len;
					}
					len = 1;
				}
				if(flag == 1 && start == 0) {
					len++;
					str+=str1;
					str+=" ";
					str+=str2;
					start = 1;
				}
				else if(flag == 1 && start == 1) {
					len++;
					str+=" ";
					str+=str2;
					start = 1;
				}
			}
			for(int i=0;i<li2.size();i++) {
				String strall = li2.get(i).toString();
				String[] arr4 = strall.split("\\s+"); //分割一个或者多个空格
				if(arr4.length==maxlen) {
					// 创建一个打印输出流，输出的目标是D盘下的1.txt文件
			        PrintStream ps = new PrintStream("C:\\Users\\DELL\\Desktop\\output4164.txt");
			        //可能会出现异常，直接throws就行了
			        System.setOut(ps);
			        //把创建的打印输出流赋给系统。即系统下次向 ps输出
			        System.out.println(strall);
			        ps.close();
					break;
				}
			}
		}
		
		
		
	}
	public static int Compare(String str1,String str2) {
        char tail1 = str1.charAt(str1.length()-1);
        
        char head2 = str2.charAt(0);
	     
	     if(tail1==head2) {
	    	 return 1;
	     }
	     else {
	    	 return 0;
	     }
	}
	

}
