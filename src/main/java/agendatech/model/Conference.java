package agendatech.model;

public class Conference {

	private Integer id;
	private String contactEmail;
	private String name;

	public Conference() {
		super();
	}

	public Conference(String name, String contactEmail) {
		this();
		this.contactEmail = contactEmail;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + id + " - " + name +"]";
	}
	
}
