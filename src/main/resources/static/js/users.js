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