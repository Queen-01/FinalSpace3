
package com.queen.finalspace.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Character {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("species")
    @Expose
    private String species;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("hair")
    @Expose
    private String hair;
    @SerializedName("alias")
    @Expose
    private List<String> alias = null;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("abilities")
    @Expose
    private List<String> abilities = null;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Character() {
    }

    /**
     * 
     * @param abilities
     * @param imgUrl
     * @param hair
     * @param gender
     * @param species
     * @param origin
     * @param name
     * @param alias
     * @param id
     * @param status
     */
    public Character(Integer id, String name, String status, String species, String gender, String hair, List<String> alias, String origin, List<String> abilities, String imgUrl) {
        super();
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.hair = hair;
        this.alias = alias;
        this.origin = origin;
        this.abilities = abilities;
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
