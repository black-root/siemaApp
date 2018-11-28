function iniciarLogin() {
    var request = new XMLHttpRequest();
    //var url = 'http://localhost:8080/SiemaApp-web/ws/profesionalsalud/usuario/' + username;

    //request.open('GET', url, true);
    request.open('GET', 'http://localhost:8080/SiemaApp-web/ws/profesionalsalud/', true);
    request.setRequestHeader("Content-Type", "application/json");
    request.onload = function () {
        // Accesando a la data
        var data = JSON.parse(this.response);

        if (request.status >= 200 && request.status < 400) {
            // data.forEach(movie => {
            // console.log(movie.title);
            // });
            console.log('DATA:' + data);
        } else {
            console.log('error');
        }
    }

    request.send();
}