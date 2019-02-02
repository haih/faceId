package com.haih.demo;

import com.haih.demo.vo.DetectBody;
import com.haih.demo.vo.OauthRep;

import com.alibaba.fastjson.JSON;    
import com.alibaba.fastjson.JSONObject;  
import com.alibaba.fastjson.TypeReference;    

public class Face
{
//	public static HttpUtil httpClint = new HttpUtil();
	public static String oauthUrl = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=LiPaOeFVqs8jdRQoubjSG7Qw&client_secret=Pdt26mSf4PyZG8stO7Ewj0COqRS1HOCI";
	private static String oauthToken;
	public static String detectUrl = "https://aip.baidubce.com/rest/2.0/face/v3/detect?";
	
    public static void main(String[] args)
    {    	
    	String strImg = PhotoConvert.GetImageStr();
    	      
    	faceDetect(strImg);

    }
    
    private static void tokenRefresh()
    {    	
      //  String strImg = PhotoConvert.GetImageStr();
    	String resp = HttpUtil.doGet(oauthUrl);
    	OauthRep oauthResp = JSON.parseObject(resp,OauthRep.class);  
    	oauthToken = "access_token=" + oauthResp.getAccess_token();
    }
    
    private static void faceDetect(String image) {
    	tokenRefresh();
    	String url = detectUrl + oauthToken;
    	DetectBody body = new DetectBody();
    	body.setImage(new StringBuilder(image));
    	body.setImage_type("BASE64");
    	body.setFace_field("gender");
    	String resp = HttpUtil.doPost(url, JSON.toJSON(body));
    	System.out.println(resp);
	}

}