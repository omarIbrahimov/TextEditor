package program;
import stack.*;

import java.util.Scanner;

public class Editor {
    public StringBuilder text=new StringBuilder();
    public MyStack UNDO=new MyStack();
    public MyStack REDO= new MyStack();

    public void Write(String content){
        text.append(content);
        UNDO.push("W"+content);
        REDO=new MyStack();
    }
    private void Delete(String content){
        if(text.isEmpty()){
            System.out.println("There is nothing to delete!");
            start();
        }

        int len=content.length();
        String end=text.substring(text.length()-len);

        while(!content.equals(end)){
            System.out.println("Please input a piece which in the end of the text:");
            Scanner input=new Scanner(System.in);
            String del=input.nextLine();
            len=del.length();
            if(len>text.length()){
                continue;
            }

            end=text.substring(text.length()-len);
        }
        text.delete(text.length()-len,text.length());
        UNDO.push("D"+content);
        REDO=new MyStack();


    }

    private void deleteEverything(){
        text= new StringBuilder();
        UNDO=new MyStack();
        REDO=new MyStack();
    }

    private void Undo(){
        if(UNDO.isEmpty()){
            System.out.println("There is nothing to undo!");
            start();
        }

        String todo=UNDO.pop();
        if(todo.charAt(0)=='W'){
            text.delete(text.length()-todo.substring(1).length(),text.length());
            REDO.push(todo);
        }
        else {
            text.append(todo.substring(1));
            REDO.push(todo);
        }
    }

    private void Redo(){
        if(REDO.isEmpty()){
            System.out.println("There is nothing to redo!");
            start();
        }

        String todo=REDO.pop();
        UNDO.push(todo);
        if(todo.charAt(0)=='W'){
            text.append(todo.substring(1));

        }
        else {
            String toRem=todo.substring(1);

            if(text.length()>=toRem.length()){
                text.delete(text.length()-toRem.length(), text.length());
            }
            else{
                text=new StringBuilder();
            }
        }
    }

    public void start(){
        System.out.println("Current text is:"+text);

        Scanner input = new Scanner(System.in);

        System.out.println("Please choose action:");
        System.out.println("1. Write");
        System.out.println("2. Delete");
        System.out.println("3. UNDO");
        System.out.println("4. REDO");
        System.out.println("5. Start Over");
        System.out.println("Please insert the name of the action: ");
        String action=input.nextLine();
        while(!action.equals("Write") && !action.equals("Delete") && !action.equals("UNDO") && !action.equals("REDO") && !action.equals("Start Over")){
            System.out.println("Please input the action as it was spelled in the catalog: ");
            action=input.nextLine();
        }
        switch(action) {
            case "Write":
                System.out.println("Insert the text:");
                String content=input.nextLine();
                Write(content);
                start();
                break;
            case "Delete":
                System.out.println("Insert the text:");
                String deletable=input.nextLine();
                Delete(deletable);
                start();
                break;
            case "UNDO":
                Undo();
                start();
                break;
            case "REDO":
                Redo();
                start();
                break;
            case "Start Over":
                deleteEverything();
                break;
        }
    }

}
