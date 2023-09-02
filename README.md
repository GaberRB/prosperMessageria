# prosperMessageria


## Descrição
Pesquise e tente implementar este tema: Como adicionar mais de um producer em uma aplicação de mensageria?

Verificar o artigo que escrevi a respeito de mensageria com kafka:

[Apache Kafka , Prometheus e Grafana em uma aplicação Java SpringBoot](https://gabrielriosbelmiro.medium.com/apache-kafka-prometheus-e-grafana-em-uma-aplica%C3%A7%C3%A3o-java-springboot-28157251b1c7)

[Analisando Sentimentos no Twitter com AWS Comprehend: Inteligência Artificial e Observability](https://gabrielriosbelmiro.medium.com/analisando-sentimentos-no-twitter-com-aws-comprehend-intelig%C3%AAncia-artificial-e-observability-2587e0ed9b0)


## Configuração do Ambiente
O projeto utiliza o Docker Compose para facilitar a montagem do ambiente.

## Pré-requisitos
Certifique-se de ter o Docker e o Docker Compose instalados em sua máquina antes de prosseguir.
Versão do Java 20. 
Maven

## Instalação e Configuração
1. Clone este repositório em sua máquina:
   git clone git@github.com:GaberRB/prosperMessageria.git

2. Navegue até o diretório clonado:
   cd ../docker
  
4. Execute o Docker Compose para iniciar  o Kafka:
   docker-compose up -d

5. Aguarde até que todos os serviços estejam em execução.
6. Após subida do ambiente aqui está a lista de acessos do localhost
- Kafdrop: Acesse o Kafdrop em http://localhost:9000 para visualizar e explorar os tópicos e mensagens do Kafka.




