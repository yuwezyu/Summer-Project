import java.io.File;

public class CVE_2013_6282{
	private static int errno;
	//exec方法等效于cmd中直接执行命令行
	private static int exec(String cmd) throws Exception{
        	Process p = Runtime.getRuntime().exec(cmd);
        	return p.waitFor();
    	}

	private static boolean Bug_id1(String path) throws Exception{
		//do detect
		//赋予bin文件执行权限
		exec("chmod 777 CVE_2013_6282");
		//执行bin获取返回值判断
		int ret = exec("."  + File.separator + "CVE_2013_6282");
		switch(ret){
			case 255://漏洞不存在
				return false;
			case 254://漏洞存在
				return true;
			default:
				ret = errno;
				throw new Exception("\n[*]Detecting failed.\n");
		}
	}	
	//Bug_id2(){}
	//  .
	//  .
	//  .
	//Bug_idn(){}


	private static int isVulnerable() throws Exception{
		//if bug return true
        	boolean Bug_id1 = Bug_id1("/data/local/tmp");
        	/*boolean Bug_id2 = Bug_id2();
			.
			.				
			
      boolean Bug_idn = Bug_idn(); */ 	
        	if(Bug_id1 /* 	 || Bug_id2 || ... || Bug_idn */ 	){
            		System.out.println("CVE_2013_6282 is Vulnerablitity true.\n");
            		return 254;
        	}
        	else{
            		System.out.println("CVE_2013_6282 is Vulnerablitity false.\n");
            		return 255;
        	}
    	}	

	public static void main(String args[]){
		try{
            		 isVulnerable(); 
		}catch(Exception e){
            		e.printStackTrace();
        	}
        	
	}
}
