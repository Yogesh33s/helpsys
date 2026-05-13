const API = "http://localhost:8080/api/requests";

async function createRequest() {

    const title = document.getElementById("title").value;

    await fetch(API, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            title: title,
            status: "PENDING"
        })
    });

    loadRequests();
}

async function loadRequests() {

    const response = await fetch(API);
    const data = await response.json();

    const list = document.getElementById("requestList");

    list.innerHTML = "";

    data.forEach(req => {

        const li = document.createElement("li");

        li.innerHTML = `
            ${req.title} - ${req.status}
            <button onclick="completeRequest('${req.id}')">
                Complete
            </button>
        `;

        list.appendChild(li);
    });
}

async function completeRequest(id) {

    await fetch(`${API}/${id}`, {
        method: "PUT"
    });

    loadRequests();
}

loadRequests();