document.getElementById("addTodoList").addEventListener("submit",function(event) {
// Prevent default action of the Form submission

    event.preventDefault()

//Select the inputs

    let title = document.getElementById("title").value;
    let description = document.getElementById("description").value;
    let date = document.getElementById("date").value;


//    // Reformat target date from ddmmyyyy to yyyymmdd
//                let day = targetDate.slice(0, 2);
//                let month = targetDate.slice(2, 4);
//                let year = targetDate.slice(4);
//                targetDate = year + month + day;
//
//    let titleElement = document.getElementById("title");
//    let title = titleElement ? titleElement.value : "";
//    let titleElement = document.getElementById("title");
//    let title = titleElement ? titleElement.value : "";
//    let titleElement = document.getElementById("title");
//    let title = titleElement ? titleElement.value : "";

    //Form Validation Code
    // Set minimum date for target date input
                    let inputDate = new Date();
                    let dd = inputDate.getDate();
                    let mm = inputDate.getMonth()+1; //January is 0!
                    let yyyy = inputDate.getFullYear();
                     if(dd<10){
                            dd='0'+dd
                        }
                        if(mm<10){
                            mm='0'+mm
                        }

                    targetDate = yyyy+'-'+mm+'-'+dd;
                    document.getElementById("date").setAttribute("min", inputDate);

                    // Form validation
                    document.getElementById("addTodoList").addEventListener("submit", function(event) {
                        let description = document.getElementById("description").value;
                        let date = document.getElementById("date").value;

                        if (!description || !date) {
                            alert("Please fill in all fields.");
                            event.preventDefault();
                        }
                    });

//calls a function from the todoListController.js to access the API to add items to the database
    addTodoList(title, description, date)
  });


