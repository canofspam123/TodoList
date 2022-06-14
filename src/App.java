import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class App {
    //Figure out how to do the UI
    //Commands: nav, rem, add, back, home
    static Task ToDoList = new Task("My Tasks","All your tasks");
    static Task currentTask = ToDoList;

    public static void main(String[] args) {

        try {
            FileInputStream fileIn = new FileInputStream("TodoList.tsk");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ToDoList = (Task) in.readObject();
            in.close();
            fileIn.close();
            currentTask = ToDoList;
        } catch (IOException i){
            System.out.println("No existing list, creating new list.");
            ToDoList = new Task("My Tasks", "All your tasks");
            currentTask = ToDoList;
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        Scanner s = new Scanner(System.in);
        String in = "";
        while (!in.equals("end")) {

            System.out.println("\n~~~~~~~~");
            System.out.println(currentTask);
            in = s.nextLine();
            commander(in);

        }


    }

    static void commander (String input) {
        Scanner s = new Scanner(System.in);
        /*
        TODO:
         home
         back
         nav
         add
         rem
         edit
         */
        switch (input) {
            case "end" : {
                try {
                    FileOutputStream fileOut = new FileOutputStream("TodoList.tsk");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(ToDoList);
                    out.close();
                    fileOut.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "home" : currentTask =ToDoList;
                break;

            case "back" :
                if(currentTask!=ToDoList){
                    currentTask=ToDoList;
                }
                break;

            case "nav" :
                System.out.println("Enter an int between 0 and " + (currentTask.getSubTasks().size()-1));
                try{
                    currentTask=currentTask.getSubTasks().get(s.nextInt());
                } catch (Exception e){
                    System.out.println("Invalid input");
                }
                break;

            case "add" :
                System.out.println("name:");
                String name = s.nextLine();
                System.out.println("desc:");
                String desc = s.nextLine();

                currentTask.addSubTask(name, desc);
                break;

            case "rem" :
                System.out.println("Enter an int between 0 and " + (currentTask.getSubTasks().size()-1));
                try{
                    currentTask.removeSubTask(s.nextInt());
                } catch (Exception e){
                    System.out.println("Invalid input");
                }
                break;

            case "edit" :
                try{
                    System.out.println("Enter an int between 0 and " + (currentTask.getSubTasks().size()-1));
                    int n = s.nextInt();
                    System.out.println("new name:");
                    String newName = s.nextLine();
                    System.out.println("new desc:");
                    String newDesc = s.nextLine();

                    currentTask.getSubTasks().get(n).setName(newName);
                    currentTask.getSubTasks().get(n).setName(newDesc);

                } catch (Exception e){
                    System.out.println("Invalid input");
                }

        }
    }
}