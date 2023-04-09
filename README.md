# Blog Application

I have developed this REST API for an Blog Application. This API performs all the fundamental CRUD operations of any Blog Application with user validation at every step.



## Installation & Run

run this command in your pc
```bash
  git clone https://github.com/itsmedudes/adobe.git
```

Before running the API server, you should update the database config inside the application.properties file.
Update the port number, username and password as per your local database config.
```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3307/adobe;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

## API Root Endpoint

`containers-us-west-203.railway.app`

`https://localhost:8888/`

`http://localhost:8888/swagger-ui/index.html`

## API Module Endpoints

### User Module


* `POST /users` : Register ( Create new Account ) 
* `PUT /users/{user_id}` : Update the User name and Bio by `user_id`
* `DELETE /users/{user_id}` : Delete User by `user_id`
* `GET /users/{user_id}` : Getting a particular User Details by `user_id`
* `GET /analytics/users` : Getting total number of User
* `GET /analytics/users/top-active` 5 Top Active Users



### Post Module

* `POST /posts` : Create a new Post 
* `PUT /posts/{post_id}` : Update the Content by `post_id`
* `DELETE /posts/{post_id}` : Delete a Post by `post_id`
* `POST /posts/{post_id}/like` :  Update a Like value by `post_id`
* `POST /posts/{post_id}/unlike` : Update a Like value by decreasing 1 by`post_id`
* `GET /posts/{post_id}` :  Getting a particular post by `post_id`
* `GET /analytics/posts` : Getting total number of Post
* `GET /analytics/posts/top-active` Top 5 Most liked Post

### Sample API Response
Request Body for User

```
{
    "name" : "jhon Doe",
    "email" : "jhonDoe@gmail.com",
    "bio" : "Full Stack Web Developer"
}

```
Response Body

```
{
    "id": 1,
    "name": "jhon Doe",
    "email": "jhonDoe@gmail.com",
    "bio": "Full Stack Web Developer",
    "created_at": "2023-04-09T17:10:18.446+00:00",
    "updated_at": null
}
```

Request Body for Post

```
{
  "user_id": 2,
  "content": "Once upon a time, there was a beautiful girl named Emma. She lived in a small town and worked in a local bakery. Emma was known for her sweet smile and kind heart. She had always dreamed of finding true love and living happily ever after."
}

```
Response Body

```
{
    "id": 13,
    "content": "Once upon a time, there was a beautiful girl named Emma. She lived in a small town and worked in a local bakery. Emma was known for her sweet smile and kind heart. She had always dreamed of finding true love and living happily ever after.",
    "created_at": "2023-04-09T17:14:17.344+00:00",
    "upated_at": null,
    "likes": 0
}
```
