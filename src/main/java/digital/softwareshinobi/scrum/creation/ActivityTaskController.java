package digital.softwareshinobi.scrum.creation;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/creation")
public class ActivityTaskController {

    @Autowired
    ActivityTaskService activityTaskService;

    @Autowired
    public ActivityTaskController(final ActivityTaskService activityTaskService) {

        System.out.println("ActivityTaskController ActivityTaskController ActivityTaskController");

        this.activityTaskService = activityTaskService;

    }
    @GetMapping("/")
    public String displaydasbhoard(Model model, HttpServletRequest request) {

        System.out.println("enter > creation-dashboard");

        List<ActivityTask> activityTaskList = activityTaskService.getAllActivityTasks();

        System.out.println("the list of activity task:");

        System.out.println(activityTaskList);

        model.addAttribute("activityTaskList", activityTaskList);

        model.addAttribute("activityTask", new ActivityTask());

        System.out.println("exit > creation-dashboard");

        return "creation/creation-dashboard";

    }
    
    @GetMapping("/manage-user-stories")
    public String displaymanager(Model model, HttpServletRequest request) {

        System.out.println("enter > creation-dashboard");

        List<ActivityTask> activityTaskList = activityTaskService.getAllActivityTasks();

        System.out.println("the list of activity task:");

        System.out.println(activityTaskList);

        model.addAttribute("activityTaskList", activityTaskList);

        model.addAttribute("activityTask", new ActivityTask());

        System.out.println("exit > creation-dashboard");

        return "creation/creation-manager";

    }

    @GetMapping("/add-new-user-story")
    public String addNewCreation(Model model, HttpServletRequest request) {

        model.addAttribute("activityTask", new ActivityTask());

        model.addAttribute("formTitle", "add activity Task");

        return "creation/add-creation";

    }

    @PostMapping("/save-new")
    public String saveNewActivityTask(@ModelAttribute ActivityTask activityTask, Model model) {

        System.out.println(">> save-new-activity " + activityTask);

        System.out.println("in:  " + activityTask);

        ActivityTask activityTask1 = this.activityTaskService.saveActivityTask(activityTask);

        System.out.println("out: " + activityTask1);

        if (activityTask1 == null) {

            model.addAttribute("error", "something went wrong saving new activity");

            System.out.println("something went wrong saving new activity");

        } else {

            model.addAttribute("toast", "new activity '$$' added".replace("##", activityTask.getDescription()));

        }

        displaymanager(model, null);

        return "creation/home";

    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model, HttpServletRequest request) {

        Optional<ActivityTask> activityTaskOptional = activityTaskService.get(id);

        if (activityTaskOptional.isPresent()) {

            System.out.println("4");

            model.addAttribute("activityTask", activityTaskOptional.get());

            model.addAttribute("formTitle", "Edit Activity Task");

            return "creation/edit-creation";

        } else {

            System.out.println("5");

            model.addAttribute("error", "creation not found for id: " + id);

            return "creation/home";

        }

    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model, HttpServletRequest request) {

        this.activityTaskService.delete(id);

        displaymanager(model, null);

        return "creation/home";

    }

    @GetMapping("/creation-reporting")
    public String viewCreationReporting(Model model, HttpServletRequest request) {

        displaydasbhoard(model, null);

        return "creation/creation-reporting";

    }
    
}

/*
    public ActivityTaskController() {

        System.out.println("ActivityTaskController ActivityTaskController ActivityTaskController");

    }


    @GetMapping("")
    public String renderNewAsituationccddddountForm() {
        return "the dash situation";
    }

    @GetMapping("/health-check")
    public String renderNewAccddddountForm() {
        return "hello";
    }

//        System.out.println("1");
//
//        Object currentUser = request.getSession().getAttribute("currentUser");
//
//        System.out.println("2");
//
//        if (currentUser == null) {
//
//            System.out.println("3");
//
//            model.addAttribute("error", "Login session has expired.");
//
//            model.addAttribute("account", new Account());
//
//            return "account/open-session-form";
//
//        }







//        Object obj = request.getSession().getAttribute("currentUser");
//        if (obj == null) {
//            model.addAttribute("error", "Login session expired");
//            return "redirect:/user/loginForm";
//        }
 */
