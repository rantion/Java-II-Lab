package models;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "Post")
public class Post {
	@Id
	@Column(name="id")
	@SequenceGenerator(name="account_seq", sequenceName="account_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
	private int id;	
	
	@ManyToOne
    @JoinColumn(name="post_id")
	private Post post = this;
	
    @OneToMany
	private Set<Post> reactions = new HashSet<Post>();
    
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.ALL})
	@JoinTable(name="post_comments", 
	joinColumns=@JoinColumn(name="post_id"),
	inverseJoinColumns=@JoinColumn(name="comment_id"))
	private List<Comment> comments;
	
	@Column(name="postTime")
	private DateTime postTime;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User poster;
	
	@Column(name="fileType")
	private String fileType;
	
	@ManyToOne
	@JoinColumn(name="group_id")
	private Group permittedViewers;
	
	@ManyToOne
	@JoinColumn(name="group_id")
	private Group haveSeenPost;
	
	@Column(name="isPrivate")
	private boolean isPrivate;
	@Column(name= "hasAudio")
	private boolean hasAudio;
	@Column(name="hasVideo")
	private boolean hasVideo;
	
	private File postContent;	
	public Post(){
		
	}

	public Set<Post> getReactions() {
		return reactions;
	}

	public void setReactions(Set<Post> reactions) {
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
