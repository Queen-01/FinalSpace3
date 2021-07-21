
package com.queen.finalspace.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Location {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("inhabitants")
    @Expose
    private List<String> inhabitants = null;
    @SerializedName("notable_residents")
    @Expose
    private List<String> notableResidents = null;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param imgUrl
     * @param inhabitants
     * @param name
     * @param id
     * @param type
     * @param notableResidents
     */
    public Location(Integer id, String name, String type, List<String> inhabitants, List<String> notableResidents, String imgUrl) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.inhabitants = inhabitants;
        this.notableResidents = notableResidents;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(List<String> inhabitants) {
        this.inhabitants = inhabitants;
    }

    public List<String> getNotableResidents() {
        return notableResidents;
    }

    public void setNotableResidents(List<String> notableResidents) {
        this.notableResidents = notableResidents;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
