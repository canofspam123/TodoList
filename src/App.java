public class App {
    //Figure out how to do the UI
    static Task ToDoList = new Task ("My Tasks");
    public static void main(String[] args) throws Exception {
        ToDoList.addSubTask("bruh");
        ToDoList.getSubTasks().get(0).addSubTask("lol");
        ToDoList.getSubTasks().get(0).addSubTask("123");
        System.out.println(ToDoList);
    }
}
