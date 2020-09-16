# Image Gallery API  

REST API which manages the Image Gallery App backend

## Features
- Manages user authentication and roles based authorization
- Stores, retrieves, updates, and deletes user selected image records

## Application Arichtecture
The application backend uses a microservices architecture to keep features modular and reusable for different applications. Client access is through a single page application.

The main application components are:

- [Image Search Engine](https://github.com/wmemorgan/image-search-api-v2): custom search api, built in NodeJS, which uses the Google Search Engine to query images
- [Image Gallery Backend](https://github.com/wmemorgan/image-gallery-app-backend): api, built in Java, which manages user security and image library
- [Image Gallery Client](https://github.com/wmemorgan/image-gallery-app-frontend): frontend, buit in React, which performs user registration, image searches, and library updates

## Demo Client Site
- [Image Gallery Frontend](https://wme-image-gallery.netlify.app/)
- [Source Code](https://github.com/wmemorgan/image-gallery-app-frontend)

## Installation
- Clone this repo to your local machine using `https://github.com/wmemorgan/image-gallery-app-backend.git`

## Setup and Usage
- Open the repo directory in IntelliJ or the IDE of your choice.
- Download the project dependencies specified in the Maven configuration file (pom.xml).

## Documentation
- [Developer Documentation](https://wilfredmorgan.com/image-gallery-app-backend/index.html)
- [REST API Specifications](https://wme-image-gallery-api.herokuapp.com/swagger-ui.html)

## License
[MIT](https://github.com/wmemorgan/image-gallery-app-backend/blob/master/LICENSE)
