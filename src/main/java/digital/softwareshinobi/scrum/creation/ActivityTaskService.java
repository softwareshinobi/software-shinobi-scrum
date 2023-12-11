package digital.softwareshinobi.scrum.creation;

import jakarta.transaction.Transactional;
import digital.softwareshinobi.scrum.creation.ActivityTask;
import digital.softwareshinobi.scrum.creation.ActivityTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = SQLException.class)
public class ActivityTaskService {

    ActivityTaskRepository activityTaskRepository;

    @Autowired
    public ActivityTaskService(ActivityTaskRepository activityTaskRepository) {
        this.activityTaskRepository = activityTaskRepository;
    }

    public ActivityTask saveActivityTask(ActivityTask activityTask) {
        return this.activityTaskRepository.save(activityTask);
    }

    public List<ActivityTask> getAllActivityTasks() {
        return this.activityTaskRepository.findAll();
    }

    public void delete(Integer id) {
        this.activityTaskRepository.deleteById(id);
    }

        public Optional<ActivityTask> get(Integer id) {
        return activityTaskRepository.findById(id);
    }
}