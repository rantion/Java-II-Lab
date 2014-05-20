package models;

import java.io.File;
import java.util.List;

import org.joda.time.DateTime;

public class Post {
	
	private List<Post> reactions;
	private List<Comment> comments;
	private DateTime postTime;
	private User poster;
	private String fileType;
	private File postContent;
	private Group permittedViewers, haveSeenPost;
	private boolean isPrivate, hasAudio, hasVideo;
	
	public Post(){
		
	}

	public List<Post> getReactions() {
		return reactions;
	}

	public void setReactions(List<Post> reactions) {
		this.reactions = reactions;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public DateTime getPostTime() {
		return postTime;
	}

	public void setPostTime(DateTime postTime) {
		this.postTime = postTime;
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

	public File getPostContent() {
		return postContent;
	}

	public void setPostContent(File postContent) {
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
