var golBrasil = Math.floor(Math.random() * 11);
var golAlemanha = Math.floor(Math.random() * 11);
var tentativas = 1;

var verificar = function () {
    var apostaBrasil = Number(document.getElementById('input-brasil').value);
    var apostaAlemanha = Number(document.getElementById('input-alemanha').value);
    var esconder = document.getElementById('esconder');
    esconder.style.display = 'block';

    var tentativa = document.getElementById('flag-tentativa');

    if (apostaBrasil === golBrasil && apostaAlemanha === golAlemanha) {
        tentativa.textContent = 'Você acertou! Parabéns!';
        tentativa.style.backgroundColor = 'lightgreen';
        document.getElementById('verificar').disabled = true;
        document.getElementById('restart').value = 'Iniciar Jogo';
        return;
    }

    tentativa.textContent = 'Errado!';
    tentativa.style.backgroundColor = 'orange';
    tentativas++;
    calculateDica(apostaBrasil, apostaAlemanha);
    salvarEstadoPalpites(apostaBrasil, apostaAlemanha);
    
    if (tentativas > 10) {
        document.getElementById('verificar').disabled = true;
    }
};

var restart = function () {
    location.reload();
};

var calculateDica = function (apostaBrasil, apostaAlemanha) {
    var textBrasil = '';
    var textAlemanha = '';

    if (apostaBrasil < golBrasil) {
        textBrasil = 'Brasil fez mais gols. ';
    } else if (apostaBrasil > golBrasil) {
        textBrasil = 'Brasil fez menos gols. ';
    }

    if (apostaAlemanha < golAlemanha) {
        textAlemanha = 'Alemanha fez mais gols.';
    } else if (apostaAlemanha > golAlemanha) {
        textAlemanha = 'Alemanha fez menos gols. ';
    }

    var dica = document.getElementById('dica');
    dica.textContent = textBrasil + textAlemanha;
};

var salvarEstadoPalpites = function (apostaBrasil, apostaAlemanha) {
    var palpites = document.getElementById('palpites');
    palpites.textContent += ' || ' + apostaBrasil + ' x ' + apostaAlemanha;
};

document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('verificar').addEventListener('click', verificar);
    document.getElementById('restart').addEventListener('click', restart);
});
