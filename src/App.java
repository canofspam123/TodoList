import java.io.*;
import java.util.*;

public class App {
    //Figure out how to do the UI
    //Commands: nav, rem, add, back, home
    static Task ToDoList = null;
    static Task current = null;
    public static void main(String[] args) throws Exception {

        try {
            FileInputStream fileIn = new FileInputStream("TodoList.tsk");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ToDoList = (Task) in.readObject();
            in.close();
            fileIn.close();
            current = ToDoList;
        } catch (IOException i){
            System.out.println("No existing list, creating new list.");
            ToDoList = new Task("My Tasks", "All your tasks");
            current = ToDoList;
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        Scanner s = new Scanner(System.in);
        String in = "";
        while (!in.equals("end")) {
            
            System.out.println("\n~~~~~~~~");
            System.out.println(current);
            in = s.nextLine();
            commander(in);
            
        }
        s.close();
        
    }

    static void commander (String input) {

        String command = input;
        String param = "";
        String param1 = "";
        if (input.indexOf(" ")!=-1) {
            command = input.substring(0, input.indexOf(" "));
            try {
                param   = input.substring(input.indexOf(" ")+1).split(" ## ")[0];
                param1   = input.substring(input.indexOf(" ")+1).split(" ## ")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                param   = input.substring(input.indexOf(" ")+1);
            }
        }

        switch(command) {
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
            
            case "back" : {
                if(current.getParent()!=null){
                    current = current.getParent();
                }
                break;
            }

            case "home" : {
                current = ToDoList;
                break;
            }

            case "nav": {
                try{
                    current = current.getSubTask(Integer.parseInt(param)-1);
                } catch (Exception e) {
                    System.out.println("Please enter a valid integer value after the nav command.");
                }
                break;

            }

            case "rem" : {
                try {
                    current.removeSubTask(Integer.parseInt(param));
                } catch (Exception e) {
                    System.out.println("Please enter a valid integer value after the rem command.");
                }
                break;

            }

            case "add" : {
                try {
                    current.addSubTask(param, param1);
                } catch (Exception e) {
                    System.out.println("Please enter a valid name value after the add command.");

                }
                break;

            }

            default : {
                System.out.println("Please enter a valid command, then parameter.");
            }
        }
    }
}