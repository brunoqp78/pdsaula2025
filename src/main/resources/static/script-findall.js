// Função para buscar um cliente por ID
function apresentarDadosCliente() {

    // capturando o id digitado no campo client-id
    var idCliente = document.getElementById('client-id').value;

    // se nada foi digitado, mostrar mensagem de erro.
    if (!idCliente) {
        alert("Por favor, digite um ID válido");
        return;
    }

    // construir a URI
    const uri = `http://localhost:8080/clients/id/${idCliente}`;

    //função assincrona que irá criar a requisição get para o endpoint de nossa apiRest
    async function buscarDadosCliente() {
        //chama a APIREST em seu endpoint /id/{id} - findById
        const resposta = await fetch(uri);
        //caso a resposta não seja um Json, mostre essa mensagem
        if (!resposta.ok) {
            alert("Não foi possível retornar os dados do cliente!!")
        } else {
            //captura o Json da resposta 
            const json = await resposta.json();
            // criei uma função para apresentar os dados do cliente, para combinar com a tabela.
            apresentarCliente(json);
        }
    }
    // Função para exibir um único cliente
    function apresentarCliente(cliente) {
        //captura a área dos detalhes de um cliente
        var dadosCliente = document.getElementById('client-details');
        //formatando data e salário
        var dataFormatada = formatarData(cliente.birthDate);
        var salarioFormatado = 'R$ ' + cliente.income.toFixed(2);

        //criando o html para modificar a página
        var html = '<h2>Detalhes do Cliente</h2>' +
            '<table>' +
            '<tr><th>ID</th><td>' + cliente.id + '</td></tr>' +
            '<tr><th>Nome</th><td>' + cliente.name + '</td></tr>' +
            '<tr><th>CPF</th><td>' + cliente.cpf + '</td></tr>' +
            '<tr><th>Renda</th><td class="income">' + salarioFormatado + '</td></tr>' +
            '<tr><th>Nascimento</th><td>' + dataFormatada + '</td></tr>' +
            '<tr><th>Filhos</th><td class="children">' + cliente.children + '</td></tr>' +
            '<tr><th>Endereço</th><td>' + cliente.address.street + " - " + cliente.address.city + "/" + cliente.address.state + '</td></tr>' +
            '<tr><th>Categoria</th><td>' + cliente.category.name + '</td></tr>' +
            '</table>';

        //modificando a área dos dados de um cliente com os dados do cliente buscado.
        dadosCliente.innerHTML = html;
    }
    buscarDadosCliente();
}

// Função para buscar todos os clientes
function apresentarTodosClientes() {
    // Primeiro limpa a tela
    limparTela();

    // construir a URI
    const uri = `http://localhost:8080/clients`;

    //função assincrona que irá criar a requisição get para o endpoint de nossa apiRest
    async function buscarTodosCliente() {
        //chama a APIREST em seu endpoint /id/{id} - findById
        const resposta = await fetch(uri);
        //caso a resposta não seja um Json, mostre essa mensagem
        if (!resposta.ok) {
            alert("Não foi possível retornar os dados dos clientes!!")
        } else {
            //captura o Json da resposta 
            const json = await resposta.json();
            // criei uma função para apresentar os dados do cliente, para combinar com a tabela.
            montarTabela(json);
        }
    }
    // Função para exibir todos os clientes
    function montarTabela(clientes) {
        // cria as variáveis relacionados a área e a tabela
        var areaTabela = document.getElementById('all-clients');
        var tabelaClientes = document.getElementById('clients-table-body');

        // Mostra a área cliente que estava escondida
        areaTabela.classList.remove('hidden');

        // Limpa a tabela de clientes
        tabelaClientes.innerHTML = '';

        //navega por todos os clientes retornados e preenche a tabela
        for (var i = 0; i < clientes.length; i++) {
            var cliente = clientes[i];
            var dataFormatada = formatarData(cliente.birthDate);
            var salarioFormatado = 'R$ ' + cliente.income.toFixed(2);
            //criar uma linha
            var linhaAtual = document.createElement('tr');
            //preencher os campos da linha
            linhaAtual.innerHTML =
                '<td>' + cliente.id + '</td>' +
                '<td>' + cliente.name + '</td>' +
                '<td>' + cliente.cpf + '</td>' +
                '<td class="income">' + salarioFormatado + '</td>' +
                '<td>' + dataFormatada + '</td>' +
                '<td class="children">' + cliente.children + '</td>' +
                '<td>' + cliente.category.name + '</td>' +
                '<td>' + cliente.address.city + '/' + cliente.address.state + '</td>';
            //inserir a linha na tabela
            tabelaClientes.appendChild(linhaAtual);
        }
    }
    buscarTodosCliente();

}





// Função para limpar a tela
function limparTela() {
    document.getElementById('client-details').innerHTML = '';
    document.getElementById('clients-table-body').innerHTML = '';
    document.getElementById('all-clients').classList.add('hidden');
    document.getElementById('client-id').value = '';
}

// Função para formatar data
function formatarData(dataOriginal) {
    var data = new Date(dataOriginal);
    var dia = data.getDate();
    var mes = data.getMonth() + 1; // Mês começa em 0
    var ano = data.getFullYear();

    // Adiciona zero à esquerda se necessário
    if (dia < 10) dia = '0' + dia;
    if (mes < 10) mes = '0' + mes;

    return dia + '/' + mes + '/' + ano;
}