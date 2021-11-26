public class App {
    //Figure out how to do the UI
    static Task ToDoList = new Task ("My Tasks");
    public static void main(String[] args) throws Exception {
        ToDoList.addSubTask(new Task("Level 1"));
        ToDoList.getSubTasks().get(0).addSubTask(new Task("Level 2"));
        ToDoList.getSubTasks().get(0).addSubTask(new Task("Level 2a"));
        ToDoList.getSubTasks().get(0).getSubTasks().get(0).addSubTask(new Task("Level 3"));
        System.out.println(ToDoList);
        
    }
}
