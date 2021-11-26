
let userForm = document.getElementById("userForm");

userForm.addEventListener('submit', event => {
    event.preventDefault();

    let requestBody = JSON.stringify({
        firstName: userForm.firstName.value,
        middleName: userForm.middleName.value,
        lastName: userForm.lastName.value,
        email: userForm.email.value,
        dateOfBirth: userForm.dateOfBirth.value
    });

    let postRequest = new Request('http://localhost:8080/users', {
        method: 'POST',
        body: requestBody,
        headers: new Headers({ 'Content-Type': 'application/json' })
    });

    fetch(postRequest);
})
