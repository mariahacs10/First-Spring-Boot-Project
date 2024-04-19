package com.example.cardatabase.firstapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="artwork")
public class ArtWork {

	@Id
	@GeneratedValue
	private Long artWorkId;
	private String authorName;
	private String authorTitle;
	private String authorDescription;
	
    private String authorImageUrl; 
	
	public ArtWork(String authorName, String authorTitle, String authorDescription, String authorImageUrl)
	{
		this.authorName = authorName;
		this.authorTitle = authorTitle;
		this.authorDescription = authorDescription;
		this.authorImageUrl = authorImageUrl;	
	}
	
	public Long getArtWorkId()
	{
		return artWorkId;
	}
	
	public void setArtWorkId(Long artWorkId)
	{
		this.artWorkId = artWorkId;
	}
	
	public String getAuthorName()
	{
		return authorName;
	}
	
	public void setAuthorName(String authorName)
	{
		this.authorName = authorName;
	}
	
	public String getAuthorTitle()
	{
		return authorTitle;
	}
	
	public void setAuthorTitle(String authorTitle)
	{
		this.authorTitle = authorTitle;
	}
	
	public String getAuthorDescription()
	{
		return authorDescription;
	}
	
	public void setAuthorDescription(String authorDescription)
	{
		this.authorDescription = authorDescription;
	}
	
	public String getAuthorImageUrl()
	{
		return authorImageUrl;
	}
	
	public void setAuthorImageUrl(String authorImageUrl)
	{
		this.authorImageUrl = authorImageUrl;
	}
	public ArtWork()
	{
		super();
	}
}
