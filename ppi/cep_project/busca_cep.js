const cep = document.getElementById('cep');
const logradouro = document.getElementById('logradouro');
const complemento = document.getElementById('complemento');
const bairro = document.getElementById('bairro');
const localidade = document.getElementById('localidade');
const uf = document.getElementById('uf');
const ddd = document.getElementById('ddd');

function insere_dados(dados) {
    // Limpa os campos
    cep.value = dados.cep;
    logradouro.value = dados.logradouro;
    complemento.value = dados.complemento;
    bairro.value = dados.bairro;
    localidade.value = dados.localidade;
    uf.value = dados.uf;
    ddd.value = dados.ddd;
}

function busca_cep() {
    var vcep = cep.value.replace(/\D/g, '');
    if (vcep.length == 8) {
        fetch('https://viacep.com.br/ws/' + vcep + '/json')
            .then(resp => resp.json())
            .then(dados => insere_dados(dados))
    }
}

cep.addEventListener('keyup', function (ev) {
    if (ev.keyCode == 13) {
        busca_cep();
    }
})