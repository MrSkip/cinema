package com.countrycinema.ua.config.jackson;

import com.countrycinema.ua.config.jackson.converter.JSR310LocalDateDeserializer;
import com.countrycinema.ua.config.jackson.converter.JSR310LocalDateTimeDeserializer;
import com.countrycinema.ua.config.jackson.converter.JSR310LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.time.*;

@Configuration
public class JacksonConfiguration {

    @Bean
    @Primary
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(OffsetDateTime.class, JSR310LocalDateTimeSerializer.INSTANCE);
        module.addSerializer(ZonedDateTime.class, JSR310LocalDateTimeSerializer.INSTANCE);
        module.addSerializer(LocalDateTime.class, JSR310LocalDateTimeSerializer.INSTANCE);
        module.addSerializer(Instant.class, JSR310LocalDateTimeSerializer.INSTANCE);
        module.addDeserializer(LocalDate.class, JSR310LocalDateDeserializer.INSTANCE);
        module.addDeserializer(LocalDateTime.class, new JSR310LocalDateTimeDeserializer());
        Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder = new Jackson2ObjectMapperBuilder()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .findModulesViaServiceLoader(true)
                .modulesToInstall(module);
        return new MappingJackson2HttpMessageConverter(jackson2ObjectMapperBuilder.build());
    }

}