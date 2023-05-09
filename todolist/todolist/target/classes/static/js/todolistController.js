const addAPI= 'http://localhost:8080/item/add';
const displayAPI = 'http://localhost:8080/item/all';

let todoListController = [];

function displayTodoList()
{
      //fetch data from database using the REST API endpoint from Spring Boot
      fetch(displayAPI)
          .then((resp) => resp.json())
          .then(function(data) {
              console.log("2. receive data")
             // console.log(data);


              data.forEach(function (todoList) {
                  const todoListObj = {
                      id: todoList.id,
                      title: todoList.title,
                      description: todoList.description,
                      date: todoList.date
                 };


                   //This array consist of 3 objects
                  todoListController.push(todoListObj);
            });


           //Display all the 3 objects from the todoListController array
            renderTodoListPage();
          })
          .catch(function(error) {
              console.log(error);
          });
}


//(3)  Display all products when user launch the product.html page
function renderTodoListPage() {


   let displayTodoList = "";


   for (let i = 0; i < todoListController.length; i++ ) {


       displayTodoList += `
           <tr>
               <td>${todoListController[i].title}</td>
               <td>${todoListController[i].description}</td>
               <td>${todoListController[i].date}</td>
           </tr>
       `
   }


   document.querySelector("#displayTodoList").innerHTML= displayTodoList;


} //End of renderTodoListPage function


function addTodoList(title, description, date)
{
    //FormData is am Object provided by the Browser API for us to send the data over to the backend
  const formData = new FormData();
  formData.append('title', title);
  formData.append('description', description);
  formData.append('date', date);

  fetch(addAPI, {
       method: 'POST',
       body: formData
       })
       .then(function(response) {
           console.log(response.status); // Will show you the status
           if (response.ok) {
               alert("Successfully Added!")
           }
           else {
              alert("Something went wrong. Please try again")
           }
       })
       .catch((error) => {
           console.error('Error:', error);
           alert("Error adding item to List")
       });


}