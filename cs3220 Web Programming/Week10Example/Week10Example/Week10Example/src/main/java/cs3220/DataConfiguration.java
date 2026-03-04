package cs3220;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cs3220.model.GuestBookEntry;

@Configuration
public class DataConfiguration {

    @Bean
    List<GuestBookEntry> entries() {
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("Tom", "Hi from Configuration Bean"));
		entries.add(new GuestBookEntry("John", "Hello"));
		return entries;
	}

//	@Bean
//    List<GuestBookEntry> entries2() {
//		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
//		entries.add(new GuestBookEntry("Tom", "Hi from Configuration Bean2"));
//		entries.add(new GuestBookEntry("John", "Hello"));
//		return entries;
//	}
}
