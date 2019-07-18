Feature:
	Scenario:
		Given user is on "https://www.google.com" page
		When user enters "star trek" in search box
		Then user should be on page with title that contains "star trek" 
