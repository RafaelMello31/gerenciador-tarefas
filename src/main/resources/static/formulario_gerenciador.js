const API_URL = "http://localhost:8080/tarefas";


async function carregarTarefas() {
    const resposta = await fetch(API_URL);
    const tarefas = await resposta.json();

    const lista = document.getElementById("lista-tarefas");
    lista.innerHTML = "";

    tarefas.forEach(tarefa => {
        const div = document.createElement("div");
        div.className = "tarefa";

        div.innerHTML = `
            <h3>${tarefa.titulo}</h3>
            <p>${tarefa.descricao || "(Sem descrição)"}</p>
            <p>Status: ${tarefa.status ? "Concluída" : "Pendente"}</p>
            <button onclick="editarTarefa(${tarefa.id})">Editar</button>
            <button onclick="deletarTarefa(${tarefa.id})">Excluir</button>
        `;

        lista.appendChild(div);
    });
}


async function criarTarefa(evento) {
    evento.preventDefault();

    const titulo = document.getElementById("titulo").value;
    const descricao = document.getElementById("descricao").value;
    const status = document.getElementById("status").value;

    const tarefa = {
        titulo: titulo,
        descricao: descricao,
        status: status === "true"
    };

    await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(tarefa)
    });

    document.getElementById("form-tarefa").reset();
    carregarTarefas();
}

async function deletarTarefa(id) {
    if (confirm("Tem certeza que deseja excluir esta tarefa?")) {
        await fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        });

        carregarTarefas();
    }
}

async function editarTarefa(id) {
    const novoTitulo = prompt("Novo título:");
    const novaDescricao = prompt("Nova descrição:");
    const novoStatus = confirm("A tarefa está concluída?");

    const tarefaAtualizada = {
        titulo: novoTitulo,
        descricao: novaDescricao,
        status: novoStatus
    };

    await fetch(`${API_URL}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(tarefaAtualizada)
    });

    carregarTarefas();
}

document.getElementById("form-tarefa").addEventListener("submit", criarTarefa);

carregarTarefas();
