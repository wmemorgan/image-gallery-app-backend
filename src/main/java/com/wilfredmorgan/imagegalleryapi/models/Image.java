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

    /**
     * Image description (String). Optional
     */
    private String description;

    /**
     * The thumbnail url (String). Optional
     */
    private String thumbnailurl;

    /**
     * Link to the Users table
     */
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    /**
     * Default constructor required by JPA
     */
    public Image() {
    }

    /**
     * Given the parameters, create a new image object
     * <p>
     * 
     * @param imageid
     * @param imageurl
     * @param description
     * @param thumbnailurl
     * @param user
     */
    public Image(long imageid, String imageurl, String description, String thumbnailurl, User user) {
        this.imageid = imageid;
        this.imageurl = imageurl;
        this.description = description;
        this.thumbnailurl = thumbnailurl;
        this.user = user;
    }

    /**
     * Getter for imageid
     *
     * @return the imageid (long) of the image
     */
    public long getImageid() {
        return imageid;
    }

    /**
     * Setter for imageid. Used primary for seeding data
     *
     * @param imageid the new imageid (long) of the image
     */
    public void setImageid(long imageid) {
        this.imageid = imageid;
    }

    /**
     * Getter for imageurl
     *
     * @return the url (long) of the image
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * Setter for imageurl
     *
     * @param imageurl the new url of the image
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * Getter for description
     *
     * @return the description (String) of the image
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     *
     * @param description the new image description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for thumbnailurl
     *
     * @return the url (long) of the image thumbnail
     */
    public String getThumbnailurl() {
        return thumbnailurl;
    }

    /**
     * Setter for thumbnailurl
     *
     * @param thumbnailurl the new thumbnail url
     */
    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }

    /**
     * Getter for user
     *
     * @return user object
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for user
     *
     * @param user - new or updated user object
     */
    public void setUser(User user) {
        this.user = user;
    }
}
