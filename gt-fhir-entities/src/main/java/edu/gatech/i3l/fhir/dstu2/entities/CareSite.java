package edu.gatech.i3l.fhir.dstu2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


@Entity
@Table(name="care_site")
@Audited
public class CareSite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="care_site_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="organization_id")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="place_of_service_concept_id")
	private Concept placeOfServiceConcept;
	
	@Column(name="care_site_source_value")
	private String careSiteSourceValue;
	
	@Column(name="place_of_service_source_value")
	private String placeOfServiceSourceValue;
	
	public CareSite() {
		super();
	}
	
	public CareSite(Long id, Location location, Organization organization, 
			Concept placeOfServiceConcept, String careSiteSourceValue) {
		super();
		
		this.id = id;
		this.location = location;
		this.organization = organization;
		this.placeOfServiceConcept = placeOfServiceConcept;
		this.careSiteSourceValue = careSiteSourceValue;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	public Concept getPlaceOfServiceConcept() {
		return placeOfServiceConcept;
	}
	
	public void setPlaceOfServiceConcept(Concept placeOfServiceConcept) {
		this.placeOfServiceConcept = placeOfServiceConcept;
	}
	
	public String getCareSiteSourceValue() {
		return careSiteSourceValue;
	}
	
	public void setCareSiteSourceValue(String careSiteSourceValue) {
		this.careSiteSourceValue = careSiteSourceValue;
	}
	
	public String getPlaceOfServiceSourceValue() {
		return placeOfServiceSourceValue;
	}
	
	public void setPlaceOfServiceSourceValue(String placeOfServiceSourceValue) {
		this.placeOfServiceSourceValue = placeOfServiceSourceValue;
	}
}
