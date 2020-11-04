$(document).ready(); {
    getTableUser();
    getTableAllUsers();
}

function getTableUser() {
    fetch('http://localhost:8080/main/user').then(
        response => {
            response.json().then(
                data => {
                    let rls = data.roles.length > 1 ? 'USER ADMIN': 'USER';
                    let str = '<tr>' +
                        '<td>' + data.id + '</td>' +
                        '<td>' + data.firstName + '</td>' +
                        '<td>' + data.lastName + '</td>' +
                        '<td>' + data.age + '</td>' +
                        '<td>' + data.email + '</td>' +
                        '<td>' + rls + '</td>' +
                        '</tr>';
                    $('#table_user tbody').empty().append(str);
                });
        });
}

function getTableAllUsers() {
    fetch('http://localhost:8080/main/admin').then(
        response => {
            response.json().then(
                data => {
                    let str = '';
                    let rls = '';
                    data.forEach(usr => {
                        usr.roles.length > 1 ? rls = 'USER ADMIN': rls = 'USER';
                        str += '<tr>' +
                            '<td>' + usr.id + '</td>' +
                            '<td>' + usr.firstName + '</td>' +
                            '<td>' + usr.lastName + '</td>' +
                            '<td>' + usr.age + '</td>' +
                            '<td>' + usr.email + '</td>' +
                            '<td>' + rls + '</td>' +
                            '<td><button type="button" onclick="getModalEdit(' + usr.id + ')" class="btn btn-info" data-toggle="modal" data-target="#modal-Edit">Edit</button></td>' +
                            '<td><button type="button" onclick="getModalDelete(' + usr.id + ')" class="btn btn-danger" data-toggle="modal" data-target="#modal-Delete">Delete</button></td>' +
                            '</tr>';
                    });
                    $('#table_all_users tbody').empty().append(str);
                });
        });
}

function getModalEdit(id) {
    $.get("/main/admin/" + id, function (usr) {
        $('#idEdit').val(usr.id);
        $('#firstNameEdit').val(usr.firstName);
        $('#lastNameEdit').val(usr.lastName);
        $('#ageEdit').val(usr.age);
        $('#emailEdit').val(usr.email);
        $('#passwordEdit').val(usr.password);
    });
}

function getModalDelete(id) {
    $.get("/main/admin/" + id, function (usr) {
        $('#idDelete').val(usr.id);
        $('#firstNameDelete').val(usr.firstName);
        $('#lastNameDelete').val(usr.lastName);
        $('#ageDelete').val(usr.age);
        $('#emailDelete').val(usr.email);
        $('#passwordDelete').val(usr.password);
    });
}

$("#tab-AddNewUser").on('click', (event) => {
    event.preventDefault();
    let user = {
        firstName: $("#firstNameNewUser").val(),
        lastName: $("#lastNameNewUser").val(),
        age: $("#ageNewUser").val(),
        email: $("#emailNewUser").val(),
        password: $("#passwordNewUser").val(),
        roles: $("#rolesNewUser").val()
    };
    $.ajax({
        url: "/main/admin",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(user)
    }).done(() => {
        getTableAllUsers();
    })
});
$("#buttonSubmitEdit").on('click', (event) => {
    event.preventDefault();
    let user = {
        id: $("#idEdit").val(),
        firstName: $("#firstNameEdit").val(),
        lastName: $("#lastNameEdit").val(),
        age: $("#ageEdit").val(),
        email: $("#emailEdit").val(),
        password: $("#passwordEdit").val(),
        roles: $("#rolesEdit").val()
    };
    $.ajax({
        url: "/main/admin",
        type: "PUT",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(user)
    }).done(() => {
        $("#editUserModal").modal('hide');
        getTableAllUsers();
    })
});
$("#buttonSubmitDelete").on('click', (event) => {
    event.preventDefault();
    let user = {
        id: $("#idEdit").val(),
        firstName: $("#firstNameEdit").val(),
        lastName: $("#lastNameEdit").val(),
        age: $("#ageEdit").val(),
        email: $("#emailEdit").val(),
        password: $("#passwordEdit").val(),
        roles: $("#rolesEdit").val()
    };
    $.ajax({
        url: "/main/admin/",
        type: "DELETE",
        dataType: "text"
    }).done(() => {
        $("#deleteUserModal").modal('hide');
        getTableAllUsers();
    })
});
