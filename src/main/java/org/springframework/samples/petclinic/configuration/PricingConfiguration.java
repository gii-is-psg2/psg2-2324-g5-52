package org.springframework.samples.petclinic.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.samples.petclinic.configuration.services.UserDetailsImpl;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import io.github.isagroup.PricingContext;
import jakarta.security.auth.message.AuthException;

@Component
public class PricingConfiguration extends PricingContext {


    @Autowired
    private UserService userService;

    @Value("${petclinic.app.jwtSecret}")
    private String jwtSecret;

    @Override
    public String getConfigFilePath() {
        return "pricing/pricing.yml";
    }

    @Override
    public String getJwtSecret() {
        return jwtSecret;
    }

    @Override
    public Map<String, Object> getUserContext() {

        try{
            return userService.findUserContext();
        }
        catch(Exception e){
            System.out.println("Anonymous user");
            return new HashMap<>();
        }
    }

    @Override
    public String getUserPlan() {
        try{
            return userService.findUserPlan();
        }
        catch(Exception e){
            System.out.println("Anonymous user");
            return "BASIC";
        }
    }

    public Object getUserAuthorities(){
        Map<String, String> authorities = new HashMap<>();
        authorities.put("role", "OWNER");
        return authorities;
    }

    @Override
    public Boolean userAffectedByPricing(){
        Authentication userAuth = SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userDetails = (UserDetailsImpl) userAuth.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
            .collect(Collectors.toList());

        return roles.contains("OWNER");

    }
}
