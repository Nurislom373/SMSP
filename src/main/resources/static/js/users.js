let createBtn = document.querySelector('.user-create-btn');
let orgSelected = document.getElementById('organizationSelect');

function getOrganizations() {
    let url = "http://localhost:8080/organizations/list";
    fetch(url)
        .then(res => res.json())
        .then(json => {
            json.forEach((obj) => {
                console.log(obj);
                let option = document.createElement('option');
                option.value = obj.id;
                option.text = obj.name;
                orgSelected.appendChild(option);
            })
        })
}

createBtn.addEventListener("click", getOrganizations);

function deleteUser(id) {
    let confirmBool = confirm('Are sure delete user?');

    if (confirmBool) {
        let url = "http://localhost:8080/users/delete/" + id;
        fetch(url,
            {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(res => {
                if (res.status === 204) {
                    sleep(1000).then(r => {
                        window.location.reload();
                    });
                } else {
                    alert('User Maybe does not deleted!')
                }
            });
    }
}

function setUpdateForm(id) {
    let url = "http://localhost:8080/users/get/" + id;
    fetch(url)
        .then(res => res.json())
        .then(json => {

            let organizationSelectUpdate = document.getElementById('organizationSelectUpdate');

            fetch("http://localhost:8080/organizations/list")
                .then(res => res.json())
                .then(jsonSec => {
                    jsonSec.forEach((obj) => {
                        console.log(obj);
                        let option = document.createElement('option');
                        option.value = obj.id;
                        option.text = obj.name;
                        console.log(json.organizationName);
                        if (obj.name === json.organizationName) {
                            option.selected = true;
                        }
                        organizationSelectUpdate.appendChild(option);
                    })
                })

            let firstNameForUpdate = document.getElementById('firstNameForUpdate');
            let lastNameForUpdate = document.getElementById('lastNameForUpdate');
            let emailForUpdate = document.getElementById('emailForUpdate');
            let phoneNumberForUpdate = document.getElementById('phoneNumberForUpdate');
            let roleSelectedUpdate = document.getElementById('roleSelectedUpdate');
            let langSelectedUpdate = document.getElementById('langSelectedUpdate');
            let statusSelectedUpdate = document.getElementById('statusSelectedUpdate');
            let updateId = document.getElementById('updateId');

            firstNameForUpdate.value = json.firstName;
            lastNameForUpdate.value = json.lastName;
            emailForUpdate.value = json.email;
            phoneNumberForUpdate.value = json.phoneNumber;
            roleSelectedUpdate.value = json.role;
            langSelectedUpdate.value = json.language;
            statusSelectedUpdate.value = json.status;
            updateId.value = id;
        })
}

function sleep(ms) {
    console.log(ms)
    return new Promise(resolve => setTimeout(resolve, ms));
}
