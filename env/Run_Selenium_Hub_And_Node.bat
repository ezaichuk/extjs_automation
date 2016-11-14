start  "Selenium Hub (Don't Close)"  cmd /c  "java -jar selenium-server-standalone.jar -role hub" 
start "Selenium Node (Don't Close)" cmd /c  "java -Dwebdriver.chrome.driver=chromedriver.exe -jar selenium-server-standalone.jar -role node -nodeConfig nodeconfig.json"


