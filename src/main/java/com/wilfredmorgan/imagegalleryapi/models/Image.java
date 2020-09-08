package com.wilfredmorgan.imagegalleryapi.models;

import javax.persistence.*;

/**
 * The entity allowing interaction with the images table
 */
@Entity
@Table(name = "images")
public class Image extends Auditable {

    /**
     * The primary key (long) of the images table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long imageid;

    /**
     * The image url (String). Cannot be null
     */
    @Column(nullable = false)
    private String imageurl;

    private String description;

    /**
     * The thumbnail url (String)
     */
    private String thumbnailurl;

    /**
     * Link to the Users table
     */
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    public Image() {
    }

    public Image(long imageid, String imageurl, String description, String thumbnailurl, User user) {
        this.imageid = imageid;
        this.imageurl = imageurl;
        this.description = description;
        this.thumbnailurl = thumbnailurl;
        this.user = user;
    }

    public long getImageid() {
        return imageid;
    }

    public void setImageid(long imageid) {
        this.imageid = imageid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
