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


}
