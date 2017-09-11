@database
Feature: FourStay db testing 

Background: 
	Given I am on the fourstay homepage 
	Given I am on the fourstay login dialog 
	
Scenario Outline: Verify user information 
	When I am entering "<email>" and "<password>" 
	And  I click login button 
	And I click Edit Profile 
	And I capture first n, last n, email, phone 
	And I connect database and capture first n, last n, email, phone 
	Then Verify the info from UI and DB are the same 
	
	
	Examples: 
		| email                 | password |
		| sking@testmail.com    | password |
		| dlorentz@testmail.com | password |
		| daustin@testmail.com  | password |
		| isciarra@testmail.com | password |	
		| imikkili@testmail.com | password |
		| jnayer@testmail.com	| password |
		| shiggins@testmail.com | password |
		| acabrio@testmail.com  | password |
		| rperkins@testmail.com | password |
		| doconnel@testmail.com | password |
		
