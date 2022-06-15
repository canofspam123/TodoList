# TodoList
 - Recursive CLI TodoList app

## Setup
 1. Download the `TodoList.jar` file to desired location.
 2. navigate to the directory where `TodoList.jar` is and run `java -jar TodoList.jar`.
 3. After ending, a file named `TodoList.tsk` will be created in the same directory. This file contains all your tasks.

## Usable commands
 - `home` - navigates to the "master" task
 - `back` - navigates to the previous task you were in
 - `nav` - prompts the user to input a number *n*, and then navigates to the subtask with index of *n* 
 - `add` - prompts user to input and `name` and `desc`, and then adds a task with those properties to the current task as a subtask
 - `rem` - prompts user to input a number  *n*, and then removes the subtask with index of *n*
 - `edit` - prompts the user to input a number *n*, a new name, and a new desc, then edits _name_ and _desc_ of subtask with index of *n*, with *new name* and *new desc* 
