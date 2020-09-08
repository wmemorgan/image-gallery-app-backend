package com.wilfredmorgan.imagegalleryapi.controllers;

import com.wilfredmorgan.imagegalleryapi.models.Image;
import com.wilfredmorgan.imagegalleryapi.services.ImageService;
import com.wilfredmorgan.imagegalleryapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The entry point for clients to access image data
 */
@RestController
@RequestMapping("/images")
public class ImageController {

    /**
     * Using the Image service to process image data
     */
    @Autowired
    ImageService imageService;

    /**
     * Using the User service to process user data
     */
    @Autowired
    UserService userService;

    /**
     * Returns a list of all images
     *
     * @return JSON list of all images with a status of OK
     * @see ImageService#findAll() ImageService.findAll()
     */
    @GetMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<?> getAllImages() {
        List<Image> images = imageService.findAll();

        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    /**
     * Returns a single image based off a image id number
     *
     * @param imageid
     * @return JSON object of the image you seek
     * @see ImageService#findImageById(long) ImageService.findImageById(long)
     */
    @GetMapping(value = "/image/{imageid}", produces= {"application/json"})
    public ResponseEntity<?> getImageById(@PathVariable long imageid) {
        Image image = imageService.findImageById(imageid);

        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    /**
     * Return a list of all images saved by specified user
     *
     * @param authentication
     * @return JSON list of all images with a status of OK
     * @see ImageService#findImagesByUser(String) ImageService.findImagesByUser(String)
     */
    @GetMapping(value = "/user", produces = {"application/json"})
    public ResponseEntity<?> getImagesByUser(Authentication authentication) {
        List<Image> images = new ArrayList<>();

        imageService.findImagesByUser(authentication.getName())
                .iterator()
                .forEachRemaining(images::add);

        return new ResponseEntity<>(images, HttpStatus.OK);
    }


}
