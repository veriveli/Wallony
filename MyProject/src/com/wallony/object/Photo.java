package com.wallony.object;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;

import com.wallonymessage.utils.Constants;

/**
 * 
 * @author v.coskun
 * 
 */

@Table(name="WL_PHOTO")
@javax.persistence.Entity
@AccessType("field")
public class Photo extends Entity implements Serializable {
	
	private static final long serialVersionUID = 207424723491719965L;
	
	@Column(name = "thumb")
	private String thumb;

	@Column(name = "title")
	private String title;

	@Column(name = "source")
	private String source;
	
	@Column(name = "refer")
	private String refer;
	
	@Column(name = "message_id")
	private long messageId;

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRefer() {
		return refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
}
