package com;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Credits.
 */
public class Credits{

	@JsonProperty("image")
	private String image;

	@JsonProperty("imageLink")
	private String imageLink;

	@JsonProperty("link")
	private String link;

	@JsonProperty("text")
	private String text;

	/**
	 * Set image.
	 *
	 * @param image the image
	 */
	public void setImage(String image){
		this.image = image;
	}

	/**
	 * Get image string.
	 *
	 * @return the string
	 */
	public String getImage(){
		return image;
	}

	/**
	 * Set image link.
	 *
	 * @param imageLink the image link
	 */
	public void setImageLink(String imageLink){
		this.imageLink = imageLink;
	}

	/**
	 * Get image link string.
	 *
	 * @return the string
	 */
	public String getImageLink(){
		return imageLink;
	}

	/**
	 * Set link.
	 *
	 * @param link the link
	 */
	public void setLink(String link){
		this.link = link;
	}

	/**
	 * Get link string.
	 *
	 * @return the string
	 */
	public String getLink(){
		return link;
	}

	/**
	 * Set text.
	 *
	 * @param text the text
	 */
	public void setText(String text){
		this.text = text;
	}

	/**
	 * Get text string.
	 *
	 * @return the string
	 */
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