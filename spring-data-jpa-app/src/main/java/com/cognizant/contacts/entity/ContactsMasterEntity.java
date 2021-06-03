package com.cognizant.contacts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts_master")
public class ContactsMasterEntity {
	
	@Id
	@Column(name = "contact_id")
	private Integer contactId;
	@Column(name = "contact_name")
	private String contactName;
	@Column(name = "contact_number")
	private String contactNumber;
	
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "ContactsMasterEntity [contactId=" + contactId + ", contactName=" + contactName + ", contactNumber="
				+ contactNumber + "]";
	}
}
