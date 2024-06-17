package javaidplevel4.javaidplevel4.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javaidplevel4.javaidplevel4.model.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    @Query("SELECT k FROM Training k")
    Page<Training> findAllTraining(Pageable pageable);

    
}
