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

@Table(name="WL_MESSAGES")
@javax.persistence.Entity
@AccessType("field")
public class Messages extends Entity implements Serializable {
	
	private static final long serialVersionUID = 2074294723491719965L;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "username")
	private String username;
	
	@Column(name = "message_date")
	private Date messageDate;

	@Column(name = "message")
	private String message;
	
	@Column(name = "mesage_id")
	private long messageId;
	
	@Column(name = "ip")
	private String ip;
	
	@Column(name = "message_level")
	private int messageLevel;
	
	@Column(name = "message_category")
	private long messageCategory;
	
	@Column(name = "video_id")
	private Video video;
	
	@Column(name = "photo_id")
	private Photo photo;

	@Transient
	private String stringDate;
	
	@Transient
	private String name;
	
	@Transient
	private List<Messages> messagesList;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getStringDate(){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(messageDate);
		long now = System.currentTimeMillis();
		long difference = now-cal.getTimeInMillis();
		if(difference<Constants.oneMinute){
			stringDate = difference/1000+" sn Once";
		} else if(difference<Constants.oneHour){
			stringDate = ((difference/(Constants.oneMinute))==0?1 : difference/(Constants.oneMinute))+" dk Once";
		} else {
			stringDate = ((difference/(Constants.oneHour))==0?1 : difference/(Constants.oneHour))+" saat Once";
		}
		return stringDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getMessageLevel() {
		return messageLevel;
	}

	public void setMessageLevel(int messageLevel) {
		this.messageLevel = messageLevel;
	}

	public long getMessageCategory() {
		return messageCategory;
	}

	public void setMessageCategory(long messageCategory) {
		this.messageCategory = messageCategory;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public List<Messages> getMessagesList() {
		return messagesList;
	}

	public void setMessagesList(List<Messages> messagesList) {
		this.messagesList = messagesList;
	}

	public String getName() {
		if(firstName!=null && lastName!=null){
			return firstName +" "+lastName;
		}
		if(firstName!=null){
			return firstName;
		}
		if(lastName!=null){
			return lastName;
		}
		return "Veli Coşkun";
	}

	public void setName(String name) {
		this.name = name;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

}
