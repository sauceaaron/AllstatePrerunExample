curl -u $SAUCE_USERNAME:$SAUCE_ACCESS_KEY \
-X POST \
-H 'Content-Type: application/octet-stream' \
https://saucelabs.com/rest/v1/storage/YOUR_USERNAME/test_file_name?overwrite=true \
--data-binary '@src/main/resources/set-akamai-in-hosts-windows.bat'