package com.wilfredmorgan.imagegalleryapi.services;

import com.wilfredmorgan.imagegalleryapi.exceptions.ResourceFoundException;
import com.wilfredmorgan.imagegalleryapi.exceptions.ResourceNotFoundException;
import com.wilfredmorgan.imagegalleryapi.handlers.HelpFunctions;
import com.wilfredmorgan.imagegalleryapi.models.Image;
import com.wilfredmorgan.imagegalleryapi.models.User;
import com.wilfredmorgan.imagegalleryapi.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements ImageService interface
 */
@Transactional
@Service(value = "imageService")
public class ImageServiceImpl implements ImageService {

    /**
     * Connects this service to the Image model
     */
    @Autowired
    ImageRepository imageRepository;

    /**
     * Connect this service to the User model
     */
    @Autowired
    UserService userService;

    @Autowired
    HelpFunctions helpFunctions;

    @Override
    public List<Image> findAll() {
        List<Image> list = new ArrayList<>();

        imageRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);

        return list;
    }

    @Override
    public Image findImageById(long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResourceFoundException(
                        "Image id " + id + " not found"
                ));
    }

    @Override
    public List<Image> findImagesByUser(long userid) {
        User u = userService.findById(userid);

        List<Image> list = new ArrayList<>();

        imageRepository.findImagesByUser(u)
                .iterator()
                .forEachRemaining(list::add);

        return list;
    }

    @Override
    public Image save(Image image) {
        Image newImage = new Image();
        // Determine if record exists to be replaced
        if (image.getImageid() != 0) {
            findImageById(image.getImageid());
            newImage.setImageid(image.getImageid());
        }

        // Populate object fields
        newImage.setImageurl(image.getImageurl());
        newImage.setDescription(image.getDescription());
        newImage.setThumbnailurl(image.getThumbnailurl());

        // Add logged in user object
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User u = userService.findByUsername(username);
        newImage.setUser(u);

        return imageRepository.save(newImage);
    }

    @Override
    public Image update(Image image, long id) {
        // Confirm image exists
        Image currentimage = findImageById(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (helpFunctions.isAuthorizedToMakeChange(username)) {

            if (image.getImageurl() != null) {
                currentimage.setImageurl(image.getImageurl());
            }

            if (image.getDescription() != null) {
                currentimage.setDescription(image.getDescription());
            }

            if (image.getThumbnailurl() != null) {
                currentimage.setThumbnailurl(image.getThumbnailurl());
            }

            if (image.getUser() != null) {
                currentimage.setUser(image.getUser());
            }

            return imageRepository.save(currentimage);
        } else {
            throw new ResourceNotFoundException("Not authorized");
        }

    }

    @Override
    public void delete(long id) {
        // Confirm image exists
        findImageById(id);

        imageRepository.deleteById(id);

    }

    @Override
    public void deleteAll() {
        imageRepository.deleteAll();
    }
}
