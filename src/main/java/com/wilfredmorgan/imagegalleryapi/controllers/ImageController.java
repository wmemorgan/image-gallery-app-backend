package com.wilfredmorgan.imagegalleryapi.controllers;

import com.wilfredmorgan.imagegalleryapi.models.Image;
import com.wilfredmorgan.imagegalleryapi.services.ImageService;
import com.wilfredmorgan.imagegalleryapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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
    @PreAuthorize("hasAnyRole('ADMIN')")
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

    /**
     * Given a complete Image object, create a new Image record
     *
     * @param newimage A complete new image to add user must already exist.
     * @return A location header with the URI to the newly created image and a status of CREATED
     * @throws URISyntaxException Exception if something does not work in creating the location header
     * @see ImageService#save(Image) ImageService.save(Image)
     */
    @PostMapping(value = "/image", consumes = {"application/json"})
    public ResponseEntity<?> addNewImage(@Valid @RequestBody Image newimage) throws URISyntaxException {
        newimage.setImageid(0);
        newimage = imageService.save(newimage);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newimage.getImageid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    /**
     * Given a complete User Object
     * Given the user id, primary key, is in the User table,
     * replace the Image record
     *
     * @param replaceImage A complete Image object
     * @param imageid The primary key of the image you want to replace
     * @return status of OK
     * @see ImageService#save(Image) ImageService.save(Image)
     */
    @PutMapping(value = "/image/{imageid}", consumes ={"application/json"})
    public ResponseEntity<?> replaceImage(@Valid @RequestBody Image replaceImage,
                                          @PathVariable long imageid) {
        replaceImage.setImageid(imageid);
        imageService.save(replaceImage);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Updates the image record associated with the given id with the provided data. Only the provided fields are affected.
     *
     * @param updateImage An object containing values for just the fields that are being updated. All other fields are left NULL.
     * @param imageid The primary key of the user you wish to update.
     * @return A status of OK
     * @see ImageService#update(Image, long)  ImageService.update(Image, long)
     */
    @PatchMapping(value = "/image/{imageid}", consumes ={"application/json"})
    public ResponseEntity<?> updateImage(@Valid @RequestBody Image updateImage,
                                         @PathVariable long imageid) {
        imageService.update(updateImage, imageid);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes a given image
     *
     * @param imageid the primary key of the user you wish to delete
     * @return Status of OK
     * @see UserService#delete(long) UserService.delete(long)
     */
    @DeleteMapping(value = "/image/{imageid}", produces = {"application/json"})
    public ResponseEntity<?> deleteImageById(@PathVariable long imageid) {
        imageService.delete(imageid);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
