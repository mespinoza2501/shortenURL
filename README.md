# shortenURL
API for short URL

Api for Shorten can be used for whatever frontend will implement calls rest.
Was use Java, SpringBoot, PostgreSQL and  Redis for cache.
Has one resource for register the URL, one resources for getting statistics for access and one resouce for recouver for URL short.
This project use a resource really interesinting that is ApplicationEventPublish. Is  possibility for publish events assync. A manner for work assync with Spring

#run
At main directory, has a file docker-compose, You will run and he will raise service  data base