package models;

import java.util.Calendar;

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
@Table(name = "Comment")
@NamedQueries({
	@NamedQuery(name="byCommentNum", query="SELECT c FROM Comment c WHERE c.id = :commentId"),
	@NamedQuery(name="byPost", query="SELECT c FROM Comment c WHERE c.belongsOnPost = :post"),
	@NamedQuery(name="byComment", query="SELECT c FROM Comment c WHERE c.belongsOnComment = :comment")
})
public class Comment 
{	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
	private Long id;	
	
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
	
	public Comment(){
		
	}
	
	public Comment(User creator, Post post, String content)
	{
		this.creator = creator;
		this.belongsOnPost = post;
		this.content = content;
		postTime = Calendar.getInstance();
	}
	
	public Comment(User creator, Comment commentOn, String content)
	{
		this.creator = creator;
		this.belongsOnComment = commentOn;
		this.content = content;
		postTime = Calendar.getInstance();
	}
	
	@Override
	public String toString(){
		return content;
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