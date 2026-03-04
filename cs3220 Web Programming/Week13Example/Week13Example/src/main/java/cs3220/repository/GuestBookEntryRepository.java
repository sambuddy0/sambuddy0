package cs3220.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cs3220.model.GuestBookEntry;

public interface GuestBookEntryRepository extends CrudRepository<GuestBookEntry, Integer>{
	List<GuestBookEntry> findByName(String name);
	
	@Query("SELECT e FROM GuestBookEntry e WHERE e.date > ?1")
	List<GuestBookEntry> getEntriesSince(LocalDate date);
	
	@Query(value = "SELECT * FROM guest_book_entry WHERE date > :date", nativeQuery = true)
	List<GuestBookEntry> getEntriesSinceNativeQuery(LocalDate date);
}
