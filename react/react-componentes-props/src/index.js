import React from 'react';
import { createRoot } from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import Pedido from './Pedido.js';
import Cartao from './Cartao.js';
import Feedback from './Feedback.js';

const App = () => {
    const textoOK = "Já chegou";
    const textoNOK = "Ainda não chegou";

    const funcaoOK = () => alert("Agradecemos a confirmação!");
    const funcaoNOK = () => alert("Verificaremos o ocorrido!");

    const componenteFeedback = (
        <Feedback
            textoOK={textoOK}
            funcaoOK={funcaoOK}
            textoNOK={textoNOK}
            funcaoNOK={funcaoNOK}
        />
    );

    return (
        // container principal 
        <div className="container border rounded mt-2">
            {/* linha para o título */}
            <div className="row border-bottom m-2">
                <h1 className="display-5 text-center">Seus pedidos</h1>
            </div>

            {/* linha para o primeiro pedido pedido*/}
            <div className="row">
                {/* controle de colunas para responsividade*/}
                <div className="col-sm-8 col-md-6 m-2">
                    <Cartao cabecalho="22/04/2025">
                        <Pedido icone="fas fa-hdd fa-2x"
                            titulo="SSD"
                            descricao="SSD Kingston A400 - SATA" />
                        {componenteFeedback}
                    </Cartao>
                </div>
            </div>
            {/* linha para o segundo pedido pedido*/}
            <div className="row">
                {/* controle de colunas para responsividade*/}
                <div className="col-sm-8 col-md-6 m-2">
                    <Cartao cabecalho="20/04/2025">
                        <Pedido icone="fas fa-book fa-2x"
                            titulo="Livro"
                            descricao="Concrete Mathematics - Donald Knuth" />
                        {componenteFeedback}
                    </Cartao>
                </div>
            </div>
            {/* linha para o terceiro pedido pedido*/}
            <div className="row">
                {/* controle de colunas para responsividade*/}
                <div className="col-sm-8 col-md-6 m-2">
                    <Cartao cabecalho="21/01/2025">
                        <Pedido icone="fas fa-laptop fa-2x"
                            titulo="Notebook"
                            descricao="Notebook Dell - 8Gb - i5" />
                        {componenteFeedback}
                    </Cartao>
                </div>
            </div>
        </div>
    );
}

const container = document.getElementById('root');
const root = createRoot(container);
root.render(<App />);