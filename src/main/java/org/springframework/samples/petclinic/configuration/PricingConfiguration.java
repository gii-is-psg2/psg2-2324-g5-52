package org.springframework.samples.petclinic.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.github.isagroup.PricingContext;

@Component
public class PricingConfiguration extends PricingContext{

    @Override
    public String getConfigFilePath() {
        return "pricing/pricing.yml";
    }

    @Override
    public String getJwtSecret() {
        return "mySecret";
    }

    @Override
    public Map<String, Object> getUserContext() {
        Map<String, Object> userContext = new HashMap<>();

        return userContext;
    }

    @Override
    public String getUserPlan() {
        return "BASIC";
    }
    
    public Object getUserAuthorities(){
        Map<String, String> authorities = new HashMap<>();
        authorities.put("role", "OWNER");
        return authorities;
    }

}
