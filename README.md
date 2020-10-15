# Challenge Wolox

_Exercise carried out for Wolox_


## Routes API (https://jsonplaceholder.typicode.com/)
* (GET) "http://localhost:8080/api/users/" Get all user
* (GET) "http://localhost:8080/api/users/{idUser}" Get one user
-------------
* (GET) "http://localhost:8080/api/albums/" Get all album
* (GET) "http://localhost:8080/api/albums/{idAlbum}" Get one album
* (GET) "http://localhost:8080/api/albums/user/{idUser}" Get all the user's albums
-------------
* (GET) "http://localhost:8080/api/comments/" Get all comments
* (GET) "http://localhost:8080/api/comments/{idComment}" Get one comment by id
* (GET) "http://localhost:8080/api/comments/name/{name}" Get one comment by name
* (GET) "http://localhost:8080/api/comments/user/{idUser}" Get comment's by user id
-------------
* (GET) "http://localhost:8080/api/photos/" Get all photos
* (GET) "http://localhost:8080/api/photos/{idPhoto}" Get one photo
* (GET) "http://localhost:8080/api/photos/user/{idUser}" Get all photos by user id

## Routes API (Spring APP | MySQL)

* (GET) "http://localhost:8080/api/manager/albums/" Get all albums
* (GET) "http://localhost:8080/api/manager/albums/{idAlbum}" Get one album 
* (POST) "http://localhost:8080/api/manager/albums/" 
```
        {
            "title": ""
        }
```
-------------
* (GET) "http://localhost:8080/api/manager/users/" Get all users
* (GET) "http://localhost:8080/api/manager/users/{idUser}" Get one user
* (GET) "http://localhost:8080/api/manager/users/read/{idAlbum}" Get all users with read permission for an album 
* (GET) "http://localhost:8080/api/manager/users/write/{idAlbum}" Get all users with write permission for an album
* (PUT) "http://localhost:8080/api/manager/users/{idUser}/albums/" Update a user permissions for an album
```
{
            "album": {
                "id": 0
            },
            "read": false,
            "write": false
}
```
* (POST) "http://localhost:8080/api/manager/users/" Create user
```
        {
            "name": "",
            "username": "",
            "phone": "",
            "email": "",
            "website": ""
        }
```
-------------
* (GET) "http://localhost:8080/api/manager/permits/" Get all permits
* (GET) "http://localhost:8080/api/manager/permits/{idPermits}" Get one permit
* (PUT) "http://localhost:8080/api/manager/permits/{idPermits}/" Update a permits 
```
        {
            "read": true,
            "write": false,
            "album": {
                "id": 0
            },
            "user": {
                "id": 0
            }
        }
```
* (POST) "http://localhost:8080/api/manager/permits/" Create permits
```
        {
            "read": true,
            "write": false,
            "album": {
                "id": 0
            },
            "user": {
                "id": 0
            }
        }
```
