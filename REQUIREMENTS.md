# Project 2 - Android Task List
## COS 470 Spring 2018

## Specification
For this project, you are going to build a simple Task List app. Users will be able to open your app and add items to their todo list of things that they want to get done. Each item will have a name, a description, and a way to record whether it has been completed or not. Since we are early in the semester and have not yet covered data storage, the app should pre-populate with just a few example items at start up and work as intended while in use, but it does not have to remember the state of the list from run to run.

## Requirements

Your app must meet the following requirements and specifications. Deviating from these will result in a reduced grade. Remember this project is graded on a two (2) point scale. If you don't meet all the requiremets you will only get one (1) point.

You will be doing this app in Java. There are a number of Android tutorials, but I've not found one that gets you as far along as there was with iOS. Your Java programming will help you quite a bit, but keep in mind that Android has its own way of doing things.

The app shall be made up of three total screens:

* a task list screen
* a create new task screen
* a task details screen (could be the same as the new task screen)

More detailed information about each screen is found below.

To accomplish this, you will (most likely) have some set of the following files in your project:

* TaskListActivity.java - The "main" activity for the app, uses ListView or RecyclerView (better)
* TaskListAdapter.java - the adapter class that handles how a `Task` appears on a list.
* TaskDetailActivity.java - an activity that shows the details of a task
* NewTaskActivity.java - an activity that lets you add a new task.
* Task.java - the model representing a single task

### TaskListActivity, TaskListAdapter, and Task

A very large portion of your overall code base will go into these three files. There are a lot of tutorials out there on how to do this. You should read through several to get a feel for all of the different functions you have to override, etc. 

* When the app starts a list of tasks should appear with checkboxes next to them
	* Use a ListView or RecyclerView (better) to display items from the task list
* Tapping on the checkbox should mark the item as complete or not complete as appropriate
* Clicking on an item should bring up an edit task screen (below)
	* You should use `startActivityForResult()` to launch the edit detail activity
	* Also capture the result with `onActivityResult()`
* There should be a `+` floating action button to add a new item to the list
	* You should use `startActivityForResult()` to launch the edit detail activity
	* Also capture the result with `onActivityResult()`

### Task

* Has all the fieds for a task item (name, completed, due date, notes)
* Should have `compareTo()` so it can be ordered in an `ArrayList`
* The class should have a factory method `createInitalTaskList()` to create initial hard-coded tasks. This should get called in `onCreate()` of `TaskListActivity`

### TaskListAdapter

* Follow the examples and the methods you need to override.

### Add Item / Edit Item Activity

The add and/or edit item should be a separate activity and launched from the `TaskListActivity` via an intent, `startActivityForResult()`. The Add/Edit activity should have the same look and feel as your `TaskListActicity` does.

* Must have an `X` or back arrow in the upper left corner which cancels the current operation.
* Must have `Save` in the upper right which will save changes to a current task or the details of a new task and return to the main activity with the list updated.
* Must have fields for all the `Task` members (name, due date, completed, notes)
* Make sure that any numeric fields are numeric entry and that the date uses a `DatePicker`.
* It is possible to use only one Activity to do both add and edit. If you want to do this, you are welcome to do so, but note that it can be a bit more complicated (if overall it is less code).
* Added or edited items should appear in the list upon save and the order fixed if needed.

### Example Screenshots

Coming soon

## Submission Notes
When we work with GitHub this semester, I will take the state of your repos at the start of class on the due date and use that for grading. There is nothing you need to do specifically in GitHub.

* You **must NOT** include a build for Android (it's doesn't work anyway) in your repository. 
* You must create a `README.md` file that describes your project and:
	* Project/App Title
	* Basic instructions on usage
	* Any special info we need to run the app
	* Lessons learned (at least one paragraph)
	* You *may* write your report in Markdown format, that would be nice.

## Definitions
The Internet Engineering Task Force (IETF) Best Practice Document RFC 2119 Key 
Words for use in Request For Comments (RFC) to Indicate Requirement Levels 
defines several keywords that are used in this assignment and throughout the 
course. Pay special attention to where they appear in the assignment.

Some of the keywords used in this assignment are as follows;

**MUST**: This word, or the terms **REQUIRED** or **SHALL**, mean that the
definition is an absolute requirement of the specification.

**SHOULD**: This word, or the adjective **RECOMMENDED**, mean that there may
exist valid reasons in particular circumstances to ignore a particular item, but
the full implications must be under.

**MAY**: This word, or the adjective **OPTIONAL**, mean that an item is truly
optional. One vendor may choose to include the item because a particular
marketplace requires it or because the vendor feels that it enhances the product
while another vendor may omit the same item.

Much of this project is adapted from a similar course, [CS 4720 Mobile Application Development](https://cs4720.cs.virginia.edu/category/ios) at University of Virginia. Thank you to UVA for the heavy lifting. Green is my pepper.

