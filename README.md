# Positive-NegativeAutomationTestForPragmaticShop

Here I wrote one positive and one negative test for the test environment PragmaticShop. 

The positive test includes:

1. Open http://shop.pragmatic.bg/
2. Go to My Account -> Register
3. Make sure to insert data into every possible field (First Name, Last Name, Email, Phone, Email, Password)
4. Selecting the Newsletter is a must -> Subscribe -> Yes
5. Selecting the ‘I have read and agree to the Privacy Policy’ is also a must

The negative test includes: 

1. Open http://shop.pragmatic.bg/
2. Go to My Account -> Register
3. The data fields should be left empty – here, we have to check whether when leaving the fields empty the correct error messages will appear. Plus verification. 
