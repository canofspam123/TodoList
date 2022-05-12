import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable{


    private String desc;
    

    //pointer to the parent Task
    private Task parentTask;

    //pointer to the parent Task
    public Task parentTask;

    
    //Stores the pointers to all subtasks of this task
    private ArrayList<Task> subTasks = new ArrayList<>();
    
    //This constructor creates a Task object with no parent,
    //and is public because a parent task can be created anywhere
    public Task (String desc) {
        this.parentTask = null;
        this.desc = desc;
    }
    private Task (String desc, Task parentTask) {

        this.desc = desc;
        this.parentTask = parentTask;
    }


    // This constructor creates a Task object with a pointer to a parent
    // is private because it is only used as a helper method for addSubTask
    private Task (String desc, Task parentTask) {
        this.desc = desc;
        this.parentTask = parentTask;
    }
    
    
    public void addSubTask (String desc) {
        subTasks.add(new Task(desc, this));
    }
    public void removeSubTask (int index) {
        subTasks.remove(index);
    }

    public String getDesc() {
        return this.desc;
    }
    public Task getParent(){
        return this.parentTask;
    }
    public ArrayList<Task> getSubTasks() {
        return this.subTasks;
    }
    public Task getSubTask(int n){
        return subTasks.get(n);
    }


    // Overloaded in this manner because it allows for a default call
    public String toString () {
        return toString(1);
    }
    public String toString (int level ) {
        String out = "";
        out += desc + "\n";

        if (subTasks.size() != 0) {
            int i = 0;
            for (Task t : subTasks) {
                for (int j = 0; j < level; j++) {
                    out += "|" +  "\t";
                }
                out += i + ". " + t.toString(level+1);
                i++;
            }
        } 
        return out;
    }
} //what even 