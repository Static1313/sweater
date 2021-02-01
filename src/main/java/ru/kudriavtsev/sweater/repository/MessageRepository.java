package ru.kudriavtsev.sweater.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kudriavtsev.sweater.model.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {

}
