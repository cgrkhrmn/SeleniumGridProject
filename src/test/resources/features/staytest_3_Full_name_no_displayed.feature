@Staytest_3 
Feature: Check the full name 

Description: Full name which was entered while signing up is not displayed correctly at the
profile of the customer. Currently the system is displaying both first and last
names in the First name field and leaving the Last name field blank. Refer to
the screen shot for more information. User's first name should be displayed in
the First name field and the user's last name should be displayed in the Last
name field. 

Scenario: User's name information should be displayed correctly 
Given  the user is on the FourStay sign up dialog 
When  the user enters enter first name "John" and last name "Smith" 
And  the user enters any unregistered email and password 
And  click on the Sign up button 
When  the user goes the account details page 
Then  first name "John" and last name "Smith" should be displayed in the right
