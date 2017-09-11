@Staytest_37 
Feature: Search result list 
	User specifies location, day in, day out and number of beds while searching for the stay. 
The result page gives a list of stays based on search criteria. 
Only those stays that meet all searching criteria should be listed on result page.

Scenario: Searching specific date range and collect the result 
	Given user is on the fourstay homepage 
	When user specify the location,day in, day out and number of beds 
	And user click search 
	Then Only those stays that meet all searching criteria should be listed on result page 
	
	
	
	
	
	
	
