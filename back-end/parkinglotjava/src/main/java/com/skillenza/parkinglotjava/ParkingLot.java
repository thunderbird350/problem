package com.skillenza.parkinglotjava;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parkinglots")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class ParkingLot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="created_at")
	private Date created_at;
	
	@Column(name="lot")
	private int lot;
	
	@Column(name="parking_amount")
	private int parking_amount;
	
	@Column(name="parking_duration")
	private int parking_duration;
	
	@Column(name="update_at")
	private Date update_at;
	
	@Column(name="vehicle_number")
	private int vehicle_number;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the created_at
	 */
	public Date getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the lot
	 */
	public int getLot() {
		return lot;
	}

	/**
	 * @param lot the lot to set
	 */
	public void setLot(int lot) {
		this.lot = lot;
	}

	/**
	 * @return the parking_amount
	 */
	public int getParking_amount() {
		return parking_amount;
	}

	/**
	 * @param parking_amount the parking_amount to set
	 */
	public void setParking_amount(int parking_amount) {
		this.parking_amount = parking_amount;
	}

	/**
	 * @return the parking_duration
	 */
	public int getParking_duration() {
		return parking_duration;
	}

	/**
	 * @param parking_duration the parking_duration to set
	 */
	public void setParking_duration(int parking_duration) {
		this.parking_duration = parking_duration;
	}

	/**
	 * @return the update_at
	 */
	public Date getUpdate_at() {
		return update_at;
	}

	/**
	 * @param update_at the update_at to set
	 */
	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}

	/**
	 * @return the vehicle_number
	 */
	public int getVehicle_number() {
		return vehicle_number;
	}

	/**
	 * @param vehicle_number the vehicle_number to set
	 */
	public void setVehicle_number(int vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
	
	
    
}
