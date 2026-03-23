package com.clara.ex04.repositorie;

import com.clara.ex04.model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorie extends JpaRepository<AutorModel, Long> {
}
