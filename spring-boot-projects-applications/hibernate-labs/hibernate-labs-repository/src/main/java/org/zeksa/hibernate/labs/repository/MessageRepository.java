package org.zeksa.hibernate.labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zeksa.hibernate.labs.model.Message;

import javax.persistence.Entity;
import java.util.Collection;

public interface MessageRepository extends JpaRepository<Message, Long> {

	Collection<Message> findByAuthor(String name);
}
