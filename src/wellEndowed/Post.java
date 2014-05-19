package wellEndowed;

import java.io.File;
import java.util.List;

import org.joda.time.DateTime;

public class Post implements Postable {
	
	private List<Post> reactions;
	private List<Comment> comments;
	private DateTime postTime;
	private User poster;
	private String fileType;
	private File postContent;
	private Groupable permittedViewers, haveSeenPost;
	private boolean isPrivate, hasAudio, hasVideo;
	
	public Post(){
		
	}

}
