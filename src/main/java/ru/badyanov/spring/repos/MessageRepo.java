package ru.badyanov.spring.repos;

import org.springframework.data.repository.CrudRepository;
import ru.badyanov.spring.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Integer> {

}
