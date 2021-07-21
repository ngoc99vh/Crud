package com.example.demojunitmockito.repository;

import com.example.demojunitmockito.model.User;
import javafx.beans.property.adapter.JavaBeanProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsUserByName(String name);
}
