package one.show.service;


import java.util.Locale;

import one.show.common.HttpsUtil;
import sun.misc.BASE64Decoder;

public class IOS_Verify {
 
    private static final String url_sandbox="https://sandbox.itunes.apple.com/verifyReceipt";  
    private static final String url_verify="https://buy.itunes.apple.com/verifyReceipt";  
      
      
    /** 
     * 苹果服务器验证 
     * @param receipt 账单 
     * @return 返回结果 
     * 沙盒   https://sandbox.itunes.apple.com/verifyReceipt 
     *  
     */  
    public static String buyAppVerify(String receipt)  
    {  
       String url=url_verify;  
       
       if (getFromBASE64(receipt).indexOf("Sandbox") >= 0){
    	   url=url_sandbox;  
       }
       
//       String buyCode=getBASE64(receipt);  
       
       String str= String.format(Locale.CHINA,"{\"receipt-data\":\"" + receipt+"\"}");  
       return HttpsUtil.post(url, str.getBytes());
     
    }  
      

    /** 
     * 用BASE64加密 
     * @param str 
     * @return 
     */  
    public static String getBASE64(String str) {  
        byte[] b = str.getBytes();  
        String s = null;  
        if (b != null) {  
            s = new sun.misc.BASE64Encoder().encode(b);  
        }  
        return s;  
    }  
    
    /** 
     * 解密BASE64字窜 
     * @param s 
     * @return 
     */  
    public static String getFromBASE64(String s) {  
        byte[] b = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                return new String(b);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return new String(b);  
    }  

}
