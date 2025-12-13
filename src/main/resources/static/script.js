const API_URL = "/api/todos";

function loadTodos() {
  fetch(API_URL)
    .then(res => res.json())
    .then(data => {
      const list = document.getElementById("todoList");
      list.innerHTML = "";
      data.forEach(todo => {
        const li = document.createElement("li");
        li.className = todo.completed ? "completed" : "";

        li.innerHTML = `
          ${todo.title}
          <span>
            <button onclick="completeTodo(${todo.id})">✔</button>
            <button onclick="deleteTodo(${todo.id})">❌</button>
          </span>
        `;
        list.appendChild(li);
      });
    });
}

function addTodo() {
  const title = document.getElementById("todoInput").value;
  fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title })
  }).then(() => {
    document.getElementById("todoInput").value = "";
    loadTodos();
  });
}

function completeTodo(id) {
  fetch(`${API_URL}/${id}`, { method: "PUT" })
    .then(loadTodos);
}

function deleteTodo(id) {
  fetch(`${API_URL}/${id}`, { method: "DELETE" })
    .then(loadTodos);
}

loadTodos();