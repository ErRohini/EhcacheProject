package com.devtalkers.hibernate2levelcache;

import java.time.Duration;

//import org.ehcache.config.CacheConfiguration;
//import org.ehcache.config.builders.CacheConfigurationBuilder;
//import org.ehcache.config.builders.ExpiryPolicyBuilder;
//import org.ehcache.config.builders.ResourcePoolsBuilder;
//import org.ehcache.config.units.MemoryUnit;
//import org.ehcache.jsr107.Eh107Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devtalkers.hibernate2levelcache.entity.Person;
@Configuration
public class CustomCacheManager {
	

	@Bean
    public CacheManager EhcacheManager() {
		
		/* Key Level Caching */
	
  CacheConfiguration<String, Person> cachecConfig = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class,
                		Person.class,
                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                                .offheap(10, MemoryUnit.MB)
                                .build())
                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(10)))
                .build();

        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();

        javax.cache.configuration.Configuration<String, Person> configuration = Eh107Configuration.fromEhcacheCacheConfiguration(cachecConfig);
        cacheManager.createCache("cacheStore", configuration);
        
       javax.cache.Cache<String, Person>  cache =cacheManager.getCache("cacheStore",String.class,Person.class);
       Person person=new Person();
       person.setId(1);
       person.setName("Srushti");
       person.setAge(12);
       cache.put("person1",person);
       
      Person p=(Person)cache.get("person1");
      
      System.out.println("Person in cache="+p);
        
        return cacheManager;
	}
	
	
	
}
