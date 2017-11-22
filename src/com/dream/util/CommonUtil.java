package com.dream.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.codec.binary.Base64;
public class CommonUtil {
	public static long convertDataStringToLong(String strDate) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(strDate);
		return date.getTime();
	}
	/**
	 * 将Date转换为XMLGregorianCalendar
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar dateToXmlDate(Date date){  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        DatatypeFactory dtf = null;  
         try {  
            dtf = DatatypeFactory.newInstance();  
        } catch (DatatypeConfigurationException e) {  
        }  
        XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();  
        dateType.setYear(cal.get(Calendar.YEAR));  
        //由于Calendar.MONTH取值范围为0~11,需要加1  
        dateType.setMonth(cal.get(Calendar.MONTH)+1);  
        dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));  
        dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));  
        dateType.setMinute(cal.get(Calendar.MINUTE));  
        dateType.setSecond(cal.get(Calendar.SECOND));  
        return dateType;  
    } 
	/**
	 * 将XMLGregorianCalendar转换为Date
	 * @param date
	 * @return
	 */
	public static String XMLGregorianCalendarToString(XMLGregorianCalendar time){
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=time.toGregorianCalendar().getTime();
		String dateTimeString=simpleDateFormat.format(date);
		return dateTimeString;
	}
	
	/**MD5加密
	 * @throws NoSuchAlgorithmException */
	public static String md5(String str){
		if(str==null||str.equals("")){
			return null;
		}
		byte[] output=null;
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			output=md.digest(str.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String md5str=Base64.encodeBase64String(output);
		return md5str;
	}

/**
     * @param plainText
     *            明文
     * @return 32位,MD5加密,小写
     */
    public static String encryptionMD532(String plainText) {
        String re_md5 = new String();
        try {
          MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            re_md5 = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }

	/**
	 * 生成UUID值
	 * @return
	 */
	public static String createId(){
		UUID uid=UUID.randomUUID();//每次产生一个随机字符串,具有唯一性
		return uid.toString();
	}
	/**
	 * 做配置文件
	 */
	/**
	 * 传入地址读取txt文档
	 * @param filePath
	 * @return
	 */
	public static String readTxtFile(){
		String filePath=CommonUtil.class.getClassLoader().getResource("path.txt").getPath();
		System.out.println("绝对路径："+filePath);
        String result="";
        try {
                String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	result=result+lineTxt;
                    	System.out.println(result);
                    }
                    read.close();
        }else{
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if("".equals(result)){
        	result="192.168.1.108:8080";
        }
		return  result;
}
}