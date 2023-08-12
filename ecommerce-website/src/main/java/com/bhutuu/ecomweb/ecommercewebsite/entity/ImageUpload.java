package com.bhutuu.ecomweb.ecommercewebsite.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
@Table(name="image_model")

public class ImageUpload {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String imagename;
	private LocalDateTime createdDate=LocalDateTime.now();
	private String type;
	@Lob
	@Column(length=5000000,columnDefinition="BLOB")
	private byte[] picbyte;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicbyte() {
        return picbyte;
    }

    public void setPicbyte(byte[] picbyte) {
        this.picbyte = picbyte;
    }

    public ImageUpload() {}
	
	public ImageUpload(String imagename,  String type, byte[] picbyte) {
		this.imagename=imagename;
		this.type=type;
		this.picbyte=picbyte;
	
	}
}
