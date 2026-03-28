function register() {
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;

  if(name && email){

    let users = JSON.parse(localStorage.getItem("users")) || [];
    users.push({name: name, email: email});
    localStorage.setItem("users", JSON.stringify(users));

    showUsers();
    generateTicket(name, email);

    alert("Registration Successful");

  } else {
    alert("Please fill all details");
  }
}

function showUsers() {
  let users = JSON.parse(localStorage.getItem("users")) || [];
  let list = document.getElementById("userList");

  list.innerHTML = "";

  users.forEach(function(user){
    let li = document.createElement("li");
    li.innerText = user.name + " - " + user.email;
    list.appendChild(li);
  });
}

function generateTicket(name, email) {
  let ticket = document.getElementById("ticket");

  let data = name + " - " + email;

  ticket.innerHTML = `
    <h2>🎫 Event Ticket</h2>
    <p><b>Name:</b> ${name}</p>
    <p><b>Email:</b> ${email}</p>
    <p><b>Event:</b> Tech Fest 2026</p>

    <img src="https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=${data}">
  `;
}

// Page load pe users dikhaye
showUsers();