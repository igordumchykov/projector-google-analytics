# Google Analytics Publisher
- gets weather details for particular city
- sends weather parameters to google analytics for further analysis

# Prerequisites
- java (17.0.4-oracle)
- Environment variables: WEATHER_API_KEY, GA_ID, GA_API_KEY, CLIENT_ID

# Run
- build application ```./gradlew clean build```
- run application ```./gradlew bootRun```

# Weather service details

## Request
```shell
curl --location 'http://api.weatherapi.com/v1/current.json?key=${API_KEY}&q=Kiev'
```

## Response
```shell
{
    "location": {
        "name": "Kiev",
        "region": "Kyyivs'ka Oblast'",
        "country": "Ukraine",
        "lat": 50.43,
        "lon": 30.52,
        "tz_id": "Europe/Kiev",
        "localtime_epoch": 1688491622,
        "localtime": "2023-07-04 20:27"
    },
    "current": {
        "last_updated_epoch": 1688490900,
        "last_updated": "2023-07-04 20:15",
        "temp_c": 24.4,
        "temp_f": 75.9,
        "is_day": 1,
        "condition": {
            "text": "Sunny",
            "icon": "//cdn.weatherapi.com/weather/64x64/day/113.png",
            "code": 1000
        },
        "wind_mph": 5.8,
        "wind_kph": 9.4,
        "wind_degree": 90,
        "wind_dir": "E",
        "pressure_mb": 1016.0,
        "pressure_in": 30.0,
        "precip_mm": 0.0,
        "precip_in": 0.0,
        "humidity": 42,
        "cloud": 12,
        "feelslike_c": 25.1,
        "feelslike_f": 77.2,
        "vis_km": 10.0,
        "vis_miles": 6.0,
        "uv": 6.0,
        "gust_mph": 11.0,
        "gust_kph": 17.6
    }
}
```

# Google analytics details

## Request
```shell
curl --location 'https://www.google-analytics.com/mp/collect?api_secret=${API_SECRET}&measurement_id=${MEASUREMENT_ID}' \
--header 'Content-Type: application/json' \
--data '{
    "client_id": "BF52DF9A-E1DB-44D1-842E-A8D37B5A969C",
    "events": [{
        "name": "kyiv_weather",
        "params": {
            "temperature": 29.9,
            "wind": 2.2,
            "pressure": 30.03,
            "humidity": 32,
            "timestamp": 1688575072405
        }
    }]
}'
```

