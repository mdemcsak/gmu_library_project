package edu.gmu.authorservice.model;

import com.google.common.base.Objects;

import java.util.Date;

public class Author {

    private Integer _id;
    private String _name;
    private Date _dob;
    private String _nationality;
    private String _awards;
    private String _biography;
    private String _imageUrl;

    public Author() {
    }

    public Author(Integer id, String name, Date dob, String nationality, String biography, String awards, String imageUrl) {
        _id = id;
        _name = name;
        _dob = dob;
        _nationality = nationality;
        _awards = awards;
        _biography = biography;
        _imageUrl = imageUrl;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public Date getDob() {
        return _dob;
    }

    public void setDob(Date dob) {
        _dob = dob;
    }

    public String getNationality() {
        return _nationality;
    }

    public void setNationality(String nationality) {
        _nationality = nationality;
    }

    public String getAwards() {
        return _awards;
    }

    public void setAwards(String awards) {
        _awards = awards;
    }

    public String getBiography() {
        return _biography;
    }

    public void setBiography(String biography) {
        _biography = biography;
    }

    // NOTE: Do NOT change the name of this getter method. It ensures
    // that when an Author instance is converted to JSON, the image URL
    // property name is image_url and not imageUrl.
    public String getImage_url() {
        return _imageUrl;
    }

    // NOTE: Do NOT change the name of this setter method. It ensures
    // that when JSON is converted to an Author instance, the image URL
    // property name is image_url and not imageUrl.
    public void setImage_url(String imageUrl) {
        _imageUrl = imageUrl;
    }

    // Here we are using Google Guava's ToStringHelper class to create
    // a nicely formatted string which is used whenever an Author object
    // is converted to a String, either explicitly or implicitly.
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", getId())
                .add("name", getName())
                .add("dob", getDob())
                .add("nationality", getNationality())
                .add("biography", getBiography())
                .add("awards", getAwards())
                .add("image_url", getImage_url())
                .toString();
    }

}
