package com.enterprise.eventmanagementsystem.dao;
import com.enterprise.eventmanagementsystem.dto.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * We designed an EventRepository interface to provide the data access layer with the code it requires.
 * We created an interface that extends the CrudRepository interface and defines CRUD methods such as fetch(), save(), findAll(), findById(),deleteById(), and so on.
 * At runtime, Spring generates the implementation code for you.
 * @author Ali Ibrahim, Benjamin Gomori, Kevin Zhu, and Son Bo
 */
@Repository("EventRepository")
public interface EventRepository extends CrudRepository<Event, Integer> {

}
