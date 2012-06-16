package com.wallony.object;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;

import com.wallonymessage.utils.Constants;

/**
 * 
 * @author v.coskun
 * 
 */

@Table(name="WL_IP_LOCATION")
@javax.persistence.Entity
@AccessType("field")
public class IpLocation extends Entity implements Serializable {
	
	private static final long serialVersionUID = 207429723491719965L;
	
	@Column(name = "ip")
	private String ip;

	@Column(name = "country")
	private String countryCode;

	@Column(name= "city_code")
	private String cityCode;
	
	@Column(name = "city")
	private String cityName;
	
	@Column(name = "company")
	private String companyName;
	
	@Column(name = "companySpecial")
	private String companyNameSpecial;

	@Column(name = "cordinate")
	private String coordinate;
	
	@Column(name = "last_update_date")
	private Date lastUpdateDate;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getCompanyNameSpecial() {
		return companyNameSpecial;
	}

	public void setCompanyNameSpecial(String companyNameSpecial) {
		this.companyNameSpecial = companyNameSpecial;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public IpLocation(){}
	
	public IpLocation(String ip, String countryCode, String cityCode, String cityName,
			String coordinate,
			String companyName,
			String companyNameSpecial,
			Date lastUpdateDate) {
		super();
		this.ip = ip;
		this.countryCode = countryCode;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.companyName = companyName;
		this.companyNameSpecial = companyNameSpecial;
		this.coordinate = coordinate;
		this.lastUpdateDate = lastUpdateDate;
	} 
}
