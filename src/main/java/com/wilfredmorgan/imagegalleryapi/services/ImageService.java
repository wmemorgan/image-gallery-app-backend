package com.wilfredmorgan.imagegalleryapi.services;

import com.wilfredmorgan.imagegalleryapi.models.Image;

import java.util.List;

/**
 * The service that works with the Image model
 */
public interface ImageService {

    /**
     * Returns a list of all images
     *
     * @return
     */
    List<Image> findAll();

    /**
     * Returns the image with the given primary key
     *
     * @param id
     * @return Image object with the given primary key or throws an exception if not found
     */
    Image findImageById(long id);

    /**
     * Returns a list of images from a specific user
     *
     * @param username
     * @return
     */
    List<Image> findImagesByUser(String username);

    /**
     * Given a complete image object, saves that image object in the database
     * If a primary key is provided, the record is completely replaced
     * If no primary key is provided, one is automatically generated and the record is added to the database
     *
     * @param image The image object to be saved
     * @return The saved image object including any automatically generated fields
     */
    Image save(Image image);

    /**
     * Updates the provided fields in the image record referenced by the primary key
     *
     * @param image
     * @param id
     * @return
     */
    Image update(Image image, long id);

    /**
     * Deletes the role record based off the provided primary key
     *
     * @param id The primary key (long) of the image to be deleted
     */
    void delete(long id);

    /**
     * Deletes all records and their associated records from the database
     */
    void deleteAll();

}
