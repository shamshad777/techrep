package com.org.spring.to;

public class StudentTO {

	private int id;
	
	private String name;
	
	private Long phone;
	
	private String email;
	
	private String course;
	
	private String counsellor;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public Long getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @return the counsellor
	 */
	public String getCounsellor() {
		return counsellor;
	}

	/**
	 * @param counsellor the counsellor to set
	 */
	public void setCounsellor(String counsellor) {
		this.counsellor = counsellor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentTO [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", course=" + course
				+ ", counsellor=" + counsellor + "]";
	}
	
	
	
	
}
