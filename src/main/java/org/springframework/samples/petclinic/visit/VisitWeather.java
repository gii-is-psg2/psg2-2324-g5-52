package org.springframework.samples.petclinic.visit;

import org.springframework.samples.petclinic.weather.Weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitWeather {
    Visit visit;
    Weather weather;
}
