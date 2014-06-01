package models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "Comment")
public class Comment 
{	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
	private int id;	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User creator;
	
	@Column(name = "belongsOnPost")
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post belongsOnPost;
	
	@Column(name = "belongsOnComment")
	@ManyToOne
	@JoinColumn(name = "comment_id")
	private Comment belongsOnComment;
	@Column(name = "content")
	private String content;
	@Column(name = "postTime")
	private Calendar postTime;
	
	public Comment(User creator, Post post, String content)
	{
//		belongsOnPost.addComment(this);
		postTime = Calendar.getInstance();
	}
	
	public Comment(User creator, Comment commentOn, String content)
	{
//		belongsOnComment.addComment(this);
		postTime = Calendar.getInstance();
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Post getBelongsOnPost() {
		return belongsOnPost;
	}

	public void setBelongsOnPost(Post belongsOnPost) {
		this.belongsOnPost = belongsOnPost;
	}

	public Comment getBelongsOnComment() {
		return belongsOnComment;
	}

	public void setBelongsOnComment(Comment belongsOnComment) {
		this.belongsOnComment = belongsOnComment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Calendar getPostTime() {
		return postTime;
	}

	public void setPostTime(Calendar postTime) {
		this.postTime = postTime;
	}
}