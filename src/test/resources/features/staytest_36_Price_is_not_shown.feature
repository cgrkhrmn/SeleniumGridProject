@Staytest_36 
Feature: Price is not shown on the result page 
	As a user, Ishould be able to see a price for each search result

Scenario: Validate if results has a price tag 
	Given as user, I am on the fourstay homepage 
	When i log in and make a search 
	And when i see the results 
	Then each result should have a price tag