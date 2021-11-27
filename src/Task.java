import java.util.ArrayList;

//TODO: Fix the tosString
public class Task {
    private String desc;

    
    //recursive classes? I'm in!
    private ArrayList<Task> subTasks = new ArrayList<>();
    

    public Task (String desc) {
        this.desc = desc;
    }
    public void addSubTask (Task subTask) {
        subTasks.add(subTask);
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
        return toString(0);    }

    public String toString (int level) {
        String out = "";
        for (int i = 0; i < level; i++) {
            out += "\t";
        }
        out += desc + "\n";

        if (subTasks.size() != 0) {
            for (Task t : subTasks) {
                
                out += t.toString(level+1);
            }
        } 
        return out;
    }
}
