package com.wilfredmorgan.imagegalleryapi.repositories;

import com.wilfredmorgan.imagegalleryapi.models.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD repositor connecting Image model to the rest of the application
 */
public interface ImageRepository extends CrudRepository<Image, Long> {
}
