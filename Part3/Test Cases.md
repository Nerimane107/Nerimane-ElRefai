# Possible Test cases to test Login feature :

### Validate successful Login :
  * I enter correct username "standard_user" and correct password "secret_sauce" and press Login.
  * I should be able to see the user products page.
### Validate unsuccessful Login :
 * I enter incorrect username "Username" and incorrect password "password" and press Login.
 * I should be presented with unsuccessful login message.
### Validate unsuccessful login with empty input fields :
* I enter nothing in both fields aand press Login.
* I should see a message requiring me to enter input fields.

### Validate unsuccessful login with an empty username input field :
* I enter nothing in the username field.
* I enter any password for example "secret_sauce" and press Login.
* I should see a message requiring me to enter a username.

### Validate unsuccessful login with an empty password input field : 
 * I enter username "standard_user".
 * I enter nothing in the password field and press Login.
 * I should see a message requiring me to enter a password.
   
### Validate locked login :
* I enter username "locker_out_user" and password "secret_sauce" and press Login.
* I should see a message explaining that this user is locked out.

### Validate performance glitch :
* I enter ysername "performance_glitch_user" and password "secret_sauce" and press Login.
* I should be able to see the user products page but after a long time.
