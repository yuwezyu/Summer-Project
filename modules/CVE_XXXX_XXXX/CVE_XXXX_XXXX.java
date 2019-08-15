import android.content.Context;
import android.os.Build;
import java.io.File;
import android.util.Log;

public class CVE_XXXX_XXXX{
	private static int errno;
	
	private static int exec(String cmd) throws Exception{
        	Process p = Runtime.getRuntime().exec(cmd);
        	return p.waitFor();
    	}

	private static  Bug_id1(String path) throws Exception{
		//first check version
		int version = Build.VERSION.SDK_INT;
		//if(version){
		//	return 
		}
		//do detect
		exec("chmod 777 " + path + File.separator + "CVE_XXXX_XXXX");
		int ret = exec("." + path + File.separator + "CVE_XXXX_XXXX";
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


	private static int isVulnerable(String path) throws Exception{
		//if bug return true
        	boolean Bug_id1 = Bug_id1(path);
        	boolean Bug_id2 = Bug_id2(path);
			.
			.				
			.
        	boolean Bug_idn = Bug_idn(path);
        	if(Bug_id1 || Bug_id2 || ... || Bug_idn){
            		System.out.println("CVE_XXXX_XXXX is Vulnerablitity true.\n");
            		return 254;
        	}
        	else{
            		System.out.println("CVE_XXXX_XXXX is Vulnerablitity false.\n");
            		return 255;
        	}
    	}	

	public static int main(Context context){
		//path to exec bin
		String path = context.getFilesDir().getAbsolutePath() + File.separator + "cve" + File.separator + "CVE_XXXX_XXXX";
		Log.i("aden","path:" + path);
		try{
            return isVulnerable(path); 
		}catch(Exception e){
            e.printStackTrace();
        }
        return errno;
	}
}
