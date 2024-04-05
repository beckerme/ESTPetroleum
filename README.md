# 1º Trabalho prático: Programação Orientada a Objetos 👨‍💻

## Descrição do  trabalho (história fictícia):

O grupo de investidores, AlbinvEST, responsável pelos sucessos das empresas de aviação, 
aluguer de automóveis e de cruzeiros, decidiu investir nos combustíveis para colmatar as 
necessidades dos restantes projetos. Para obter sucesso, apostaram num novo sistema de 
controlo da distribuição dos combustíveis pelos vários postos de abastecimento que possuem. 
Para o desenvolvimento do protótipo do sistema de gestão contactaram a sua parceira do 
costume, a EST. Nesta primeira fase o sistema irá apenas preocupar-se com a definição dos 
itinerários de reabastecimento dos postos para cada camião-cisterna. 

# Classes a desenvoler:

## Posto ⛽
 Esta classe representa um posto de abastecimento. Cada posto tem um código numérico 
único, a sua posição no mapa, a capacidade e quantidade atual de combustível no seu depósito 
(em litros), bem como o gasto diário médio de combustível. 

## Camiao 🚚
 Esta classe representa um camião-cisterna que transporta combustível. Cada camião tem 
uma matrícula única, a capacidade máxima e quantidade atual de combustível que transporta 
(em litros), a velocidade média (km/hora) e o débito usado para encher os postos (litros por 
segundo). Tem ainda o itinerário que deverá cumprir. 

## Itinerario 🛣️
 Esta classe representa o itinerário que um camião deve realizar. Deve ter uma lista com 
as paragens a realizar durante o itinerário. Tem um ponto de início e, após percorrer todas as 
paragens, deve retornar ao ponto inicial. 

## Paragem 🚏
 Esta classe representa uma paragem no itinerário. Indica qual o posto onde parar e 
quantos litros são para despejar nesse posto.

## Central 🏢
 Esta classe contém toda a informação relativa ao sistema, como os camiões e postos que 
existem. Deve também armazenar a posição da central. 

## Classes do package menu (JanelaControlo, Mapa, MarcadorPosto, RendererCamiao) 
 Estas classes são as responsáveis pela interface gráfica. Nestas classes apenas devem 
completar os TODO, já que a interface gráfica e interação com o utilizador já estão completas. 
A classe JanelaControlo apresenta a informação do sistema, como o mapa, os postos e os 
percursos. A classe Mapa é responsável por calcular as distâncias entre pontos no mapa. A 
MarcadorPosto desenha as informações do posto no mapa. A RendererCamiao apresenta as 
informações de cada camião na lista de camiões. 

