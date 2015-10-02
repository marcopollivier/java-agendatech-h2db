package agendatech.model;

import java.util.Date;

public class Conference {

	private Integer id;
	private String contactEmail;
	private String state;
	private String description;
	private String name;
	private Date startDate;
	private Date endDate;

	public Conference() {
	}
	
	public Conference(String name, String contactEmail, String state, Date startDate, Date endDate) {
		this.name = name;
		this.contactEmail = contactEmail;
		this.state = state;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Conference(Integer id, String name, String contactEmail, String state, Date startDate, Date endDate) {
		this(name, contactEmail, state, startDate, endDate);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "[" + id + " - " + name +"]";
	}
	
}
