package com.wilfredmorgan.imagegalleryapi.repositories;

import com.wilfredmorgan.imagegalleryapi.models.Image;
import com.wilfredmorgan.imagegalleryapi.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * CRUD repositor connecting Image model to the rest of the application
 */
public interface ImageRepository extends CrudRepository<Image, Long> {

    /**
     * List all images saved by the specified user
     *
     * @param user
     * @return list of image objects created by the specific user
     */
    List<Image> findImagesByUser(User user);

    /**
     * Returns the image with the given primary key
     *
     * @param id
     * @return Image object with the given primary key
     */
    Image findById(long id);
}
