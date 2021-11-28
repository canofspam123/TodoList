import java.util.ArrayList;

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
        return toString(1);
    }
    public String toString (int level ) {
        String out = "";
        out += desc + "\n";

        if (subTasks.size() != 0) {
            int i = 1;
            for (Task t : subTasks) {
                for (int j = 0; j < level; j++) {
                    out += "\t";
                }
                out += i + ". " + t.toString(level+1);
                i++;
            }
        } 
        return out;
    }
}
