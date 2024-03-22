# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

- **Updated `mainscreen.html` Title Element**: Changed the title tag in the `mainscreen.html` file to "Cellphone Shop" in line 14.
- **Updated `mainscreen.html` Heading Element**: Modified the h1 tag inside the div with the class "container" to "Cellphone Sanctuary" in line 19.



### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
- **Created `about.html`  file**: Created file in the templates directory.
- **`about.html`**: added title 'About' on line 8.
- **`about.html`**: added a div with class container on line 11.
- **`about.html`**: added a paragraph on line 15.
- **`about.html`**: added a paragraph on line 17.
- **`about.html`**: added a paragraph on line 18.
- **`about.html`l**: added an anchor element to return to main screen on line 21.

- **Created `AboutController.java`** class : Created class in the controllers directory.
- **`AboutController.java`** class : Added a Controller annotation on line 6.
- **`AboutController.java`** class : Added a GetMapping annotation on line 9.
- **`AboutController.java`** class : Created a method to handle requests for the About page on line 10.
- **`AboutController.java`** class : Added a return statement on line 13.

- **`mainscreen.html`**: Added a button that links to the about page on line 20.

### E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

- **`BootStrapData.java`**: Added an InhousePartRepository variable on line 35. 
- **`BootStrapData.java`**: Added the argument `inhousePartRepository` to the constructor method `BootStrapData on line 36.
- **`BootStrapData.java`**: The constructor was updated to include the assignment `this.inhousePartRepository = inhousePartRepository;` on line 41. This change adds the `inhousePartRepository` parameter to the constructor signature and initializes the corresponding field.
- **`BootStrapData.java`**: Implemented a conditional statement on line 64 to display 5 parts on the main screen if `partRepository` equals 0.
- **`BootStrapData.java`**: Created 5 different parts and save them in either `outsourcedPartRepository` or `inhousePartRepository` from line 65 to 106.
- **`BootStrapData.java`**: Implemented a conditional statement on line 125 to display 5 products on the main screen if `partRepository` equals 0.
- **`BootStrapData.java`**: Created 5 instances of Products from line 126 to 130.
- **`BootStrapData.java`**: Used the `save()` method to store the 5 Product instances from line 131 to 135.



### F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:

- **`mainscreen.html`**: Created an Html form with the action set to /products/buy and the method set to POST on line 87.
- **`mainscreen.html`**: Included a hidden input field inside the form to send the product ID to the server on line 88.
- **`mainscreen.html`**: Added a button inside the form with the text "Buy Now". This button will submit the form to initiate the buy process on line 89.

- **`ProductServiceImpl.java`**: Implemented a buyProduct method on line 70, that takes the ID of the product (productId) as input and uses it to retrieve the corresponding product entity from the database using the productRepository.
- **`ProductServiceImpl.java`**: Added a conditional statement on line 72 to verify if the retrieved product exists (not null) and if its inventory is greater than zero on line 74. This ensures that the product is available for purchase and has sufficient inventory.
- **`ProductServiceImpl.java`**: Added a statement that  If the product is available, the method decrements its inventory level by one using the `decrementInventory()` method of the `Product` entity on line 75.
- **`ProductServiceImpl.java`**: Added a statement that update database, after decrementing the inventory, the method saves the updated product entity back to the database using the save() method of the productRepository.
- **`ProductServiceImpl.java`**: Added a return status that returns true if the purchase was successful (product available and inventory decremented), and false otherwise.

- **`ProductService.java`**: Added a buyProduct declaration in the ProductService interface on line 21.

- **`Product.java`**: Added a method named `decrementInventory`  on line 50, this method is responsible for reducing the inventory count of the product entity by 1 unit.

- **Created `ProductController.java`** class : Created class in the controllers directory.
- **`ProductController.java`** : Added a Controller annotation on line 11.
- **`ProductController.java`** : Added a GetMapping annotation on line 12.
- **`ProductController.java`** : Included the `@Autowired` annotation. This annotation is used to inject an object of the `ProductService` class into the `ProductController`, enabling it to perform the business logic associated with purchasing products on line 14 and 15.
- **`ProductController.java`**: Included the `@PostMapping` annotation on line 18. This endpoint handles the purchase of a product.
- **`ProductController.java`**: Implemented `buyProduct` method, this method is mapped to the `/products/buy` endpoint and is executed when a POST request is received and it takes the  productId parameter on line 19..i9l9oo
- **`ProductController.java`**: Added a conditional statement. If the purchase is successful, the method returns (`successPage`), which displays a success message to the user on line 21.
- **`ProductController.java`**: Added an else statement. If the purchase fails (product out of stock), the method returns error page (`errorProduct`), which notifies the user of the failure.

- **`successPage.html`**: Created the file successPage in the resources/templates directory that contain a paragraph element with a success message inside . 
- **`successPage.html`**: Added a div with a class container on line 11.
- **`successPage.html`**: Added a heading that contain the name of the shop on line 12.
- **`successPage.html`**: Added a paragraph element with a success message on line 13.
- **`successPage.html`**: Added an anchor element on line 14 to return to main screen.

- **`errorProduct.html`**: Created the file errorProduct in the resources/templates directory that contain a paragraph element with a fail message inside .
- **`errorProduct.html`**: Added a div with a class container on line 11.
- **`errorProduct.html`**: Added a heading that contain the name of the shop on line 12.
- **`errorProduct.html`**: Added a paragraph element with a fail message on line 13.
- **`errorProduct.html`**: Added an anchor element on line 14 to return to main screen.


### G.  Modify the parts to track maximum and minimum inventory by doing the following:

*  Add additional fields to the part entity for maximum and minimum inventory.
*  Modify the sample inventory to include the maximum and minimum fields.
*  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
*  Rename the file the persistent storage is saved to.
*  Modify the code to enforce that the inventory is between or at the minimum and maximum value.


### H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:

* Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
* Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
* Display error messages when adding and updating parts if the inventory is greater than the maximum.


### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.


### J.  Remove the class files for any unused validators in order to clean your code.
