let createBtn = document.querySelector('.btn-add-now');
let orgSelected = document.getElementById('organizationSelectCreate');

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

function deleteGrade(id) {
    let confirmBool = confirm('Are sure delete grade?');

    if (confirmBool) {
        let url = "http://localhost:8080/grades/delete/" + id;
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
                    alert('Grade Maybe does not deleted!')
                }
            });
    }
}

function sleep(ms) {
    console.log(ms)
    return new Promise(resolve => setTimeout(resolve, ms));
}

function setUpdateForm(id) {
    let url = "http://localhost:8080/grades/get/" + id;
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

            let nameSlideTopUpdate = document.getElementById('nameSlideTopUpdate');
            let defaultSelectUpdate = document.getElementById('defaultSelectUpdate');
            let textareaUpdate = document.getElementById('textareaUpdate');
            let updateId = document.getElementById('updateId');

            nameSlideTopUpdate.value = json.name;
            defaultSelectUpdate.value = json.status;
            textareaUpdate.value = json.description;
            updateId.value = id;
        })
}