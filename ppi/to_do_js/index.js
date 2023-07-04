var entrada = document.querySelector('#entrada');
var botao = document.getElementById('botao');
var lista = document.getElementById('lista');
var tarefas = JSON.parse(localStorage.getItem('tarefas')) || [];
let contador = 0;

botao.onclick = function() {
  let msg = entrada.value;
  let tar = tarefas.indexOf();
  contador += 1;
  if (msg.length > 0) {
    let no = `<li id="tar${contador}" class="list-group-item">${msg}
                <button type="button" onclick="removeTarefa(tar${contador})" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </li>`;
    lista.innerHTML += no;
    entrada.value = '';
    tarefas.push(msg);
    entrada.focus();
    salvarTarefas();

    console.log(tarefas);
  } else {
    alert("A tarefa não pode ser vazia");
  }
}

entrada.addEventListener('keyup', function(event) {
  event.preventDefault();
  if (event.keyCode == 13) {
    botao.click();
  }
});

function removeTarefa(obj) {
  lista.removeChild(obj);
}

function salvarTarefas(){
  localStorage.setItem('tarefas', JSON.stringify(tarefas))
}

// function buscarTarefa(){
//   localStorage.getItem('chave');
//   JSON.parse(getItem)
// }

function render(){
  for (item of tarefas) {
    console.log("item: " + item);
    let no = `<li class="list-group-item">${item}
                <button type="button" onclick="removeTarefa(this)" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </li>`;
    lista.innerHTML += no;
  }
}

render();