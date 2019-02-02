package com.haih.demo.vo;

import com.alibaba.fastjson.annotation.JSONField;

public class DetectBody {
	@JSONField(name = "image")
	private StringBuilder image;
	@JSONField(name = "image_type")
	private String image_type;
	@JSONField(name = "face_field")
	private String face_field;
	
	public StringBuilder getImage() {
		return image;
	}
	public void setImage(StringBuilder image) {
		this.image = image;
	}
	public String getImage_type() {
		return image_type;
	}
	public void setImage_type(String image_type) {
		this.image_type = image_type;
	}
	public String getFace_field() {
		return face_field;
	}
	public void setFace_field(String face_field) {
		this.face_field = face_field;
	}		
}
