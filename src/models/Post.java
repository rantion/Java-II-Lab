package models;

import java.io.File;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Post")
@NamedQueries({ @NamedQuery(name = "postsByPost", query = "SELECT p FROM Post p WHERE p.postingOn = :post") })
public class Post {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "account_seq", sequenceName = "account_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	private int id;

	@Column(name="postTime")
	private Date postTime = new Date(System.currentTimeMillis());

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User poster;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post postingOn;

	@Column(name = "fileType")
	private String fileType;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group permittedViewers;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group haveSeenPost;

	@Column(name = "isPrivate")
	private boolean isPrivate;

	@Column(name = "hasAudio")
	private boolean hasAudio;

	@Column(name = "hasVideo")
	private boolean hasVideo;

	@Column(name= "postContent")
	private byte[] postContent;

	public Post() {}
	
	public Post(User poster) {
		this.poster = poster;
	}

	public Post(User poster, Post postingOn) {
		this.poster = poster;
		this.postingOn = postingOn;
	}

	public Date getPostTime() {
		return postTime;
	}

	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getPostContent() {
		return postContent;
	}

	public void setPostContent(byte[] postContent) {
		this.postContent = postContent;
	}

	public Group getPermittedViewers() {
		return permittedViewers;
	}

	public void setPermittedViewers(Group permittedViewers) {
		this.permittedViewers = permittedViewers;
	}

	public Group getHaveSeenPost() {
		return haveSeenPost;
	}

	public void setHaveSeenPost(Group haveSeenPost) {
		this.haveSeenPost = haveSeenPost;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public boolean isHasAudio() {
		return hasAudio;
	}

	public void setHasAudio(boolean hasAudio) {
		this.hasAudio = hasAudio;
	}

	public boolean isHasVideo() {
		return hasVideo;
	}

	public void setHasVideo(boolean hasVideo) {
		this.hasVideo = hasVideo;
	}

}
