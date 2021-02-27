# Book store Back-End
This is back end for learn basic skills for test REST API.

## REST service description
This is book store which gives possibility:
* get list of books
* get book author
* read author information
* read book tags for quick search 

### Book store entities

| Entity | Description |
| ------ | ----------- | 
| Author | Author of a book |
| Book   | Book for sell in a store |
| BookTag | Book tag for quick search book in a store |
| User    | Authorized user in service                |

### REST API Endpoints

**Authorization**

Use HTTP Basic authorization.
* username - `user`
* password - `user`

**HTTP Book endpoints**
* `GET /books` - get list of books
  * `page` - parameter which indicates page of entities. Max entities per page - 20.
* `GET /books/{id}` - get book by id
  * `id` - path parameter which indicates id of book.
* `PUT /books` - create new book
  * body - json representation of book
* `POST /books/{id}` - update book by id
  * body - json representation of book
    
    
**HTTP Author endpoints**
* `GET /authors` - get list of authors
  * `page` - parameter which indicates page of entities. Max entities per page - 20.
* `GET /authors/{id}` - get author by id]
  * `id` - path parameter which indicates id of author.
* `PUT /authors` - create new author
  * body - json representation of author
