# About
This is a fun project to demonstrate how we can create a CFG using <b>recursion</b>
# How does it work?
We always start with production rule that contains variable S. We keep adding text 
<br>
of this production rule to our result until we encounter a variable. We then 
pick a production rule that has this variable and <b>recursively</b> explores it. We
stop once there is no more production rule to explore. 
### Example
Let's say we have the following set of production rules:
<br>
