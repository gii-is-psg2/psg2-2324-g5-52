package org.springframework.samples.petclinic.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitWeather;

public class WeatherService {
    private static Weather getWeather() {
        Weather weather = new Weather();
        weather.setTemp(getRandomWeather());
        weather.setWeatherType(getWeatherType());
        return weather;
    }

    private static Integer getRandomWeather() {
        Random rand = new Random();
        //Random number between 20 and 30
        Integer randomNum = rand.nextInt((30 - 20) + 1) + 20;
        return randomNum;
    }

    private static WeatherType getWeatherType() {
        Random rand = new Random();
        int randomNum = rand.nextInt(100);

        if(randomNum < 50) {
            return WeatherType.SUNNY;
        } else if(randomNum < 80) {
            return WeatherType.CLOUDY;
        } else {
            return WeatherType.RAINY;
        }
    }

    private static VisitWeather groupVisitWeather(Visit visit) {
        VisitWeather visitWeather = new VisitWeather();
        visitWeather.setVisit(visit);
        visitWeather.setWeather(getWeather());
        return visitWeather;
    }

    public static List<VisitWeather> groupVisitWeathers(List<Visit> visits) {
        List<VisitWeather> visitWeathers = new ArrayList<>();
        for (Visit visit : visits) {
            visitWeathers.add(groupVisitWeather(visit));
        }
        return visitWeathers;
    }

}
