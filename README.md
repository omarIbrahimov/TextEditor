📝 TextEditor — Java Console-Based Editor with Undo/Redo
---------------------------------------------------------
A simple console-based text editor written in Java.
Supports writing, deleting, undo, redo, and clearing all text using a custom stack implementation.

This project demonstrates:

1. Use of StringBuilder

2. Implementation of UNDO/REDO using two stacks

3. Basic command-driven interface

Managing state changes and reversing operations

--------------------------------------------

🚀 Features
✔ Write
Append new content to the text editor.

✔ Delete
Remove text only from the end (suffix delete).
The editor ensures the input matches the end of the current text.

✔ Undo
Reverses the last operation:
Undo write → removes appended text
Undo delete → restores deleted text

✔ Redo
Re-applies the last undone operation.

✔ Start Over
Clears the entire text and resets history.

--------------------------------------------

🧠 Core Logic

The editor keeps track of operations in the form:
1. "W<text>" — write operations.
2. "D<text>" — delete operations

These are pushed into:
a. UNDO stack — for undoing actions
b. REDO stack — for reapplying undone actions

📘 Example Usage
Current text is:

Choose action: Write, Delete, UNDO, REDO, Delete Everything
> Write
Insert the text:
> Hello

Current text is: Hello
> Delete
Insert the text:
> lo

Current text is: Hel
> UNDO

Current text is: Hello

--------------------------------------------

🛠 Technologies Used<br/>
Java<br/>
Custom stack implementation<br/>
StringBuilder

--------------------------------------------

📄 License<br/>
This project is free to use for learning, assignments, and personal projects.
