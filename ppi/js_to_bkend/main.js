let args = process.argv;
let arg = process.argv.slice(2);

// console.log(args);
// console.log(arg);

let opcao = "2";

if (arg.length == 3) {
    if (arg[0] === 's')
        opcao = soma(parseInt(arg[1]), parent(arg[2]));
    else if (arg[0] === 'm')
        opcao = multi(parseInt(arg[1]), parseInt(arg[2]));
    else
        console.log("Opção Inválida.")
}

function soma(a, b) {
    return a + b;
}

function multi(a, b) {
    return a * b;
}

console.log(opcao);