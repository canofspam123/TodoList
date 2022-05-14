import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable{


    private String name;
    private String desc;
    

    //pointer to the parent Task
    private Task parentTask;


    
    //Stores the pointers to all subtasks of this task
    private ArrayList<Task> subTasks = new ArrayList<>();
    
    //This constructor creates a Task object with no parent,
    //and is public because a parent task can be created anywhere
    public Task (String name, String desc) {
        this.parentTask = null;
        this.name = name;
        this.desc = desc;
    }


    // This constructor creates a Task object with a pointer to a parent
    // is private because it is only used as a helper method for addSubTask
    private Task (String name, String desc, Task parentTask) {
        this.name = name;
        this.desc = desc;
        this.parentTask = parentTask;
    }
    
    
    public void addSubTask (String name, String desc) {
        subTasks.add(new Task(name, desc, this));
    }
    public void removeSubTask (int index) {
        subTasks.remove(index);
    }

    public String getname() {
        return this.name;
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
        out += name;
        if (level==1) out += " - " + desc;
        out += "\n";
        if (subTasks.size() != 0) {
            int i = 1;
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