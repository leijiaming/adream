package com.dream.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;


public class ZipUtil {
	
//	private static Log log = LogFactory.getLog(ZipUtil.class);
 
	/**
	 * 解压缩
	 * @param zipFileName 压缩文件
	 * @param outputDirectory  解压缩输出目录
	 * @throws Exception
	 */
	public void unzip(String zipFileName, String outputDirectory) throws Exception {
		ZipInputStream in = new ZipInputStream(new FileInputStream(zipFileName));
		ZipEntry z;
		while ((z = in.getNextEntry()) != null) {
//			log.info("正在解压缩 " + z.getName());
			if (z.isDirectory()) {
				String name = z.getName();
				name = name.substring(0, name.length() - 1);
				File f = new File(outputDirectory + File.separator + name);
				f.mkdir();
//				log.info("正在创建目录 " + outputDirectory + File.separator + name);
			} else {
				File f = new File(outputDirectory + File.separator + z.getName());
				f.createNewFile();
				FileOutputStream out = new FileOutputStream(f);
				int b;
				while ((b = in.read()) != -1)
					out.write(b);
				out.close();
			}
		}
		in.close();
//	    log.info("解压缩完成");
	}

	public static byte[] zip(String fileName)throws Exception {
		byte[] b = null;
        ByteArrayOutputStream bos = null;
        GZIPOutputStream gzip = null;
        byte[] buf=new byte[1024];
        int number; 
        try {
        	FileInputStream fin = new FileInputStream(fileName); 
        	bos = new ByteArrayOutputStream();
            gzip = new GZIPOutputStream(bos);
            while ((number = fin.read(buf)) != -1){
            	gzip.write(buf,0,number); 
            }
//            gzip.write(data.getBytes("UTF-8"));
            gzip.finish();
            gzip.close();
            b = bos.toByteArray();
        } finally {
            if (null != bos) {
                bos.close();
            }
        }
        return b;
	}
	/**
	 * 压缩
	 * @param zipFileName 压缩输出文件路径
	 * @param inputDirectory 待压缩的输入文件路径
	 * @throws Exception
	 */
	public void zip(String zipFileName, String inputDirectory) throws Exception {
		zip(zipFileName, new File(inputDirectory));
	}

	public void zip(String zipFileName, File inputFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out, inputFile, "");
//        log.info("压缩完成");
		out.close();
	}

	public void zip(ZipOutputStream out, File f, String base) throws Exception {
//		log.info("正在压缩  " + f.getName());
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
			in.close();
		}
	}
	/**
	 * 对给出的字符串进行压缩
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static byte[] gZip(String data) throws IOException {
        if (null == data || 0 == data.length()) {
            return new byte[0];
        }
        byte[] b = null;
        ByteArrayOutputStream bos = null;
        GZIPOutputStream gzip = null;
        try {
            bos = new ByteArrayOutputStream();
            gzip = new GZIPOutputStream(bos);
            gzip.write(data.getBytes("UTF-8"));
            gzip.finish();
            gzip.close();
            b = bos.toByteArray();
        } finally {
            if (null != bos) {
                bos.close();
            }
        }
        return b;
    }
   /**
    * 解压缩，返回字符串
    * @param data
    * @return
    * @throws IOException
    */
	public static String unGZip(byte[] data) throws IOException {
        if(null == data || 0 == data.length){
            return "";
        }
        byte[] b = null;
        ByteArrayInputStream bis = null;
        GZIPInputStream gzip = null;
        ByteArrayOutputStream baos = null;
        try {
            bis = new ByteArrayInputStream(data);
            gzip = new GZIPInputStream(bis);
            byte[] buf = new byte[1024];
            int num = -1;
            baos = new ByteArrayOutputStream();
            while ((num = gzip.read(buf, 0, buf.length)) != -1) {
                baos.write(buf, 0, num);
            }
            b = baos.toByteArray();
            baos.flush();
        } finally {
            if (null != baos) {
                baos.close();
            }
            if (null != gzip) {
                gzip.close();
            }
            if (null != bis) {
                bis.close();
            }
        }
        return new String(b,"UTF-8");
    }
	 public static void readTxtFile(String filePath){
	        try {
	                String encoding="UTF-8";
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){ //判断文件是否存在
	                    InputStreamReader read = new InputStreamReader(
	                    new FileInputStream(file),encoding);//考虑到编码格式
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    String lineTxt = null;
	                    while((lineTxt = bufferedReader.readLine()) != null){
	                        System.out.println(lineTxt);
	                    }
	                    read.close();
	        }else{
	            System.out.println("找不到指定的文件");
	        }
	        } catch (Exception e) {
	            System.out.println("读取文件内容出错");
	            e.printStackTrace();
	        }
	}
	public static void main(String[] args) {
		try {
			ZipUtil t = new ZipUtil();
			ZipUtil.readTxtFile("d:/serviceTestFile/sgbd.txt");
			//t.zip("c:\\01.zip", "c:\\01");
			//t.unzip("c:\\01.zip", "c:\\01");
//			System.out.println( new String(t.gZip("中华人民共和国")));
//			System.out.println(t.unGZip( t.gZip("中华人民共和国")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
