# Task 1 👾
1. Create collection of requests in Postman with name `BookStore API`
   * Read how create collection of requests in Postman
2. Read carefully about HTTP endpoints in `bookstore` service: [README](https://github.com/vitalii-honchar/bookstore/blob/main/server/README.md)
   * Read about HTTP Basic Authorization*
   * Read how use HTTP Basic Authorization in Postman 
3. Create and execute requests
   * Read book requests
     * `GET /books` - you will receive list of books.
     * `GET /books/{id}` - take id from previous request and read book entity with given id.
   * Read authors requests
     * `GET /authors` - you will receive list of authors.
     * `GET /authors/{id}` - take id from previous request and read author entity with given id.
4. All requests which you execute you must save in collection `BookStore API`
5. Create new author
   * `PUT /authors` with header `Content-Type: application/json` and body: `{"firstName": "Tester", "lastName": "Tester"}`.
6. Create new book
   * `PUT /books` with header `Content-Type: application/json` and body: `{ "name": "Test", "description": "Test description", "authorId": {id}}`. 
     Where id is id of author which you created in previouse request. 
7. Update created book
   * `POST /books/{id}` with header `Content-Type: application/json`, id is id of created book from previous request and body: `{ "name": "Test 34" }`
8. Wow. What happens? Why you received 500 - Internal error? May be your developer is a cock? ![img.png](img.png)
9. Let's create your first bug
   * Read about how create bug report: [How To Write A Good Bug Report?](https://www.softwaretestinghelp.com/how-to-write-good-bug-report/)
   * Open your favorite text editor and write this:
    ```
   Bug 1 (number of bug)
   
   ER (expected result)
   Update book with provided id and receive updated book in response
   
   AR (actual result)
   500 Internal Server Error 
   
   STR (step to reproduce)
   POST /books/{id}
   Content-Type: application/json
   { "name": "Test 34" }
   ```
   * Contact your developer with bug report.
10. Congratulations! You completed your theory of first chapter. Please complete exercises to complete first chapter. 

## Exercises
1. Create a new book with specified author id. In the response you must receive full book information. What happens wrong?
Please create a bug report.
2. Try add new tag for created book. What happens wrong? Please create a bug report.
3. Try create a new book without author id. You can't create book without author. What happens wrong? Please create a bug report.
4. Try edit exists author. What happens wrong? 
5. Read how write feature requests and bug reports: [Writing feature requests and bug reports that get results](https://ddbeck.com/bug-reports-that-get-results/)
