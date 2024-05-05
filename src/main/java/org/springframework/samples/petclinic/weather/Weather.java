package org.springframework.samples.petclinic.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private Integer temp;
    private WeatherType weatherType;
}
