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
public class Pet {
    private int id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private PetStatus status;
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
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
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
	 * @return the photoUrls
	 */
	public ArrayList<String> getPhotoUrls() {
		return photoUrls;
	}
	/**
	 * @param photoUrls the photoUrls to set
	 */
	public void setPhotoUrls(ArrayList<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	/**
	 * @return the tags
	 */
	public ArrayList<Tag> getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}
	/**
	 * @return the status
	 */
	public PetStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(PetStatus status) {
		this.status = status;
	}
}