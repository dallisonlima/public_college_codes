function metodo_get(id) {
    // Método AJAX
    fetch('http://localhost:3000/produtos/' + id)
        .then(resp => resp.json())
        .then(dados => console.log(dados));
}

function metodo_get2(id) {
    // Método AJAX
    fetch('http://localhost:3000/produtos/' + id)
        .then(resp => resp.json())
        .then(dados => console.log(dados));
}

metodo_get(1);
metodo_get2(2);
