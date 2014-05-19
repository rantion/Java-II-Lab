package wellEndowed;

import java.util.Calendar;

public class Comment 
{	
	private User creator;
	private Post belongsOnPost;
	private Comment belongsOnComment;
	private String content;
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