package in.bhusanproj.expensetrackerapi.entity;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorObject {
	
	private Integer statusCode;
	private String message;
	private Date timestamp;
	public Integer getstatusCode() {
		return statusCode;
	}
	public void setstatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	

}
