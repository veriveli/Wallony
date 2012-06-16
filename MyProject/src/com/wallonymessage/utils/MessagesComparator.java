package com.wallonymessage.utils;

import java.util.Comparator;

import com.wallony.object.Messages;

public class MessagesComparator implements Comparator<Messages> {

	public int compare(Messages o1, Messages o2) {
			Long timeIncoming = o1.getMessageDate().getTime() ;
			Long timeThis = o2.getMessageDate().getTime();
			return timeThis.compareTo( timeIncoming );
	}
}