This will run a Selenium test in Sauce Labs using a prerun executable that edits the /etc/hosts file to use Akamai.

see documentation on using a prerun executable here:
https://wiki.saucelabs.com/display/DOCS/Editing+the+Virtual+Machine%27s+Host+File

It also uses the Sauce Labs extended debugging capability so you can check that the Akamai header is set.
	
see documentation on using extended debugging here:

https://wiki.saucelabs.com/pages/viewpage.action?pageId=70072943#DebuggingTestswithJavaScriptConsoleLogsandHARFiles(ExtendedDebugging)-extendedDebuggingCapability

You can run the Java example with:

	mvn clean test

You can run the Javascript example with:

	npm install && npm test

The Java example does, but the Javascript example does not upload the prerun executables directly. 
The shellscript upload-to-sauce-storage.sh will accomplish this.
	
See documentation on uploading to Sauce storage here:
https://wiki.saucelabs.com/display/DOCS/Temporary+Storage+Methods#TemporaryStorageMethods-UploadFile



