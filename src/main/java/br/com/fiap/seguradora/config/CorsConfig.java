package br.com.fiap.seguradora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


// testar no console do chrome:
//
//    fetch("http://localhost/usuarios", {
//        method: "GET",
//                headers: {
//            "Content-Type": "application/json"
//        }
//    })
//            .then((res) => {
//        if (!res.ok) {
//            throw new Error("Network response was not ok");
//        }
//        return res.json();
//    })
//            .then((user) => {
//        console.log(user);
//    })
//            .catch((error) => {
//        console.error("Error fetching data:", error);
//    });


}
