Feature: Displaying user information 

Background: 
	Given I am on the fourstay login dialog 
	
	
Scenario: Verify host user information 

	And I enter email "testscooper@test.mail.com" 
	And I enter password "password" 
	When I click on the login button 
	Then the user name should be "Sheldon Cooper" 
	
Scenario: Verify host user information 
	And I enter email "testafowler@test.mail.com" 
	And I enter password "password" 
	When I click on the login button 
	Then the user name should be "Amy Fowler" 
@Staytest_124 
Scenario Outline: Verify host user information 
	And I enter email "<email>" 
	And I enter password "<password>" 
	When I click on the login button 
	Then the user name should be "<name>" 
	
	Examples: 
		|name				|	email						|	password		|
		|Amy Fowler			| testafowler@test.mail.com   	|    password       | 
		|Sheldon Cooper 	|testscooper@test.mail.com  	|     password    	|
		|Orlando Wolf		|	OrlandoWolf@test.mail.com	|Orlandob74cf		|
		|Lenora Ferry		|LenoraFerry@test.mail.com|	Lenoradb1d1|
#		|Charlotte Heller	|	CharlotteHeller@test.mail.com|	Charlotte6b8a2|
#		|Ethel MacGyver		|	EthelMacGyver@test.mail.com|	Ethelbb8ed|
#		|Dina Prohaska		|	DinaProhaska@test.mail.com|	Dina429c8|
#		|Jacquelyn Welch	|	JacquelynWelch@test.mail.com|	Jacquelyn2d254|
#		|Urban Keeling		|UrbanKeeling@test.mail.com|	Urban5e15f|
#		|Chad White			|ChadWhite@test.mail.com|	Chad834f6|
#		|Joelle Fay			|JoelleFay@test.mail.com|	Joelle1d25f|
#		|Ross Hane			|	RossHane@test.mail.com|	Ross867ac|
#		|Kennith Gleichner	|	KennithGleichner@test.mail.com|	Kennith25e1f|
#		|Aaliyah Terry		|AaliyahTerry@test.mail.com	|Aaliyahc0856|
#		|Rashawn Mertz		|	RashawnMertz@test.mail.com|	Rashawn36e2c|
#		|Lauryn Becker	|LaurynBecker@test.mail.com	|Laurynafeab|
#		|Issac Frami	|IssacFrami@test.mail.com	|Issac2f39f|
#		|Edward Ondricka|	EdwardOndricka@test.mail.com|	Edwardc47f3|
#		|Delphia Lakin|	DelphiaLakin@test.mail.com|	Delphia39690|
#		|Deangelo Mills|	DeangeloMills@test.mail.com	|Deangelo4a386|
#		|Arnoldo Bechtelar|	ArnoldoBechtelar@test.mail.com|	Arnoldo0e840|
#		|Kenyon Pagac	|KenyonPagac@test.mail.com|	Kenyon94f66|
		
		
