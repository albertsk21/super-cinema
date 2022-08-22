package project.SuperCinema.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import project.SuperCinema.utils.FileUtil;
import project.SuperCinema.utils.FileUtilImpl;
import project.SuperCinema.dtos.MovieDtoJson;
import project.SuperCinema.entities.Movie;

@Component
public class ConfigurationApplication {

    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }
    @Bean
    public FileUtil fileUtil(){
        return new FileUtilImpl();
    }
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<MovieDtoJson, Movie>() {
            @Override
            protected void configure() {
                map().setReleaseDate(null);
            }
        });
        return modelMapper;
    }

    @Bean
    public WebMvcConfigurer configure(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://127.0.0.1:5500","http://localhost:3000","http://localhost:8000")
                        .allowedMethods("GET","POST","PUT");
            }
        };
    }
}
