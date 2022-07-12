package org.example.repositories;

import java.util.List;

import org.example.models.LongUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LongUrlRepository extends JpaRepository<LongUrl, Long> {
}
