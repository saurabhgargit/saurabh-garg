package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private OrderStatus status;
    private boolean complete;
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
	 * @return the petId
	 */
	public int getPetId() {
		return petId;
	}
	/**
	 * @param petId the petId to set
	 */
	public void setPetId(int petId) {
		this.petId = petId;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the shipDate
	 */
	public String getShipDate() {
		return shipDate;
	}
	/**
	 * @param shipDate the shipDate to set
	 */
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	/**
	 * @return the status
	 */
	public OrderStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	/**
	 * @return the complete
	 */
	public boolean isComplete() {
		return complete;
	}
	/**
	 * @param complete the complete to set
	 */
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
}