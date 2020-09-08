-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspectionForFile
DELETE
FROM userroles;

DELETE
FROM users;

DELETE
FROM roles;

INSERT INTO USERS(USERID, USERNAME, FIRSTNAME, LASTNAME, PRIMARYEMAIL, PASSWORD, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
     VALUES (1, 'admin','Admin','User','admin@mail.com','$2y$12$Xf.lnWwVVCcexh/CRlQwou6Ma4pFIKJlQjOHf0eTwozjejQrpGtVa','SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (2, 'gkaplan','George','Kaplan','george@mail.com','$2y$12$oCvu/soDlKYCOeWAK51V3OfiY/xRhg/8a.EwuNZIjfCB.yVVBnOru','SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (3, 'srogers','Steve','Rogers','srogers@example.com','$2y$12$XKbrsDIxH3ta/zZwBnR3w.cy5/epthXbWFx68kBM0e6twjotOWuBi','SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (4, 'hpotter', 'Harry', 'Potter','harry-potter@hogwarts.edu','$2y$12$VZc0OZa4iFuBThv2.LqLxupxBLAo2Kftneurw0aN.8p6fD2D/WR4i','SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (5, 'demo', 'Demo', 'User','demo@example.com','$2y$12$/6FkYon37/q1KTjGLpqbWuyqBDgNhs5.tKTAPKACxBv9v2tCTNw/e','SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO ROLES(ROLEID, NAME, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
     VALUES (1, 'ADMIN', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (2, 'USER',  'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO USERROLES(USERID, ROLEID, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
     VALUES (1, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (2, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (2, 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (3, 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (4, 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (5, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
            (5, 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO IMAGES(IMAGEID, IMAGEURL, DESCRIPTION, THUMBNAILURL, USERID, CREATEDBY, CREATEDDATE, LASTMODIFIEDBY, LASTMODIFIEDDATE)
    VALUES (1, 'https://lithub.com/wp-content/uploads/sites/3/2019/08/north-by-northwest-still-feat.jpg','How North by Northwest Changed Cinema Forever | CrimeReads','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXDhZybrz5kWOPv1s03jET-tXUWOG7Kk51zCS5Py8xJrZz4qRfiiEV4ts&s', 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (2, 'https://secure.i.telegraph.co.uk/multimedia/archive/03264/northbynorthwest_3264989b.jpg', 'North by Northwest, review: "magnificent"', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_u2gKhQt9JePXXcMohIhI82-g213IwQvWLW720fEYnymxnpBcYa5mZw&s', 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (3, 'https://lcnme.com/wp-content/uploads/2019/03/harry-potter-2-color.jpg', 'Complete Harry Potter Series of Films at Lincoln Theater - The ...', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEhUpbqyXKMe2_j6W6YOcwX1GTJiu1mbekMeAMVyruKYxRq3RApgC47xw&s', 4, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
           (4, 'https://gomerblog.com/wp-content/uploads/2018/05/Emergency-Medicine.jpg', 'Medical Specialties as Harry Potter Characters | GomerBlog', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFe3vP0r0kNUYY8FoaRiU40m7Roz1oxegWEMoJII6392ZroD5nWG3KEd0&s', 4, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);


alter sequence hibernate_sequence restart with 15;