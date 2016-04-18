package bg.softuni.socialnetwork.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")

public class Comment implements Serializable {
	private static final long serialVersionUID = 1455960171897295767L;
	
	
	@Column(name="ID")
	@Id
	private Long id;
	
	
	@Column(name ="AUTHOR_ID")
	private Long authorId;
	
	@Column(name ="POST_ID")
	private Long postId;

	@Column(name = "AUTHOR_NAME")
	private String authorName;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "CREATED_ON")
	private Date createdOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	
}
