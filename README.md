# url-shortener-iswacademy-victor-abidoye
A URL Shortening Service built with Java Spring, it uses redis as the in-memory storage leveraging the pub/sub feature on redis for message queues.

-----

# URL Shortener

    POST /api/v1/url
    
## Description
Shorten a long URL 

## Headers
**Content-Type** : application/json

## Body

    {
	"longUrl":"https://www.google.com/search?q=using+redith+sql+server&rlz=1C1GCEA_enNG819NG819&oq=using+sql+with+redis&aqs=chrome.1.69i57j0.6347j0j4&sourceid=chrome&ie=UTF-8"
    }

## Result
    {
    "code": "201",
    "description": "Successfully Created",
    "longUrl": "https://www.google.com/search?q=using+redith+sql+server&rlz=1C1GCEA_enNG819NG819&oq=using+sql+with+redis&aqs=chrome.1.69i57j0.6347j0j4&sourceid=chrome&ie=UTF-8",
    "shortUrl": "http://localhost:8080/NDY1Qk"
    }
    
 
 # Expand URL
 
    GET /api/v1/{url}

## Description
Shorten a long URL

## Parameters
**shtUrl** : http://localhost:8080/NDY1Qk

## Result
    {
    "code": "200",
    "description": "Found",
    "errors": null,
    "longUrl": "https://www.google.com/search?q=using+redith+sql+server&rlz=1C1GCEA_enNG819NG819&oq=using+sql+with+redis&aqs=chrome.1.69i57j0.6347j0j4&sourceid=chrome&ie=UTF-8",
    "shortUrl": "http://localhost:8080/NDY1Qk"
    }
    
 
 # Redirect to Original URL
    
    GET /{url}
    
 ## Description
 Redirect User to Original URL
