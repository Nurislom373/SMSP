

function deleteOrganization(id) {
    let confirmBool = confirm('Are sure delete organization?');

    if (confirmBool) {
        let url = "http://localhost:8080/organizations/delete/" + id;
        fetch(url,
            {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(res => console.log(res.json()));
        sleep(1000).then(r => {
            window.location.reload();
        });
    }
}

function getOrganization(id) {
    console.log(id);
    let url = "http://localhost:8080/organizations/get/" + id;

    fetch(url)
        .then(res => res.json())
        .then(json => {
            console.log(json);
            let nameInput = document.getElementById('nameSlideUpdate');
            let emailInput = document.getElementById('emailSlideUpdate');
            let statusSelect = document.getElementById('defaultSelectUpdate');
            let idInput = document.getElementById('idUpdate');
            idInput.value = id;
            nameInput.value = json.name;
            emailInput.value = json.email;
            statusSelect.value = json.status;
        })
}

function newGet(id) {
    console.log(id);
    let url = "http://localhost:8080/organizations/get/" + id;

    fetch(url)
        .then(res => res.json())
        .then(json => {
            console.log(json);
            let nameInput = document.getElementById('nameSlideUpdate');
            let emailInput = document.getElementById('emailSlideUpdate');
            let statusSelect = document.getElementById('defaultSelectUpdate');
            let idInput = document.getElementById('idUpdate');
            idInput.value = id;
            nameInput.value = json.name;
            emailInput.value = json.email;
            statusSelect.value = json.status;
        })
}

// function updateOrganization() {
//     let json = {};
//     let idInput = document.getElementById('idUpdate');
//     let nameInput = document.getElementById('nameSlideUpdate');
//     let emailInput = document.getElementById('emailSlideUpdate');
//     let statusSelect = document.getElementById('defaultUpdateSelect');
//     let fileInput = document.getElementById('formUpdateFile');
//
// }

function sleep(ms) {
    console.log(ms)
    return new Promise(resolve => setTimeout(resolve, ms));
}

