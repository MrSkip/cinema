package com.countrycinema.ua.config.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class GlobalConfiguration {

    @Bean
    public ModelMapper configure() {
        ModelMapper mapper = new ModelMapper();

//        TypeMap<FilmRequestDTO, Film> typeMap = mapper.createTypeMap(FilmRequestDTO.class, Film.class);
//        typeMap.addMapping(FilmRequestDTO::getId, Film::setId_);

//        TypeMap<IdDT, IdComponentLong> typeMap
//                = modelMapper.createTypeMap(IdDTO.class, IdComponentLong.class)
//                .addMapping(IdDTO::getId, (destination, value) -> {
//                    destination.setIdBuild(2L);
//                });

//        typeMap.includeBase(FilmRequestDTO.class, Film.class);

        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PACKAGE_PRIVATE)
                .setMethodAccessLevel(Configuration.AccessLevel.PACKAGE_PRIVATE)

                .setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper;
    }
}
