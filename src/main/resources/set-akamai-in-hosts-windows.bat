echo prerun executable should add to hosts file
echo 184.31.101.219 purchase-stest.allstate.com > %temp%\temphosts.txt
type C:\WINDOWS\system32\drivers\etc\hosts >> %temp%\temphosts.txt
copy /Y %temp%\temphosts.txt C:\WINDOWS\system32\drivers\etc\hosts
type C:\WINDOWS\system32\drivers\etc\hosts
nslookup purchase-stest.allstate.com.edgekey-staging.net