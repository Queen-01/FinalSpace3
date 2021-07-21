
package com.queen.finalspace.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

@Parcel
public class Episode {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("air_date")
    @Expose
    private String airDate;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("writer")
    @Expose
    private String writer;
    @SerializedName("characters")
    @Expose
    private List<String> characters = null;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Episode() {
    }

    /**
     * 
     * @param imgUrl
     * @param characters
     * @param director
     * @param name
     * @param airDate
     * @param id
     * @param writer
     */
    public Episode(Integer id, String name, String airDate, String director, String writer, List<String> characters, String imgUrl) {
        super();
        this.id = id;
        this.name = name;
        this.airDate = airDate;
        this.director = director;
        this.writer = writer;
        this.characters = characters;
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

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
