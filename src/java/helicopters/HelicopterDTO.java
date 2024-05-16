/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopters;

/**
 *
 * @author hp
 */
public class HelicopterDTO {
    private String helicopterID;
    private String helicopterName;
    private String description;
    private float price;
    private String image;

    public HelicopterDTO() {
    }

    public HelicopterDTO(String helicopterID, String helicopterName, String description, float price, String image) {
        this.helicopterID = helicopterID;
        this.helicopterName = helicopterName;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getHelicopterID() {
        return helicopterID;
    }

    public void setHelicopterID(String helicopterID) {
        this.helicopterID = helicopterID;
    }

    public String getHelicopterName() {
        return helicopterName;
    }

    public void setHelicopterName(String helicopterName) {
        this.helicopterName = helicopterName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
