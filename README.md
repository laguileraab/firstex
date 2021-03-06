<div align="center" id="top"> 
  <a href="" rel="noopener">

 <img width=200px height=200px src="https://i.imgur.com/6wj0hh6.jpg" alt="Firstex"></a>
  &#xa0;
</div>

<h1 align="center">First exercise</h1>

<p align="center">

  <img alt="Github top language" src="https://img.shields.io/github/languages/top/laguileraab/firstex?color=56BEB8">

  <img alt="Github language count" src="https://img.shields.io/github/languages/count/laguileraab/firstex?color=56BEB8">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/laguileraab/firstex?color=56BEB8">

  <!--<img alt="License" src="https://img.shields.io/github/license/laguileraab/firstex?color=56BEB8">-->
</p>
<p align="center">
  <a href="#dart-about">About</a> &#xa0; | &#xa0;
    <a href="#white_check_mark-requirements">Requirements</a> &#xa0; | &#xa0;
    <a href="#rocket-technologies">Technologies</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-starting">Starting</a> &#xa0; | &#xa0;
  <a href="#sparkles-features">Usage</a> &#xa0; | &#xa0;
  <a href="https://github.com/laguileraab" target="_blank">Author</a>
</p>

<br>

## :dart: About ##

The goal of this project is to manage an inventory of products in a warehouse, for that i build an API that will allow to be consumed from a third party app.

## :white_check_mark: Requirements ##

You need to have Java >= 17 and Maven installed in order to run this project. Check if you have install it already with:

Java
```bash
java --version
```

Maven
```bash
mvn --version
```

## :rocket: Technologies ##

The following tools were used in this project:

- [Java](https://www.java.com/)
- [Spring](https://spring.io/)
- [H2](https://www.h2database.com/)


## :checkered_flag: Starting ##

```bash
# Clone this project
$ git clone https://github.com/laguileraab/firstex

# Access
$ cd firstex

# Install dependencies
$ mvn clean package

# Run the project
$ java -jar .\target\firstex-0.0.1-SNAPSHOT.jar

# The app server will initialize in the <http://localhost:8080>

# The database server will be available in the <http://localhost:8080/h2-ui>
```

:pushpin:
In case of database/file deleted, the app will reacreated with the necessary schema but the role  admin and operator needs to be manually added in the h2 console under /h2-ui:

```bash
INSERT INTO roles(name) VALUES('ROLE_OPERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```

## :sparkles: Usage of the app ##

## :heavy_check_mark: Spring Security and JWT ##

The app has authentication and authorization implemented with Spring Security and Management Session with Json Web Token.

## Login and roles
There are 2 roles defined and is necessary to be authenticated in the app in order to use it. For that we need to send a post request like this:

```bash
curl -X POST -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/signin' --data '{
  "username":"admin",
  "password":"supersecurepassword"
}'
```
## SignUp

For registration, ROLE_OPERARIO is the default and the role for admin is ROLE_ADMIN. The prefix ROLE_ is necessary for Spring Security.

```bash

# SignUp
curl -X POST -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/signin' --data '{
  "username": "user",
  "password":"supersecretpassword"
  "email": "contacto@users.com",
  "roles": ["ROLE_OPERARIO"]
}'

# SignOut
curl -X POST -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/signout'

```

## Authorization

Role operator has authorization for every task in the app except being able to delete a section, this is perform only by an administrator.

## :heavy_check_mark: Hibernate with H2 Database in-File ##

Database is an in-File H2 database called warehouse_data.

Available operations are the following:


-Sections (Create, Edit, Remove and List)

:triangular_flag_on_post: Important!
The type of sections accepted are the following:
 Appliance, Meat, Clothes, Hygiene (Case sensitive).

```bash
# Create section Appliance with 24 m
curl -X POST -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/add/section' --data '{
"size":"24",
"type":"Appliance"
}'

# Edit section 1
curl -X POST -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/edit/section' --data '{
  "id":"1",
  "size":"22",
  "type":"Appliance"
}'

# Remove section 1
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/rem/section/1'

# List section 1
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/list/section/1'
```

-Products (Add to a section, Remove and Filter by [Color,Lot,Envelop,Fragile,Price,Quantity and Section])

:triangular_flag_on_post: Important!
The type of envelop accepted are the following: Nylon, Plastic, Carton, Glass (Case sensitive).

```bash
# Add product to section 1
curl -X POST -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/add/product/1' --data '{
"SIZE":"12",
"COLOR":"Blue",
"PRICE":"9.99",
"FRAGILE":true,
"ENVELOP":"Nylon",
"LOT":"A7889",
"QUANTITY":"22"
}'

# Add products to section 1
curl -X POST -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/add/products/1' --data '[{
"size":"12",
"color":"Blue",
"price":"97.99",
"fragile":false,
"envelop":"Nylon",
"lot":"A7889",
"quantity":"22"
},
{
"size":"12",
"color":"Yellow",
"price":"97.99",
"fragile":false,
"envelop":"Nylon",
"lot":"A7889",
"quantity":"22"
}]'

# Remove product
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/rem/product/53'

# List Products
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/list/products'

# Filter by Color Blue
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/list/products/color/blue'

# Filter by Lot B7889
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/list/products/lot/B7889'

# Filter by Envelop Types Admited {Nylon,Plastic,Carton,Glass}
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/list/products/envelop/Nylon'

# Filter by Fragile True | False
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/list/products/fragile/true'

# Filter by Price 9.99
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/list/products/price/9.99'

# Filter by Range Price Min-Max
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/list/products/price/9.95-99'

# Filter by Quantity 20
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/list/products/quantity/20'

# Filter by Section 1
curl -X GET -H 'Content-Type: application/json' -i 'http://127.0.0.1:8080/list/products/section/1'

```

## :heavy_check_mark: Spring MVC ##

## ?????? Authors <a name = "authors"></a>

- [@laguileraab](https://github.com/laguileraab) - Idea & Initial work

Made with :heart: by <a href="https://github.com/laguileraab" target="_blank">Leonardo Aguilera Blanco</a>

&#xa0;

<a href="#top">Back to top</a>
