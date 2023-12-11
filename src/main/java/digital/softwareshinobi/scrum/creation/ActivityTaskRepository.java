package digital.softwareshinobi.scrum.creation;

import digital.softwareshinobi.scrum.creation.ActivityTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityTaskRepository extends JpaRepository<ActivityTask, Integer> {

    Optional<ActivityTask> findByIdAllIgnoreCase(Integer id);

}