package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credits{

	@JsonProperty("image")
	private String image;

	@JsonProperty("imageLink")
	private String imageLink;

	@JsonProperty("link")
	private String link;

	@JsonProperty("text")
	private String text;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setImageLink(String imageLink){
		this.imageLink = imageLink;
	}

	public String getImageLink(){
		return imageLink;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"Credits{" + 
			"image = '" + image + '\'' + 
			",imageLink = '" + imageLink + '\'' + 
			",link = '" + link + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}