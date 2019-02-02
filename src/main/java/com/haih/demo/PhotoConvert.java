package com.haih.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PhotoConvert {
	private static String imgFile = "C://Users//huhai//Desktop//faceid//1.jpg";         //�������ͼƬ
	
	 //ͼƬת����base64�ַ���
    public static String GetImageStr()
    {//��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��

        InputStream in = null;
        byte[] data = null;
        //��ȡͼƬ�ֽ�����
        try 
        {
            in = new FileInputStream(imgFile);        
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        //���ֽ�����Base64����
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//����Base64��������ֽ������ַ���
    }
    
    //base64�ַ���ת����ͼƬ
    public static boolean GenerateImage(String imgStr)
    {   //���ֽ������ַ�������Base64���벢����ͼƬ
        if (imgStr == null) //ͼ������Ϊ��
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try 
        {
            //Base64����
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//�����쳣����
                    b[i]+=256;
                }
            }
            //����jpegͼƬ
            String imgFilePath = "d://222.jpg";//�����ɵ�ͼƬ
            OutputStream out = new FileOutputStream(imgFilePath);    
            out.write(b);
            out.flush();
            out.close();
            return true;
        } 
        catch (Exception e) 
        {
            return false;
        }
    }
}
