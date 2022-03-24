
//array for tasks
var tasks = [];

//task status 'enum'
var taskStatus = {
    active: 'active',
    completed: 'completed'
};

//task constructor function
function Task (id, name, status) {
    this.id = id;
    this.name = name;
    this.status = status;
}

//creates new task element, adds to DOM
function addTaskElement (task) {
    //creates elements
    var listEl = document.getElementById('active-list');
    var taskEl = document.createElement('li');
    var textEl = document.createTextNode(task.name);
    
    //set attributes
    taskEl.setAttribute('id', task.id);

    //add text to task el
    taskEl.appendChild(textEl);

    //add task element to list
    listEl.appendChild(taskEl);
}

//click handler to add new task
function addTask (event) {
    var inputEl = document.getElementById('input-task');
    if (inputEl.value != '') {
        //create unique id
        var id = 'item-' + tasks.length;

        //create new task
        var task = new Task(id, inputEl.value, taskStatus.active);
        tasks.push(task);

        //add the task to DOM
        addTaskElement(task);

        //reset input
        inputEl.value = '';
    }
}

//click handler to complete a task
function completeTask (event) {
    //get task element
    var taskEl = event.target;
    var id = taskEl.id;

    //find corresponding task in task array and update status
    for (var i = 0; i < tasks.length; i++) {
        if (tasks.id === id) {
            tasks.status = taskStatus.completed;
            break;
        }
    }

    //move task el from active list to completed list
    taskEl.remove();
    document.getElementById('completed-list').appendChild(taskEl);
}

//key press handler to automatically click add task button
function clickButton (event) {
    if (event.keyCode === 13) {
        document.getElementById('add-task').click();
    }
}

//initialize app
function init () {
    //wire up the add task button click handler
    document.getElementById('add-task').onclick = addTask;

    //wire up the task completed list item click handler
    document.getElementById('active-list').onclick = completeTask;

    //wire up the task input key press handler
    document.getElementById('input-task').onkeypress = clickButton;
}

init();