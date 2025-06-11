        
        function fetchData(){
            // criar as variáveis que representa os campos do formulários
            const dadosCliente = document.getElementById('client-details');
            // iremos capturar o id presente no input do html
            const clientId = document.getElementById('client-id').value;

            //limpar os dados do cliente atual
            dadosCliente.innerHTML=``;

            //validando se o ID informado é válido!!!
            if (!clientId){
                alert("O campo ID é obrigatório");
                return;
            }

            // construir a URI
            const uri = `http://localhost:8080/clients/id/${clientId}`;

            //função assincrona que irá criar a requisição get para o endpoint de nossa apiRest
            async function fetchClientData() {
                //chama a APIREST em seu endpoint /id/{id} - findById
                const response = await fetch(uri);
                //caso a resposta não seja um Json, mostre essa mensagem
                if (!response.ok){
                    alert("Não foi possível retornar os dados do cliente!!!")
                }else{
                    //captura o Json da resposta 
                    const json = await response.json();
                    //imprime os dados na área do cliente
                    dadosCliente.innerHTML = 
                    `<p>Nome: ${json.name} </p>
                    <p>Cpf: ${json.cpf} </p>
                    <p>Salário: ${json.income} </p>
                    <p>N. Filhos: ${json.children} </p>`;            
                }
            }

            fetchClientData();            
        }