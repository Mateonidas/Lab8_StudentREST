const studentFormDelete = document.querySelector(".student-delete");
const studentFormUpdate = document.querySelector(".student-update");
const message = document.querySelector(".message");

message.textContent = "";

function getAllStudents() {
    fetch("http://localhost:8080/students")
        .then((response) => {
            if (response.status !== 200) {
                return Promise.reject('Something go wrong');
            }
            return response.json();
        })
        .then((data) => {
            showTable(data);
        })
        .catch((error) => {
            console.log(error);
        });
}

function showTable(response) {
    const main = document.getElementById('main');
    let content = "<table border='1'> <thead> <tr> <th> Id</th><th> Imię</th>" +
        "<th>Nazwisko</th><th>Średnia</th></tr></thead><tbody>";
    for (let st in response) {
        let id = response[st].id;
        let name = response[st].name;
        let surname = response[st].surname;
        let average = response[st].average;
        content += "<tr><td>" + id + "</td><td>" + name +
            "</td><td>" + surname + "</td><td>" + average + "</td></tr>";
    }
    content += "</tbody></table>";
    main.innerHTML = content;
}

function deleteStudent() {

    message.textContent = "";

    let id = document.getElementById('id').value;

    if (id === "") {
        message.textContent = "Id cannot be null."
    } else {
        fetch("http://localhost:8080/students/" + id, {
            method: "DELETE",
            headers: {"Content-type": "application/json; charset=UTF-8"}
        })
            .then(response => {
                if (!response.ok) {
                    response.json().then(response => {
                            console.log(response);
                            message.textContent = response.details;
                            return Promise.reject(response.details);
                    });
                } else {
                    location.reload();
                }
            });
    }
}

const handleSubmitDeleteStudent = e => {
    e.preventDefault();
    deleteStudent();
};

function updateStudent() {
    let updateId = document.getElementById('updateId').value;

    if (updateId === "") {
        message.textContent = "Id cannot be null."
    } else {
        fetch("http://localhost:8080/students/" + updateId, {
            method: "GET",
            headers: {"Content-type": "application/json; charset=UTF-8"}
        })
            .then(response => {
                if (!response.ok) {
                    response.json().then(response => {
                            console.log(response);
                            message.textContent = response.details;
                            return Promise.reject(response.details);
                    });
                } else {
                    response.json().then(response => {
                        sessionStorage.setItem("updateId", updateId);
                        sessionStorage.setItem("name", response.name);
                        sessionStorage.setItem("surname", response.surname);
                        sessionStorage.setItem("average", response.average);
                        window.location.href = 'http://localhost:8080/updateStudent';
                    })
                }
            });
    }
}

const handleSubmitUpdateStudent = e => {
    e.preventDefault();
    updateStudent();
};

document.addEventListener('DOMContentLoaded', () => {
    getAllStudents();
});

studentFormDelete.addEventListener("submit", e => handleSubmitDeleteStudent(e));

studentFormUpdate.addEventListener("submit", e => handleSubmitUpdateStudent(e));
