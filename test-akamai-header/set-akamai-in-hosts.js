var webdriverio = require('webdriverio');
var SAUCE_USERNAME = process.env.SAUCE_USERNAME;
var SAUCE_ACCESS_KEY = process.env.SAUCE_ACCESS_KEY;

var options = { 
	desiredCapabilities: {
		platform: "Windows 7",
		browerName: "Chrome",
		version: "latest",
		name: "should set Akamai in hosts file with prerun executable",
		extendedDebugging: true,
		prerun: "sauce-storage:set-akamai-in-hosts-windows.bat"
	},
	protocol: "https",
	host: SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com",
	port: "443",
	path: "/wd/hub"
}

webdriverio
	.remote(options)
	.init()
	.url("https://purchase-stest.allstate.com/onlineshopping/welcome")
	.getTitle().then(function(title) {
		console.log('got title: ' + title);
	})
	.end();