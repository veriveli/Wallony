package com.wallony.object;

import java.io.Serializable;

public interface Persistable extends Serializable {
	
	public static final long UNSAVED_ID_VALUE = 0L ;
	public static final String ID_COLUMN_NAME = "record_id";
	
    public long getId();
    public void setId(long id);
	
    public long getVersion();
	public void setVersion(long version) ;
	
	public boolean getActive() ;
	public void setActive(boolean active) ;
	
}
