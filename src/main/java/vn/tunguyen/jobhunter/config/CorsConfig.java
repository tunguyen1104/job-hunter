package vn.tunguyen.jobhunter.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
    
        // Specify which URLs are allowed to connect to the backend
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
    
        // Specify which HTTP methods are allowed
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    
        // Specify which headers are allowed to be sent
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));
    
        // Whether cookies are allowed to be sent
        configuration.setAllowCredentials(true);
    
        // Cache duration for pre-flight requests (in seconds)
        configuration.setMaxAge(3600L);
    
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Apply CORS configuration to all APIs
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }    
}
