package com.challenge.config;

import com.challenge.commons.ForecastResponseKryoSerializer;
import com.challenge.model.ForecastResponse;
import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HazelcastCacheConfig {

    @Bean
    public Config hazelCastConfig() {
        Config config = new Config();
        config.getSerializationConfig().getSerializerConfigs().add(
                new SerializerConfig().
                        setTypeClass(ForecastResponse.class).
                        setImplementation(new ForecastResponseKryoSerializer()));


        config.setInstanceName("hazelcast-instance")
                .addMapConfig(
                        new MapConfig()
                                .setName("configuration")
                                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                                .setEvictionPolicy(EvictionPolicy.LRU)
                                .setTimeToLiveSeconds(-1));
        return config;
    }


}
