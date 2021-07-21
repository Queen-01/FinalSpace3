
package com.queen.finalspace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Quote {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("quote")
    @Expose
    private String quote;
    @SerializedName("by")
    @Expose
    private String by;
    @SerializedName("character")
    @Expose
    private String character;
    @SerializedName("image")
    @Expose
    private String image;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Quote() {
    }

    /**
     * 
     * @param image
     * @param character
     * @param quote
     * @param by
     * @param id
     */
    public Quote(Integer id, String quote, String by, String character, String image) {
        super();
        this.id = id;
        this.quote = quote;
        this.by = by;
        this.character = character;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
