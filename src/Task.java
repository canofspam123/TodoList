import java.util.ArrayList;

public class Task {
    private String desc;

    //pointer to the parent Task
    public Task parentTask;

    
    //recursive classes? I'm in!
    private ArrayList<Task> subTasks = new ArrayList<>();
    

    public Task (String desc) {
        this.parentTask = null;
        this.desc = desc;
    }
    private Task (String desc, Task parentTask) {
        this.desc = desc;
        this.parentTask = parentTask;
    }
    //how the f what the heck am i doing lmao
    
    public void addSubTask (String desc) {
        subTasks.add(new Task(desc, this));
    }
    public void removeSubTask (int index) {
        subTasks.remove(index);
    }

    public String getDesc() {
        return this.desc;
    }
    public ArrayList<Task> getSubTasks() {
        return this.subTasks;
    }



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